package pe.lufega.todolist.domain.usecase;

import pe.lufega.todolist.domain.executor.PostExecutionThread;
import pe.lufega.todolist.domain.executor.ThreadExecutor;
import pe.lufega.todolist.domain.model.User;
import pe.lufega.todolist.domain.repository.RepositoryCallback;
import pe.lufega.todolist.domain.repository.UserRepository;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public class GetUser extends UseCase<User> {
    private final UserRepository userRepository;

    public GetUser(UserRepository userRepository,ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository=userRepository;
    }

    @Override
    protected void buildUseCase() {
        userRepository.UserData(new RepositoryCallback<User>() {
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
