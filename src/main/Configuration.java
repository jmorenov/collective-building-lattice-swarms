package main;

public class Configuration 
{	
	/**
	 * Configuration parameters
	 */
	public static int gridWidth = 30;
	public static int gridHeight = 30;
	public static int gridLength = 30;
	public static int numberOfAgents = 3;
	
	/**
	 * Configuration class. Don't touch!
	 */
	private static Configuration instance = null;
	protected Configuration() {}
	   
	public static Configuration getInstance() 
	{
		if(instance == null) {
			instance = new Configuration();
		}
		
		return instance;   
	}
}
