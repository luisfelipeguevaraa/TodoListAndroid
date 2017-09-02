package pe.lufega.todolist.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import pe.lufega.todolist.data.entity.NewsEntity;
import pe.lufega.todolist.domain.model.News;

/**
 * Created by Android on 19/08/2017.
 */

public class NewsEntityDataMapper {

    public News transform(NewsEntity newsEntity) {
        News news = new News();
        news.setTitle(newsEntity.getTitle());
        news.setDetail(newsEntity.getDetail());
        news.setImageUrl(newsEntity.getImageUrl());

        return news;
    }

    public List<News> transform(List<NewsEntity> newsEntityList) {
        List<News> newsList = new ArrayList<>();
        for (NewsEntity newsEntity : newsEntityList) {
            newsList.add(transform(newsEntity));
        }
        return newsList;
    }
}
