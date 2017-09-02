package pe.lufega.todolist.data.repository.datasource;

import java.util.List;

import pe.lufega.todolist.data.entity.NewsEntity;

/**
 * Created by Android on 19/08/2017.
 */

public interface NewsDataSource {

    List<NewsEntity> newsEntityList() throws Exception;
}
