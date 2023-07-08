package com.hodan.dvd.service;

import com.hodan.dvd.dto.DVD;
import com.hodan.dvd.persistence.DVDDataAccess;

public class ModifyBusinessLogicImpl extends DVDBusinessLogicImpl{

	public ModifyBusinessLogicImpl(DVDDataAccess dataAccess) {
		super(dataAccess);
	}
	
    @Override
    public DVD getDVDByTitle(String title) {
        for (DVD dvd : getAllDVDs()) {
            if (title.equals(dvd.getTitle())) {
            	dvd.setTitle(dvd.getTitle().toUpperCase());
                return dvd;
            }
        }
        return null;
    }
}
