package com.hodan.dvd.client;
import java.util.Scanner;

import com.hodan.dvd.presentation.DVDUserInterface;
import com.hodan.dvd.presentation.DVDUserInterfaceImpl;

public class DVDClient {

	public static void main(String[] args) {
		

		DVDUserInterface DVDUserInterface=new DVDUserInterfaceImpl();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			DVDUserInterface.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			try {
				DVDUserInterface.performMenu(choice);
			} catch (Exception e) {
				System.out.println("Something went wrong , please try after sometime!");
			}
			
		}

	}

}







