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
		while (button != Button.ID_ESCAPE)
		{
		myBot.drawShape(1,1);
		button = Button.waitForAnyPress();
		}
	}
	
}
