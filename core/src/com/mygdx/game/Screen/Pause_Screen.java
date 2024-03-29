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


public class Pause_Screen implements Screen {
	MyGdxGame game;
	private Texture texture1, texture2, texture3, texture4;
	private TextureRegion region;

	private OrthographicCamera gamecam;
	private Stage stage;
	private Viewport gamePort;

	private Image sky2_image,resume_image,save_game_image,exit_image;
	int tank1id,tank2id;

	public Pause_Screen(MyGdxGame game,int tank_id1,int tank_id2){
		this.tank1id = tank_id1;
		this.tank2id = tank_id2;
		this.game = game;
		texture1 = new Texture("bg2.png");
		sky2_image = new Image(texture1);

		texture2 = new Texture("Resume.png");
		resume_image = new Image(texture2);

		texture3 = new Texture("SAVE_GAME.png");
		save_game_image = new Image(texture3);

		texture4 = new Texture("EXIT_GAME.png");
		exit_image = new Image(texture4);


//		texture2 = new Texture("new_game.png");
//		start_image = new Image(texture2);
//
//		texture3 = new Texture("load_game.png");
//		load_game_image = new Image(texture3);
//
//		texture4 = new Texture("exit.png");
//		exit_image = new Image(texture4);

		region = new TextureRegion(texture1, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new StretchViewport(1920, 1080, gamecam);
		stage = new Stage(gamePort);

		sky2_image.setPosition(0, 0);
		resume_image.setPosition(800, 800);
		save_game_image.setPosition(800, 600);
		exit_image.setPosition(800, 400);

//		start_image.setPosition(400,1500);
//		load_game_image.setPosition(400,1100);
//		exit_image.setPosition(400,700);

		stage.addActor(sky2_image);
		stage.addActor(resume_image);
		stage.addActor(save_game_image);
		stage.addActor(exit_image);

//		stage.addActor(start_image);
//		stage.addActor(load_game_image);
//		stage.addActor(exit_image);


	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		sky2_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
		sky2_image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.printf("CLICKED ON SKY\n");
//				game.setScreen(new PlayGame(game));
//				dispose();
			}
		});
		resume_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
		resume_image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				resume_it();
//				dispose();

				return;
//				game.setScreen(PlayGame(game));
//				game.setScreen(new PlayGame(game));
//				dispose();
			}
		});

		save_game_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
		save_game_image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				save_it();
			}
		});

		exit_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
		exit_image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				exit_it();
			}
		});
//		stage.addActor(pause_image);
//		pause_image.addAction(sequence(alpha(0), fadeIn(2f)));
//		pause_image.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("CLICKED ON PAUSE");
//				game.setScreen((Screen) new Pause_Screen(game));
////				game.setScreen(new Pause_Screen(game));
//				dispose();
////				game.setScreen(new Pause(game));
//			}
//		});
	}

	private void exit_it() {
		System.out.printf("CLICKED ON EXIT GAME\n");
		game.setScreen(new MainMenuScreen(game));
		dispose();
	}

	private void resume_it() {
		game.setScreen(new PlayGame(game,tank1id,tank2id));
//		dispose();
	}

	private void save_it() {
		System.out.printf("CLICKED ON SAVE GAME\n");
//		game.setScreen(new PlayGame(game));
//		game.setScreen(new SaveGame(game,tank1id,tank2id));
//		dispose();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(texture1, 0, 0);
		game.batch.end();
		stage.act();
		stage.draw();
	}

	public void update(float delta) {
		stage.act(delta);
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		stage.dispose();
		texture1.dispose();
		texture2.dispose();
		texture3.dispose();
		texture4.dispose();

	}
}

