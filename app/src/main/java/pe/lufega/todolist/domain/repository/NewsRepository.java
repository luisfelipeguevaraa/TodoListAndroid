package pe.lufega.todolist.domain.repository;

import java.util.List;

import pe.lufega.todolist.domain.model.News;

/**
 * Created by Android on 19/08/2017.
 */

public interface NewsRepository {

    void newsList(RepositoryCallback<List<News>> callback);
}
