package application;

import java.awt.Dimension;

import javafx.scene.layout.Pane;

public class PaddleBot extends Paddle{
	
	private Ball _ball;

	public PaddleBot(int x, int y, Dimension movementBounds, int speed, Pane root) {
		super(x, y, movementBounds, speed, root);

	}
	
	public void setBall(Ball b)
	{
		_ball = b;
	}
	
	public void update()
	{
		if (_ball.getY() > getY() + getBounds().getHeight())
		{
			moveDown();
		}
		else if (_ball.getY() < getY() - getBounds().getHeight() / 10)
		{
			moveUp();
		}
	}

}
