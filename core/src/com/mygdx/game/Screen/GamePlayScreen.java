package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import java.awt.*;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class GamePlayScreen implements Screen {

	MyGdxGame game;
	private Texture texture,texture2,play_button_active,play_button_inactive,exit_button_active,exit_button_inactive;
	private TextureRegion region;

	private OrthographicCamera gamecam;
	private Stage stage;
	private Viewport gamePort;

	private Texture gameplayscreen;
	private Image gameplayscreen_image;
//	private OrthographicCamera gamecam;
//	public GamePlayScreen(MyGdxGame game) {
//		this.game = game;
//		System.out.printf("GamePlayScreen created");
//
//	}
public GamePlayScreen(MyGdxGame game) {
	this.game = game;
	texture = new Texture("gameplayscreen1.jpg");
	gameplayscreen_image = new Image(texture);
	System.out.println("GamePlayScreen created 2");
	region = new TextureRegion(texture, 0, 0, 32, 32);
	gamecam = new OrthographicCamera();
	gamePort = new StretchViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
	stage = new Stage(gamePort);
	gameplayscreen_image.setPosition(0,0);
	stage.addActor(gameplayscreen_image);

//		gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		System.out.println("show 2.1");
		gameplayscreen_image.addAction(sequence(alpha(0), fadeIn(2f)));
		gameplayscreen_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.printf("GamePlayScreen clicked 2.3");
//				game.setScreen(new GamePlayScreen(game));
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.setProjectionMatrix(gamecam.combined);
		update(delta);
		stage.draw();
		game.batch.begin();
		game.batch.end();
	}
//		Gdx.gl.glClearColor(1, 0, 1, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		game.batch.setProjectionMatrix(gamecam.combined);
//		game.batch.begin();
////		game.batch.draw(texture,-Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth()-326, Gdx.graphics.getHeight());
//		if (Gdx.input.isTouched()){
//			game.setScreen(new NewGame(game));
////			dispose();
////		}
////		if (Gdx.input.getX() > 0 && Gdx.input.getX() < 200 && Gdx.input.getY() > 0 && Gdx.input.getY() < 200) {
////			game.batch.draw(play_button_active, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
////		} else {
////			game.batch.draw(play_button_inactive, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
////		}
////		if (Gdx.input.getX() > 0 && Gdx.input.getX() < 200 && Gdx.input.getY() > 0 && Gdx.input.getY() < 200) {
////			game.batch.draw(exit_button_active, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
////		} else {
////			game.batch.draw(exit_button_inactive, -Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
////		}
//		if (Gdx.input.isTouched()){
//			dispose();
//			game.setScreen(new GamePlayScreen(game));
//		}
//		game.batch.end();
//	}

	public void update(float delta){
		stage.act(delta);
//		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
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
		texture.dispose();
		stage.dispose();
	}
}
