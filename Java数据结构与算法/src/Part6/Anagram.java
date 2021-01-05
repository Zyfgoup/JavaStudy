package Part6;

public class Anagram {
	public static void doAnagram(String word,String prefix){
		if(word.length() == 0){
			System.out.println(prefix + word);
			return;
		}
		
		for(int i = 0 ;i < word.length(); i++){
			char ch = word.charAt(0);
			doAnagram(word.substring(1),prefix + ch);
			word = rotate(word);
		}
	}

	private static String rotate(String word) {
		return  word.substring(1) +word.substring(0, 1); 
	}
	
	public static void main(String[] args) {
		doAnagram("abcd","");
	}
}
