package database;

import java.io.IOException;

public class DatabaseTesting {
    public static void main(String[] args) throws IOException {
    	Table a = new Table("a");
    	
    	a.fillList(QueryGenerator.AllFrom("CartesAll"));
    	System.out.println(a.toString());
    	
    	
    	
    }
}

