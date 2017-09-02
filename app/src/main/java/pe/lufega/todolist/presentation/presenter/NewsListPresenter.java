package pe.lufega.todolist.presentation.presenter;

import android.util.Log;

import java.util.List;

import pe.lufega.todolist.data.entity.mapper.NewsEntityDataMapper;
import pe.lufega.todolist.data.executor.JobExecutor;
import pe.lufega.todolist.data.repository.NewsDataRepository;
import pe.lufega.todolist.data.repository.datasource.NewsDataSourceFactory;
import pe.lufega.todolist.domain.model.News;
import pe.lufega.todolist.domain.repository.NewsRepository;
import pe.lufega.todolist.domain.usecase.GetNewsList;
import pe.lufega.todolist.domain.usecase.UseCase;
import pe.lufega.todolist.presentation.executor.UIThread;
import pe.lufega.todolist.presentation.model.mapper.NewsModelDataMapper;
import pe.lufega.todolist.presentation.view.NewsListView;

/**
 * Created by Android on 19/08/2017.
 */

public class NewsListPresenter extends BasePresenter<NewsListView> {

    private static final String TAG = "NewsListPresenter";

    private final GetNewsList getNewsList;
    private final NewsModelDataMapper newsModelDataMapper;

    public NewsListPresenter(NewsListView view) {
        super(view);

        NewsRepository newsRepository = new NewsDataRepository(
                new NewsDataSourceFactory(view.context()), new NewsEntityDataMapper());

        this.getNewsList = new GetNewsList(
                newsRepository, new JobExecutor(), new UIThread());

        this.newsModelDataMapper = new NewsModelDataMapper();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getNewsList.cancel();
        this.view = null;
    }

    private void renderNewsListInView(List<News> newsList) {
        view.renderNewsList(newsModelDataMapper.transform(newsList));
    }

    private void showLoadingView() {
        view.showLoading();
    }

    private void hideLoadingView() {
        view.hideLoading();
    }

    private void showErrorMessage(String message) {
        view.showErrorMessage(message);
    }

    public void getNewsList() {
        showLoadingView();
        getNewsList.execute(new UseCase.Callback<List<News>>() {
            @Override
            public void onSuccess(List<News> response) {
                hideLoadingView();
                renderNewsListInView(response);
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
