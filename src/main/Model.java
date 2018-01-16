package main;

import sim.engine.*;
import sim.field.grid.*;

public class Model extends SimState implements Steppable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int gridWidth=40;
	public int gridHeight=20;
	public int gridLength = 10;
	public IntGrid3D grid = null;
	
	public Model(long seed)
	{
		super(seed);
	}
	
	public void start()
	{
		super.start();
		
		grid = new IntGrid3D(gridWidth, gridHeight, gridLength);
		seedGrid();
		schedule.scheduleRepeating(this);
	}
	
	private void seedGrid()
	{
		for (int x = 0; x < grid.field.length; x++)
		{
			for (int y = 0; y < grid.field[x].length; y++)
			{
				for (int z = 0; z < grid.field[x][y].length; z++)
				{
					grid.field[x][y][z] = random.nextInt(2);
				}
			}
		}
	}
	
	public void step(SimState state)
	{
		IntGrid3D tmpGrid = new IntGrid3D(grid);
		
		for (int x = 0; x < grid.field.length; x++)
		{
			for (int y = 0; y < grid.field[x].length; y++)
			{
				for (int z = 0; z < grid.field[x][y].length; z++)
				{
					tmpGrid.field[x][y][z] = random.nextInt(2);
				}
			}
		}
	}
}
