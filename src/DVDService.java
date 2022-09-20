import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class DVDService  {

	public void addDVD(DVD dvd)  {
		ArrayList<DVD> dvdList =  loadDVDs(); //Get current file
		dvdList.add(dvd); //Add the new dvd entry
		saveDVDs(dvdList);

	}
	public void saveDVDs(ArrayList<DVD> dvdList) {
		try{
			FileOutputStream fStream = new FileOutputStream(new File("DVD.dat"));
			ObjectOutputStream oStream = new ObjectOutputStream(fStream);

			for (DVD d : dvdList) { //Add all dvd's to file
				oStream.writeObject(d);
			}
			fStream.close();
			oStream.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<DVD> loadDVDs() {
		try{
			FileInputStream fStream = new FileInputStream(new File("DVD.dat"));
			ObjectInputStream oStream = new ObjectInputStream(fStream);
			
			ArrayList<DVD> dvdList = new ArrayList<>();
			while (true) {
				try{
					dvdList.add((DVD) oStream.readObject());
				}
				catch(EOFException eof){ //Expecting, when there are no more object in the file
					fStream.close();
					oStream.close();
					break;
				}
				catch(Exception e) {e.printStackTrace();break;}
			}
			return dvdList;
		}				
		catch (FileNotFoundException fnf) {
			File file = new File("DVD.dat");
			try {
				file.createNewFile();
				System.out.println("There are currently 0 movies in the library!\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new ArrayList<DVD>();}
		catch (EOFException eof) {System.out.println("There are currently 0 movies in the library!\n");return new ArrayList<DVD>();}
		catch(Exception e) {e.printStackTrace();return null;}
	}
		
	
	public void removeDVD(String title) {
		ArrayList<DVD> dvdList =  loadDVDs();
		for (DVD d : dvdList) {
			if (d.getTitle().toLowerCase().contentEquals(title.toLowerCase())) {
				dvdList.remove(d);
				System.out.println("Movie has been found!");
				break;
			}
		}
		System.out.println("chicken nugget");
		saveDVDs(dvdList);
		
	}
	public String dvdInfo(String title) {
		ArrayList<DVD> dvdList =  loadDVDs();
		for (DVD d : dvdList) {
			if (d.getTitle().toLowerCase().contentEquals(title.toLowerCase())) {
				return d.toString();
			}
		}
		
		return "Movie name does not exist";
	}

}
