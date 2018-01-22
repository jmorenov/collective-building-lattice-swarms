package main;

import sim.engine.*;
import sim.field.grid.*;
import strategies.Strategy;

public class Model extends SimState
{
	private static final long serialVersionUID = 1L;
	public int gridWidth = Configuration.gridWidth;
	public int gridHeight = Configuration.gridHeight;
	public int gridLength = Configuration.gridLength;
	public int numberOfAgents = Configuration.numberOfAgents;
	public Strategy strategy = Configuration.strategy;
	
	public IntGrid3D grid = null;
	private AgentConstructor[] agents;
	
	public Model(long seed)
	{
		super(seed);
	}
	
	public void start()
	{
		super.start();
		
		grid = new IntGrid3D(gridWidth, gridHeight, gridLength); 
		
		createAgents();
	}
	
	private void createAgents()
	{
		agents = new AgentConstructor[numberOfAgents];
		
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
