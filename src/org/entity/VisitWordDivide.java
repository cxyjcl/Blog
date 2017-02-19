package org.entity;

import java.util.List;

public class VisitWordDivide {
	
	private int wordCode=1;
	//分页的页数
	private long totalRecored;
	//总的留言数
	private int totalWord;
	private List<Visit> wordList;
	
	public int getWordCode() {
		return wordCode;
	}
	public void setWordCode(int wordCode) {
		this.wordCode = wordCode;
	}
	public long getTotalRecored() {
		int temp=totalWord/10;
		return totalWord%10>0?temp+1:temp;
	}
	public int getTotalWord() {
		return totalWord;
	}
	public void setTotalWord(long totalWord) {
		this.totalWord =(int)totalWord;
	}
	public List<Visit> getWordList() {
		return wordList;
	}
	public void setWordList(List<Visit> wordList) {
		this.wordList = wordList;
	}
	public String toString() {
		return "VisitWordDivide [wordCode=" + wordCode + ", totalRecored="
				+ getTotalRecored() + ", totalWord=" + totalWord + ", wordList="
				+ wordList + "]";
	}
}
