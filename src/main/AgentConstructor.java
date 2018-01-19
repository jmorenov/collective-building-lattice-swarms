package main;

import sim.engine.SimState;
import sim.engine.Steppable;

public class AgentConstructor implements Steppable 
{
	private static final long serialVersionUID = 1L;
	private int posX;
	private int posY;
	private int posZ;
	private String name;
	
	public AgentConstructor(String name)
	{
		this.posX = 0;
		this.posY = 0;
		this.posZ = 0;
		this.name = name;
	}
	
	public int getPosX()
	{
		return posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public int getPosZ()
	{
		return posZ;
	}
	
	@Override
	public void step(final SimState state) 
	{
		final Model model = (Model) state;
		
		int newPosX, newPosY, newPosZ;
		do
		{
			newPosX = model.random.nextInt(model.gridWidth);
			newPosY = model.random.nextInt(model.gridHeight);
			newPosZ = model.random.nextInt(model.gridLength);
		} while (model.isAnotherAgentInThisPosition(newPosX, newPosY, newPosZ));
		
		posX = newPosX;
		posY = newPosY;
		posZ = newPosZ;
		
		System.out.println("Agent " + name + " new position: " + posX + " " + posY + " " + posZ);
		
		if (model.strategy.checkPosition(model.grid, posX, posY, posZ))
			model.grid.field[posX][posY][posZ] = 1;
	}
}