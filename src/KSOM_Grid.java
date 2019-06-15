
public class KSOM_Grid {

   // Largura e Comprimento do grid
   private int width, height;
   // Grid de nodes
   private KSOM_Node[][] grid;

   public KSOM_Grid(int w, int h) {
      width = w;
      height = h;
      grid = new KSOM_Node[width][height];

      for (int x = 0; x < w; x++) {
         for (int y = 0; y < h; y++) {
            grid[x][y] = new KSOM_Node();
            grid[x][y].setX(x);
            grid[x][y].setY(y);
         }
      }
   }

   public KSOM_Node getNode(int x, int y) {
      return grid[x][y];
   }

   public int getWidth() {
      return width;
   }

   public int getHeight() {
      return height;
   }

   /**
    * Busca pelo node BMU.
    *
    * @param inputVector - Input Vector
    * @return KSOM_Node  - BMU
    */
   public KSOM_Node getBMU(KSOM_Color inputVector) {
      // Começa assumindo que o [0, 0] é o BMU
      KSOM_Node bmu   = grid[0][0];
      double bestDist = euclideanDistance(inputVector, bmu.getColor());

      // Verfica a distancia euclidiana entre o vetor 'input' e os nodes
      for (int x = 0; x < width; x++) {
         for (int y = 0; y < height; y++) {
            double curDist = euclideanDistance(inputVector, grid[x][y].getColor());
            // Se a distância atual for menor que a distância do BMU, att os valores
            if (curDist < bestDist) {
               bmu      = grid[x][y];
               bestDist = curDist;
            }
         }
      }

      return bmu;
   }

   /**
    * Calcula a distância entro dois vetores(Valor R, G e B das cores).
    * 
    * @param c1 - Cor 1
    * @param c2 - Cor 2
    * @return double - Distância Euclidiana
    */
   public double euclideanDistance(KSOM_Color c1, KSOM_Color c2) {
      double summation = 0, temp;

      // R
      temp = c1.getR() - c2.getR();
      temp *= temp;                  // pow(temp, 2)
      summation += temp;
      // G
      temp = c1.getG() - c2.getG();
      temp *= temp;                  // pow(temp, 2)
      summation += temp;
      // B
      temp = c1.getB() - c2.getB();
      temp *= temp;                  // pow(temp, 2)
      summation += temp;

      return summation;
   }
}
