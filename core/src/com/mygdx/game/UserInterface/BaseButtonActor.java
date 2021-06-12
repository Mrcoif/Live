package com.mygdx.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.mygdx.game.Live.touchPos;

public class BaseButtonActor extends Actor {

    protected Texture texture;
    public String id;
    public boolean isTouched = false;
    public int speed = 10;

    private int time = 0;

    public BaseButtonActor(String path, Rectangle boundary) {
        setBounds(boundary.x, boundary.y, boundary.width, boundary.height);
        this.id = id;
        texture = new Texture(Gdx.files.internal(path));
    }

    @Override
    public void act(float delta) {
        if(time<speed) time++;
        if(time >= speed && Gdx.input.isTouched() && touchPos.x > getX() && touchPos.y > getY() && touchPos.x < getX()+getWidth() && touchPos.y < getY() + getHeight()){
            isTouched = true;
            time = 0;
        } else{
            isTouched = false;
        }
        if(isTouched) {
            function();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    protected void function(){

    }
}
