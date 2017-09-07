package pe.lufega.todolist.presentation.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.lufega.todolist.R;
import pe.lufega.todolist.presentation.model.NewsModel;
import pe.lufega.todolist.presentation.presenter.NewsListPresenter;
import pe.lufega.todolist.presentation.view.NewsListView;

public class NewsListFragment extends Fragment implements NewsListView {

    private ProgressBar progressBar;
    private ListView listView;

    private ArrayAdapter<NewsModel> adapter;
    private List<NewsModel> newsModelList;

    private NewsListPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progress);
        listView = view.findViewById(R.id.list_view);


        initUI();

        presenter = new NewsListPresenter(this);

        if (savedInstanceState == null) {
            presenter.getNewsList();
        }
    }

    private void initUI() {
        newsModelList = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                getContext(), android.R.layout.simple_list_item_1, newsModelList);
        listView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void renderNewsList(List<NewsModel> newsModelList) {
        adapter.clear();
        adapter.addAll(newsModelList);
    }
}
