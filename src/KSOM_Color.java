
public class KSOM_Color {

   // Valores R, G e B - Pesos
   private double r, g, b;

   public KSOM_Color() {
      this(0.0, 0.0, 0.0);
   }

   public KSOM_Color(double r, double g, double b) {
      this.r = r;
      this.g = g;
      this.b = b;
   }

   public double getR() {
      return r;
   }

   public void setR(double r) {
      this.r = r;
   }

   public double getG() {
      return g;
   }

   public void setG(double g) {
      this.g = g;
   }

   public double getB() {
      return b;
   }

   public void setB(double b) {
      this.b = b;
   }
}
