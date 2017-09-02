package pe.lufega.todolist.data.cache;

import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import pe.lufega.todolist.data.entity.NewsEntity;

/**
 * Created by Android on 19/08/2017.
 */

public class NewsCacheImpl implements NewsCache {

    @Override
    public void put(final List<NewsEntity> newsEntityList) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealm(newsEntityList);
            }
        });
        realm.close();
    }

    @Override
    public List<NewsEntity> list() {
        final Realm realm = Realm.getDefaultInstance();
        RealmResults<NewsEntity> results = realm.where(NewsEntity.class).findAll();
        return Arrays.asList(results.toArray(new NewsEntity[results.size()]));
    }
}
