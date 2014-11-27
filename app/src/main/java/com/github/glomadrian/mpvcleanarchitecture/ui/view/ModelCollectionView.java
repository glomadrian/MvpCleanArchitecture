package com.github.glomadrian.mpvcleanarchitecture.ui.view;

import com.github.glomadrian.mpvcleanarchitecture.ui.viewModel.Model;

import java.util.List;

/**
 * Model collection view is designed to be used in different scenarios, in this concrete case
 * the collection is of characters but can be of Users or Animals, but the view can be the same
 *
 * @author glomadrian
 */
public interface ModelCollectionView extends View {


    void add(Model model);

    void add(List<Model> models);

    void remove(Model model);


}
