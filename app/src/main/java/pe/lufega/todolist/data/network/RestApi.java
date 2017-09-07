package pe.lufega.todolist.data.network;

import java.util.List;

import pe.lufega.todolist.data.entity.NewsEntity;
import pe.lufega.todolist.data.entity.UserEntity;

/**
 * Created by Android on 19/08/2017.
 */

public interface RestApi {

    List<NewsEntity> getNewsEntityList() throws Exception;

    UserEntity getUserEntity() throws Exception;

    UserEntity setUserEntity(UserEntity userEntity) throws Exception;

}
