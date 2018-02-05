package application;

import java.util.ArrayList;
import java.util.List;

final public class EntitiesUtil 
{
	final private static List<Entity> _entities = new ArrayList<>(5);
	
	public static final void addEntity(Entity e)
	{
		getEntities().add(e);
	}
	
	public static final List<Entity> getEntities()
	{
		return _entities;
	}
}
