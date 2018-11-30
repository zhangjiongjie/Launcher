package com.sagereal.launcher;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.GridView;

public class MainMenuGridView extends GridView {
    private int numRows = 3;
    private int childHeight = 100;
    public MainMenuGridView(Context context){
        this(context, null);
    }
    public MainMenuGridView(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }
    public MainMenuGridView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MainMenuGridView);
        numRows = array.getInteger(R.styleable.MainMenuGridView_numRows, numRows);
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        childHeight = height / numRows;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        int ct = getPaddingTop();

    }
}
