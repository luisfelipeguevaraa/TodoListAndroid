package pe.lufega.todolist.presentation.view;

import java.util.List;

import pe.lufega.todolist.presentation.model.NewsModel;

/**
 * Created by Android on 19/08/2017.
 */

public interface NewsListView extends LoadingView {

    void renderNewsList(List<NewsModel> newsModelList);
}
