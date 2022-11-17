package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.dao.UserDao;
import com.example.app.database.UserDataBase;
import com.example.app.entity.User;

public class MainActivity extends AppCompatActivity {
    private static  int TIME_OUT =4000;

    EditText editEmail,editPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDao db_u;
    UserDataBase dataBase_u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                getBaseContext().startActivity(loginIntent);
                finish();
            }
        },TIME_OUT);

        editEmail = findViewById(R.id.editTextEmail);
        editPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewRegister = findViewById(R.id.textViewRegister);

        dataBase_u = Room.databaseBuilder(this, UserDataBase.class, "User")
           .allowMainThreadQueries().build();
        db_u = dataBase_u.getUserDao();

        textViewRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(MainActivity.this, SignupController.class);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email = editEmail.getText().toString().trim();
               String password = editPassword.getText().toString().trim();

               User user = db_u.getUser(email,password);
               if(user != null) {
                   Intent i = new Intent(MainActivity.this, HomeActivity.class);
                   i.putExtra("User", user);
                   startActivity(i);
                   finish();
               }else{
                   Toast.makeText(MainActivity.this, "UnRegister User, or incorrect user name ",Toast.LENGTH_SHORT).show();
               }

           }
        });

    }
}