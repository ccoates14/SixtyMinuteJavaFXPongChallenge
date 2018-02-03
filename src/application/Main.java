package application;
	
import java.awt.Dimension;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application
{
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Pane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			Dimension movementBounds = new Dimension((int)scene.getWidth(), (int)scene.getHeight());
	
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Paddle[] paddles = {new Paddle(10, (int) scene.getHeight() / 2, movementBounds, 10, root),(new PaddleBot((int) scene.getWidth() - 25, (int) scene.getHeight() / 2, movementBounds, 10, root))};
			Ball ball = new Ball((int)scene.getWidth() / 2, (int)scene.getHeight() / 2, 
					root, movementBounds , paddles);
			
			((PaddleBot)paddles[1]).setBall(ball);
			
			
		    Timeline timeline  = new Timeline(); 
		    
		    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(.016), e -> {
	           
		    	ball.update();
		    	((PaddleBot)paddles[1]).update();
		
		  
	         }));
		    timeline.setCycleCount(Timeline.INDEFINITE); 
	         timeline.play();
	         
	         scene.setOnKeyPressed(e -> {

	             if (KeyCode.UP.equals(e.getCode()))
	             {
	  
	                paddles[0].moveUp();
	             }
	             else if (KeyCode.DOWN.equals(e.getCode()))
	             {
	            	 paddles[0].moveDown();
	             }
	         });
	             
		    
			primaryStage.setTitle("Pong!");
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
