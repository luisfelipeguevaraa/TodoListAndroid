package pe.lufega.todolist.data.repository.datasource;

import pe.lufega.todolist.data.entity.UserEntity;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public interface UserDataSource {

    UserEntity SetUserEntity(UserEntity userEntity) throws Exception;

    UserEntity GetUserEntity() throws Exception;
}
