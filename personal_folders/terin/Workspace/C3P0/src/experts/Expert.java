package experts;

import java.util.ArrayList;

import main.Beer;

public interface Expert {

	public ArrayList<Beer> decision(String input, ArrayList<Beer> beers);
	public String toString();
}
