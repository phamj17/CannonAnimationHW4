package cs301.cannon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


/**
 * Created by phamj17 on 10/30/2015.
 */
public class Cannon {

    private int length;
    private int width;


    public Cannon() {
        length = 500;
        width = 320;
    }

//    public void setAngle(double newAngle) {
//        angle = newAngle;
//    }

    public void paint(Canvas g) {
        Paint cannon = new Paint();
        cannon.setColor(Color.BLACK);
        g.drawRect(0, g.getHeight() - width - 50, length, g.getHeight() - 50, cannon);
    }

//    public void setAngle(double newAngle) {
//        angle = newAngle;
//    }
}
