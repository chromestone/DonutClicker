package org.qohs.clicker.screens.menu.buttons;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.util.Button;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SettingsButton extends Button {

	public SettingsButton() {
		super(GameWorld.GAMEWIDTH - (GameWorld.GAMEWIDTH/10+5), 5,
				GameWorld.GAMEWIDTH*1/10, GameWorld.GAMEHEIGHT*1/15,
				new TextureRegionDrawable(AssetLoader.icon_settings), new TextureRegionDrawable(AssetLoader.icon_settings));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}

}
