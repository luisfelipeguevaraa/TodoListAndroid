package pe.lufega.todolist.data.entity.mapper;

import pe.lufega.todolist.data.entity.UserEntity;
import pe.lufega.todolist.domain.model.User;

/**
 * Created by DesarrolloF on 05/09/2017.
 */

public class UserEntityDataMapper {

    public User transform(UserEntity userEntity) {
        User user = new User();
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        return user;
    }
}
