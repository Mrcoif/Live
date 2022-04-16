package com.mygdx.game.MainMenu;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Live;

public class MainMenuScreen implements Screen {

    public Live live;
    public Stage stage;

    public MainMenuScreen(Live live) {
        this.live = live;
        stage = new Stage();
        addActors();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0 ,0 ,1);

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

    @Override
    public void dispose() {

    }

    private void addActors(){
        stage.addActor(new StartButtonActor(this));
        stage.addActor(new RulesButtonActor(this));
    }
}
