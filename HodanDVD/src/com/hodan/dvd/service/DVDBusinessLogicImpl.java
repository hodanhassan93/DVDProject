package com.hodan.dvd.service;
import java.util.LinkedList;

import com.hodan.dvd.dto.DVD;
import com.hodan.dvd.persistence.DVDDataAccess;
import com.hodan.dvd.persistence.DVDDataAccessImpl;
public class DVDBusinessLogicImpl implements DVDBusinessLogic{

	
	private DVDDataAccess dataAccess; //=new DVDDataAccessImpl();
	
	public DVDBusinessLogicImpl(DVDDataAccess dataAccess) {
		super();
		this.dataAccess = dataAccess;
	}

	private LinkedList<DVD> dVDList;
	
	
	{
		try {
			dVDList = DVDDataAccessImpl.readRecords();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public LinkedList<DVD> getAllDVDs() {
		
		return dVDList;
	}

	@Override
	public boolean addDVD(DVD dVDs) {
		
		return dVDList.add(dVDs);
	}

	@Override
	public boolean deleteDVD(String title) {
		for(DVD dVDs:dVDList) {
			if(title.equals(dVDs.getTitle())) {
				return dVDList.remove(dVDs);
			}
		}
		return false;
	}
	
	  @Override
	    public boolean editDVD(String title, DVD updatedDVD) {
	        for (DVD dVDs : dVDList) {
	            if (title.equals(dVDs.getTitle())) {
	                dVDs.setTitle(updatedDVD.getTitle());
	                dVDs.setReleaseDate(updatedDVD.getReleaseDate());
	                dVDs.setMpaaRating(updatedDVD.getMpaaRating());
	                dVDs.setDirector(updatedDVD.getDirector());
	                dVDs.setStudio(updatedDVD.getStudio());
	                dVDs.setUserRating(updatedDVD.getUserRating());
	                return true;
	            }
	        }
	        return false;
	    }
	
	
	
    @Override
    public DVD getDVDByTitle(String title) {
        for (DVD dvd : dVDList) {
            if (title.equals(dvd.getTitle())) {
                return dvd;
            }
        }
        return null;
    }

	public void saveAllDVDs() throws Exception {
		
			dataAccess.writeRecords(dVDList);
		
	}
	

}