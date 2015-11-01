package cs301.cannon;

/**
 * Created by phamj17 on 10/30/2015.
 */
public class CannonBall {

    private int xPosition;
    private int yPosition;
    private int xVelocity;
    private int yVelocity;
    private double angle;
    private final int g = -5;
    private final int initVelocity = 100;

    public CannonBall(double degrees) {
        angle = 60 * Math.PI / 180;
        xPosition = 0;
        yPosition = 0;

        double xVel = initVelocity * Math.cos(angle);
        xVelocity = (int) xVel;
        double yVel = initVelocity * Math.sin(angle);
        yVelocity = (int) yVel;
    }

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

//    public void calcVelocity(double degrees) {
//        double radians = degrees * Math.PI / 180;
//        double x = initVelocity * Math.sin(radians);
//        xVelocity = (int) x;
//        double y = initVelocity * Math.cos(radians);
//        yVelocity = (int) y;
//    }


    public int getXPosition() {return xPosition;}
    public int getYPosition() {return yPosition;}
    public int getXVelocity() {return xVelocity;}
    public int getYVelocity() {return yVelocity;}
    public int getInitVelocity() {return initVelocity;}
    public double getAngle() {return angle;}

    public void setXPosition(int newX) {xPosition = newX;}
    public void setYPosition(int newY) {yPosition = newY;}
    public void setYVelocity(int newYVel) {yVelocity = newYVel;}

    //public void setTime(int count) {time = count;}

    public void setAngle(double degrees) {angle = degrees;}
}
