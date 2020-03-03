package com.felipestella.whorkshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date date;
	private String text;
	
	private AuthorDto author;
	
	public ComentsDto() {
	}

	public ComentsDto(Date date, String text, AuthorDto author) {
		super();
		this.date = date;
		this.text = text;
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
	}
	
	
}
