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

public class PlayScreen implements Screen {

	private MyGdxGame game;
	private Texture texture,texture2;
	private TextureRegion region;
	Rectangle Tanks;
	Array<Rectangle> Weapons;

	private OrthographicCamera gamecam;
	private Viewport gamePort;


	public PlayScreen(MyGdxGame game) {
		this.game = game;
		texture = new Texture("Untitled.png");
		texture2 = new Texture("Tankstars.png");
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
//		try {
//			sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		game.batch.draw(texture, 0, 0);
		game.batch.draw(texture, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		game.font.draw(game.batch, "Welcome to Tankstars2!!! ", 100, 150)
		//Display message Welcome to Tankstars
		//print texture2 after 5 seconds
//		try {
//			sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		game.batch.draw(texture2, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		game.batch.draw(texture2, 0, 0);
//		game.batch.draw(texture2, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		game.batch.draw(texture2, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		game.batch.draw(texture2, 0, 0);
//		try {
//			wait(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Texture img = new Texture("bad.jpg");
//		game.batch.draw(img, 0, 0);
//		game.batch.end();
//		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Tankstars", 100, 150);
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
