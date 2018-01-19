package strategies;

import sim.field.grid.IntGrid3D;

public abstract class Strategy 
{	
	public abstract boolean checkPosition(IntGrid3D grid, int x, int y, int z);
}
