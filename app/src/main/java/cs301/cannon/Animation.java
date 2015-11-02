package cs301.cannon;

import android.graphics.*;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;


/**
 * class that animates a ball repeatedly moving diagonally on
 * simple background
 * 
 * @author Steve Vegdahl
 * @author Andrew Nuxoll
 * @version September 2012
 */
public class Animation implements Animator {
	//implements Runnable?

	// instance variables
	//private int count = 0; // counts the screen clicks after the first
	private boolean shoot = false; // whether clock is ticking backwards
	//private int maxHeight;
	//private int maxWidth;

	double degrees;
	private Cannon cannon = new Cannon();
	private CannonBall ball = new CannonBall();
	private Target target0 = new Target(0);
	private Target target1 = new Target(1);
	//private ArrayList<CannonBall> ballList = new ArrayList<CannonBall>();


	/**
	 * Interval between animation frames: .03 seconds (i.e., about 33 times
	 * per second).
	 * 
	 * @return the time interval between frames, in milliseconds.
	 */
	public int interval() {
		return 30;
	}
	
	/**
	 * The background color: a light blue.
	 * 
	 * @return the background color onto which we will draw the image.
	 */
	public int backgroundColor() {
		// create/return the background color
		return Color.rgb(180, 200, 255);
	}
	
//	/**
//	 * Tells the animation whether to go backwards.
//	 *
//	 * @param b true iff animation is to go backwards.
//	 */
//	public void goBackwards(boolean b) {
//		// set our instance variable
//		goBackwards = b;
//	}
	
	/**
	 * Action to perform on clock tick
	 * 
	 * @param g the graphics object on which to draw
	 */
	public void tick(Canvas g) {

		//ballList.add(new CannonBall());
		//ballList.add(ball);
		//CannonBall newOne = ballList.get(count);

		if (shoot) {
				ball.calculate(ball);
		}

		g.save();

		float angleF = (float) degrees;
		g.rotate(-angleF, 125, g.getHeight() - 80);
		//CannonBall newBall = new CannonBall(ball);
		cannon.paint(g);

		g.restore();
		ball.paint(g);
		target0.paint(g);
		target1.paint(g);
	}

	/**
	 * Tells that we never pause.
	 * 
	 * @return indication of whether to pause
	 */
	public boolean doPause() {
		if ((ball.getYPosition()) == 0 && shoot) {
			return true;
		}
		return false;
	}

	/**
	 * Tells that we never stop the animation.
	 * 
	 * @return indication of whether to quit.
	 */
	public boolean doQuit() {
		return false;
	}
	
	/**
	 * reverse the ball's direction when the screen is tapped
	 */
	public void onTouch(MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			//if (shoot == false) {
				ball.initVel(degrees);
				shoot = true;
			//}
//			else {
//				ball = new CannonBall();
//			}
//			if (shoot == false) {
//				shoot = true;
//			}
//			else {
//				Thread newBall = new Thread(this);
//				newBall.start();
//				//ballList.add(new CannonBall());
//			}
//			count++;
		}
	}

	public void getAngle(double angle) {
		degrees = angle;
	}

//	@Override
//	public void run() {
//		try
//		{
//			Thread.sleep(10);
//		}
//		catch(InterruptedException ie)
//		{
//			//interruption is no problem
//		}
//
//		CannonBall newBall = new CannonBall();
//		if (newBall != null) {
//			ballList.add(newBall);
//		}
//	}
}//class TextAnimator