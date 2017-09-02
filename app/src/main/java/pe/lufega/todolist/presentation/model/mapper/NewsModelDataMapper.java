package pe.lufega.todolist.presentation.model.mapper;

import java.util.ArrayList;
import java.util.List;

import pe.lufega.todolist.domain.model.News;
import pe.lufega.todolist.presentation.model.NewsModel;

/**
 * Created by Android on 19/08/2017.
 */

public class NewsModelDataMapper {

    public NewsModel transform(News news) {
        NewsModel newsModel = new NewsModel();
        newsModel.setTitle(news.getTitle());
        newsModel.setDetail(news.getDetail());
        newsModel.setImageUrl(news.getImageUrl());

        return newsModel;
    }

    public List<NewsModel> transform(List<News> newsList) {
        List<NewsModel> newsModelList = new ArrayList<>();
        for (News news : newsList) {
            newsModelList.add(transform(news));
        }

        return newsModelList;
    }
}
