package com.project;

public class Book {
	 private String id;
	    private String  author;
	    private String title;
	    private String publishYear;
	    private String status;
	    
	    public Book() {
	    }
	    
	   
	    
	    public Book(String id, String author, String title, String publishYear, String status) {
			super();
			this.id = id;
			this.author = author;
			this.title = title;
			this.publishYear = publishYear;
			this.status = status;
		}



		

		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public String getAuthor() {
			return author;
		}



		public void setAuthor(String author) {
			this.author = author;
		}



		public String getTitle() {
			return title;
		}



		public void setTitle(String title) {
			this.title = title;
		}



		public String getPublishYear() {
			return publishYear;
		}



		public void setPublishYear(String publishYear) {
			this.publishYear = publishYear;
		}



		public String getStatus() {
			return status;
		}



		public void setStatus(String status) {
			this.status = status;
		}



		@Override
		public String toString() {
			return "Book [id=" + id + ", author=" + author + ", title=" + title + ", publishYear=" + publishYear
					+ ", status=" + status + ", getId()=" + getId() + ", getAuthor()=" + getAuthor() + ", getTitle()="
					+ getTitle() + ", getPublishYear()=" + getPublishYear() + ", getStatus()=" + getStatus()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}



		
	   
	}

