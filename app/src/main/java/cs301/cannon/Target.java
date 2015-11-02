package cs301.cannon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by phamj17 on 11/1/2015.
 */
public class Target {

    Random rand = new Random();
    private int x;
    private int y;
    private int size = rand.nextInt(50) + 45;
    private int color;

    public Target(int number) {
        if (number == 0) {
            x = rand.nextInt(1000) + 50;
            y = rand.nextInt(500) + 100;
            color = Color.RED;
        }
        if (number == 1) {
            x = rand.nextInt(1000) + 1050;
            y = rand.nextInt(500) + 600;
            color = Color.BLUE;
        }
    }

    public void paint(Canvas canvas) {
        Paint targetPaint = new Paint();
        targetPaint.setColor(color);
        canvas.drawCircle(x, y, size, targetPaint);
    }
}
