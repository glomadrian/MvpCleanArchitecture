package com.github.glomadrian.mvpcleanarchitecture.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * ViewHolder for inject views using ButterKnife
 *
 * @author glomadrian
 */
public abstract class AbstractRecyclerViewHolder extends RecyclerView.ViewHolder {


    public AbstractRecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
