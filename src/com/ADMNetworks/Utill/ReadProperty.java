package com.ADMNetworks.Utill;

import java.io.*;
import java.util.*;

public class ReadProperty{
		
	CustomMethod custom = new CustomMethod();
	String path =  custom.getPath();
		  	
	  	
	    public String readApplicationFile(String key){ 
	    	String value = "";
	        try{  
	        	
		          Properties prop = new Properties();
		          File f = new File(path + "//src//com/ADMNetworks//Config//application.properties");
		          if(f.exists()){
			          prop.load(new FileInputStream(f));
			          value = prop.getProperty(key);  
	          	}
		   }
	        catch(Exception e){  
	           System.out.println("Failed to read from application.properties file.");  
	        }
	        return value;
	     } 
	    
	    public String readLoginFile(String key){ 
	    	String value = "";
	        try{  
	        	
		          Properties prop = new Properties();
		          File f = new File(path + "//src//com/ADMNetworks//Config//Login.properties");
		          if(f.exists()){
			          prop.load(new FileInputStream(f));
			          value = prop.getProperty(key);  
	          	}
		   }
	        catch(Exception e){  
	           System.out.println("Failed to read from Login.properties file.");  
	       }
	        return value;
     }  
	    public String readDatafrom(String fname, String key){ 
	    	String value = "";
	        try{  
		          Properties prop = new Properties();
		          File f = new File(path + "//src//com/ADMNetworks//Config//"+fname+".properties");
		          if(f.exists()){
			          prop.load(new FileInputStream(f));
			          value = prop.getProperty(key);  
			          if(value.equals("NA"))
			          {
			        	  System.out.println(fname+".properties file does not have records");   
			          }
	          	}else{
	          		System.out.println(fname+".properties file does not exist");  
	          	}
		   }
	        catch(Exception e){  
	           System.out.println("Failed to read from "+fname+".properties file.");  
	        }
	        return value;
	     } 
  }

