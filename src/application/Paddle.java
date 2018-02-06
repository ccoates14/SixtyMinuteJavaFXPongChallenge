package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Paddle extends Entity 
{
	public static final int WIDTH = 10;
	public static final int HEIGHT = 50;
	public static final Paint COLOR = Color.GREEN;
	
	public Paddle(int x, int y, Rectangle movementBounds, int speed, Pane root) {
		super(x, y, movementBounds);

		setYSpeed(speed);
		
		setBounds(new Rectangle(getX(), getY(), WIDTH, HEIGHT));
		getBounds().setStroke(COLOR);
		
		root.getChildren().add(getBounds());
	}
	
	public boolean update()
	{
		return true;
	}
	
	public void moveUp()
	{
		if (getMovementBounds().contains(getX(), getY() - getYSpeed()))
		{	
			setY((int) (getY() - getYSpeed()));
			getBounds().setY(getY());
		}

	}
	
	public void moveDown()
	{
		if (getMovementBounds().contains(getX(), getY() + getYSpeed()))
		{
			setY((int) (getY() + getYSpeed()));
			getBounds().setY(getY());
		}
	}
	
}
