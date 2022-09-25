package com.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Main {
	
	    public static void main(String[] args) throws Exception {

	         Scanner sc = new Scanner(System.in);
	         BookServiceInterface service = (BookServiceInterface)new BookServiceImpl();
	        while (true) {
	            System.out.println("Welcome to Book Management Application");
	            System.out.println("1.Add Book\n2.Show All Books\n3.Show Available Books\n4.Borrow Book\n5.Return Book\n6.Exit\n");
	            System.out.println("Enter Your Choice !");
	             int ch = sc.nextInt();
	            switch (ch) {
	                case 1: {
	                    service.addBook();
	                    continue;
	                }
	                case 2: {
	                    service.showAllBooks();
	                    continue;
	                }
	                case 3: {
	                    service.showAllAvailableBooks();
	                    continue;
	                }
	                case 4: {
	                    service.borrowBook();
	                    continue;
	                }
	                case 5: {
	                    service.returnBook();
	                    continue; 
	                }
	                case 6: {
	                    System.out.println("Thank you for Using Application !!");
	                    System.exit(0);
	                    continue;
	                }
	                default: {
	                    System.out.println("Please Enter Valid Choice !");
	                    continue;
	                }
	            }
	        }
	   
	}
	    
}
