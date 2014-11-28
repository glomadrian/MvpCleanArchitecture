package com.github.glomadrian.mvpcleanarchitecture.ui.custom.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.HapticFeedbackConstants;
import android.view.SoundEffectConstants;
import android.view.View;

/**
 * From: From: https://github.com/lucasr/twoway-view/
 * Custom recycler view adding itemClickListener support
 *
 * @author glomadrian
 */
public class ClickRecyclerView extends RecyclerView {


    private TouchListener mTouchListener;

    private OnItemClickListener mItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;


    public ClickRecyclerView(Context context) {
        super(context);
        init();
    }

    public ClickRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClickRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mTouchListener = new TouchListener(this);
        addOnItemTouchListener(mTouchListener);
    }

    /**
     * Register a callback to be invoked when an item in the
     * RecyclerView has been clicked.
     *
     * @param listener The callback that will be invoked.
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    /**
     * Register a callback to be invoked when an item in the
     * RecyclerView has been clicked and held.
     *
     * @param listener The callback that will be invoked.
     */
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }

        mItemLongClickListener = listener;
    }

    /**
     * Interface definition for a callback to be invoked when an item in the
     * RecyclerView has been clicked.
     */
    public interface OnItemClickListener {
        /**
         * Callback method to be invoked when an item in the RecyclerView
         * has been clicked.
         *
         * @param parent   The RecyclerView where the click happened.
         * @param view     The view within the RecyclerView that was clicked
         * @param position The position of the view in the adapter.
         * @param id       The row id of the item that was clicked.
         */
        void onItemClick(RecyclerView parent, View view, int position, long id);
    }

    /**
     * Interface definition for a callback to be invoked when an item in the
     * RecyclerView has been clicked and held.
     */
    public interface OnItemLongClickListener {
        /**
         * Callback method to be invoked when an item in the RecyclerView
         * has been clicked and held.
         *
         * @param parent   The RecyclerView where the click happened
         * @param view     The view within the RecyclerView that was clicked
         * @param position The position of the view in the list
         * @param id       The row id of the item that was clicked
         * @return true if the callback consumed the long click, false otherwise
         */
        boolean onItemLongClick(RecyclerView parent, View view, int position, long id);
    }

    private class TouchListener extends ClickItemTouchListener {
        TouchListener(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override
        boolean performItemClick(RecyclerView parent, View view, int position, long id) {
            if (mItemClickListener != null) {
                view.playSoundEffect(SoundEffectConstants.CLICK);
                mItemClickListener.onItemClick(parent, view, position, id);
                return true;
            }

            return false;
        }

        @Override
        boolean performItemLongClick(RecyclerView parent, View view, int position, long id) {
            if (mItemLongClickListener != null) {
                view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                return mItemLongClickListener.onItemLongClick(parent, view, position, id);
            }

            return false;
        }
    }
}
