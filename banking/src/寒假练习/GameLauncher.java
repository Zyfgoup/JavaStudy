package 寒假练习;
class GuessGame{
	Player p1;
	Player p2;
	Player p3;
	
	public void startGame() {
		p1=new Player();//创建Player的对象
		p2=new Player();
		p3=new Player();
		
		int guessp1=0;
		int guessp2=0;
		int guessp3=0;
		
		boolean p1isRight=false;
		boolean p2isRight=false;
		boolean p3isRight=false;
		
		int targetNumber=(int)(Math.random()*10);
		System.out.println("I'm thingking of a number between 0 and 9...");
		 
		while(true) {//while(true)为无限循环 需要用break跳出
			System.out.println("Number to guess is "+targetNumber);	
			
			p1.guess();//调用Player类中的guess（）方法，因为p1 2 3 都是Player类的对象
			p2.guess();
			p3.guess();
			
			guessp1=p1.number;
			System.out.println("Player1 guessed "+guessp1);
			
			guessp2=p2.number;
			System.out.println("Player2 guessed "+guessp2);
			
			guessp3=p3.number;
			System.out.println("Player3 guessed "+guessp3);
			
			if(guessp1==targetNumber) {
				p1isRight=true;
			}
			if(guessp2==targetNumber) {
				p2isRight=true;
			}
			if(guessp3==targetNumber) {
				p3isRight=true;
			}
			
			if(p1isRight||p2isRight||p3isRight) {
				System.out.println("We have a winner");
				System.out.println("Player1 got is right?"+p1isRight);
				System.out.println("Player2 got is right?"+p2isRight);
				System.out.println("Player3 got is right?"+p3isRight);
				System.out.println("Game is over");
				break;
			}else {
				System.out.println("Players will have to try again.");
			}
		}

	}
}
class Player{
	int number=0;
	
	public void guess() {
		number=(int)(Math.random()*10);
		System.out.println("I'm guessing "+number);
	}
}
public class GameLauncher {
	
	public static void main(String[] args) {
		GuessGame game=new GuessGame();
		game.startGame();
	}
}
