package main;

import sim.engine.*;
import sim.display.*;
import sim.display3d.Display3D;
import sim.portrayal3d.grid.ValueGridPortrayal3D;

import java.awt.*;
import javax.swing.*;

public class GuiModel extends GUIState
{
	public Display3D display;
	public JFrame displayFrame;
	
	public GuiModel()
	{
		super(new Model(System.currentTimeMillis()));
	}
	
	public GuiModel(SimState state)
	{
		super(state);
	}
	
	ValueGridPortrayal3D gridPortrayal = new ValueGridPortrayal3D();
	
	public void setupPortrayals()
	{
		// tell the portrayals what to portray and how
		// to portray them
		gridPortrayal.setField(((Model)state).grid);
		gridPortrayal.setMap(new sim.util.gui.SimpleColorMap(
				new Color[] {new Color(0,0,0,0), Color.blue}));
	}
	
	private void setup()
	{
		setupPortrayals();
		display.reset();
		display.repaint();
	}

	public void start()
	{
		super.start();
		setup();
	}
	
	public void load(SimState state)
	{
		super.load(state);
		// we now have a new grid. Set up the portrayals to reflect this
		setup();
	}
	
	private void closePortroyals() 
	{
		if ( displayFrame != null ) {
			displayFrame.dispose();
		}
	}

	public void quit() 
	{
		super.quit();
		closePortroyals();
	}
	
	public void init(Controller c)
	{
		super.init(c);
		// Make the Display3D. We’ll have it display stuff later.
		Model model = (Model)state;
		display = new Display3D(40.0 * 4, 20.0 * 4, this);
		displayFrame = display.createFrame();
		
		// register the frame so it appears in the "Display" list
		c.registerFrame(displayFrame);
		displayFrame.setVisible(true);
		
		// attach the portrayals
		display.attach(gridPortrayal,"Life");
		
		// specify the backdrop color -- what gets painted behind the displays
		display.setBackdrop(Color.black);
	}
	
	public static void main(String[] args)
	{
		new GuiModel().createController();
	}
}