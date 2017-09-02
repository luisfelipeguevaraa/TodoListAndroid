package pe.lufega.todolist.presentation.view;

/**
 * Created by Android on 19/08/2017.
 */

public interface LoadingView extends BaseView {

    void showLoading();

    void hideLoading();

    void showErrorMessage(String message);
}
