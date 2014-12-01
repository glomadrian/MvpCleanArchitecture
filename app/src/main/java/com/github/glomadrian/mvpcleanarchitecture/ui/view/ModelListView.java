package com.github.glomadrian.mvpcleanarchitecture.ui.view;

<<<<<<< HEAD
import com.github.glomadrian.mvpcleanarchitecture.ui.viewmodel.Model;
=======
import com.github.glomadrian.mvpcleanarchitecture.ui.viewModel.Model;
>>>>>>> 546c101c57264276a397087a22e9847094903ffc

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
