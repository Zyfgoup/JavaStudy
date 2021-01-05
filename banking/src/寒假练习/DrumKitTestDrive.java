package ∫ÆºŸ¡∑œ∞;
class DrumKit{
	boolean topHat=true;
	boolean snare=true;
	 void playsnare() {
		 System.out.println("bang bang ba-bang");
		 
	 }
	 void playtopHat() {
		 System.out.println("ding ding da-ding");
	 }
	 
	
}
public class DrumKitTestDrive {
		public static void main(String[] args) {
			DrumKit d=new DrumKit();
			d.playsnare();
			d.playtopHat();
			d.snare=false;
			
			if(d.snare==true) {
				d.playsnare();
			}
		}

}
