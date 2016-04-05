package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import experts.ExpertConsultant;
import security.Encryption;

public class Controller {
	
	private static ArrayList<Beer> beers;

	public static void main(String[] args) {
		//Parser.parse();
		
		beers = new ArrayList<Beer>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("data/data.txt"));
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
		
		
		//TODO(terin): Get the inputs from the UI here
		
		
		ExpertConsultant expertConsultant = new ExpertConsultant(beers, "Lager", "Light and Malty", "Canada");
		
		expertConsultant.getTypeExpertResults();
		expertConsultant.getStyleExpertResults();
		expertConsultant.getOriginExpertResults();
		expertConsultant.consult();
		
		for (Beer b : expertConsultant.getOriginExpertResults()) System.out.println(b);
		
		//TODO(terin): Send the results above to the UI here
		
		
	}
}
