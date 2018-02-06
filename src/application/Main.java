package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application
{
	public static final int SCREEN_WIDTH = 400;
	public static final int SCREEN_HEIGHT = 400;
	public static final String GAME_TITLE = "PONG";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new BorderPane();
			Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
			
			final int PADDLE_SPEED_Y = 7;
			final int PLAYER_X = 10;
			final int PLAYER_Y = (int) scene.getHeight() / 2;
			
			final int BOT_X = (int) scene.getWidth() - 25;
			final int BOT_Y = (int) scene.getHeight() / 2;
			
			Rectangle entityBounds = new Rectangle(0, 0, (int)scene.getWidth(), (int)scene.getHeight());
			Paddle playerPaddle = new Paddle(PLAYER_X, PLAYER_Y, entityBounds, PADDLE_SPEED_Y, root);
			PaddleBot paddleBot = new PaddleBot(BOT_X, BOT_Y, entityBounds, PADDLE_SPEED_Y, root);
			
			Ball ball = new Ball((int)scene.getWidth() / 2, (int)scene.getHeight() / 2, 
					root, entityBounds);
			
			EntitiesUtil.addEntity(paddleBot);
			EntitiesUtil.addEntity(playerPaddle);
			EntitiesUtil.addEntity(ball);
			
			paddleBot.setBall(ball);
			
		    Timeline timeline  = new Timeline(); 
		    
		    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(.016), e -> {
	           
		    	ball.update();
		    	paddleBot.update();
		    	playerPaddle.update();
		    	
		    	if (Input.ARROW_UP)
		    	{
		    		playerPaddle.moveUp();
		    	}
		    	if (Input.ARROW_DOWN)
		    	{
		    		playerPaddle.moveDown();
		    	}
		
		  
	         }));
		    
		    timeline.setCycleCount(Timeline.INDEFINITE); 
	        timeline.play();
	         
	         scene.setOnKeyPressed(e -> {

	             if (KeyCode.UP.equals(e.getCode()))
	             {
	  
	                Input.ARROW_UP = true;
	             }
	             else if (KeyCode.DOWN.equals(e.getCode()))
	             {
	            	 Input.ARROW_DOWN = true;
	             }
	             else if (KeyCode.ESCAPE.equals(e.getCode()))
	             {
	            	 System.exit(0);
	             }
	         });
	         
	         scene.setOnKeyReleased(e -> {
	        	 if (KeyCode.UP.equals(e.getCode()))
	             {
	                Input.ARROW_UP = false;
	             }
	        	 else if (KeyCode.DOWN.equals(e.getCode()))
	             {
	            	 Input.ARROW_DOWN = false;
	             }
	         });
	             
		    
			primaryStage.setTitle(GAME_TITLE);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
