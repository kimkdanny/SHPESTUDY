package study.shpe.com.shpestudy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.SizeF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Kim on 5/7/16.
 */
public class TouchEventView extends View{
    private Paint paint = new Paint();
    private Path path = new Path();
    private Canvas c = new Canvas();

    public TouchEventView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        setDrawingCacheEnabled(true);

        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        this.setBackgroundColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, paint);
        c = canvas;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float xpos = event.getX();
        float ypos = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xpos, ypos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xpos,ypos);
                break;
            case MotionEvent.ACTION_UP://do nothing finger lifted
                break;
            default:
                return false;
        }


        //schedule a repaint
        invalidate();
        return true;
    }

}
