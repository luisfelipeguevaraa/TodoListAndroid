package pe.lufega.todolist.data.repository.datasource;

import pe.lufega.todolist.data.entity.UserEntity;
import pe.lufega.todolist.data.network.RestApi;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public class NetworkUserDataSource implements UserDataSource {
    private final RestApi restApi;

    public NetworkUserDataSource(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public UserEntity SetUserEntity(UserEntity userEntity) throws Exception {
        UserEntity user = restApi.setUserEntity(userEntity);
        return user;
    }

    @Override
    public UserEntity GetUserEntity() throws Exception {
        return restApi.getUserEntity();
    }
}
