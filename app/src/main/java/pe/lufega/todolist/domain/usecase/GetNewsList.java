package pe.lufega.todolist.domain.usecase;

import java.util.List;

import pe.lufega.todolist.domain.executor.PostExecutionThread;
import pe.lufega.todolist.domain.executor.ThreadExecutor;
import pe.lufega.todolist.domain.model.News;
import pe.lufega.todolist.domain.repository.NewsRepository;
import pe.lufega.todolist.domain.repository.RepositoryCallback;

/**
 * Created by Android on 19/08/2017.
 */

public class GetNewsList extends UseCase<List<News>> {

    private final NewsRepository newsRepository;

    public GetNewsList(NewsRepository newsRepository, ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.newsRepository = newsRepository;
    }

    @Override
    protected void buildUseCase() {
        newsRepository.newsList(new RepositoryCallback<List<News>>() {
            @Override
            public void onSuccess(List<News> response) {
                notifyUseCaseSuccess(response);
            }

            @Override
            public void onError(Throwable e) {
                notifyUseCaseError(e);
            }
        });
    }
}
