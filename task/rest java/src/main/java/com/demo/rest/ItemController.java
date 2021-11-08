package com.demo.rest;

import java.io.IOException;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class ItemController {

	private ArrayList<Item> items = new ArrayList<Item>();

	@CrossOrigin
	@GetMapping(path = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Item> get() throws IOException, ClassNotFoundException {
		items = DataIO.dataInput();
		return items;
	}

	@CrossOrigin
	@PostMapping(path = "/additem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> post(@RequestBody Item item) throws IOException, ClassNotFoundException {
		if(item.getName() != null) {
			if(item.getName().length() <= 50 && item.getDetails().length() <= 200){
				items = DataIO.dataInput();
				item.setId(GenerateID.newID(items));
				items.add(item);
				DataIO.dataOutput(items);
				return new ResponseEntity<Item>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin
	@DeleteMapping(path = "/deleteitem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> delete(@RequestBody Item itemToDelete) throws IOException, ClassNotFoundException {
		items = DataIO.dataInput();
		Item itemToRemove = null;
		for (Item item : items) {
			if (item.getId() == itemToDelete.getId()) {
				itemToRemove = item;
			}
		}
		if (itemToRemove != null) {
			items.remove(itemToRemove);
			DataIO.dataOutput(items);
			return new ResponseEntity<Item>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}
}