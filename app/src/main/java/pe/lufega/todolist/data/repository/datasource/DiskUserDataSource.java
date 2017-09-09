package pe.lufega.todolist.data.repository.datasource;

import pe.lufega.todolist.data.cache.UserCache;
import pe.lufega.todolist.data.entity.UserEntity;

/**
 * Created by DesarrolloF on 07/09/2017.
 */

public class DiskUserDataSource implements  UserDataSource{

    private final UserCache userCache;

    public DiskUserDataSource(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override
    public UserEntity SetUserEntity(UserEntity userEntity) throws Exception {
        return null;
    }

    @Override
    public UserEntity GetUserEntity() throws Exception {
        return null;
    }
}
