package com.example.cashlet.demo.model;

import java.util.ArrayList;
import java.util.List;

public class PiratePath{
    public List<ArrayList<Integer>> path;
    public int coins;

    public PiratePath(ArrayList<ArrayList<Integer>> path,int coins){
        this.path = path;
        this.coins = coins;
    }


    public PiratePath(){
        this.coins = 0;
        this.path = new ArrayList<>();
    }
}