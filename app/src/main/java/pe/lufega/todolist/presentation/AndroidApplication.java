package pe.lufega.todolist.presentation;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Android on 19/08/2017.
 */

public class AndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
