
public class KSOM_Trainer extends Thread {

   // Número de Iterações
   private int iterations;
   // Fator de aprendizado
   private double learningRate;
   // Raio
   private double gridRadius;
   
   private double TIME_CONSTANT;
   // Problem
   private KSOM_Problem problem;

   public KSOM_Trainer(KSOM_Problem problem) {
      this(problem, 500, 0.07);
   }

   public KSOM_Trainer(KSOM_Problem problem, int iterations) {
      this(problem, iterations, 0.07);
   }

   public KSOM_Trainer(KSOM_Problem problem, int iterations, double learningRate) {
      this.problem      = problem;
      this.iterations   = iterations;
      this.learningRate = learningRate;
   }

   private double getNeighborhoodRadius(double iteration) {
      return gridRadius * Math.exp(-iteration / TIME_CONSTANT);
   }

   private double getDistanceFalloff(double distSq, double radius) {
      double radiusSq = radius * radius;
      return Math.exp(-(distSq) / (2 * radiusSq));
   }

   @Override
   public void run() {
      KSOM_Grid    grid   = problem.getGrid();
      KSOM_Color[] inputs = problem.getInputs();

      int gridW = grid.getWidth();
      int gridH = grid.getHeight();

      int iteration = 0;
      int xstart, ystart, xend, yend;

      double dist, dFalloff;
      double nbhRadius;

      KSOM_Node bmu  = null;
      KSOM_Node temp = null;

      KSOM_Color curInput = null;

      gridRadius = Math.max(gridW, gridH) / 2;
      TIME_CONSTANT = iterations / Math.log(gridRadius);

      while (iteration < iterations) {
         nbhRadius = getNeighborhoodRadius(iteration);
         
         /**
          * Para cada valor do vetor de entrada: 
          *     - Busca pelo BMU;
          *     - Ajusta os pesos para a vizinhança do node BMU
          */
         for (int i = 0; i < inputs.length; i++) {
            curInput = inputs[i];
            // Busca o node BMU para o valor de entrada atual, depois ajusta os visinhos
            bmu = grid.getBMU(curInput);

            xstart = (int) (bmu.getX() - nbhRadius - 1);
            ystart = (int) (bmu.getY() - nbhRadius - 1);
            
            xend = (int) (xstart + (nbhRadius * 2) + 1);
            yend = (int) (ystart + (nbhRadius * 2) + 1);
            if (xend > gridW) {
               xend = gridW;
            }
            if (xstart < 0) {
               xstart = 0;
            }
            if (yend > gridH) {
               yend = gridH;
            }
            if (ystart < 0) {
               ystart = 0;
            }

            for (int x = xstart; x < xend; x++) {
               for (int y = ystart; y < yend; y++) {
                  temp = grid.getNode(x, y);
                  dist = bmu.distanceTo(temp);
                  if (dist <= (nbhRadius * nbhRadius)) {
                     dFalloff = getDistanceFalloff(dist, nbhRadius);
                     temp.adjustColor(curInput, learningRate, dFalloff);
                  }
               }
            }
         }
         iteration++;
         learningRate = learningRate * Math.exp(-(double) iteration / iterations);

         problem.renderGrid(grid, iteration);

         try {
            Thread.sleep(50);
         } catch (Exception e) {
            System.out.println(" > [SOMTrainer] Thread Sleep: " + e);
         }
      }
      
      problem.stop();
   }
}
