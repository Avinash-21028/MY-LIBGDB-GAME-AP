package com.mygdx.game.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import static java.lang.Thread.sleep;

public class MainMenuScreen implements Screen {

	private MyGdxGame game;
	private Texture texture,texture2,play_button_active,play_button_inactive,exit_button_active,exit_button_inactive;
	private TextureRegion region;
	Rectangle Tanks;
	Array<Rectangle> Weapons;

	private OrthographicCamera gamecam;
	private Viewport gamePort;


	public MainMenuScreen(MyGdxGame game) {
		this.game = game;
		texture = new Texture("Untitled.gif");
		texture2 = new Texture("Tankstars.png");
		play_button_active = new Texture("play_button_active.png");
		play_button_inactive = new Texture("play_button_inactive.png");
		exit_button_active = new Texture("exit_button_active.png");
		exit_button_inactive = new Texture("exit_button_inactive.png");
		region = new TextureRegion(texture, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new ScreenViewport(gamecam);
//		gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.setProjectionMatrix(gamecam.combined);
		game.batch.begin();
		game.batch.draw(texture, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		if (Gdx.input.getX() > 0 && Gdx.input.getX() < 200 && Gdx.input.getY() > 0 && Gdx.input.getY() < 200) {
//			game.batch.draw(play_button_active, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		} else {
//			game.batch.draw(play_button_inactive, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		}
//		if (Gdx.input.getX() > 0 && Gdx.input.getX() < 200 && Gdx.input.getY() > 0 && Gdx.input.getY() < 200) {
//			game.batch.draw(exit_button_active, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		} else {
//			game.batch.draw(exit_button_inactive, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		}
		if (Gdx.input.isTouched()){
			game.setScreen(new GamePlayScreen(game));
		}
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		gamePort.update(width,height);
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
}
