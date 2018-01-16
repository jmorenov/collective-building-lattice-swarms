package main;

import sim.engine.*;
import sim.display.*;
import sim.display3d.Display3D;
import sim.portrayal3d.grid.ValueGridPortrayal3D;
import sim.portrayal3d.grid.quad.TilePortrayal;
import sim.portrayal3d.simple.WireFrameBoxPortrayal3D;
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
		// tell the portrayals what to portray and how
		// to portray them
		gridPortrayal.setField(((Model)state).grid);
		//gridPortrayal.setMap(new sim.util.gui.SimpleColorMap();
		SimpleColorMap map = new SimpleColorMap();
		map.setLevels(0.0,1.0,Color.blue,Color.gray);
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
		display = new Display3D(50, 50, this);
	
		Model model = (Model) state;
		//wireFrameP = new WireFrameBoxPortrayal3D(0, 0, 0, model.gridWidth, model.gridHeight, model.gridLength);
		
		// attach the portrayals
		display.attach(gridPortrayal, "Life");
		//display.attach(wireFrameP, "Fish tank");
		
		// translate the whole kit and caboodle into the center
	    //display.translate(-model.gridWidth/2, -model.gridHeight/2, -model.gridLength/2);
	    // scale it down to some reasonable value, say, the maximal dimension of the boxes
	    //display.scale(1/Math.max(model.gridHeight, Math.max(model.gridWidth, model.gridLength)));
		
		displayFrame = display.createFrame();
	    c.registerFrame(displayFrame);
	    displayFrame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new GuiModel().createController();
	}
}