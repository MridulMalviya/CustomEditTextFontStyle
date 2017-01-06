package com.malviya.demoedittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;


/**
 * Created by Prafulla on 1/6/2017.
 */

public class CustomEditText<T> extends AppCompatEditText  {

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}