package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookServiceInterface
{
    public static final String RED = "\u001b[31m";
    public static final String RESET = "\u001b[0m";
    public static final String BLUE = "\u001b[34m";
    public static final String GREEN = "\u001b[32m";
    public static final String CYAN = "\u001b[36m";
    public static final String BLACK = "\u001b[30m";
    Scanner sc;
    Validator validator;
    List<Book> books;
    Utiljdbc util= new Utiljdbc();
    
    public BookServiceImpl() {
        this.sc = new Scanner(System.in);
        this.validator = new Validator();
        this.books = new ArrayList<Book>();
    }
    
    public void addBook() throws Exception   {
    	

	 
        final String bookid = this.validator.validateId();
        final String title = this.validator.validateAuthorTitle("Title");
        final String author = this.validator.validateAuthorTitle("Author");

        final String publishyear = this.validator.validatePublishYear();
        final Book book = new Book(bookid, author, title, publishyear, "Available");
        this.books.add(book);
        System.out.println("\u001b[32mBook Added Successfully !!!\u001b[0m");
        
        Connection con 	= util.getConnection();
		  String sql ="insert into bookmanagement(bookid,title,author,publishyear,status)"+"values(?,?,?,?,?)";
		  
		  PreparedStatement prepareStmt=con.prepareStatement(sql);
		 
		  prepareStmt.setString(1,book.getId()); 
		  prepareStmt.setString(2,book.getTitle());
		  prepareStmt.setString(3,book.getAuthor());
		  prepareStmt.setString(4,book.getPublishYear());
		  prepareStmt.setString(5,book.getStatus());

		  int i = prepareStmt.executeUpdate(); 
		  System.out.println("record inserted " +i);
    }
    
    
    public void showAllBooks() throws Exception {
        boolean flag = false;
     //   System.out.println("\n----------------------------------------------------------------------------------------------");
      //  System.out.format("\u001b[36m%s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR", "PUBLISH YEAR", "STATUS\u001b[0m");
     //   System.out.println("\n----------------------------------------------------------------------------------------------");
        for (final Book book : this.books) {
            System.out.format("%s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
            System.out.println();
            flag = true;
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
       
        Connection con 	= util.getConnection();
       String sql = "Select * from bookmanagement";
		  PreparedStatement prepareStmt=con.prepareStatement(sql);
		ResultSet rs =  prepareStmt.executeQuery();
     
		while(rs.next()) {
			System.out.println("id " +rs.getInt(1));
			System.out.println("title " +rs.getString(2));
			System.out.println("author " +rs.getString(3));
			System.out.println("publishyear " +rs.getString(4));
			System.out.println("status " +rs.getString(5));

		}
    
    
		 if (!flag) {
	            System.out.println("\u001b[31mThere are no Books in Library\u001b[0m");
	        
		 }
    }
    
    
    
    public void showAllAvailableBooks() throws Exception {
        boolean flag = false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format("\u001b[36m%s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR", "PUBLISH YEAR", "STATUS\u001b[0m");
        System.out.println("\n----------------------------------------------------------------------------------------------");
      if (this.books.size() > 0) {
            for (final Book book : this.books) {
                if (book.getStatus() == "Available") {
                   System.out.format("%s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
                 // System.out.println(book);
                    flag = true;
                }
            
       
    
			/*
			 * Book book = new Book(); Connection con = util.getConnection(); String sql =
			 * "Select status from bookmanagement"; PreparedStatement
			 * prepareStmt=con.prepareStatement(sql); prepareStmt.setString(1,book.getId());
			 * prepareStmt.setString(2,book.getTitle());
			 * prepareStmt.setString(3,book.getAuthor());
			 * prepareStmt.setString(4,book.getPublishYear());
			 * prepareStmt.setString(5,book.getStatus());
			 * 
			 * ResultSet rs = prepareStmt.executeQuery(); while(rs.next()) {
			 * System.out.println("id " +rs.getInt(1)); System.out.println("title "
			 * +rs.getString(2)); System.out.println("author " +rs.getString(3));
			 * System.out.println("publishyear " +rs.getString(4));
			 * System.out.println("status " +rs.getString(5));
			 */
			/*
			 * } }
			 * 
			 */
			
			  else {
			  System.out.println("\u001b[31mNo Books Available in the library\u001b[0m"); }
			  System.out.println( "\n---------------------------------------------------------------------------------------------"); 
			  if (!flag) 
			 System.out.println("\u001b[31mThere are no books with status Available\u001b[0m"); 
			  
            }
       }
    }
    public void borrowBook() {
        final String bookid = this.validator.validateId();
        boolean flag = false;
        for (final Book book : this.books) {
            if (book.getId().equals(bookid) && book.getStatus().equals("Available")) {
                flag = true;
                System.out.println("\u001b[32mBook Borrowed Successfully !!!\u001b[0m");
                book.setStatus("Not Available");
                System.out.println( book);
            }
        }
        if (!flag) {
            System.out.println("\u001b[31mThis book is not available to borrow\u001b[0m");
        }
    }
    
    public void returnBook() {
        boolean flag = false;
        final String bookid = this.validator.validateId();
        for (final Book book : this.books) {
            if (book.getId().equals(bookid) && book.getStatus().equals("Not Available")) {
                flag = true;
                System.out.println("\u001b[32mBook Returned Successfully !!!\u001b[0m");
                book.setStatus("Available");
                System.out.println(book);
            }
        }
        if (!flag) {
            System.out.println("\u001b[31mWe can not return this book\u001b[0m");
        }
    }
}

