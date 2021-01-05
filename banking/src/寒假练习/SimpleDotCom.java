package ∫ÆºŸ¡∑œ∞;

public class SimpleDotCom {
	int[] locationcells;
	int count;
	
	public void setLocationCells(int locs[]) {
		locationcells=locs;
	}
	public String checkYourself(String stringGuess) {
		int guess=Integer.parseInt(stringGuess);
		String result="miss";
		for(int cell:locationcells) {
			if(guess==cell) {
				result="hit";
				count++;
				break;
			}
		}
		
		if(count==locationcells.length) {
			result="kill";
			
		}
		
		System.out.println(result);
		return result;
	}
}
