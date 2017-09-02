package pe.lufega.todolist.domain.usecase;

import pe.lufega.todolist.domain.executor.PostExecutionThread;
import pe.lufega.todolist.domain.executor.ThreadExecutor;

/**
 * Created by Android on 19/08/2017.
 */

public abstract class UseCase<T> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private Callback<T> callback;

    public UseCase(ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    protected abstract void buildUseCase();

    public void execute(final Callback<T> callback) {
        this.callback = callback;
        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                buildUseCase();
            }
        });
    }

    protected void notifyUseCaseSuccess(final T response) {
        postExecutionThread.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onSuccess(response);
                }
            }
        });
    }

    protected void notifyUseCaseError(final Throwable e) {
        postExecutionThread.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onError(e);
                }
            }
        });
    }

    public void cancel() {
        callback = null;
    }

    public interface Callback<T> {

        void onSuccess(T response);

        void onError(Throwable e);
    }
}
