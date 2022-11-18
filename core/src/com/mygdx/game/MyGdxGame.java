package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Screen.PlayScreen;

public class MyGdxGame extends Game {
	public static final int V_WIDTH = 786;
	public static final int V_HEIGHT = 461;
	public SpriteBatch batch;
	public BitmapFont font;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Untitled.png");
		font = new BitmapFont();
		img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
	}
}
