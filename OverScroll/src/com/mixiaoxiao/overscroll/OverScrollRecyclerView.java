package com.mixiaoxiao.overscroll;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.mixiaoxiao.overscroll.OverScrollDelegate.OverScrollable;

/**
 * https://github.com/Mixiaoxiao/OverScroll-Everywhere
 * 
 * @author Mixiaoxiao 2016-08-31
 */
public class OverScrollRecyclerView extends RecyclerView implements OverScrollable {

	private OverScrollDelegate mDelegate;

	public OverScrollRecyclerView(Context context) {
		super(context);
		createOverScrollDelegate(context);
	}

	public OverScrollRecyclerView(Context context, AttributeSet attrs) {
		super(context, attrs); 
		createOverScrollDelegate(context);
	}

	public OverScrollRecyclerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		createOverScrollDelegate(context);
	}

	private void createOverScrollDelegate(Context context) {
		mDelegate = new OverScrollDelegate(this);
	}

	// =====================
	// Delegate
	// =====================

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return mDelegate.onTouchEvent(event);
	}

	@Override
	public void draw(Canvas canvas) {
		mDelegate.draw(canvas);
	}

	@Override
	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX,
			int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
		// TODO Auto-generated method stub
		return mDelegate.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX,
				maxOverScrollY, isTouchEvent);
	}

	// ================
	// OverScrollable
	// ================

	@Override
	public int superComputeVerticalScrollExtent() {
		return super.computeVerticalScrollExtent();
	}

	@Override
	public int superComputeVerticalScrollOffset() {
		return super.computeVerticalScrollOffset();
	}

	@Override
	public int superComputeVerticalScrollRange() {
		return super.computeVerticalScrollRange();
	}

	@Override
	public boolean superOnTouchEventOfOverScrollable(MotionEvent event) {
		return super.onTouchEvent(event);
	}

	@Override
	public void superDraw(Canvas canvas) {
		super.draw(canvas);
	}

	@Override
	public View getOverScrollableView() {
		return this;
	}

	@Override
	public OverScrollDelegate getOverScrollDelegate() {
		return mDelegate;
	}

	@Override
	public boolean superAwakenScrollBars() {
		return super.awakenScrollBars();
	}

	@Override
	public boolean superOverScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX,
			int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
		return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX,
				maxOverScrollY, isTouchEvent);
	}

}
