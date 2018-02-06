package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Ball extends Entity{
	
	public static final int WIDTH = 15;
	public static final int HEIGHT = 15;
	
	public static final Paint COLOR = Color.RED;
	
	private final int BASE_SPEED = 5;

	public Ball(int x, int y, Pane root, Rectangle movementBounds) {
		super(x, y, movementBounds);
		
		setBounds(new Rectangle(getX(), getY(), WIDTH, HEIGHT));
	
		getBounds().setStroke(COLOR);
		
		root.getChildren().add(getBounds());
		
		setXSpeed(generateRandomSpeed());
		setYSpeed(generateRandomSpeed());
		
	}
	
	public boolean update()
	{
		boolean bouncedPaddle = false;
		
		for (int i = 0; i < EntitiesUtil.getEntities().size() && !bouncedPaddle; i++)
		{
			if (EntitiesUtil.getEntities().get(i) != this
					&&
					getBounds().getBoundsInParent().intersects(EntitiesUtil.getEntities().get(i).getBounds().getBoundsInParent()))
			{
				bouncedPaddle = true;
			}

		}
		
		if (!bouncedPaddle)
		{
			if (getX() <= getMovementBounds().getX() ||
					getX() >= getMovementBounds().getX() + getMovementBounds().getWidth())
			{
				setXSpeed(getXSpeed() * -1);
			}
			if (getY() <= getMovementBounds().getX() ||
					getY() >= getMovementBounds().getY() + getMovementBounds().getHeight())
			{
				setYSpeed(getYSpeed() * -1);
			}

		}
		else
		{
			setXSpeed(getXSpeed() * -1);
		}
		
		setX((int) (getX() + getXSpeed()));
		setY((int) (getY() + getYSpeed())); 
		
		getBounds().setX(getX());
		getBounds().setY(getY());
		
		return true;
	}
	
	private int generateRandomSpeed()
	{
		return (int) (BASE_SPEED * Math.random() * (Math.random() > .5 ? -1 : 1));
	}

}
