package com.hodan.fileio;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

public class DataFile {
	public static void main(String[] args) throws Exception {
		LinkedList<DVD> dVD=new LinkedList<DVD>();

        dVD.add(new DVD("Spiderman", "03-05-2002", "PG-13", "Sam Raimi", "Columbia Pictures", "4/5"));
        dVD.add(new DVD("Scream", "20-12-1996", "18", "Wes Craven", "Dimension Films", "4/5"));
        dVD.add(new DVD("Batman", "23-06-1989", "PG-13", "Tim Burton", "Warner Bros", "3/5"));
	
	
	
	FileWriter fileWriter=new FileWriter("DVDData2");
	PrintWriter printWriter=new PrintWriter(fileWriter);
	

	for(DVD dVDs:dVD) {
		String dVDStr=dVDs.getTitle()+","+dVDs.getReleaseDate()+","+dVDs.getMpaaRating()+","+dVDs.getDirector()+","+dVDs.getStudio()+","+dVDs.getUserRating();
		
		printWriter.println(dVDStr);
	}
	
	printWriter.flush();
	
	printWriter.close();

	fileWriter.close();
	
	System.out.println("DVD Data Stored");
}
}
