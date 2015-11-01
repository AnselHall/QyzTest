package com.qyz.qyztest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ansel on 2015/10/29.
 */
public class MeasureSpecTest extends View {
    public MeasureSpecTest(Context context) {
        super(context);
    }

    public MeasureSpecTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureSpecTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }*/

    private int measureHeight(int heightMeasureSpec) {

        int result = 0;
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                result =  heightSize;
                break;
            case MeasureSpec.AT_MOST:
                result = 300;
                result =  Math.min(result,heightSize);
                break;
        }
        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int result = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                result =  widthSize;
                break;
            case MeasureSpec.AT_MOST:
                result = 300;
                result =  Math.min(result,widthSize);
                break;
        }
        return result;
    }
}
