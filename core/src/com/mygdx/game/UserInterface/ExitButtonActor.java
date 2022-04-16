package com.mygdx.game.UserInterface;

import static com.mygdx.game.Live.SCREEN_WIDTH;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;
import com.mygdx.game.MainMenu.MainMenuScreen;

public class ExitButtonActor extends BaseButtonActor{

    private GameScreen gameScreen;

    public ExitButtonActor(GameScreen gameScreen) {
        super(new Vector2(0,5), "exit", gameScreen.live.font);
        this.gameScreen = gameScreen;
        setBounds(0, 5, (float) (gameScreen.live.font.getXHeight() * ("exit".length() - 0.3)), gameScreen.live.font.getLineHeight());
    }

    @Override
    protected void function() {
        gameScreen.live.setScreen(new MainMenuScreen(gameScreen.live));
    }
}
