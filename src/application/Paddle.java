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
	
	private boolean _movedUp = false;
	private boolean _movedDown = false;
	
	public Paddle(int x, int y, Rectangle movementBounds, int speed, Pane root) {
		super(x, y, movementBounds);

		setYSpeed(speed);
		
		setBounds(new Rectangle(getX(), getY(), WIDTH, HEIGHT));
		getBounds().setStroke(COLOR);
		
		root.getChildren().add(getBounds());
	}
	
	public boolean update()
	{
		_movedUp = false;
		_movedDown = false;
		return true;
	}
	
	public boolean movedUp()
	{
		return _movedUp;
	}
	
	public boolean movedDown()
	{
		return _movedDown;
	}
	
	public void moveUp()
	{
		if (getMovementBounds().contains(getX(), getY() - getYSpeed()))
		{	
			setY((int) (getY() - getYSpeed()));
			getBounds().setY(getY());
			_movedUp = true;
			_movedDown = false;
		}

	}
	
	public void moveDown()
	{
		if (getMovementBounds().contains(getX(), getY() + getYSpeed()))
		{
			setY((int) (getY() + getYSpeed()));
			getBounds().setY(getY());
			_movedDown = true;
			_movedUp = false;
		}
	}
	
}
