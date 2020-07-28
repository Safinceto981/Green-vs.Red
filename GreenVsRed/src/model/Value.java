package model;


import java.util.Scanner;

public class Value {
	private Scanner scanner;
	public Value(Scanner scanner) {
		this.scanner=scanner;
	}
	//reading the user input and splitting it
	public String[] readLine(String line)  {
	        return scanner.nextLine().split(line);
	    }

}
