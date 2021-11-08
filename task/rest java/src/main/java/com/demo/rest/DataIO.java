package com.demo.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataIO {

	public static void dataOutput(ArrayList<Item> items) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File("data.ser"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(items);
		oos.close();
		fos.close();
	}
	
	public static ArrayList<Item> dataInput() throws ClassNotFoundException, IOException{
		FileInputStream fis = new FileInputStream("data.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		ArrayList<Item> items =  (ArrayList<Item>) ois.readObject();
		ois.close();
		fis.close();
		return items;
	}
}