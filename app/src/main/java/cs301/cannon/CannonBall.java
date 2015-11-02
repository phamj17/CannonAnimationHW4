package cs301.cannon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by phamj17 on 10/30/2015.
 */
public class CannonBall {

    private int xPosition;
    private int yPosition;
    private int xVelocity;
    private int yVelocity;
    private double angle;
    private int size;
    private final int g = -5;
    private final int initVelocity = 120;

    public CannonBall() {
        angle = 0.0;
        xPosition = 0;
        yPosition = 0;
        xVelocity = 0;
        yVelocity = 0;
        size = 45;
    }

    public void initVel(double degrees) {
        angle = Math.toRadians(degrees);
                //degrees * Math.PI / 180;

        double xVel = initVelocity * Math.cos(angle);
        xVelocity = (int) xVel;
        double yVel = initVelocity * Math.sin(angle);
        yVelocity = (int) yVel;
    }

//    public CannonBall(double degrees) {
//        angle = degrees * Math.PI / 180;
//        xPosition = 0;
//        yPosition = 0;
//
//        double xVel = initVelocity * Math.cos(angle);
//        xVelocity = (int) xVel;
//        double yVel = initVelocity * Math.sin(angle);
//        yVelocity = (int) yVel;
//    }

    public void calculate(CannonBall current) {

        double yVel = current.getYVelocity() + g;
        current.setYVelocity((int) yVel);

        int x = current.getXPosition() + current.getXVelocity();
        if (x >= 0) {
            current.setXPosition(x);
        }
        else {
            current.setXPosition(0);
        }
        int y = current.getYPosition() + current.getYVelocity();
        if (y >= 0) {
            current.setYPosition(y);
        }
        else {
            current.setYPosition(0);
        }

    }

//    public void stopBall(CannonBall current) {
//
//    }

    public void paint(Canvas g) {
        Paint cannonball = new Paint();
        cannonball.setColor(Color.BLACK);
        g.drawCircle(xPosition, g.getHeight() - yPosition - 150, size, cannonball);

    }


    public int getXPosition() {return xPosition;}
    public int getYPosition() {return yPosition;}
    public int getXVelocity() {return xVelocity;}
    public int getYVelocity() {return yVelocity;}

    public void setXPosition(int newX) {xPosition = newX;}
    public void setYPosition(int newY) {yPosition = newY;}
    public void setYVelocity(int newYVel) {yVelocity = newYVel;}
}
