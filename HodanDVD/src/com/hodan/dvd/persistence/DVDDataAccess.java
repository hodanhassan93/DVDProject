package com.hodan.dvd.persistence;
import java.util.LinkedList;

import com.hodan.dvd.dto.DVD;

public interface DVDDataAccess {

	public boolean writeRecords(LinkedList<DVD> dVD)throws Exception;
	//public LinkedList<DVD> readRecords()throws Exception;
	

}
