package com.example.mitchell.myapplication;

/**
 * Created by mitchell on 4/3/16.
 */
public class BeerProvider {

    private String beer_Name;
    private String expert_Info_1;
    private String expert_Info_2;
    private String expert_Info_3;

    public BeerProvider(String beer_Name, String expert_Info_1, String expert_Info_2,
                 String expert_Info_3){

        this.setBeer_Name(beer_Name);
        this.setExpert_Info_1(expert_Info_1);
        this.setExpert_Info_2(expert_Info_2);
        this.setExpert_Info_3(expert_Info_3);
    }


    // Getters and setters

    public String getExpert_Info_3() {
        return expert_Info_3;
    }

    public void setExpert_Info_3(String expert_Info_3) {
        this.expert_Info_3 = expert_Info_3;
    }

    public String getExpert_Info_2() {
        return expert_Info_2;
    }

    public void setExpert_Info_2(String expert_Info_2) {
        this.expert_Info_2 = expert_Info_2;
    }

    public String getExpert_Info_1() {
        return expert_Info_1;
    }

    public void setExpert_Info_1(String expert_Info_1) {
        this.expert_Info_1 = expert_Info_1;
    }

    public String getBeer_Name() {
        return beer_Name;
    }

    public void setBeer_Name(String beer_Name) {
        this.beer_Name = beer_Name;
    }

}
