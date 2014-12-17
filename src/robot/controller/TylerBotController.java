package robot.controller;

import lejos.nxt.Button;
import robot.model.TylerBot;

public class TylerBotController 
{

	private TylerBot myBot;
	
	public TylerBotController()
	{
		myBot = new TylerBot();
	}
	
	public void start()
	{
		int button = Button.ID_ENTER;
		button = Button.waitForAnyPress();
		while (button == Button.ID_ESCAPE)
		{
			//myBot.drawShape(3,2);
			myBot.driveAroundRoom();
			//button = Button.waitForAnyPress();
		}
	}
	
}
