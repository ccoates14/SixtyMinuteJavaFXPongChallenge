package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Ball extends Entity{
	
	public static final int WIDTH = 15;
	public static final int HEIGHT = 15;
	
	public static final Paint COLOR = Color.RED;
	
	private final int BASE_SPEED = 7;

	public Ball(int x, int y, Pane root, Rectangle movementBounds) {
		super(x, y, movementBounds);
		
		setBounds(new Rectangle(getX(), getY(), WIDTH, HEIGHT));
		setSpeed((int) (Math.random() * BASE_SPEED) + 1);
		
		getBounds().setStroke(COLOR);
		
		root.getChildren().add(getBounds());
		
	}
	
	public boolean update()
	{
		boolean bounced = false;
		
		for (int i = 0; i < EntitiesUtil.getEntities().size() && !bounced; i++)
		{
			if (EntitiesUtil.getEntities().get(i) != this
					&&
					getBounds().getBoundsInParent().intersects(EntitiesUtil.getEntities().get(i).getBounds().getBoundsInParent()))
			{
				bounced = true;
			}

		}
		
		if (!bounced)
		{
			if (!getMovementBounds().intersects(getBounds().getBoundsInLocal()))
			{
				bounced = true;
			}
			
		}
		
		if (bounced)
		{	
			setSpeed(getSpeed() * -1);	
			
		}
		
		setX(getX() + getSpeed());
		setY(getY() + getSpeed()); 
		
		getBounds().setX(getX());
		getBounds().setY(getY());
		
		return true;
	}

}
