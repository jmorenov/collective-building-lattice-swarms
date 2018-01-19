package main;

import sim.engine.*;
import sim.display.*;
import sim.display3d.Display3D;
import sim.portrayal3d.grid.ValueGridPortrayal3D;
import sim.util.gui.SimpleColorMap;

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
		SimpleColorMap map = new SimpleColorMap(new Color[] { new Color(0, 0, 0, 0), Color.blue });
		
		gridPortrayal.setField(((Model)state).grid);
		gridPortrayal.setMap(map);
	}
	
	private void setup()
	{
		setupPortrayals();
		display.createSceneGraph();
		display.reset();
	}
	
	public void start()
	{
		super.start();
		setup();
	}
	
	public void load(SimState state)
	{
		super.load(state);
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
		
		display = new Display3D(300, 300, this);
		
		display.attach(gridPortrayal, "Life");
		
		displayFrame = display.createFrame();
	    
		c.registerFrame(displayFrame);
	    displayFrame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new GuiModel().createController();
	}
}