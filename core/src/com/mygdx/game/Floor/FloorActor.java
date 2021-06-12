package com.mygdx.game.Floor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;

import static com.mygdx.game.Live.SCREEN_HEIGHT;
import static com.mygdx.game.Live.SCREEN_WIDTH;
import static com.mygdx.game.Live.touchPos;

public class FloorActor {

    private Rectangle rect = new Rectangle();
    private Texture black;
    private Texture grey;
    private Texture white;
    
    private int time = 0;
    
    private GameScreen gameScreen;
    
    public FloorActor(GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        black = new Texture(Gdx.files.internal("floor/black.png"));
        grey = new Texture(Gdx.files.internal("floor/grey.png"));
        white = new Texture(Gdx.files.internal("floor/white.png"));
    }
    
    public void render(){
        gameScreen.live.batch.begin();
        gameScreen.live.batch.draw(grey, 0, SCREEN_HEIGHT - SCREEN_WIDTH, SCREEN_WIDTH, SCREEN_WIDTH);
        for(int i = 0; i< gameScreen.logic.floorLength; i++){
            for(int j = 0; j< gameScreen.logic.floorLength; j++){
                rect.set(SCREEN_WIDTH/ gameScreen.logic.floorLength * j+1, SCREEN_HEIGHT - SCREEN_WIDTH/ gameScreen.logic.floorLength + 2 - (SCREEN_WIDTH/ gameScreen.logic.floorLength * i+1), SCREEN_WIDTH/ gameScreen.logic.floorLength-2, SCREEN_WIDTH/ gameScreen.logic.floorLength-2);
                if(gameScreen.logic.floor[i][j][gameScreen.logic.layerNum]){
                    gameScreen.live.batch.draw(white, rect.x, rect.y, rect.width, rect.height);
                } else {
                    gameScreen.live.batch.draw(black, rect.x, rect.y, rect.width, rect.height);
                }
                if(time == 20 && Gdx.input.isTouched() && touchPos.x > rect.x && touchPos.y > rect.y && touchPos.x < rect.x + rect.width && touchPos.y < rect.y + rect.height){
                    gameScreen.logic.floor[i][j][gameScreen.logic.layerNum] = !gameScreen.logic.floor[i][j][gameScreen.logic.layerNum];
                    time = 0;
                }
            }
        }
        gameScreen.live.batch.end();

        if(time<20) time++;
    }
    
    public void dispose(){
        black.dispose();
        grey.dispose();
        white.dispose();
        gameScreen.dispose();
    }
}
