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
	
	private boolean _scored = false;

	public Ball(int x, int y, Pane root, Rectangle movementBounds) {
		super(x, y, movementBounds);
		
		setBounds(new Rectangle(getX(), getY(), WIDTH, HEIGHT));
	
		getBounds().setStroke(COLOR);
		
		root.getChildren().add(getBounds());
		
		setXSpeed(0);
		setYSpeed(0);
		
		generateRandomSpeed();

	}
	
	public boolean isScored()
	{
		boolean scored = _scored;
		_scored = false;
		
		return scored;
	}
	
	public boolean update()
	{
		boolean bouncedPaddle = false;
		boolean paddleMovedUp = false;
		boolean paddleMovedDown = false;

		for (int i = 0; i < EntitiesUtil.getEntities().size() && !bouncedPaddle; i++)
		{
			if (EntitiesUtil.getEntities().get(i) != this
					&&
					getBounds().getBoundsInParent().intersects(EntitiesUtil.getEntities().get(i).getBounds().getBoundsInParent()))
			{
				bouncedPaddle = true;
				Paddle p = ((Paddle) EntitiesUtil.getEntities().get(i));
				paddleMovedDown = p.movedDown();
				paddleMovedUp = p.movedUp();
				setXSpeed(getXSpeed() * -1);
			}

		}
		
		if (getX() <= getMovementBounds().getX() ||
				getX() >= getMovementBounds().getX() + getMovementBounds().getWidth())
		{
			recenter();
		}
		if (getY() <= getMovementBounds().getX() ||
				getY() >= getMovementBounds().getY() + getMovementBounds().getHeight())
		{
			setYSpeed(getYSpeed() * -1);
		}
		
		if (bouncedPaddle)
		{
			if (paddleMovedUp)
			{
				if (getYSpeed() > 0)
				{
					setYSpeed(getYSpeed() * -1);
				}
			}
			else if (paddleMovedDown)
			{
				if (getYSpeed() < 0)
				{
					setYSpeed(getYSpeed() * -1);
				}
			}
		}
		
		setX((int) (getX() + getXSpeed()));
		setY((int) (getY() + getYSpeed())); 
		
		getBounds().setX(getX());
		getBounds().setY(getY());
		
		return true;
	}
	
	private void generateRandomSpeed()
	{
		while (getXSpeed() == 0d)
		{
			setXSpeed((int) (BASE_SPEED * Math.random() * (Math.random() > .5 ? -1 : 1)));
		}
		
		while (getYSpeed() == 0d)
		{
			setYSpeed((int) (BASE_SPEED * Math.random() * (Math.random() > .5 ? -1 : 1)));
		}

	}
	
	private void recenter()
	{
		setX((int) (getMovementBounds().getWidth() / 2));
		setY((int) (getMovementBounds().getHeight() / 2));
		generateRandomSpeed();
		_scored = true;
	}

}
