package com.hitesh.learn.problemsolving.old;
import java.util.ArrayList;
import java.util.List;


public class DeleteProgram {

	public static void main(String args[])
	{
		
		/*Path filepath= Paths.get("C:/Temp/"+"myImage.png");		
		try {
		    // Create the empty file with default permissions, etc.
			filepath =	Files.createFile(filepath);
			
		} catch (FileAlreadyExistsException x) {
		    System.err.format("file named %s" +
		        " already exists%n", filepath);
		} catch (IOException x) {
		    // Some other sort of failure, such as permissions.
		    System.err.format("createFile error: %s%n", x);
		}*/
/*		String tDir = System.getProperty("java.io.tmpdir");
		File file = new File("C:/Temp/"+"myImage.png");
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	String str = "apj-jh-hans";
	String regionCode= str.substring(0, str.indexOf("-", 0));
	String langCode= str.substring(str.indexOf("-", 0)+1,str.length());
	System.out.println(regionCode);
	System.out.println(langCode);
		
	}
	
}
