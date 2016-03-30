import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;

public class Parser {

	private final static int PAGES = 100;
	private final static String URL = "http://lcboapi.com/products?q=beer&per_page=10&page=";
	private final static String KEY = "&access_key=MDo5ZWEzNDRhMC1lOTY3LTExZTUtOTEwYS02ZjE1YTFkMjkyNGM6SUV4bzZlVGtLdTZadlp2MmRDamNJaEdNNFlRMTc4Y1lDaDJ6";
	
	private static JSONObject js;
	
	public static void main(String[] args) {
		Parser.parse();
	}
	
	public static void parse() {
		//createData();

        try {
			PrintWriter writer = new PrintWriter("data2.txt", "UTF-8");
    		InputStream is = new FileInputStream("data.json");
            String jsonTxt = IOUtils.toString(is);
          //  System.out.println(jsonTxt);
			JSONObject json = new JSONObject(jsonTxt);
			org.json.JSONArray ja = json.getJSONArray("result");
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = ja.getJSONObject(i);
				String name = jo.getString("name");
				writer.println(name);

				//String secondary_category = jo.getString("secondary_category");
				//Object style = jo.get("style");
				//Object tasting_note = jo.get("tasting_note");
				//System.out.println(i + " : " + name);
				//System.out.println(json.get("result"));
			}
			writer.close();
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}       
		

/*
		
		try {
			JSONArray ja = js.getJSONArray("result");
			PrintWriter writer = new PrintWriter("data2.txt", "UTF-8");
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = ja.getJSONObject(i);
				String name = jo.getString("name");
				
				writer.println(name);
				System.out.println(name);

				//String secondary_category = jo.getString("secondary_category");
				//Object style = jo.get("style");
				//Object tasting_note = jo.get("tasting_note");
				//System.out.println(i + " : " + name);
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}

	private static void createData() {
		
		try {
			PrintWriter writer = new PrintWriter("data.json", "UTF-8");
			writer.write("{ \"result\": [");
			for (int i = 1; i < PAGES; i++) {
				String data = new String(readURL(URL + i + KEY));
				if (i == PAGES-1) data = data.substring(0, data.length()-1);
				js = new JSONObject(data);
				writer.println(data);
			}
			writer.write("]}");

			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

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
			
			String s = buffer.toString();
			s = s.substring(s.indexOf("result")+9, s.indexOf("],\"suggestion\":")) + ",";
			return s;
		} finally {
			if (reader != null)
				reader.close();
		}
	}

}
