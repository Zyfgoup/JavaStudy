package ∫ÆºŸ¡∑œ∞;
import java.util.*;
public class DotComBust {
	private GameHelper helper=new GameHelper();
	private ArrayList<DotCom>dotComsList=new ArrayList<DotCom>();
	private int numOfGuesses=0;
	
	private void setUpGame() {
		DotCom one=new DotCom();
		one.setName("pets.com");
		DotCom two=new DotCom();
		two.setName("estoys.com");;
		DotCom three=new DotCom();
		three.setName("go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("pets.com,etoys.com,go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		
		for(DotCom dotComToSet:dotComsList) {
			ArrayList<String> newlocation=helper.placeDotCom(3);
			dotComToSet.setLocationCells(newlocation);
		}
	}
	
	private void startPlaying() {
		while(!dotComsList.isEmpty()) {
			String userGuess=helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result="miss";
		for(DotCom dotComToTest:dotComsList) {
			result=dotComToTest.checkYourself(userGuess);
			if(result.equals("hit")) {
				break;
			}
			if(result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless");
		if(numOfGuesses<=18) {
			System.out.println("It only tool you"+numOfGuesses+"guesses");
			System.out.println("You got out before your options sank");
		}else {
			System.out.println("Took you long enough."+numOfGuesses+"guesses");
			System.out.println("Fish are dancing with your options");
		}
	}
	
	public static void main(String[] args) {
		DotComBust game=new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}