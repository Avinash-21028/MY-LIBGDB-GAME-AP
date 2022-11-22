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
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Player;
import com.mygdx.game.Tank;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import com.badlogic.gdx.Screen;

public class PlayGame implements Screen {
	MyGdxGame game;
	private Texture texture1,texture2,texture3,texture4;
	private TextureRegion region;

	private OrthographicCamera gamecam;
	private Stage stage;
	private Viewport gamePort;

	private Image sky,pause;

	public PlayGame(MyGdxGame game){
		this.game = game;
		texture1 = new Texture("sky.jpg");
		sky = new Image(texture1);

		texture2 = new Texture("pause.png");
		pause = new Image(texture2);

//		texture3 = new Texture("load_game.png");
//		load_game_image = new Image(texture3);
//
//		texture4 = new Texture("exit.png");
//		exit_image = new Image(texture4);

		region = new TextureRegion(texture1, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new StretchViewport(1920,1201, gamecam);
		stage = new Stage(gamePort);

		sky.setPosition(0,0);
		pause.setPosition(1800,1800);


		stage.addActor(sky);
		stage.addActor(pause);
//		stage.addActor(load_game_image);
//		stage.addActor(exit_image);

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		sky.addAction(sequence(alpha(0), fadeIn(2f)));
	}

	public void update(float delta){
		stage.act(delta);
//		stage.draw();
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

	public void update(float delta) {
		stage.act(delta);
	}

	@Override
	public void resize(int width, int height) {

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
