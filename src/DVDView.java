import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class DVDView {
	DVDService dvdService = new DVDService();
	
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Please enter a number"
					+ "\n[1] Add DVD"
					+ "\n[2] Remove DVD"
					+ "\n[3] Edit Existing DVD"
					+ "\n[4] List DVD's"
					+ "\n[5] Display information about DVD"
					+ "\n[6] Search by DVD title"
					+ "\n[7] Exit the program\n:");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				newDVD();
				break;
			case 2:
				removeDVD();
				break;
			case 3:
				editDVD();
				break;
			case 4:
				listDVDs();
				break;
			case 5:
				dvdInfo();
				break;
			case 6:
				dvdSearch();
			case 7:
				System.exit(0);
			}
		}
	}
	public void newDVD()  {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the dvd title: ");
		String title = sc.nextLine();
		
		LocalDate releaseDate = null;
		System.out.print("Enter the dvd release date in the format yyyy-mm-dd: ");
		
		String releaseDateS = sc.nextLine();
		try {
			releaseDate = LocalDate.parse(releaseDateS);
		}
		catch (DateTimeParseException e) {
			System.out.println("Invalid date entered");
			newDVD();
		}
		
		System.out.print("Enter the dvd MPAA rating: ");
		String mpaaRatingS = sc.nextLine();
		String mpaaRating = mpaaRatingS;
		
		System.out.print("Enter the dvd's director's name: ");
		String director = sc.nextLine();
		
		System.out.print("Enter the dvd's studio: ");
		String studio = sc.nextLine();
		
		System.out.print("Enter any additional notes or rating: ");
		String notes = sc.nextLine();
		
		DVD dvd = new DVD(title, releaseDate, mpaaRating, director, studio, notes);
		dvdService.addDVD(dvd);
		System.out.println("DVD has been successfully added into library!\n\n");
	}
	
	public void removeDVD() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the movie title to delete: ");
		String title = sc.nextLine();
		dvdService.removeDVD(title);
	}
	public void listDVDs() {
		ArrayList<DVD> dvdList = dvdService.loadDVDs();
		System.out.println("\n\n--------DVD's--------");
		for(DVD d : dvdList) {
			System.out.println(d.getTitle());
		}
		System.out.println("---------------------");
	}
	public void editDVD() { //Not finsihed
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the dvd you wish to edit: ");
		sc.nextLine();
	}
	public void dvdInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the dvd: ");
		String title = sc.nextLine();
		System.out.println(dvdService.dvdInfo(title));
		
		
	}
	public void dvdSearch() {
		
		
		
	}
}
