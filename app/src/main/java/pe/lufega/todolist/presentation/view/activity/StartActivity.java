package pe.lufega.todolist.presentation.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.lufega.todolist.R;
import pe.lufega.todolist.presentation.view.fragment.NewsListFragment;
import pe.lufega.todolist.presentation.view.fragment.StartFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(android.R.id.content, new StartFragment());
            ft.commit();
        }
    }
}
