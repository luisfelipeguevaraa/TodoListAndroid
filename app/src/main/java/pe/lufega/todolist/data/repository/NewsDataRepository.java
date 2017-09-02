package pe.lufega.todolist.data.repository;

import java.util.List;

import pe.lufega.todolist.data.entity.NewsEntity;
import pe.lufega.todolist.data.entity.mapper.NewsEntityDataMapper;
import pe.lufega.todolist.data.repository.datasource.NewsDataSource;
import pe.lufega.todolist.data.repository.datasource.NewsDataSourceFactory;
import pe.lufega.todolist.domain.model.News;
import pe.lufega.todolist.domain.repository.NewsRepository;
import pe.lufega.todolist.domain.repository.RepositoryCallback;

/**
 * Created by Android on 19/08/2017.
 */

public class NewsDataRepository implements NewsRepository {

    private final NewsDataSourceFactory newsDataSourceFactory;
    private final NewsEntityDataMapper newsEntityDataMapper;

    public NewsDataRepository(NewsDataSourceFactory newsDataSourceFactory,
                              NewsEntityDataMapper newsEntityDataMapper) {
        this.newsDataSourceFactory = newsDataSourceFactory;
        this.newsEntityDataMapper = newsEntityDataMapper;
    }

    @Override
    public void newsList(RepositoryCallback<List<News>> callback) {
        final NewsDataSource newsDataSource = newsDataSourceFactory.create();
        try {
            List<NewsEntity> newsEntityList = newsDataSource.newsEntityList();
            callback.onSuccess(newsEntityDataMapper.transform(newsEntityList));
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
