package com.example.cashlet.demo.service;

import java.util.ArrayList;

import com.example.cashlet.demo.model.PiratePath;

import org.springframework.stereotype.Service;

@Service
public class PathFinderService{

    public PiratePath findPath(int[][] field,int startx,int starty,int targetx, int targety ) {
        PiratePath piratePath = new PiratePath();
        if(field.length == 0){
            return piratePath;
        }
        
        ArrayList<int[]> pathList = new ArrayList<int[]>();
        
        field = reverseList(field);
        int r = field.length;
        int c = field[0].length;
        int[][] maxValues = new int[r][c];
        boolean[][] path = new boolean[r][c];


        int maxR = 0,maxC = 0;
        for (int i = startx; i <= targetx; i++) {
            for (int j = starty; j <= targety; j++) {
                if (i == 0 && j == 0) {
                    maxValues[i][j] = field[i][j];
                    path[i][j] = true;
                } else if (i == 0) {
                    maxValues[i][j] = maxValues[i][j-1] + field[i][j];
                    path[i][j] =  maxValues[i][j] >= maxValues[i][j-1];
                } else if (j == 0) {
                    maxValues[i][j] = maxValues[i-1][j] + field[i][j];
                    path[i][j] =  maxValues[i][j] >= maxValues[maxR][maxC];
                } else {
                    maxValues[i][j] = Math.max(maxValues[i][j-1], maxValues[i-1][j]) + field[i][j];
                    path[i][j] =  maxValues[i][j] >=  maxValues[maxR][maxC];
                }

                if(path[i][j] == true){
                    maxR = i;
                    maxC = j;
                    System.out.println(j+","+i);

                    pathList.add(new int[]{j,i});
                }
                
            }

           

        }
      
        piratePath.coins =  maxValues[targetx][targety];
        piratePath.path = pathList;
        
        return piratePath;
    }

    public static int[][] reverseList(int[][] points){
        int[][] result = new int[points.length][];
        for(int i = points.length-1,r = 0; i>=0; i--,r++){
            result[r] = points[i];
        }

        return result;
    }
}