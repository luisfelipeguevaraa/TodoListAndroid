package pe.lufega.todolist.domain.usecase;

import pe.lufega.todolist.domain.executor.PostExecutionThread;
import pe.lufega.todolist.domain.executor.ThreadExecutor;
import pe.lufega.todolist.domain.model.User;
import pe.lufega.todolist.domain.repository.RepositoryCallback;
import pe.lufega.todolist.domain.repository.UserRepository;
import retrofit2.Call;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public class SetUser extends UseCase<User> {
    private String name;
    private String email;
    private String password;

    private final UserRepository userRepository;

    public SetUser(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    public void UpdateUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    protected void buildUseCase() {

        userRepository.setUserData(new RepositoryCallback<User>() {
            @Override
            public void onSuccess(User response) {
                notifyUseCaseSuccess(response);
            }

            @Override
            public void onError(Throwable e) {
                notifyUseCaseError(e);
            }
        });

    }
}
