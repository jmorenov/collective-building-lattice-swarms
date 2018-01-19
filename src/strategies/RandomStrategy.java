package strategies;

import sim.field.grid.IntGrid3D;

public class RandomStrategy extends Strategy 
{
	private static double probabilityOfConstruction = 0.02;
	
	public boolean checkPosition(IntGrid3D grid, int x, int y, int z)
	{
		return Math.random() < probabilityOfConstruction;
	}
}
