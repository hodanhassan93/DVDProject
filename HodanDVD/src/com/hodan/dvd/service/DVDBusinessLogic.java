package com.hodan.dvd.service;

import java.util.LinkedList;


import com.hodan.dvd.dto.DVD;

public interface DVDBusinessLogic {
		LinkedList<DVD> getAllDVDs();
		boolean addDVD(DVD dVD);
		boolean deleteDVD(String title);
		public void saveAllDVDs()throws Exception;
		DVD getDVDByTitle(String title);
		boolean editDVD(String title, DVD updatedDVD);
	
}
