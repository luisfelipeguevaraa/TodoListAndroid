package pe.lufega.todolist.data.repository.datasource;

import java.util.List;

import pe.lufega.todolist.data.cache.NewsCache;
import pe.lufega.todolist.data.entity.NewsEntity;
import pe.lufega.todolist.data.network.RestApi;

/**
 * Created by Android on 19/08/2017.
 */

public class NetworkNewsDataSource implements NewsDataSource {

    private final RestApi restApi;
    private final NewsCache newsCache;

    public NetworkNewsDataSource(RestApi restApi, NewsCache newsCache) {
        this.restApi = restApi;
        this.newsCache = newsCache;
    }

    @Override
    public List<NewsEntity> newsEntityList() throws Exception {
        List<NewsEntity> newsEntityList = restApi.getNewsEntityList();
        newsCache.put(newsEntityList);
        return newsEntityList;
    }
}
