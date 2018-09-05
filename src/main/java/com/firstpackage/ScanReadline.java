package com.firstpackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ScanReadline {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> values=new ArrayList<String>();
		        // Create an instance of File for data.txt file.
		        File file = new File("E:\\Development\\JavaDev\\csv\\file1.csv");
		        try {
		            // Create a new Scanner object which will read the data
		            // from the file passed in. To check if there are more 
		            // line to read from it we check by calling the 
		            // scanner.hasNextLine() method. We then read line one 
		            // by one till all lines is read.
		            Scanner scanner = new Scanner(file);
		            while (scanner.hasNextLine()) {
		                String line = scanner.nextLine();
		                System.out.println(line);
		                String[] stringArr=line.split("|");
		    			for(String stringValue :stringArr) {
		    				values.add(stringValue);
		    			}
		            }
		            
		            for(String stringValues:values) {
		            	System.out.print(stringValues);
		            }
		            
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }
		    }
}
