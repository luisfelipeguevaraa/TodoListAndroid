package pe.lufega.todolist.presentation.model.mapper;

import pe.lufega.todolist.domain.model.User;
import pe.lufega.todolist.presentation.model.NewsModel;
import pe.lufega.todolist.presentation.model.UserModel;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public class UserModelDataMapper {

    public UserModel transform(User user) {
        UserModel userModel= new UserModel();
        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());

        return userModel;
    }

}
