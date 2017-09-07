package pe.lufega.todolist.presentation.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import pe.lufega.todolist.R;
import pe.lufega.todolist.presentation.model.UserModel;
import pe.lufega.todolist.presentation.view.RegisterView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements RegisterView {

    ProgressBar progressBar;
    EditText edtMail;
    EditText edtUser;
    EditText edtPassword;
    Button btnRegistrar;


    public RegisterFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progress_reg);
        edtMail= view.findViewById(R.id.edt_reg_mail);
        edtUser= view.findViewById(R.id.edt_reg_user);
        edtPassword= view.findViewById(R.id.edt_reg_password);
        btnRegistrar= view.findViewById(R.id.btn_reg_registrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerClick(view);
            }
        });
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
    public void registerClick(View view) {
        

    }

    @Override
    public void renderUser(UserModel userModel) {

    }
}
