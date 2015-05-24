package com.treehouse.treet;
import java.util.*;
import java.io.*;

public class Treet implements Comparable<Treet>, Serializable{
	//private boolean mBreakIt = true;
	private String mAuthor;
	private String mDescription;
	private Date mCreationDate;
	public Treet(String author, String descript, Date date) {
		mAuthor = author;
		mDescription = descript;
		mCreationDate = date;
	}
	public String getAuthor() {
		return mAuthor;
	}
	public String Description() {
		return mDescription;
	}
	public Date getDate() {
		return mCreationDate;
	}
	public List<String> getHashTags() {
		return getWordPrefixedWith("#");

	}
	public List<String> getMentions() {
		return getWordPrefixedWith("@");
	}
	private List<String> getWordPrefixedWith(String prefix) {
		List<String> results = new ArrayList<String>();
		for (String word: getWords()) {
			if(word.startsWith(prefix)) {
				results.add(word);
			}
		}
		return results;
	}
	public List<String> getWords() {
		//splits string
		// \w highlights all characters but no punctuation
		// ^\w highlights all punctuation
		// ^\w and add other special characters you want.
		
		String[] words = mDescription.toLowerCase().split("[^\\w#@']+");
		return Arrays.asList(words);
	}
	@Override
	public int compareTo(Treet o) {
		Treet other = o;
		if (equals(other)) {
			return 0;
		}
		int dateCmp = mCreationDate.compareTo(other.mCreationDate);
		if ( dateCmp == 0) {
			return mDescription.compareTo(other.mDescription);
		}
		else return dateCmp;
	}
	@Override
	public String toString() {
		return String.format("Treet: \"%s\" by %s on %s", mDescription, mAuthor, mCreationDate);
	}
	
}
