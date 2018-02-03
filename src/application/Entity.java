package application;

import javafx.scene.shape.Rectangle;

public class Entity 
{
	private int _x, _y, _speed;
	private Rectangle _bounds;
	
	public Entity(int x, int y)
	{
		setX(x);
		setY(y);
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
