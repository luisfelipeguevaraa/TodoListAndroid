package pe.lufega.todolist.data.cache;

import java.util.List;

import pe.lufega.todolist.data.entity.NewsEntity;

/**
 * Created by Android on 19/08/2017.
 */

public interface NewsCache {

    void put(List<NewsEntity> newsEntityList);

    List<NewsEntity> list();
}
