package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
	public static final String RED = "\u001b[31m";
    public static final String RESET = "\u001b[0m";
	    private static Pattern ID_PATTERN;
	    private static Pattern AuthorTitle_Pattern;
	    private static Pattern PublishYear_Pattern;
	    Scanner sc;
	    
	    Utiljdbc util= new Utiljdbc();
	    
	    public Validator() {
	        this.sc = new Scanner(System.in);
	    }
	    
	    public String validateId() {
	        String bookid;
	        while (true) {
	            System.out.println("Enter Book ID ");
	            bookid = this.sc.nextLine();
	            if (Validator.ID_PATTERN.matcher(bookid).matches()) {
	                break;
	            }
	            System.out.println("\u001b[31mSORRY ! PLEASE ENTER VALID BOOK ID\u001b[0m");
	        }
	        return bookid;
	    }
	    
	    public String validateAuthorTitle(final String input) {
	        String result;
	        while (true) {
	            if (input == "Title") {
	                System.out.println("Enter Title");
	            }
	            else {
	                System.out.println("Enter Author");
	            }
	            result = this.sc.nextLine();
	            if (Validator.AuthorTitle_Pattern.matcher(result).matches()) {
	                break;
	            }
	            System.out.println( input);
	        }
	        return result;
	    }
	    
	    public String validatePublishYear() {
	        String year;
	        while (true) {
	            System.out.println("Enter Publish Year of Book ");
	            year = this.sc.nextLine();
	            if (Validator.PublishYear_Pattern.matcher(year).matches()) {
	                break;
	            }
	            System.out.println("Enter valid Publish Year");
	        }
	        return year;
	    }
	    static {
	        Validator.ID_PATTERN = Pattern.compile("^\\d{1,4}$");
	        Validator.AuthorTitle_Pattern = Pattern.compile("^[a-zA-Z ]+$");
	        Validator.PublishYear_Pattern = Pattern.compile("^\\d{4}$");
	    }
	    
	    

	      
	 
	}

