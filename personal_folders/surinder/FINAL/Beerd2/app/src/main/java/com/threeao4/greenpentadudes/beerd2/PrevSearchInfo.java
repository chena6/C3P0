package com.threeao4.greenpentadudes.beerd2;

/**
 * Created by GlenCoco on 16-04-06.
 */
public class PrevSearchInfo {

    private String typeofSearch = "";
    private String styleofSearch = "";
    private String countryofSearch = "";
    private String beerResult = "";

    public PrevSearchInfo(){
        typeofSearch = "No info";
        styleofSearch = "No info";
        countryofSearch = "No info";
        beerResult = "Not found";
    }

    public void updateInfo(String t, String s, String c){
        this.typeofSearch = t;
        this.styleofSearch = s;
        this.countryofSearch = c;
    }

    public void updateBeerResult(String r){
        this.beerResult = r;
    }

    public String getTypeofSearch(){
        return this.typeofSearch;
    }
    public String getStyleofSearch(){
        return this.styleofSearch;
    }
    public String getCountryofSearch(){
        return this.countryofSearch;
    }

    public String getBeerResult(){
        return this.beerResult;
    }
}
