package com.hitesh.learn.problemsolving.old;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
 
public class JsonMapExample {
    public static void main(String[] args) {
 
	String jsonString = "{\"testing\":\"http://iloseiwin\"},{\"tests\":\"http://akbja\"},{\"virtuso\":\"http://www.savant.com\"},{\"rendezvous\":\"http://www.facebook.com\"},{\"Vendetta\":\"http://www.imdb.com\"},{\"mostttt\":\"http://jkjkljkljk\"},{\"sad\":\"sadasd\"}"; 
    	//String jsonArray = "{\"name\":\"mkyong\", \"age\":\"29\"}";
    	String [] jsonArray =  jsonString.split(",");
    	System.out.println("Array Szie"+jsonArray.length);
    	ObjectMapper mapper = new ObjectMapper();
    	Map<String, String>valueAndURLMap = new HashMap<String, String>();
    	for(String str:jsonArray)
    	{
	
    		Map<String, String> tempMap = new HashMap<String, String>();
	
				try {
				tempMap = mapper.readValue(str,
						new TypeReference<HashMap<String, String>>() {
				});
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
				 for (Map.Entry<String, String> entry : tempMap.entrySet()) {

					 valueAndURLMap.put(entry.getKey(), entry.getValue());
					    }	
				
    	}
		
		
	
    for (Map.Entry<String, String> entry : valueAndURLMap.entrySet()) {

 System.out.println(entry.getKey()+"  ---------------  "+entry.getValue());
    }
}
}