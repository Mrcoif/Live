package com.mygdx.game.Floor;

import com.badlogic.gdx.Gdx;

import java.util.Random;

import static com.mygdx.game.Live.SCREEN_HEIGHT;
import static com.mygdx.game.Live.SCREEN_WIDTH;
import static com.mygdx.game.Live.touchPos;

public class Logic {

    public boolean[][][] floor;
    public int layerNum = 0;
    public int layerLength = 1024;
    public int floorLength;
    public boolean fulled = false;
    public int firstLayer = 0;

    private Random random = new Random();

    public Logic(int floorLength) {
        this.floorLength = floorLength;
        floor = new boolean[floorLength][floorLength][layerLength];

    }

    public void generateNewLayer() {
        for (int i = 0; i < floorLength; i++) {
            for (int j = 0; j < floorLength; j++) {
                int counter = 0;
                if (i + 1 < floorLength && j + 1 < floorLength)
                    if (floor[i + 1][j + 1][layerNum]) counter++;
                if (i + 1 < floorLength) if (floor[i + 1][j][layerNum]) counter++;
                if (j + 1 < floorLength) if (floor[i][j + 1][layerNum]) counter++;
                if (i + 1 < floorLength && j - 1 >= 0) if (floor[i + 1][j - 1][layerNum]) counter++;
                if (j - 1 >= 0) if (floor[i][j - 1][layerNum]) counter++;
                if (i - 1 >= 0 && j - 1 >= 0) if (floor[i - 1][j - 1][layerNum]) counter++;
                if (i - 1 >= 0) if (floor[i - 1][j][layerNum]) counter++;
                if (i - 1 >= 0 && j + 1 < floorLength) if (floor[i - 1][j + 1][layerNum]) counter++;


                if (floor[i][j][layerNum] && (counter < 2 || counter > 3)) {
                    if (layerNum + 1 < layerLength) {
                        floor[i][j][layerNum + 1] = false;
                    } else {
                        floor[i][j][0] = false;
                    }
                } else if (!floor[i][j][layerNum] && counter >= 3) {
                    if (layerNum + 1 < layerLength) {
                        floor[i][j][layerNum + 1] = true;
                    } else {
                        floor[i][j][0] = true;
                    }

                } else {
                    if (layerNum + 1 < layerLength) {
                        floor[i][j][layerNum + 1] = floor[i][j][layerNum];
                    } else {
                        floor[i][j][0] = floor[i][j][layerNum];
                    }
                }
            }
        }
        if (layerNum == layerLength - 1) {
            layerNum = 0;
            fulled = true;
        } else {
            layerNum++;
        }
        if (fulled) {
            if (firstLayer == layerLength - 1) {
                firstLayer = 0;
            } else {
                firstLayer++;
            }
        }
    }

    public void randomLayer(int chance) {
        layerNum++;
        for (int i = 0; i < floorLength; i++) {
            for (int j = 0; j < floorLength; j++) {
                if (random.nextInt(chance) == 0) {
                    floor[i][j][layerNum] = true;
                }
                else {
                    floor[i][j][layerNum] = false;
                }
            }
        }
    }

    public void clearLayer() {
        layerNum++;
        for (int i = 0; i < floorLength; i++) {
            for (int j = 0; j < floorLength; j++) {
                floor[i][j][layerNum] = false;
            }
        }
    }

    public void setFloorLength(int nextLength) {
        if (nextLength != floorLength) {
            boolean[][][] nextFloor = new boolean[nextLength][nextLength][layerLength];
            if (nextLength > floorLength) {
                for(int i = 0; i<nextLength;i++){
                    for(int j = 0; j<nextLength;j++){
                        if(i<floorLength && j<floorLength) nextFloor[i][j][0] = floor[i][j][layerNum];
                        else nextFloor[i][j][0] = false;
                    }
                }
            } else if (nextLength < floorLength) {
                for(int i = 0; i<nextLength;i++){
                    for(int j = 0; j<nextLength;j++){
                        nextFloor[i][j][0] = floor[i][j][layerNum];
                    }
                }
            }
            layerNum = 0;
            floorLength = nextLength;
            floor = nextFloor;
            fulled = false;
            firstLayer = 0;

        }
    }

    public void dispose() {

    }
}
