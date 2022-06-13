package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	private String content; 
	private List<String> contentTokens;
	private Map<String, Integer> wordFrequency = new TreeMap<>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
		}
		else {
			System.out.println("The author is already in the author list.");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		}
		else {
			System.out.println("The author is not in the author list.");
		}
	}
	
	public void setContent(String content) {
		this.content = content;
		this.processContent();
	}
	
	public String toString() {
		return String.format("Book: [%s] - [%s]  - %s - [ID: %d]\nContent Length: %d \nWord Frequency: %s", this.getTitle(), this.getCategory(), this.getAuthors().toString(), this.getId(), this.contentTokens.size(), this.wordFrequency.toString());
	}
	
	public void processContent() {
		contentTokens = Arrays.asList(content.split("[,.'? ]+"));
		Collections.sort(contentTokens);
		
		for (String word: contentTokens) {
			if (wordFrequency.containsKey(word)) {
				wordFrequency.put(word, wordFrequency.get(word) + 1);
			}
			else {
				wordFrequency.put(word, 1);
			}
		}
		
	}
}
