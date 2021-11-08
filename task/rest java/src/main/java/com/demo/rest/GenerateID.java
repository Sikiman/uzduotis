package com.demo.rest;

import java.util.ArrayList;
import java.util.Random;

public class GenerateID {

	public static long newID(ArrayList<Item> items) {
		
		Random random = new Random();
		long rand = random.nextLong(89999999)+10000000;
		
		if(numberRepeats(rand, items)) {
			return newID(items);
		}
		else {
			return rand;
		}
	}
	
	private static boolean numberRepeats(long rand, ArrayList<Item> items) {
		
		for(Item item : items) {
			if(item.getId() == rand) {
				return true;
			}
		}
		return false;
	}
}
