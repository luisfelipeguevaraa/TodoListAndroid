package pe.lufega.todolist.data.network;

import java.util.List;

import pe.lufega.todolist.data.entity.NewsEntity;

/**
 * Created by Android on 19/08/2017.
 */

public interface RestApi {

    List<NewsEntity> getNewsEntityList() throws Exception;
}
