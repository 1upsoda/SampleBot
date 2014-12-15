package robot.model;

import lejos.nxt.Button;
import lejos.nxt.Motor;

public class TylerBot {

	public void drawShape(int vertexCount, int length) {
		int angle = calculateAngle(vertexCount);

		for (int drawCount = 0; drawCount < vertexCount; drawCount++) {
			for (int i = 0; i < 4; i++) {
				try {
					Motor.A.rotate(-360 * length, true);
					Motor.B.rotate(-360 * length);				
					Motor.A.stop();
					Motor.B.stop();
					Motor.A.rotate(angle, true);
					Motor.B.rotate(-angle);
				} catch (Exception threadException) {
					System.out.print(threadException.getMessage());
				}
			}
		}
	}

	private int calculateAngle(int vertexCount) {
		int currentAngle = 0;

		if (vertexCount != 0) {
			currentAngle = (int) ((360 / vertexCount) * 1.7);
		}

		return currentAngle;
	}
}
