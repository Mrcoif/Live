package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Floor.FloorActor;
import com.mygdx.game.Floor.Logic;
import com.mygdx.game.UserInterface.ClearButtonActor;
import com.mygdx.game.UserInterface.MinusButtonActor;
import com.mygdx.game.UserInterface.PlusButtonActor;
import com.mygdx.game.UserInterface.RandomButtonActor;
import com.mygdx.game.UserInterface.RedoButtonActor;
import com.mygdx.game.UserInterface.UndoButtonActor;
import com.mygdx.game.UserInterface.ExitButtonActor;

public class GameScreen implements Screen {

    public Live live;
    public Stage stage;
    public Logic logic;

    private FloorActor floorActor;

    public GameScreen(Live live) {
        this.live = live;
        stage = new Stage();
        logic = new Logic(10);
        floorActor = new FloorActor(this);

        addActors();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0 ,0 ,1);
        floorActor.render();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public void dispose() {
        live.dispose();
    }

    private void addActors() {
        stage.addActor(new ExitButtonActor(this));
        stage.addActor(new RedoButtonActor(this));
        stage.addActor(new UndoButtonActor(this));
        stage.addActor(new PlusButtonActor(this));
        stage.addActor(new MinusButtonActor(this));
        stage.addActor(new ClearButtonActor(this));
        stage.addActor(new RandomButtonActor(this));
    }
}
