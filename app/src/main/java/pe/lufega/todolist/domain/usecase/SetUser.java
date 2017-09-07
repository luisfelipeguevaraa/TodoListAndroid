package pe.lufega.todolist.domain.usecase;

import pe.lufega.todolist.domain.executor.PostExecutionThread;
import pe.lufega.todolist.domain.executor.ThreadExecutor;
import pe.lufega.todolist.domain.model.User;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public class SetUser extends UseCase<User> {
    private final String name;
    private final String mail;
    private final String password;

    public SetUser(String name, String mail,String password,ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.name=name;
        this.mail=mail;
        this.password=password;
    }

    @Override
    protected void buildUseCase() {

    }
}
