package com.mygdx.game.MainMenu;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;
import com.mygdx.game.UserInterface.BaseButtonActor;

import static com.mygdx.game.Live.SCREEN_HEIGHT;
import static com.mygdx.game.Live.SCREEN_WIDTH;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RulesButtonActor  extends BaseButtonActor {

    private MainMenuScreen mainMenuScreen;

    public RulesButtonActor(MainMenuScreen mainMenuScreen) {
        super(new Vector2(SCREEN_WIDTH/4, SCREEN_HEIGHT/3), "rules", mainMenuScreen.live.font);
        this.mainMenuScreen = mainMenuScreen;
    }

    @Override
    protected void function() throws URISyntaxException {
        URI uri = new URI("https://hsto.org/getpro/habr/post_images/bf4/532/d73/bf4532d731026f10377b451dcf8ecdd7.jpg");
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
