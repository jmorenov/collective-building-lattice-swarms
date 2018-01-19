package main;

import sim.engine.*;
import sim.field.grid.*;

public class Model extends SimState
{
	private static final long serialVersionUID = 1L;
	public int gridWidth = 30;
	public int gridHeight = 30;
	public int gridLength = 30;
	public int numberOfAgents = 3;
	
	public IntGrid3D grid = null;
	private final AgentConstructor[] agents = new AgentConstructor[3];
	
	public Model(long seed)
	{
		super(seed);
	}
	
	public void start()
	{
		super.start();
		
		grid = new IntGrid3D(gridWidth, gridHeight, gridLength);
		seedGrid();
		createAgents();
	}
	
	private void seedGrid()
	{
		for (int x = 0; x < grid.field.length; x++)
		{
			for (int y = 0; y < grid.field[x].length; y++)
			{
				for (int z = 0; z < grid.field[x][y].length; z++)
				{
					grid.field[x][y][z] = 0;
				}
			}
		}
	}
	
	private void createAgents()
	{
		for (int i = 0; i < numberOfAgents; i++)
		{
			agents[i] = new AgentConstructor("" + i);
			schedule.scheduleRepeating(agents[i]);
		}
	}
	
	public boolean isAnotherAgentInThisPosition(int posX, int posY, int posZ)
	{
		for (int i = 0; i < numberOfAgents; i++)
		{
			if (posX == agents[i].getPosX() 
					&& posY == agents[i].getPosY()
					&& posZ == agents[i].getPosZ())
			{
				return true;
			}
		}
		
		return false;
	}
}
