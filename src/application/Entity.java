package application;

import javafx.scene.shape.Rectangle;

public abstract class Entity 
{
	private int _x, _y, _speed;
	private Rectangle _bounds;
	private Rectangle _movementBounds;
	private double _angle;
	
	public Entity(int x, int y, Rectangle movementBounds)
	{
		setX(x);
		setY(y);
		setMovementBounds(movementBounds);
	}
	
	public abstract boolean update();
	
	public void setMovementBounds(Rectangle r)
	{
		_movementBounds = r;
	}
	
	public void setAngle(double angle)
	{
		_angle = angle;
	}
	
	public double getAngle()
	{
		return _angle;
	}
	
	public Rectangle getMovementBounds()
	{
		return _movementBounds;
	}
	
	public void setSpeed(int speed)
	{
		_speed = speed;
	}
	
	public int getSpeed()
	{
		return _speed;
	}
	
	public void setBounds(Rectangle bounds)
	{
		_bounds = bounds;
	}
	
	public Rectangle getBounds()
	{
		if (_bounds == null)
			setBounds(new Rectangle());
		
		return _bounds;
	}
	
	public void setX(int x)
	{
		_x = x;
	}
	
	public void setY(int y)
	{
		_y = y;
	}
	
	public int getX()
	{
		return _x;
	}
	
	public int getY()
	{
		return _y;
	}

}
