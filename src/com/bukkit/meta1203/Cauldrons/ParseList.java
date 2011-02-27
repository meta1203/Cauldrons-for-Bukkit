package com.bukkit.meta1203.Cauldrons;
import java.io.*;
import java.util.ArrayList;

import org.bukkit.block.Block;

public class ParseList {
	File file;
	public ParseList(String fileLocation) {
		file = new File(fileLocation);
	}
	
	private String getRawData() {
		String input = "";
		   try {
	   		String str;
	   	    BufferedReader in = new BufferedReader(new FileReader(file));
	   	    while ((str = in.readLine()) != null) {
	   	        input = input + str + ";";
	   	    }
	   	    in.close();
	   	    return input;
	   	} catch (IOException e) {
	   		if (!file.exists()) {
	   			try {
	   			file.createNewFile();
	   			}
	   			catch (IOException e1){
	   				System.out.println(e1);
	   			}
	   		}
	   	}
	   	return null;
	}
	
	public ArrayList<Integer> getList() {
		String[] lines = getRawData().split(";");
		String[][] total = new String[lines.length][];
		for (int x = 0; x<lines.length; x++) {
			total[x] = lines[x].split(":");
		}
		
		return null;
	}
	}
