
public class KSOM_GUI extends javax.swing.JFrame {

   private KSOM_Problem problem;

   public KSOM_GUI(KSOM_Problem problem) {
      initComponents();

      this.problem = problem;
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      sizeLabel = new javax.swing.JLabel();
      inputSize = new javax.swing.JTextField();
      startButton = new javax.swing.JButton();
      gridRender = new KSOM_GridRender();
      iterationsLabel = new javax.swing.JLabel();
      inputIterations = new javax.swing.JTextField();
      setSettingsButton = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      sizeLabel.setText("Tamanho do GRID");

      startButton.setText("Start");
      startButton.setEnabled(false);
      startButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            startButtonActionPerformed(evt);
         }
      });

      gridRender.setBackground(new java.awt.Color(0, 0, 0));
      gridRender.setPreferredSize(new java.awt.Dimension(600, 600));

      javax.swing.GroupLayout gridRenderLayout = new javax.swing.GroupLayout(gridRender);
      gridRender.setLayout(gridRenderLayout);
      gridRenderLayout.setHorizontalGroup(
         gridRenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 600, Short.MAX_VALUE)
      );
      gridRenderLayout.setVerticalGroup(
         gridRenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 600, Short.MAX_VALUE)
      );

      iterationsLabel.setText("Iterações");

      setSettingsButton.setText("Set Settings");
      setSettingsButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            setSettingsButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(gridRender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(sizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
               .addComponent(inputSize)
               .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(iterationsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
               .addComponent(inputIterations)
               .addComponent(setSettingsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(sizeLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(iterationsLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputIterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(setSettingsButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(startButton)
            .addContainerGap())
         .addGroup(layout.createSequentialGroup()
            .addComponent(gridRender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 2, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
      problem.start();
   }//GEN-LAST:event_startButtonActionPerformed

   private void setSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setSettingsButtonActionPerformed
      int size = Integer.parseInt(inputSize.getText());
      int iter = Integer.parseInt(inputIterations.getText());
      
      inputSize.setEnabled(false);
      inputIterations.setEnabled(false);
      setSettingsButton.setEnabled(false);
      startButton.setEnabled(true);
      
      problem.setSettings(size, iter);
   }//GEN-LAST:event_setSettingsButtonActionPerformed

   public void setGrid(KSOM_Grid grid) {
      gridRender.setGrid(grid);
   }

   public void render(KSOM_Grid grid, int iteration) {
      setGrid(grid);
      gridRender.render();
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private KSOM_GridRender gridRender;
   private javax.swing.JTextField inputIterations;
   private javax.swing.JTextField inputSize;
   private javax.swing.JLabel iterationsLabel;
   private javax.swing.JButton setSettingsButton;
   private javax.swing.JLabel sizeLabel;
   private javax.swing.JButton startButton;
   // End of variables declaration//GEN-END:variables

}