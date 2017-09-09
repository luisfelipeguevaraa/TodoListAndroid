package pe.lufega.todolist.data.repository;

import java.util.List;

import pe.lufega.todolist.data.entity.NewsEntity;
import pe.lufega.todolist.data.entity.mapper.UserEntityDataMapper;
import pe.lufega.todolist.data.repository.datasource.UserDataSource;
import pe.lufega.todolist.data.repository.datasource.UserDataSourceFactory;
import pe.lufega.todolist.domain.model.User;
import pe.lufega.todolist.domain.repository.RepositoryCallback;
import pe.lufega.todolist.domain.repository.UserRepository;

/**
 * Created by DesarrolloF on 07/09/2017.
 */

public class UserDataRepository implements UserRepository {

    private final UserDataSourceFactory userDataSourceFactory;
    private final UserEntityDataMapper userEntityDataMapper;


    public UserDataRepository(UserDataSourceFactory userDataSourceFactory,
                              UserEntityDataMapper userEntityDataMapper) {
        this.userDataSourceFactory = userDataSourceFactory;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public void setUserData(RepositoryCallback<User> callback) {
        final UserDataSource userDataSource = userDataSourceFactory.create();
        try {
            callback.onSuccess(userEntityDataMapper.transform(userDataSource.GetUserEntity()));
        } catch (Exception e) {
            callback.onError(e);
        }
    }



}
