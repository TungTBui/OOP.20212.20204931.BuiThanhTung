package hust.soict.dsai.garbage;

public class GarbageCreator {
	
	public static void main (String[] args) {
		String word = "";
		for (int i = 0; i < 100000; i ++) {
			word += "More";
		}
		System.out.println(word);
	}

}
