package com.threeao4.greenpentadudes.beerd2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.threeao4.greenpentadudes.beerd2.ExpertConsultant;
import com.threeao4.greenpentadudes.beerd2.Encryption;

public class Controller {

	private static ArrayList<Beer> beers = new ArrayList<>();
	
	private ArrayList<Beer> typeResults;
	private ArrayList<Beer> styleResults;
	private ArrayList<Beer> originResults;
	private ArrayList<Beer> results;



	public Controller(InputStream is, String typeInput, String styleInput, String originInput) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));



			String currentLine = br.readLine();

			while (currentLine != null) {
				currentLine = Encryption.decrypt(currentLine);
				String[] elements = currentLine.split(",");
				beers.add(new Beer(elements[0], elements[1], elements[2], elements[3]));
				currentLine = br.readLine();



			}
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		ExpertConsultant expertConsultant = new ExpertConsultant(beers, typeInput, styleInput, originInput);
		
		typeResults = expertConsultant.getTypeExpertResults();
		styleResults = expertConsultant.getStyleExpertResults();
		originResults = expertConsultant.getOriginExpertResults();
		results = expertConsultant.consult();
	}

	public ArrayList<Beer> getTypeResults() {
		return typeResults;
	}
	
	public ArrayList<Beer> getStyleResults() {
		return styleResults;
	}
	
	public ArrayList<Beer> getOriginResults() {
		return originResults;
	}
	
	public ArrayList<Beer> getResults() {
		return results;

	}


}
