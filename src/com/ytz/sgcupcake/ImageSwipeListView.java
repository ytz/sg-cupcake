package com.ytz.sgcupcake;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Improves scrolling experience of viewpager inside listview (x & y scrolling conflict)
 * 
 * From stackoverflow
 * http://stackoverflow.com/questions/2646028/android-horizontalscrollview-within-scrollview-touch-handling
 * @author ytz
 */
public class ImageSwipeListView extends ListView {
	
	private GestureDetector mGestureDetector;
    View.OnTouchListener mGestureListener;
    
    public ImageSwipeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(0);
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev) && mGestureDetector.onTouchEvent(ev);
    }

    // Return false if we're scrolling in the x direction  
    class YScrollDetector extends SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if(Math.abs(distanceY) > Math.abs(distanceX)) {
                return true;
            }
            return false;
        }
    }
}
