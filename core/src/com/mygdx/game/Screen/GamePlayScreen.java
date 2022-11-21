package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

public class GamePlayScreen implements Screen {
	private final MyGdxGame game;
	private final OrthographicCamera gamecam;
	private Texture gameplayscreen;
//	private OrthographicCamera gamecam;
	private Viewport gamePort;
	public GamePlayScreen(MyGdxGame game) {
		this.game = game;
		System.out.printf("GamePlayScreen created");
		gameplayscreen = new Texture("gameplayscreen1.jpg");
		TextureRegion regions = new TextureRegion(gameplayscreen, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
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
		game.batch.draw(gameplayscreen, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		gamePort.update(width, height);
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
