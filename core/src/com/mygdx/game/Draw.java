package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.mygdx.game.Live.SCREEN_HEIGHT;
import static com.mygdx.game.Live.SCREEN_WIDTH;

public class Draw {

    private ShapeRenderer renderer;
    private Logic logic;

    public Draw(){
        renderer = new ShapeRenderer();
        logic = new Logic(10);
    }

    public void render(){
        ScreenUtils.clear((float) 0.5, (float) 0.5, (float) 0.5, 1);
        logic.render();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int i = 0; i<logic.getData().length; i++){
            for(int j = 0; j<logic.getData().length; j++){
                if(logic.getData()[i][j]){
                    renderer.setColor(Color.WHITE);
                } else {
                    renderer.setColor(Color.BLACK);
                }
                renderer.rect(SCREEN_HEIGHT/logic.getData().length * j+1, SCREEN_WIDTH/logic.getData().length * i+1, SCREEN_HEIGHT/logic.getData().length-2, SCREEN_WIDTH/logic.getData().length-2);
            }
        }
        renderer.end();
    }

    public void dispose(){
        renderer.dispose();
    }
}
