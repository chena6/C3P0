

package com.threeao4.greenpentadudes.beerd2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class Parser {

	private final static int PAGES = 100;
	private final static String URL = "http://lcboapi.com/products?q=beer&per_page=10&page=";
	private final static String KEY = "&access_key=MDo5ZWEzNDRhMC1lOTY3LTExZTUtOTEwYS02ZjE1YTFkMjkyNGM6SUV4bzZlVGtLdTZadlp2MmRDamNJaEdNNFlRMTc4Y1lDaDJ6";
	
	public static void parse(FileOutputStream fos, InputStream is) {

        try {


			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String jsonTxt = IOUtils.toString(is);
			JSONObject json = new JSONObject(jsonTxt);
			org.json.JSONArray ja = json.getJSONArray("result");
			
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = ja.getJSONObject(i);
				if (jo.getString("primary_category").equals("Beer")) {
					String name = jo.getString("name");
					String type = jo.get("secondary_category").toString();
					String style = jo.get("style").toString();
					String originTemp = jo.get("origin").toString();
					if (originTemp.indexOf(',') >= 0) {
						String origin = originTemp.substring(0, originTemp.indexOf(','));
						fos.write((Encryption.encrypt(name + "," + type  + "," + style  + "," + origin)+ "\n").getBytes());

					}
				}
			}
			
			fos.close();
			is.close();
		
        } catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void start(FileOutputStream fos) {
		
		try {

			fos.write(("{ \"result\": [" + "\n").getBytes());
			
			for (int i = 1; i < PAGES; i++) {
				String data = new String(accessAPI(URL + i + KEY));
				if (i == PAGES-1) data = data.substring(0, data.length()-1);
				fos.write((data + "\n").getBytes());
			}
			
			fos.write((("]}")+"\n").getBytes());
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static String accessAPI(String urlString) throws Exception {
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
