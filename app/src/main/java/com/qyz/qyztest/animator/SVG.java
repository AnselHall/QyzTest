package com.qyz.qyztest.animator;

import android.graphics.drawable.VectorDrawable;
import android.os.Build;

/**
 * Created by user on 2015/11/23.
 */
public class SVG {
    VectorDrawable vectorDrawable;

    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            vectorDrawable = new VectorDrawable();
        }
    }


}
