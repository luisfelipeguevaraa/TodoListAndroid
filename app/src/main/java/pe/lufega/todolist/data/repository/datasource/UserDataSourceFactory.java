package pe.lufega.todolist.data.repository.datasource;

import android.content.Context;

import pe.lufega.todolist.data.cache.NewsCache;
import pe.lufega.todolist.data.cache.NewsCacheImpl;
import pe.lufega.todolist.data.cache.UserCache;
import pe.lufega.todolist.data.cache.UserCacheImpl;
import pe.lufega.todolist.data.network.RestApi;
import pe.lufega.todolist.data.network.RestApiImpl;

/**
 * Created by DesarrolloF on 07/09/2017.
 */

public class UserDataSourceFactory {


    private final Context context;
    private final UserCache userCache;

    public UserDataSourceFactory(Context context) {
        this.context = context;
        userCache = new UserCacheImpl();
    }

    public UserDataSource create() {
        if (userCache == null) {
            RestApi restApi = new RestApiImpl(context);
            return new NetworkUserDataSource(restApi);
        }
        return createDiskDataSource();
    }

    private UserDataSource createDiskDataSource() {
        return new DiskUserDataSource(userCache);
    }

}
