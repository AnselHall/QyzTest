package com.qyz.qyztest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Ansel on 2015/11/1.
 */
public class CustomTextView extends TextView {

    private Paint mPaint1;
    private Paint mPaint2;
    private int mViewWidth;
    private TextPaint mPaint;
    private Matrix mGradientMatrix;
    private int mTranslate;
    private LinearGradient linearGradient;

    public CustomTextView(Context context) {
        super(context);
        init();
    }


    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                //
                mPaint = getPaint();
                linearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[]{Color.BLUE, 0xff0000, Color.BLUE}, null, Shader.TileMode.CLAMP);
                mPaint.setShader(linearGradient);

                mGradientMatrix = new Matrix();
            }

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
/*

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);

        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);

        canvas.save();
        canvas.translate(10, 0);
*/

        super.onDraw(canvas);
//        canvas.restore();

        if (mGradientMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }

            mGradientMatrix.setTranslate(mTranslate,0);
            linearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }
}
