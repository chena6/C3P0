package com.threeao4.greenpentadudes.beerd2;

import java.util.ArrayList;


public interface Expert {

	public ArrayList<Beer> decision(String input, ArrayList<Beer> beers);
	public String toString();
}
