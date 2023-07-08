package com.hodan.dvd.presentation;
import java.util.LinkedList;

import java.util.Scanner;
import com.hodan.dvd.dto.DVD;
import com.hodan.dvd.service.DVDBusinessLogic;
import com.hodan.dvd.service.DVDBusinessLogicImpl;


public class DVDUserInterfaceImpl implements DVDUserInterface {
	private DVDBusinessLogic businessLogic=new DVDBusinessLogicImpl();
	
	@Override
	public void showMenu() {
		System.out.println("1. List All DVD's");
		System.out.println("2. Add New DVD");
		System.out.println("3. Delete Existing DVD");
		System.out.println("4. Edit The Details Of An Existing DVD");
		System.out.println("5. Search for a DVD by Title");
		System.out.println("6. Exit");

	}

	@Override
	public void performMenu(int choice)throws Exception {
		Scanner scanner=new Scanner(System.in);
	switch (choice) {
		case 1: 
			LinkedList<DVD> dVD=businessLogic.getAllDVDs();
			for(DVD dVDs:dVD) {
				System.out.println(dVDs);
			}
			break;
		case 2:
			DVD dVDs=new DVD();
			System.out.println("Enter The DVD Title : ");
			dVDs.setTitle(scanner.nextLine());
			System.out.println("Enter DVD Release Date : ");
			dVDs.setReleaseDate(scanner.nextLine());
			System.out.println("Enter DVD MPAA Rating : ");
			dVDs.setMpaaRating(scanner.nextLine());
			System.out.println("Enter DVD Director : ");
			dVDs.setDirector(scanner.nextLine());
			System.out.println("Enter DVD Studio : ");
			dVDs.setStudio(scanner.nextLine());
			System.out.println("Enter DVD User Rating");
			dVDs.setUserRating(scanner.nextLine());
			
			boolean status=businessLogic.addDVD(dVDs);
			
			if(status)
				System.out.println("DVD Added!");
			else
				System.out.println("DVD Not Added!");
			break;
		case 3:
			System.out.println("Enter DVD Title to delete: ");
			String title=scanner.nextLine();
			if(businessLogic.deleteDVD(title))
				System.out.println("DVD Deleted");
			else
				System.out.println("DVD with Title "+title+" does not exist");
			break;
			
		case 4:	
			  System.out.println("Enter the DVD Title to edit: ");
              String editTitle = scanner.nextLine();
              DVD existingDVD = businessLogic.getDVDByTitle(editTitle);
              if (existingDVD == null) {
                  System.out.println("DVD with Title " + editTitle + " does not exist");
              } else {
                  int editOption = -1;
                  while (editOption != 0) {
                      System.out.println("Select the information to edit:");
                      System.out.println("1. DVD Title");
                      System.out.println("2. DVD Release Date");
                      System.out.println("3. DVD MPAA Rating");
                      System.out.println("4. DVD Director");
                      System.out.println("5. DVD Studio");
                      System.out.println("6. DVD User Rating");
                      System.out.println("0. Exit");

                      editOption = Integer.parseInt(scanner.nextLine());

                      switch (editOption) {
                          case 1:
                              System.out.println("Enter the new DVD Title: ");
                              existingDVD.setTitle(scanner.nextLine());
                              break;
                          case 2:
                              System.out.println("Enter the new DVD Release Date: ");
                              existingDVD.setReleaseDate(scanner.nextLine());
                              break;
                          case 3:
                              System.out.println("Enter the new DVD MPAA Rating: ");
                              existingDVD.setMpaaRating(scanner.nextLine());
                              break;
                          case 4:
                              System.out.println("Enter the new DVD Director: ");
                              existingDVD.setDirector(scanner.nextLine());
                              break;
                          case 5:
                              System.out.println("Enter the new DVD Studio: ");
                              existingDVD.setStudio(scanner.nextLine());
                              break;
                          case 6:
                              System.out.println("Enter the new DVD User Rating: ");
                              existingDVD.setUserRating(scanner.nextLine());
                              break;
                          case 0:
                              System.out.println("You have successfully exited the editing system");
                              break;
                          default:
                              System.out.println("Invalid option. Please enter a valid option.");
                              break;
                      }
                  }
                  

              }
              break;        
           
		case 5: 
		    System.out.println("Enter the DVD Title to search: ");
            String searchTitle = scanner.nextLine();
            DVD foundDVD = businessLogic.getDVDByTitle(searchTitle);
            if (foundDVD != null) {
                System.out.println("DVD Found:");
                System.out.println(foundDVD);
            } else {
                System.out.println("DVD with Title " + searchTitle + " not found");
            }
            break;
            
		case 6:
			businessLogic.saveAllDVDs();
			System.out.println("Thanks for Using Our System");
			System.exit(0);
			
		default:
			System.out.println("Invalid Choice");
		}

	}

}