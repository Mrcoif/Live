package com.mygdx.game.UserInterface;

import static com.mygdx.game.Live.SCREEN_WIDTH;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.GameScreen;

public class SizeChangerActor extends Actor {
    private GameScreen gameScreen;

    private Stage stagePlusMinus;

    private BaseButtonActor plus;
    private BaseButtonActor minus;

    private int size = 0;
    private int sizeRange = 50;

    public SizeChangerActor(GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        size = gameScreen.logic.floorLength;
        stagePlusMinus = new Stage();

        plus = new BaseButtonActor(new Vector2(SCREEN_WIDTH-60-5, 215), "+", gameScreen.live.font);
        plus.speed = 5;
        plus.setWidth(60);
        minus = new BaseButtonActor(new Vector2(SCREEN_WIDTH-plus.getWidth()*2-10, 215), "-", gameScreen.live.font);
        minus.speed = 5;
        minus.setWidth(plus.getWidth());

        stagePlusMinus.addActor(plus);
        stagePlusMinus.addActor(minus);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        stagePlusMinus.act();
//        plus.act(delta);
//        minus.act(delta);
        if (size < sizeRange) {
            for (Actor actor : gameScreen.stage.getActors()) {
                if (actor instanceof BaseButtonActor) {
                    if(((BaseButtonActor) actor).getActorName().equals("-") && ((BaseButtonActor) actor).isTouched){
                        size++;
                        gameScreen.logic.setFloorLength(gameScreen.logic.floorLength+1);
                    }
                }
            }
        } else if (size >2) {
            for (Actor actor : gameScreen.stage.getActors()) {
                if (actor instanceof BaseButtonActor) {
                    if(((BaseButtonActor) actor).getActorName().equals("+") && ((BaseButtonActor) actor).isTouched){
                        size--;
                        gameScreen.logic.setFloorLength(gameScreen.logic.floorLength-1);
                    }
                }
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        stagePlusMinus.draw();
//        plus.draw(batch, parentAlpha);
//        minus.draw(batch, parentAlpha);
    }
//    if (size < sizeRange) {
//        for (Actor actor : gameScreen.stage.getActors()) {
//            if (actor instanceof BaseButtonActor) {
//                if(((BaseButtonActor) actor).getActorName().equals("+") && ((BaseButtonActor) actor).isTouched){
//                    size++;
//                    gameScreen.logic.setFloorLength(gameScreen.logic.floorLength+1);
//                }
//            }
//        }
//    } else if (size >2) {
//        for (Actor actor : gameScreen.stage.getActors()) {
//            if (actor instanceof BaseButtonActor) {
//                if(((BaseButtonActor) actor).getActorName().equals("-") && ((BaseButtonActor) actor).isTouched){
//                    size--;
//                    gameScreen.logic.setFloorLength(gameScreen.logic.floorLength-1);
//                }
//            }
//        }
//    }
}
