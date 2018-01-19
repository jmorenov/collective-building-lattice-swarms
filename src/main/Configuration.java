package main;

import strategies.*;
import strategies.Strategy;

public class Configuration 
{	
	/**
	 * Configuration parameters
	 */
	public static int gridWidth = 30;
	public static int gridHeight = 30;
	public static int gridLength = 30;
	public static int numberOfAgents = 3;
	public static Strategy strategy = new RandomStrategy();
}
