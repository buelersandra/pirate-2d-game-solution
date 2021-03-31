package com.example.cashlet.demo.model;

import java.util.ArrayList;

public class PiratePath{
    public ArrayList<int[]> path;
    public int coins;

    public PiratePath(ArrayList<int[]> path,int coins){
        this.path = path;
        this.coins = coins;
    }


    public PiratePath(){
        this.coins = 0;
        this.path = new ArrayList<>();
    }
}