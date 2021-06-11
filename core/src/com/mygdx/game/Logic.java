package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class Logic {

    private Random random = new Random();
    private boolean[][] floor1;
    private boolean[][] floor2;
    private int floorLength;
    private  short time = 0;

    public Logic(int floorLength) {
        this.floorLength = floorLength;
        floor1 = new boolean[floorLength][floorLength];
        floor2 = new boolean[floorLength][floorLength];

        for (int i = 0; i < floorLength; i++) {
            for (int j = 0; j < floorLength; j++) {
                if(random.nextInt(4)==0) floor1[i][j] = true;
                else floor1[i][j] = false;
                floor2[i][j] = false;
            }
        }
    }

    public void render() {
        if(time % 30==0 && Gdx.input.isTouched()) {
            for (int i = 0; i < floorLength; i++) {
                for (int j = 0; j < floorLength; j++) {
                    int counter = 0;
                    if (i + 1 < floorLength && j + 1 < floorLength)
                        if (floor1[i + 1][j + 1]) counter++;
                    if (i + 1 < floorLength) if (floor1[i + 1][j]) counter++;
                    if (j + 1 < floorLength) if (floor1[i][j + 1]) counter++;
                    if (i + 1 < floorLength && j - 1 >= 0) if (floor1[i + 1][j - 1]) counter++;
                    if (j - 1 >= 0) if (floor1[i][j - 1]) counter++;
                    if (i - 1 >= 0 && j - 1 >= 0) if (floor1[i - 1][j - 1]) counter++;
                    if (i - 1 >= 0) if (floor1[i - 1][j]) counter++;
                    if (i - 1 >= 0 && j + 1 < floorLength) if (floor1[i - 1][j + 1]) counter++;
                    if (floor1[i][j] && (counter < 2 || counter > 3)) {
                        floor2[i][j] = false;
                    } else if (!floor1[i][j] && counter >= 3) {
                        floor2[i][j] = true;
                    } else {
                        floor2[i][j] = floor1[i][j];
                    }
                }
            }
            floor1 = floor2;
            for (int i = 0; i < floorLength; i++) {
                for (int j = 0; j < floorLength; j++) {
                    //floor2[i][j] = false;
                }
            }
        }
        time++;
    }

    public boolean[][] getData(){
        return floor1;
    }
}
