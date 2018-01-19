package strategies;

import main.Configuration;
import sim.field.grid.IntGrid3D;

public class PyramidStrategy extends Strategy 
{	
	public boolean checkPosition(IntGrid3D grid, int x, int y, int z)
	{
		return x - y >= 0 && x + y < Configuration.gridWidth
				&& z - y >=0 && z + y < Configuration.gridLength;
	}
}
