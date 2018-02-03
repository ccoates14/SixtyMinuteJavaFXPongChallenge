package application;

import java.awt.Dimension;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Ball extends Entity{
	
	public static final int WIDTH = 15;
	public static final int HEIGHT = 15;
	
	public static final Paint COLOR = Color.RED;
	
	private final int BASE_SPEED = 40;
	
	private Entity _solidEntities[];
	private Dimension _movementBounds;

	public Ball(int x, int y, Pane root, Dimension movementBounds, Entity solidEntities[]) {
		super(x, y);
		
		
		
		setBounds(new Rectangle(getX(), getY(), WIDTH, HEIGHT));
		setSpeed((Math.random() * BASE_SPEED * Math.random() > .5 ? -1 : 1) + 3);
		
		getBounds().setStroke(COLOR);
		
		root.getChildren().add(getBounds());
		
		_solidEntities = solidEntities;
		_movementBounds = movementBounds;
		
	}
	
	public void update()
	{
		boolean bounced = false;
		
		for (int i = 0; i < _solidEntities.length && !bounced; i++)
		{
			if (getBounds().intersects(_solidEntities[i].getBounds().getBoundsInLocal()))
			{
				bounced = true;
			}
		}
		
		if (!bounced)
		{
			if (_movementBounds.getWidth() - getX() <= 0 ||
					_movementBounds.getWidth() - getX() >= _movementBounds.getWidth()
					|| _movementBounds.getHeight() - getY() <= 0 ||
					_movementBounds.getHeight() - getY() >= _movementBounds.getHeight())
			{
				bounced = true;
			}
			
		}
		
		if (bounced)
		{
			setSpeed((int) (getSpeed() + Math.random() * 2));
			if (getSpeed() == 0)
			{
				setSpeed(Math.random() * BASE_SPEED * Math.random() > .5 ? -1 : 1);
			}
			
			setSpeed(getSpeed() * -1);
			
			
		}
		
		setX(getX() + getSpeed());
		setY(getY() + getSpeed()); 
		
		getBounds().setX(getX());
		getBounds().setY(getY());
	}

}
