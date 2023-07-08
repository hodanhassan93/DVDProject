package com.hodan.dvd.persistence;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


import com.hodan.dvd.dto.DVD;

public class DVDDataAccessImpl implements DVDDataAccess{

	@Override
	public boolean writeRecords(LinkedList<DVD> dVD)throws Exception {
		FileWriter fileWriter=new FileWriter("DVDData2");
		PrintWriter printWriter=new PrintWriter(fileWriter);
		
		for(DVD dVDs:dVD) {
			String dVDStr=dVDs.getTitle()+","+dVDs.getReleaseDate()+","+dVDs.getMpaaRating()+","+dVDs.getDirector()+","+dVDs.getStudio()+","+dVDs.getUserRating();
			
			printWriter.println(dVDStr);
		}
		
		printWriter.flush();
		
		printWriter.close();

		fileWriter.close();
		return true;
	}


	
	public static LinkedList<DVD> readRecords() throws Exception {
		LinkedList<DVD> dVD=new LinkedList<DVD>();
		
		FileReader fileReader = new FileReader("DVDData2");

		
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		Scanner scanner = new Scanner(bufferedReader);
		while (scanner.hasNext()) {
			String currentLine = scanner.nextLine();

			String values[]=currentLine.split(",");
			
			DVD dVDs=new DVD(values[0], values[1], values[2], values[3],values[4], values[5]);
			
			dVD.add(dVDs);
		}
		fileReader.close();
		bufferedReader.close();
		
		return dVD;
	}
}
