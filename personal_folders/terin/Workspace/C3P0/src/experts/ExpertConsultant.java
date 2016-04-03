package experts;

import java.util.ArrayList;

import main.Beer;

public class ExpertConsultant {
	
	private ArrayList<Beer> beers;
	
	private String typeInput;
	private String styleInput;
	private String originInput;
	
	private TypeExpert typeExpert = new TypeExpert();
	private StyleExpert styleExpert = new StyleExpert();
	private OriginExpert originExpert = new OriginExpert();
	
	public ExpertConsultant(ArrayList<Beer> b, String ti, String si, String oi) {
		beers = b;
		typeInput = ti;
		styleInput = si;
		originInput = oi;
	}
	
	public ArrayList<Beer> getTypeExpertResults() {
		return typeExpert.decision(typeInput, beers);
	}
	
	public ArrayList<Beer> getStyleExpertResults() {
		return styleExpert.decision(styleInput, beers);
	}
	
	public ArrayList<Beer> getOriginExpertResults() {
		return originExpert.decision(originInput, beers);
	}

	public ArrayList<Beer> consult() {
		
		OriginExpert originExpert = new OriginExpert();
		StyleExpert styleExpert = new StyleExpert();
		TypeExpert typeExpert = new TypeExpert();
		
		ArrayList<Beer> filter1 = originExpert.decision(originInput, beers);
		ArrayList<Beer> filter2 = styleExpert.decision(styleInput, filter1);
		ArrayList<Beer> results = typeExpert.decision(typeInput, filter2);
		
		return results;
	}
}
