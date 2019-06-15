
public class KSOM_Problem {

   // Tamanho do Grid
   private int size;
   // Interface Gráfica
   private KSOM_GUI gui;
   // Grid c/ as cores
   private KSOM_Grid grid;
   // Treinador
   private KSOM_Trainer trainer;
   // Valores de entrada
   private KSOM_Color[] input;

   public KSOM_Problem() {
      size  = 1;
      grid  = new KSOM_Grid(size, size);
      gui   = new KSOM_GUI(this);
      input = new KSOM_Color[8];

      int cont         = 0;
      KSOM_Color color = null;
      for (int x = 0; x < 2; x++) {
         for (int y = 0; y < 2; y++) {
            for (int z = 0; z < 2; z++) {
               color = new KSOM_Color(x, y, z);
               input[cont++] = color;
            }
         }
      }
   }

   public KSOM_Grid getGrid() {
      return grid;
   }

   public KSOM_Color[] getInputs() {
      return input;
   }

   public void start() {
      if (trainer == null) {
         trainer = new KSOM_Trainer(this);
      }
      trainer.start();
   }

   public void stop() {
      trainer.stop();
   }

   public void renderGrid(KSOM_Grid grid, int iteration) {
      gui.render(grid, iteration);
   }

   void setSettings(int size, int iterations) {
      grid    = new KSOM_Grid(size, size);
      trainer = new KSOM_Trainer(this, iterations);
      renderGrid(grid, 0);
   }

   // função 'main' desta classe
   void exec() {
      gui.setVisible(true);
      renderGrid(grid, 0);
   }
}
