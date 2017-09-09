package pe.lufega.todolist.domain.repository;

import pe.lufega.todolist.domain.model.User;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public interface UserRepository {

    void setUserData(RepositoryCallback<User> callback);
}
