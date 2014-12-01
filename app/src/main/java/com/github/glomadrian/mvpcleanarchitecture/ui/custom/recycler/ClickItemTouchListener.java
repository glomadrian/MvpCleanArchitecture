package com.github.glomadrian.mvpcleanarchitecture.ui.custom.recycler;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author lucasr
 *         from: https://github.com/lucasr/twoway-view
 */
abstract class ClickItemTouchListener implements RecyclerView.OnItemTouchListener {
<<<<<<< HEAD

    private static final int ANDROID_SDK_19 = 19;
=======
    private static final String LOGTAG = "ClickItemTouchListener";
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

    private final GestureDetectorCompat mGestureDetector;

    ClickItemTouchListener(RecyclerView hostView) {
        mGestureDetector = new ItemClickGestureDetector(hostView.getContext(),
                new ItemClickGestureListener(hostView));
    }

    private boolean isAttachedToWindow(RecyclerView hostView) {
<<<<<<< HEAD
        if (Build.VERSION.SDK_INT >= ANDROID_SDK_19) {
            return hostView.isAttachedToWindow();
        } else {
            return hostView.getHandler() != null;
=======
        if (Build.VERSION.SDK_INT >= 19) {
            return hostView.isAttachedToWindow();
        } else {
            return (hostView.getHandler() != null);
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
        }
    }

    private boolean hasAdapter(RecyclerView hostView) {
<<<<<<< HEAD
        return hostView.getAdapter() != null;
=======
        return (hostView.getAdapter() != null);
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent event) {
        if (!isAttachedToWindow(recyclerView) || !hasAdapter(recyclerView)) {
            return false;
        }

        mGestureDetector.onTouchEvent(event);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent event) {
        // We can silently track tap and and long presses by silently
        // intercepting touch events in the host RecyclerView.
    }

    abstract boolean performItemClick(RecyclerView parent, View view, int position, long id);

    abstract boolean performItemLongClick(RecyclerView parent, View view, int position, long id);

    private class ItemClickGestureDetector extends GestureDetectorCompat {
        private final ItemClickGestureListener mGestureListener;

        public ItemClickGestureDetector(Context context, ItemClickGestureListener listener) {
            super(context, listener);
            mGestureListener = listener;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            final boolean handled = super.onTouchEvent(event);

            final int action = event.getAction() & MotionEventCompat.ACTION_MASK;
            if (action == MotionEvent.ACTION_UP) {
                mGestureListener.dispatchSingleTapUpIfNeeded(event);
            }

            return handled;
        }
    }

    private class ItemClickGestureListener extends GestureDetector.SimpleOnGestureListener {
        private final RecyclerView mHostView;
        private View mTargetChild;

        public ItemClickGestureListener(RecyclerView hostView) {
            mHostView = hostView;
        }

        public void dispatchSingleTapUpIfNeeded(MotionEvent event) {
            // When the long press hook is called but the long press listener
            // returns false, the target child will be left around to be
            // handled later. In this case, we should still treat the gesture
            // as potential item click.
            if (mTargetChild != null) {
                onSingleTapUp(event);
            }
        }

        @Override
        public boolean onDown(MotionEvent event) {
            final int x = (int) event.getX();
            final int y = (int) event.getY();

            mTargetChild = mHostView.findChildViewUnder(x, y);
<<<<<<< HEAD
            return mTargetChild != null;
=======
            return (mTargetChild != null);
>>>>>>> 546c101c57264276a397087a22e9847094903ffc
        }

        @Override
        public void onShowPress(MotionEvent event) {
            if (mTargetChild != null) {
                mTargetChild.setPressed(true);
            }
        }

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            boolean handled = false;

            if (mTargetChild != null) {
                mTargetChild.setPressed(false);

                final int position = mHostView.getChildPosition(mTargetChild);
                final long id = mHostView.getAdapter().getItemId(position);
                handled = performItemClick(mHostView, mTargetChild, position, id);

                mTargetChild = null;
            }

            return handled;
        }

        @Override
        public boolean onScroll(MotionEvent event, MotionEvent event2, float v, float v2) {
            if (mTargetChild != null) {
                mTargetChild.setPressed(false);
                mTargetChild = null;

                return true;
            }

            return false;
        }

        @Override
        public void onLongPress(MotionEvent event) {
            if (mTargetChild == null) {
                return;
            }

            final int position = mHostView.getChildPosition(mTargetChild);
            final long id = mHostView.getAdapter().getItemId(position);
            final boolean handled = performItemLongClick(mHostView, mTargetChild, position, id);

            if (handled) {
                mTargetChild.setPressed(false);
                mTargetChild = null;
            }
        }
    }
}