package com.project;

public interface BookServiceInterface {
	
	    void addBook() throws Exception;
	    
	    void showAllBooks() throws Exception;
	    
	    void showAllAvailableBooks() throws Exception;
	    
	    void borrowBook();
	    
	    void returnBook();
	}

