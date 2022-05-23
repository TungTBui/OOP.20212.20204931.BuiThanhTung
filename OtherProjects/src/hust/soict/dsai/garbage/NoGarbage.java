package hust.soict.dsai.garbage;

public class NoGarbage {
	
	public static void main (String[] args) {
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < 100000; i ++) {
			word.append("More");
		}
		String s = word.toString();
		System.out.println(s);
	}

}

