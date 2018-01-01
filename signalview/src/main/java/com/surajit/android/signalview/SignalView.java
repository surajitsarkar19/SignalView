package com.surajit.android.signalview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by Surajit on 12/30/2017.
 */

public class SignalView extends View {

    private Paint paintFill;
    private Paint paintStroke;
    private int barCount;
    private int spaceCount;
    private int level;
    private float levelUnit;
    private boolean showAllBar; //show all signal bars

    public SignalView(Context context) {
        super(context);
        initView(null);
    }

    public SignalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    private void initView(AttributeSet attrs){
        int barColor = Color.WHITE;
        barCount = 5;
        level = 100;
        showAllBar = true;

        if (attrs != null) {
            final TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.SignalView);
            if(array.hasValue(R.styleable.SignalView_barColor)){
                barColor = array.getColor(R.styleable.SignalView_barColor, Color.WHITE);
            }
            if(array.hasValue(R.styleable.SignalView_barCount)){
                barCount = array.getColor(R.styleable.SignalView_barCount, 5);
            }
            if(array.hasValue(R.styleable.SignalView_signalLevel)){
                level = array.getColor(R.styleable.SignalView_signalLevel, 100);
            }
            if(array.hasValue(R.styleable.SignalView_showAllBar)){
                showAllBar = array.getBoolean(R.styleable.SignalView_showAllBar, true);
            }
            array.recycle();
        }

        spaceCount = barCount/2;
        levelUnit = 100/barCount;
        setBackgroundColor(Color.TRANSPARENT);

        paintFill = new Paint();
        paintFill.setStyle(Paint.Style.FILL);
        paintFill.setColor(barColor);

        paintStroke = new Paint();
        paintStroke.setStyle(Paint.Style.STROKE);
        paintStroke.setStrokeWidth(2);
        paintStroke.setColor(barColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        float unitWidth = (float)contentWidth/(barCount+spaceCount);
        float unitHeight = (float)contentHeight/barCount;

        float barWidth = unitWidth;
        float spaceWidth = (unitWidth * spaceCount) / (barCount - 1);

        int barToDraw = Math.round(level/levelUnit);

        for(int i=1; i<=barCount; i++){
            float left = paddingLeft;
            float top = paddingTop+contentHeight-i*unitHeight;
            float right = paddingLeft+ barWidth;
            float bottom = paddingTop+contentHeight;
            RectF rect = new RectF(left,top, right, bottom);
            if(i>barToDraw) {
                if(showAllBar)
                    canvas.drawRect(rect, paintStroke);
                else
                    break;
            }
            else {
                canvas.drawRect(rect, paintFill);
            }
            paddingLeft+= spaceWidth + barWidth;
        }
    }

    /**
     * Signal percentage
     * @param level can be between 0 - 100
     */
    public void setLevel(int level){
        if (level > 100) level = 100;
        if (level < 0) level = 0;
        this.level = level;
        invalidate();
    }
}
