package pe.lufega.todolist.presentation.presenter;

import pe.lufega.todolist.presentation.view.BaseView;

/**
 * Created by Android on 19/08/2017.
 */

public abstract class BasePresenter<V extends BaseView> {

    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    public abstract void resume();

    public abstract void pause();

    public abstract void destroy();
}
