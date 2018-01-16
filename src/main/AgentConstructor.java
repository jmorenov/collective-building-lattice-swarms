package main;

import sim.engine.SimState;
import sim.engine.Steppable;

public class AgentConstructor implements Steppable 
{
	private static final long serialVersionUID = 1L;

	@Override
	public void step(final SimState state) 
	{
		final Model model = (Model) state;
	}
}