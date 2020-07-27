package model;

import java.io.IOException;
import java.util.Scanner;

public class Value {
	private Scanner scanner;
	public Value(Scanner scanner) {
		this.scanner=scanner;
	}
	
	public String[] readLine(String line) throws IOException {
	        return scanner.nextLine().split(line);
	    }

}
