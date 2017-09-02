package pe.lufega.todolist.data.repository.datasource;

import java.util.List;

import pe.lufega.todolist.data.cache.NewsCache;
import pe.lufega.todolist.data.entity.NewsEntity;

/**
 * Created by Android on 19/08/2017.
 */

public class DiskNewsDataSource implements NewsDataSource {

    private final NewsCache newsCache;

    public DiskNewsDataSource(NewsCache newsCache) {
        this.newsCache = newsCache;
    }

    @Override
    public List<NewsEntity> newsEntityList() throws Exception {
        return newsCache.list();
    }
}
