package º®¼ÙÁ·Ï°;

public class Circle1 {
		private double radius;
		
		public Circle1() {
			this.radius=1;
		}
		
		public void setRadius(int radius) {
			this.radius=radius;
		}
		
		public double getRadius() {
			return radius;
		}
	
		public double findArea() {
			return Math.PI*radius*radius;
		}
}
