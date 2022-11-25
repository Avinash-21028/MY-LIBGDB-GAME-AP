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

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class PlayGame implements Screen {
	MyGdxGame game;
	int p1_id,p2_id;
	private Texture texture1,texture2,texture3,texture4,texture5;
	private TextureRegion region;

	private OrthographicCamera gamecam;
	private Stage stage;
	private Viewport gamePort;

	private Image sky_image,pause_image,tank1_image,tank2_image,ground_image;

//	public PlayGame(MyGdxGame game){
//		this.game = game;
//		texture1 = new Texture("sky.jpg");
//		sky_image = new Image(texture1);
//
//		texture2 = new Texture("pause.png");
//		pause_image = new Image(texture2);
//
////		texture3 = new Texture("load_game.png");
////		load_game_image = new Image(texture3);
////
////		texture4 = new Texture("exit.png");
////		exit_image = new Image(texture4);
//
//		region = new TextureRegion(texture1, 0, 0, 32, 32);
//		gamecam = new OrthographicCamera();
//		gamePort = new StretchViewport(1920,1201, gamecam);
//		stage = new Stage(gamePort);
//
//		sky_image.setPosition(0,0);
//		pause_image.setPosition(1800,1800);
//
//
////		stage.addActor(sky);
////		stage.addActor(pause);
////		stage.addActor(load_game_image);
////		stage.addActor(exit_image);
//
//	}

	public PlayGame(MyGdxGame game, Player player1, Player player2) {
		this.p1_id=player1.getTank_ID();
		this.p2_id=player2.getTank_ID();
		this.game = game;
		System.out.println("PlayGame created");
		texture1 = new Texture("sky1.jpeg");
		sky_image = new Image(texture1);

		texture2 = new Texture("pause.png");
		pause_image = new Image(texture2);
		System.out.println("PlayGame created");


		texture3 = new Texture("T1.png");
		tank1_image = new Image(texture3);
		tank1_image.setSize(tank1_image.getWidth()/4,tank1_image.getHeight()/4);
//		tank1_image.setPosition(50,140);
//
//		texture4 = new Texture("T2.jpg");
//		tank2_image = new Image(texture4);

		texture5 = new Texture("gnd.png");
		ground_image = new Image(texture5);
		ground_image.setSize(texture1.getWidth(), texture1.getHeight()/1.5f);

		region = new TextureRegion(texture1, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new StretchViewport(910,512, gamecam);
		stage = new Stage(gamePort);

		sky_image.setPosition(0,0);

		pause_image.setScale(0.25f);
		pause_image.setPosition(gamePort.getWorldWidth() - 50, (float) (gamePort.getWorldHeight() - 0.25*pause_image.getHeight()));
		System.out.printf("THIS IS PLAYGAME CONSTRUCTOR");

	}

	public PlayGame(MyGdxGame game, int tank1id, int tank2id) {
		this.p1_id=tank1id;
		this.p2_id=tank2id;
		this.game = game;
		texture1 = new Texture("sky1.jpeg");
		sky_image = new Image(texture1);

		texture2 = new Texture("pause.png");
		pause_image = new Image(texture2);

//		System.out.println("PlayGame created");

		texture3 = new Texture("T1.png");
		tank1_image = new Image(texture3);
//		System.out.println("PlayGame created");
//
//		texture4 = new Texture("T2.jpg");
//		tank2_image = new Image(texture4);

		texture5 = new Texture("gnd.png");
		ground_image = new Image(texture5);
		ground_image.setSize(texture1.getWidth(), texture1.getHeight()/1.5f);

		region = new TextureRegion(texture1, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new StretchViewport(910,512, gamecam);
		stage = new Stage(gamePort);

//		tank1_image.setPosition(160,160);
		sky_image.setPosition(0,0);
		ground_image.setPosition(0,0);
		tank1_image.setPosition(160,160);
		System.out.println("x: "+tank1_image.getX()+" y: "+tank1_image.getY());
		pause_image.setScale(0.25f);
		pause_image.setPosition(gamePort.getWorldWidth() - 50, (float) (gamePort.getWorldHeight() - 0.25*pause_image.getHeight()));
		System.out.printf("THIS IS PLAYGAME CONSTRUCTOR");

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		stage.addActor(sky_image);
		sky_image.addAction(sequence(alpha(0), fadeIn(2f)));
		sky_image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.printf("CLICKED ON SKY");
//				game.setScreen(new PlayGame(game));
//				dispose();
			}
		});

		stage.addActor(ground_image);
		ground_image.addAction(sequence(alpha(0), fadeIn(2f)));
		ground_image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.printf("CLICKED ON GROUND");
//				game.setScreen(new PlayGame(game));
//				dispose();
			}
		});
		if (p1_id==1) {
			texture3 = new Texture("T1.png");
			tank1_image = new Image(texture3);
			tank1_image.setSize(tank1_image.getWidth() / 4, tank1_image.getHeight() / 4);
			tank1_image.setPosition(50, 140);
			stage.addActor(tank1_image);
			tank1_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		else if (p1_id==2) {
			texture3 = new Texture("T2.png");
			tank1_image = new Image(texture3);
			tank1_image.setSize(tank1_image.getWidth() / 4, tank1_image.getHeight() / 4);
			tank1_image.setPosition(50, 122);
			stage.addActor(tank1_image);
			tank1_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		else if (p1_id==3) {
			texture3 = new Texture("T3.png");
			tank1_image = new Image(texture3);
			tank1_image.setSize(tank1_image.getWidth() / 4, tank1_image.getHeight() / 4);
			tank1_image.setPosition(50, 140);
			stage.addActor(tank1_image);
			tank1_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}

		if (p2_id==1) {
			texture4 = new Texture("T1R.png");
			tank2_image = new Image(texture4);
			tank2_image.setSize(tank2_image.getWidth() / 4, tank2_image.getHeight() / 4);
			tank2_image.setPosition(gamePort.getWorldWidth()-250, gamePort.getWorldHeight()-350);
			stage.addActor(tank2_image);
			tank2_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		else if (p2_id==2) {
			texture4 = new Texture("T2R.png");
			tank2_image = new Image(texture4);
			tank2_image.setSize(tank2_image.getWidth() / 4, tank2_image.getHeight() / 4);
			tank2_image.setPosition(gamePort.getWorldWidth()-250, gamePort.getWorldHeight()-363);
			stage.addActor(tank2_image);
			tank2_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		else if (p2_id==3) {
			texture4 = new Texture("T3R.png");
			tank2_image = new Image(texture4);
			tank2_image.setSize(tank2_image.getWidth() / 4, tank2_image.getHeight() / 4);
			tank2_image.setPosition(gamePort.getWorldWidth()-250, gamePort.getWorldHeight()-350);
			stage.addActor(tank2_image);
			tank2_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		stage.addActor(tank1_image);
		tank1_image.addAction(sequence(alpha(0), fadeIn(2f)));


		stage.addActor(pause_image);
		pause_image.addAction(sequence(alpha(0), fadeIn(2f)));
		pause_image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pause_it();
			}
		});
	}
	private void pause_it(){
		System.out.printf("CLICKED ON PAUSE");
		game.setScreen((Screen) new Pause_Screen(game,p1_id,p2_id));
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
		stage.dispose();
	}
}
