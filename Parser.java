import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Parser {
	
	//private final static String API_KEY = "?access_key=MDozMGYxNGI5MC1lOTY4LTExZTUtODcyNy1hNzQyYzA4MzA1NTA6RkFXb0lVS1VkazB0cWw2cklDTm51RzFob1ZYcThSNFNEQTY5";
	
	private static String readURL(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 
	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
	public static void main(String[] args) throws Exception {
		try {
		    PrintWriter writer = new PrintWriter("stuff.txt", "UTF-8");
			String url = new String("http://lcboapi.com/products?q=beer&per_page=100&page=");
			
			for (int i = 1; i < 11; i++) {
				String data = new String(readURL(url + i));
			    JSONObject json = new JSONObject(data);
			    String x = (String) json.toString();
			    System.out.println(x);
			    writer.println(x);
			}
		    writer.close();
		} catch (JSONException e) {
		    e.printStackTrace();
		}
	}

}
