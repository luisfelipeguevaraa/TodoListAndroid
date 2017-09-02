package pe.lufega.todolist.domain.repository;

/**
 * Created by Android on 19/08/2017.
 */

public interface RepositoryCallback<T> {

    void onSuccess(T response);

    void onError(Throwable e);
}
