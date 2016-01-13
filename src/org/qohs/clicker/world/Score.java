package org.qohs.clicker.world;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.util.UpdateRenderObj;
import org.qohs.clicker.world.gameobjects.Donut;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Score implements UpdateRenderObj {

	private static Donut donut;
	
	public Score(Donut donut) {
		this.donut = donut;
		GameWorld.registerUpdates(this, false, true);
	}
	
	private static long score = 0;
	
	public static void setScore(long score) {
		Score.score = score;
	}
	
	public static void addScore(int addition) {
		score += addition;
	}
	
	public static void addScore(int clicks, double multiplier) {
		
		addScore((int)(multiplier * clicks));
	}
	
	public static void addClicks(int addition) {
		addScore((int)(AssetLoader.multiplierMap.get(donut.getTopping().toString()) * addition));
	}
	
	public static long getScore() {
		return score;
	}
	
	public void render(SpriteBatch batcher, ShapeRenderer renderer) {
		batcher.begin();
		GlyphLayout glyphLayout = new GlyphLayout();
		String item = Long.toString(getScore());
		glyphLayout.setText(AssetLoader.score_font, item);
		float w = glyphLayout.width;
		AssetLoader.score_font.draw(batcher, glyphLayout, (GameWorld.GAMEWIDTH - w)/2, 25);
		batcher.end();
	}

	public void update(float delta) { //method disabled as per constructor
		// TODO Auto-generated method stub
		
	}
}