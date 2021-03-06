package com.company.server.controller;

import com.company.model.Car;
import com.company.model.User;

import java.io.File;
import java.io.IOException;

public class Storage {
	public Storage() {
		File files = new File("files/");
		File users = new File("users/");
		
		if (!files.exists()) {
			files.mkdirs();
		}
		
		if (!users.exists()) {
			users.mkdirs();
		}
	}
	
	public File createFileForCar(Car car) throws IOException {
		String filePath = car.getId() + ".xml";
		File file = new File("files/", filePath);
		
		file.setWritable(true);
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		return file;
	}
	
	public File getCarFile(int id) throws IOException {
		String filePath = "files/" + id + ".xml";
		File file = new File(filePath);
		
		if (!file.exists()) {
			return null;
		}
		
		return file;
	}
	
	public File createFileForUser(User user) throws IOException {
		String filePath =  "users/" + user.getUsername() + ".xml";
		File file = new File(filePath);
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		return file;
	}
	
	public File getUserFile(String username) throws IOException {
		String filePath = "users/" + username + ".xml";
		File file = new File(filePath);
		
		if (!file.exists()) {
			return null;
		}
		
		return file;
	}

}
