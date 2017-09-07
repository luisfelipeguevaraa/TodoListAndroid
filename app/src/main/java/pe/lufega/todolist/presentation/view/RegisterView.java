package pe.lufega.todolist.presentation.view;

import android.view.View;

import pe.lufega.todolist.domain.model.User;
import pe.lufega.todolist.presentation.model.UserModel;

/**
 * Created by DesarrolloF on 03/09/2017.
 */

public interface RegisterView extends LoadingView{

    void registerClick(View view);
    void renderUser(UserModel userModel);

}
