/**
 * 
 */
package com.hitesh.learn.problemsolving.old;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author hitjoshi
 * Parser Class to parse CVA files from Hp FTP
 * Populates a Map with all key Value pairs, which in turn is used to populate an enum with required Values only
 * Write Logic to get File from FTP-- Take from Saurabh
 *  Write Logic, if required, to get data that is not a Key Value Pair
 */
public class CVAFileParser
{
	//private final Path fFilePath;
	private final static Charset ENCODING = StandardCharsets.UTF_8;  

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String filePath = "C:\\Users\\hitjoshi\\Desktop\\CAL\\Sprint_2\\sp42203.cva";
		//String filePath = "ftp://ftp.hp.com/pub/softpaq/sp45001-45500/sp45117.cva";
		try {
			Map<String, String> keyValuePair =	processLineByLine(filePath);
			for(Map.Entry<String, String> entry: keyValuePair.entrySet())
			{
				System.out.println(" Key: "+entry.getKey() + "  Value:  " + entry.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static final Map <String ,String > processLineByLine(String filePath) throws IOException, URISyntaxException  {
		Path path = Paths.get(filePath);
		Map<String, String> map = new LinkedHashMap<String,String>();
		// BufferedReader in = new BufferedReader(new InputStreamReader(new InputStream(filePath)));
		 
		//Get  a scanner for the whole file
		Scanner scanner =  new Scanner(path, ENCODING.name());
		while (scanner.hasNextLine())
		{				
			String scannedLine = scanner.nextLine();
			scannedLine = scannedLine.trim();
			Scanner lineScanner = new Scanner(scannedLine);
			Pattern p =  Pattern.compile("\\s*=\\s*");
			if(scannedLine.contains("=") && !scannedLine.endsWith("=") )
			{
				lineScanner.useDelimiter(p);

				if (lineScanner.hasNext())
				{
					String name = lineScanner.next();
					String value = lineScanner.next();
					map.put(name, value);
				}

			}
			lineScanner.close();
		}
		scanner.close();
		return map;
	}		
	
}
