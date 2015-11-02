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
            x = rand.nextInt(700) + 50;
            y = rand.nextInt(350) + 200;
            color = Color.RED;
        }
        if (number == 1) {
            x = rand.nextInt(700) + 750;
            y = rand.nextInt(350) + 600;
            color = Color.BLUE;
        }
    }

    public void paint(Canvas canvas) {
        Paint targetPaint = new Paint();
        targetPaint.setColor(color);
        canvas.drawCircle(x, y, size, targetPaint);
    }
}