//package com.mygdx.game.Screen;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.badlogic.gdx.utils.viewport.StretchViewport;
//import com.badlogic.gdx.utils.viewport.Viewport;
//import com.mygdx.game.MyGdxGame;
//import com.mygdx.game.Player;
//
//import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
//
//
//public class Pause_Screen implements Screen {
//	MyGdxGame game;
//	private Texture texture1, texture2, texture3, texture4;
//	private TextureRegion region;
//
//	private OrthographicCamera gamecam;
//	private Stage stage;
//	private Viewport gamePort;
//
//	private Image sky2_image,resume_image,save_game_image,exit_image;
//
//	public Pause_Screen(MyGdxGame game) {
//		this.game = game;
//		texture1 = new Texture("bg2.png");
//		sky2_image = new Image(texture1);
//
//		texture2 = new Texture("Resume.png");
//		resume_image = new Image(texture2);
//
//		texture3 = new Texture("SAVE_GAME.png");
//		save_game_image = new Image(texture3);
//
//		texture4 = new Texture("EXIT_GAME.png");
//		exit_image = new Image(texture4);
//
////		texture2 = new Texture("new_game.png");
////		start_image = new Image(texture2);
////
////		texture3 = new Texture("load_game.png");
////		load_game_image = new Image(texture3);
////
////		texture4 = new Texture("exit.png");
////		exit_image = new Image(texture4);
//
//		region = new TextureRegion(texture1, 0, 0, 32, 32);
//		gamecam = new OrthographicCamera();
//		gamePort = new StretchViewport(1920, 1080, gamecam);
//		stage = new Stage(gamePort);
//
//		sky2_image.setPosition(0, 0);
//		resume_image.setPosition(800, 800);
//		save_game_image.setPosition(800, 600);
//		exit_image.setPosition(800, 400);
//
//		stage.addActor(sky2_image);
//		stage.addActor(resume_image);
//		stage.addActor(save_game_image);
//		stage.addActor(exit_image);
//
//
//	}
//
//	@Override
//	public void show() {
//		Gdx.input.setInputProcessor(stage);
//		sky2_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
//		sky2_image.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("CLICKED ON SKY");
////				game.setScreen(new PlayGame(game));
////				dispose();
//			}
//		});
//		resume_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
//		resume_image.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("CLICKED ON RESUME");
////				game.setScreen(new PlayGame(game));
////				dispose();
//			}
//		});
//
//		save_game_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
//		save_game_image.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("CLICKED ON SAVE GAME");
////				game.setScreen(new PlayGame(game));
//			}
//		});
////		stage.addActor(pause_image);
////		pause_image.addAction(sequence(alpha(0), fadeIn(2f)));
////		pause_image.addListener(new ClickListener(){
////			@Override
////			public void clicked(InputEvent event, float x, float y) {
////				System.out.printf("CLICKED ON PAUSE");
////				game.setScreen((Screen) new Pause_Screen(game));
//////				game.setScreen(new Pause_Screen(game));
////				dispose();
//////				game.setScreen(new Pause(game));
////			}
////		});
//	}
////	public void show() {
////		Gdx.input.setInputProcessor(stage);
////		sky2_image.addAction(sequence(alpha(0), fadeIn(1.15f)));
////		sky2_image.addListener(new ClickListener(){
////			@Override
////			public void clicked(InputEvent event, float x, float y) {
////				System.out.printf("CLICKED ON SKY");
//////				game.setScreen(new PlayGame(game));
//////				dispose();
////			}
////		});
//////		stage.addActor(pause_image);
//////		pause_image.addAction(sequence(alpha(0), fadeIn(2f)));
//////		pause_image.addListener(new ClickListener(){
//////			@Override
//////			public void clicked(InputEvent event, float x, float y) {
//////				System.out.printf("CLICKED ON PAUSE");
//////				game.setScreen((Screen) new Pause_Screen(game));
////////				game.setScreen(new Pause_Screen(game));
//////				dispose();
////////				game.setScreen(new Pause(game));
//////			}
//////		});
////	}
//
//	@Override
//	public void render(float delta) {
//		// TODO Auto-generated method stub
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		game.batch.begin();
//		game.batch.draw(texture1, 0, 0);
//		game.batch.end();
//		stage.act();
//		stage.draw();
//	}
//
//	public void update(float delta) {
//		stage.act(delta);
//	}
//
//
//	@Override
//	public void resize(int width, int height) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void pause() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void resume() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void hide() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void dispose() {
//		stage.dispose();
//
//	}
//}
