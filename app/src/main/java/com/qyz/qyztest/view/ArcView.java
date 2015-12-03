package com.qyz.qyztest.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ArcView extends View {

    private static final String TAG = "tag";
    private Paint paint;
    private int height, width;
    private int angel;
    private RectF oval;
    private Paint txPaint;

    public ArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public ArcView(Context context) {
        super(context);
        init();
    }

    private void init() {

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Style.STROKE);

        txPaint = new Paint();

        oval = new RectF();
    }

    /*
    * w:当前控件的宽
     * h:当前控件的高
     *
     * oldw:控件之前的宽
     * oldh:控件之前的高
    * */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        Log.e("Paragrame", "w = " + w + "h = " + h + "oldw = " + oldw + "oldh = " + oldh);
        if (w >= h) {
            w = h;
        }

        width = height = w;
    }

    public void setarc(int a, int b) {
        this.angel = (int) (a * 360 / b);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//		canvas.drawColor(getResources().getColor(R.color.colorPrimary));
        canvas.drawColor(Color.TRANSPARENT);
//		canvas.drawColor(Color.WHITE);

        oval.left = 20;
        oval.top = 20;
        oval.right = width - 20;
        oval.bottom = height - 20;

        paint.setStrokeWidth(width / 15);
        canvas.drawArc(oval, 360, angel, false, paint);

        txPaint.setColor(Color.WHITE);
        txPaint.setTextSize(200.0f);

        float textSize = txPaint.getTextSize();

        String seven = "7";
        Rect rect = new Rect();
        txPaint.getTextBounds(seven,0,1,rect);

        int height = rect.height();
        int width = rect.width();
        Log.e(TAG, "onDraw: width" + width );
        Log.e(TAG, "onDraw: height"+ height);

        canvas.drawText(seven, this.width / 2 - width / 2, this.height / 2 + height / 2, txPaint);
    }

}
