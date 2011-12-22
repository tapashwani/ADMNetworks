package com.ADMNetworks.Utill;

import java.io.*;
import java.util.Properties;
import java.lang.String;

public class WritePropertiesFile {
	CustomMethod custom = new CustomMethod();
	String path =  custom.getPath();
	
	//Update Key, Value in the existing property file	
public void WritePropertyFile(String fname, String Key, String Val) throws IOException {
		try{
			Properties pro = new Properties();
			File f = new File(path + "//src//com/ADMNetworks//Config//"+fname+".properties");
			FileInputStream in = new FileInputStream(f);
			pro.load(in);
			pro.setProperty(Key, Val);
			pro.store(new FileOutputStream(f), null);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Creates new file if not exist or delete contents of an existing file.
public void SetProperty1(String fname)throws IOException {
		
		try {			
			Properties properties = new Properties();
			File f = new File(path + "//src//com/ADMNetworks//Config//"+fname+".properties");
				if (f.exists()) {
			            System.out.println("File already exists");
			    } 
				else {
			            f.createNewFile();
			            System.out.println("File is created");
			    }
				FileOutputStream fileOut = new FileOutputStream(f);
				properties.store(fileOut, "New Policy information");	
				fileOut.close();						
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
	
//Create new file if not already exist.
public void CreateNewFiles(String fname) throws Exception {
		    //File file = new File("C:/newfile.txt");
		    File file = new File(path + "//src//com/ADMNetworks//Config//"+fname+".properties");
		    if (file.exists()) {
		            System.out.println("File already exists");
		    } else {
		            file.createNewFile();
		            System.out.println("File is created");
		    }
		}

	// Split specific characters from the from the string.
public String[] SplitString(String Var){
	String data = Var;	
	String[] items = data.split("\\\u00A3");
	
	/*for (String item : items)	
		{	
			System.out.println(item);
		}*/
		return items;
	}
}
