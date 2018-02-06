package application;

import javafx.scene.shape.Rectangle;

public abstract class Entity 
{
	private int _x, _y;
	private double _xSpeed, _ySpeed;
	private Rectangle _bounds;
	private Rectangle _movementBounds;
	
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
	
	public Rectangle getMovementBounds()
	{
		return _movementBounds;
	}
	
	public void setXSpeed(double xSpeed)
	{
		_xSpeed = xSpeed;
	}
	
	public double getXSpeed()
	{
		return _xSpeed;
	}
	
	public void setYSpeed(double ySpeed)
	{
		_ySpeed = ySpeed;
	}
	
	public double getYSpeed()
	{
		return _ySpeed;
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
