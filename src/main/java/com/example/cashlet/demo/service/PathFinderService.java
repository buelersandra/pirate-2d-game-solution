package com.example.cashlet.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.cashlet.demo.model.PirateMap;
import com.example.cashlet.demo.model.PiratePath;

import org.springframework.stereotype.Service;

@Service
public class PathFinderService{

    public PiratePath findPath(List<List<PirateMap>> map,int startx,int starty,int targetx, int targety ) {

        PiratePath piratePath = new PiratePath();
        if(map.size() == 0){
            return piratePath;
        }
        
        map = reverseList(map);
        int r = map.size();
        int c = map.get(0).size();
        int[][] maxValues = new int[r][c];
        boolean[][] path = new boolean[r][c];

        List<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        int maxR = 0,maxC = 0;


        for (int i = startx; i <= targetx; i++) {
            for (int j = starty; j <= targety; j++) {

               
                if (i == 0 && j == 0) {
                    maxValues[i][j] = (Integer) map.get(i).get(j).getAmountValue();
                } else if (i == 0) {
                    maxValues[i][j] = maxValues[i][j-1] + (Integer) map.get(i).get(j).getAmountValue();
                } else if (j == 0) {
                    maxValues[i][j] = maxValues[i-1][j] + (Integer) map.get(i).get(j).getAmountValue();
                } else {

                    // System.out.println(maxValues[i][j-1] + ","+maxValues[i-1][j]+"+"+(Integer) map.get(i).get(j).getAmountValue());
                    // if(map.get(i).get(j).getType().equalsIgnoreCase("rock")){
                    //     maxValues[i][j] = maxValues[i][j-1];
                    // }else{
                    //     maxValues[i][j] = Math.max(maxValues[i][j-1], maxValues[i-1][j]) + (Integer) map.get(i).get(j).getAmountValue();
                    // }

                    maxValues[i][j] = Math.max(maxValues[i][j-1], maxValues[i-1][j]) + (Integer) map.get(i).get(j).getAmountValue();


                }

                
                path[i][j] =  maxValues[i][j] >=  maxValues[maxR][maxC];
            


                if(path[i][j] == true){
                    maxR = i;
                    maxC = j;
                    pathList.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{j,i})));
                }
                
            }
        }
      
        piratePath.coins =  maxValues[targetx][targety];
        piratePath.path = pathList;
        
        return piratePath;
    }



    public static List<List<PirateMap>> reverseList(List<List<PirateMap>> points){
        List<List<PirateMap>> result = new ArrayList<List<PirateMap>>() ;
        for(int i = points.size() - 1,r = 0; i>=0; i--,r++){
            result.add(r, points.get(i));
        }

        return result;
    }
}