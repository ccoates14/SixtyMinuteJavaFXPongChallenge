package application;

import java.awt.Dimension;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Paddle extends Entity 
{
	public static final int WIDTH = 10;
	public static final int HEIGHT = 50;
	public static final Paint COLOR = Color.GREEN;
	
	private Dimension _movementBounds;

	public Paddle(int x, int y, Dimension movementBounds, int speed, Pane root) {
		super(x, y);
		
		setSpeed(speed);
		setBounds(new Rectangle(getX(), getY(), WIDTH, HEIGHT));
		getBounds().setStroke(COLOR);
		
		_movementBounds = movementBounds;
		
		root.getChildren().add(getBounds());
	}
	
	public void moveUp()
	{
		if (_movementBounds.getHeight() - (getY() + getSpeed()) > 0)
		{
			
			setY(getY() - getSpeed());
			getBounds().setY(getY());
		}
	}
	
	public void moveDown()
	{
		if (_movementBounds.getHeight() - (getY() + getSpeed()) < _movementBounds.getHeight())
		{
			setY(getY() + getSpeed());
			getBounds().setY(getY());
		}
	}
	
}
