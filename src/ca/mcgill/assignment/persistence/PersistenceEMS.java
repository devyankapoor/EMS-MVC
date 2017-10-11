package ca.mcgill.assignment.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistenceEMS {

	private static String filename = "output.txt";

	public static void serialize(Object object) {
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(object);
			
			out.flush();
			out.close();
			fileOut.close();
		} catch (Exception e) {
			//throw new RuntimeException("Could not save data to file '" + filename + "'.");
			System.out.println("Not serialized");
		}

	}

	public static Object deserialize() {
		Object o = null;
		ObjectInputStream in;
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			in = new ObjectInputStream(fileIn);
			o = in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e) {
			o = null;
		}
		return o;
	}
	
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}
	
	public static void deleteserialize(Object object) {
			File f= new File(filename);
			Boolean b=f.delete();
           
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(object);
			out.flush();
			out.close();
			fileOut.close();
		} catch (Exception e) {
			//throw new RuntimeException("Could not save data to file '" + filename + "'.");
			System.out.println("Not serialized");
		}

	}

}
