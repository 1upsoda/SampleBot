package robot.model;

import lejos.nxt.*;

public class TylerBot 

{
	
	private UltrasonicSensor mySonar;
	private TouchSensor leftTouch, rightTouch;
	private SoundSensor microphone;
	
	public TylerBot()
	{
		mySonar = new UltrasonicSensor(SensorPort.S1);
		leftTouch = new TouchSensor(SensorPort.S2);
		rightTouch = new TouchSensor(SensorPort.S3);
		microphone = new SoundSensor(SensorPort.S4);
	}

	public void driveAroundRoom()
	{
		int button = Button.ID_ENTER;
		while (/*button != Button.ID_ESCAPE*/true)
		{
			Motor.A.backward();
			Motor.B.backward();
			if (mySonar.getDistance() < 25)
			{
				Motor.A.rotate(90);
				Motor.B.rotate(-90);
			}
			//button = Button.waitForAnyPress();
		}
		
	}
	
	public void danceRobotDance()
	{
		
	}
	
	public void isTouched()
	{
		if(leftTouch.isPressed())
		{
			Motor.A.stop();
			Motor.B.stop();
			Motor.A.rotate(-180, true);
			Motor.B.rotate(180);
		}
		
		if(rightTouch.isPressed())
		{
			Motor.A.stop();
			Motor.B.stop();
			Motor.A.rotate(180, true);
			Motor.B.rotate(-180);
		}
		
		if (!rightTouch.isPressed() && !leftTouch.isPressed())
		{
			Motor.A.backward();
			Motor.B.backward();
			
			try
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	
	public void drawShape(int vertexCount, int length) 
	{
		int angle = calculateAngle(vertexCount);

		for (int drawCount = 0; drawCount < vertexCount; drawCount++) 
		{
				try
				{
					Motor.A.rotate(-360 * length, true);
					Motor.B.rotate(-360 * length);				
					Motor.A.stop();
					Motor.B.stop();
					Motor.A.rotate(angle, true);
					Motor.B.rotate(-angle);
				} 
				catch (Exception threadException) 
				{
					System.out.print(threadException.getMessage());
				}
			
		}
	}

	private int calculateAngle(int vertexCount) 
	{
		int currentAngle = 0;

		if (vertexCount != 0) 
		{
			currentAngle = (int) ((360 / vertexCount) * 1.7);
		}

		return currentAngle;
	}
}
