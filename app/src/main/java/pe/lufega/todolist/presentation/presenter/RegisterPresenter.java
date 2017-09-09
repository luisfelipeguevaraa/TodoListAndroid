package pe.lufega.todolist.presentation.presenter;

import android.util.Log;

import javax.sql.DataSource;

import pe.lufega.todolist.data.entity.mapper.NewsEntityDataMapper;
import pe.lufega.todolist.data.entity.mapper.UserEntityDataMapper;
import pe.lufega.todolist.data.executor.JobExecutor;
import pe.lufega.todolist.data.repository.NewsDataRepository;
import pe.lufega.todolist.data.repository.UserDataRepository;
import pe.lufega.todolist.data.repository.datasource.NewsDataSourceFactory;
import pe.lufega.todolist.data.repository.datasource.UserDataSourceFactory;
import pe.lufega.todolist.domain.model.User;
import pe.lufega.todolist.domain.repository.NewsRepository;
import pe.lufega.todolist.domain.repository.RepositoryCallback;
import pe.lufega.todolist.domain.repository.UserRepository;
import pe.lufega.todolist.domain.usecase.GetUser;
import pe.lufega.todolist.domain.usecase.SetUser;
import pe.lufega.todolist.domain.usecase.UseCase;
import pe.lufega.todolist.presentation.executor.UIThread;
import pe.lufega.todolist.presentation.model.mapper.UserModelDataMapper;
import pe.lufega.todolist.presentation.view.RegisterView;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {

    private static final String TAG = "RegisterPresenter";
    private final SetUser setUser;
    private final UserModelDataMapper userModelDataMapper;


    public RegisterPresenter(RegisterView view) {
        super(view);

       UserRepository userRepository = new UserDataRepository(
                new UserDataSourceFactory(view.context()), new UserEntityDataMapper());

        this.setUser= new SetUser(userRepository,new JobExecutor(), new UIThread());
        this.userModelDataMapper = new UserModelDataMapper();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.setUser.cancel();
        this.view = null;

    }

    private void hideLoadingView() {
        view.hideLoading();
    }

    private void renderSuccess(User user) {
        view.renderUser(userModelDataMapper.transform(user));
    }

    private void showErrorMessage(String message) {
        view.showErrorMessage(message);
    }

    public void setUser(String name,String email,String password ) {

        setUser.UpdateUser(name,email,password);
        setUser.execute(new UseCase.Callback<User>() {
            @Override
            public void onSuccess(User response) {
                hideLoadingView();
                renderSuccess(response);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);
                hideLoadingView();
                showErrorMessage(e.getMessage());
            }
        });
    }
}
