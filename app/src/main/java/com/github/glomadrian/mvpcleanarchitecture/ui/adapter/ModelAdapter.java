package com.github.glomadrian.mvpcleanarchitecture.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.glomadrian.mvpcleanarchitecture.R;
import com.github.glomadrian.mvpcleanarchitecture.ui.viewholder.AbstractRecyclerViewHolder;
import com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel.Model;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * @author glomadrian
 */
public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    private List<Model> models;

    public ModelAdapter() {
        models = new ArrayList<Model>();
    }

    public ModelAdapter(List<Model> models) {
        this.models = models;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View modelView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model, viewGroup, false);
        return new ViewHolder(modelView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Model model = models.get(position);

        viewHolder.modelTitle.setText(model.getTitle());
        viewHolder.modelSubtitle.setText(model.getSubtitle());

        Picasso.with(viewHolder.view.getContext())
                .load(model.getImageUrl())
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void add(Model model) {
        models.add(model);
        notifyDataSetChanged();
    }

    public void add(List<Model> models) {
        this.models.addAll(models);
        notifyDataSetChanged();
    }

    public class ViewHolder extends AbstractRecyclerViewHolder {

        View view;

        @InjectView(R.id.model_title)
        TextView modelTitle;
        @InjectView(R.id.model_image)
        ImageView imageView;
        @InjectView(R.id.model_subtitle)
        TextView modelSubtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
