package org.qohs.clicker;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.io.InputHandler;
import org.qohs.clicker.screens.GameScreen;
import org.qohs.clicker.screens.MenuScreen;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.menu.Menu;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Do not touch this code - it's copy pasted from somewhere... it creates a game
 * @author Sam Holmberg
 *
 */
//I'm sorry, we touched it. @vigilante Derek Zhang

public class Clicker extends Game {
    
    private static GameScreen gameScreen;
    private static MenuScreen menuScreen;
    
    private static ScreenType currentType = ScreenType.GAME;
    
    public void create() {
        AssetLoader.load();
        gameScreen = new GameScreen();
        setClickerScreen(ScreenType.GAME);
		Gdx.input.setInputProcessor(new InputHandler());
    }

	@Override
	public void render() {

		//Gdx.gl.glClearColor(0, 0, 0, 0);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
    
    public void setLocalClickerScreen(ScreenType screen) {
    	currentType = screen;
        switch (screen) {
	        case GAME: 
	            setScreen(gameScreen);
	            break;
	        case MENU:
	        	if (menuScreen == null)
	        		menuScreen = new MenuScreen();
	            setScreen(menuScreen);
	            break;
            default: 
	            setScreen(gameScreen);
	            System.out.println("DEFAULTED ON setClickerScreen() - NOT GOOD");
            	break;
        }
    }
    
    public static void setClickerScreen(ScreenType screen) { //static reference method for method above (thanks Derek)
    	System.out.println("SCREEN CHANGE TO: " + screen);
    	ApplicationListener appListener = Gdx.app.getApplicationListener();
		if (appListener instanceof Clicker) {
			Clicker clicker = (Clicker) appListener;
			clicker.setLocalClickerScreen(screen);
		}
    }
    
    public static ScreenType getClickerScreenType() {
        return currentType;
    }
    
    public static Screen getClickerScreen() {
//      too annoying :(
//    	if (gameScreen == null)
//    		System.out.println("GAME SCREEN NULL");
//    	if (menuScreen == null)
//    		System.out.println("MENU SCREEN NULL");
	    switch (getClickerScreenType()) {
	        case GAME: 
	            return gameScreen;
	        case MENU:
	        	return menuScreen;
	        default: 
	            System.out.println("DEFAULTED ON getClickerScreen() - NOT GOOD");
	            return gameScreen;
	    }
    }

    public enum ScreenType {
        GAME,
        MENU;
    }

	@Override
	public void resize(int width, int height) {

		GameWorld.GAMEWIDTH = width;
		GameWorld.GAMEHEIGHT = height;
		Menu.GAMEWIDTH = width;
		Menu.GAMEHEIGHT = height;
	}
}
