package com.github.glomadrian.mvpcleanarchitecture.ui.view;


import com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel.Model;

import java.util.List;

/**
 * Model collection view is designed to be used in different scenarios, in this concrete case
 * the collection is of characters but can be of Users or Animals, but the view can be the same
 *
 * @author glomadrian
 */
public interface ModelListView extends View {


    void add(Model model);

    void add(List<Model> models);

    void remove(Model model);


}
