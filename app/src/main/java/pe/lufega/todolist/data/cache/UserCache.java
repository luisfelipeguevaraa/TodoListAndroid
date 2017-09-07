package pe.lufega.todolist.data.cache;

import pe.lufega.todolist.data.entity.UserEntity;

/**
 * Created by DesarrolloF on 05/09/2017.
 */

public interface UserCache {

    void post(UserEntity userEntity);

    void put(UserEntity userEntity);

    UserEntity userEntity = null;
}
