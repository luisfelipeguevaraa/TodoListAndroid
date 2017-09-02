package pe.lufega.todolist.data.repository.datasource;

import android.content.Context;

import pe.lufega.todolist.data.cache.NewsCache;
import pe.lufega.todolist.data.cache.NewsCacheImpl;
import pe.lufega.todolist.data.network.RestApi;
import pe.lufega.todolist.data.network.RestApiImpl;

/**
 * Created by Android on 19/08/2017.
 */

public class NewsDataSourceFactory {

    private final Context context;
    private final NewsCache newsCache;

    public NewsDataSourceFactory(Context context) {
        this.context = context;
        newsCache = new NewsCacheImpl();
    }

    public NewsDataSource create() {
        if (newsCache.list().isEmpty()) {
            RestApi restApi = new RestApiImpl(context);
            return new NetworkNewsDataSource(restApi, newsCache);
        }
        return createDiskDataSource();
    }

    private NewsDataSource createDiskDataSource() {
        return new DiskNewsDataSource(newsCache);
    }
}
