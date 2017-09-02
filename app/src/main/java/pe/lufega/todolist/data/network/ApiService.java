package pe.lufega.todolist.data.network;

import java.util.List;

import pe.lufega.todolist.data.entity.NewsEntity;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Android on 19/08/2017.
 */

public interface ApiService {

    String BASE_URL = "https://api.backendless.com/9A93628B-54D0-4D9C-FF79-03C4606CCB00/22C006FB-0F32-7A42-FF75-C799CD790300/data/";

    @GET("News")
    Call<List<NewsEntity>> newsEntityList();

}
