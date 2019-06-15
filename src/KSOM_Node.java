
public class KSOM_Node {

   // Cor do node
   private KSOM_Color color;
   // Posição do node no grid
   private int x, y;

   public KSOM_Node() {
      color = new KSOM_Color(Math.random(), Math.random(), Math.random());
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }

   public KSOM_Color getColor() {
      return color;
   }

   public void setColor(KSOM_Color color) {
      this.color = color;
   }

   /**
    * Calcula a distância para outro node.
    *
    * @param n2      - Node 2
    * @return double - Distância
    */
   public double distanceTo(KSOM_Node n2) {
      int deltaX = getX() - n2.getX();
      deltaX *= deltaX;                 // pow(deltaX, 2)
      
      int deltaY = getY() - n2.getY();
      deltaY *= deltaY;                 // pow(deltaY, 2)

      return deltaX + deltaY;
   }

   /**
    * Ajusta os pesos.(Valores R, G e B == Pesos)
    * 
    * @param input
    * @param learningRate
    * @param distanceFalloff 
    */
   public void adjustColor(KSOM_Color input, double learningRate, double distanceFalloff) {
      double cThis, cInput;

      // R
      cThis = color.getR();
      cInput = input.getR();
      cThis += distanceFalloff * learningRate * (cInput - cThis);
      color.setR(cThis);
      // G
      cThis = color.getG();
      cInput = input.getG();
      cThis += distanceFalloff * learningRate * (cInput - cThis);
      color.setG(cThis);
      // B
      cThis = color.getB();
      cInput = input.getB();
      cThis += distanceFalloff * learningRate * (cInput - cThis);
      color.setB(cThis);
   }
}
