package pe.lufega.todolist.presentation.executor;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import pe.lufega.todolist.domain.executor.PostExecutionThread;

/**
 * Created by Android on 19/08/2017.
 */

public class UIThread implements PostExecutionThread {

    private Handler uiHandler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(@NonNull Runnable runnable) {
        uiHandler.post(runnable);
    }
}
