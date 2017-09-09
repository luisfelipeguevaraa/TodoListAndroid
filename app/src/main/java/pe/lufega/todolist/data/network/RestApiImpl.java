package pe.lufega.todolist.data.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

import pe.lufega.todolist.data.entity.NewsEntity;
import pe.lufega.todolist.data.entity.UserEntity;
import pe.lufega.todolist.data.exception.NetworkException;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android on 19/08/2017.
 */

public class RestApiImpl implements RestApi {

    private final ApiService apiService;
    private final Context context;

    private UserEntity userDatos;

    public RestApiImpl(Context context) {
        this.context = context;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.apiService = retrofit.create(ApiService.class);
    }

    @Override
    public List<NewsEntity> getNewsEntityList() throws Exception {
        if (hasInternetConnection()) {
            Call<List<NewsEntity>> call = apiService.newsEntityList();
            Response<List<NewsEntity>> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new NetworkException("Get News list request failed");
            }
        } else {
            throw new NetworkException("No internet connection");
        }
    }

    @Override
    public UserEntity getUserEntity() throws Exception {
        if (hasInternetConnection()) {
            Call<UserEntity> call = apiService.userEntity();
            Response<UserEntity> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new NetworkException("Get News list request failed");
            }
        } else {
            throw new NetworkException("No internet connection");
        }
    }

    public void UpdateUser(String name, String email, String password) {
        userDatos.setEmail(email);
        userDatos.setName(email);
        userDatos.setPassword(email);
    }


    @Override
    public UserEntity setUserEntity(UserEntity userEntity) throws Exception {
        if (hasInternetConnection()) {
            Call<UserEntity> call = apiService.userEntity(userDatos);
            Response<UserEntity> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new NetworkException("Get News list request failed");
            }
        } else {
            throw new NetworkException("No internet connection");
        }
    }

    private boolean hasInternetConnection() {
        boolean isConnected;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();

        return isConnected;
    }
}
