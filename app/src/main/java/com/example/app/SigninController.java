package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.app.database.AppDataBase;
import com.example.app.entity.User;

import java.util.ArrayList;
import java.util.List;


public class SigninController extends Fragment {
    private Button signInButton;
    private AppDataBase database ;
   // private Adapter usersAdapter;
    private List<User> userList = new ArrayList<User>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signin_tab,container,false);
        signInButton = (Button) root.findViewById(R.id.button_login);
        database = AppDataBase.getAppDatabase(this.getContext());
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(getContext(),HomeActivity.class);
                getContext().startActivity(intent);*/

                User user = new User();
                EditText  edit_username = root.findViewById(R.id.editText_username);
                EditText  edit_password = root.findViewById(R.id.editText_password);
                user.setUserName(edit_username.getText().toString());
                user.setUserName(edit_password.getText().toString());
                database.userDao().insertOne(user);
            }
        });
        return root;

    }
}
