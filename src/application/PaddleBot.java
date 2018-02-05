package application;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class PaddleBot extends Paddle{
	
	private Ball _ball;

	public PaddleBot(int x, int y, Rectangle movementBounds, int speed, Pane root) {
		super(x, y, movementBounds, speed, root);

	}
	
	public void setBall(Ball b)
	{
		_ball = b;
	}
	
	public boolean update()
	{
		if (_ball.getY() > getY() + getBounds().getHeight())
		{
			moveDown();
		}
		else if (_ball.getY() < getY() - getBounds().getHeight() / 10)
		{
			moveUp();
		}
		
		return true;
	}

}
