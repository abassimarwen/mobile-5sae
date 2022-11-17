package com.example.app;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app.entity.User;
import com.makeramen.RoundedImageView;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUser;
    private User user;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*********/
        user = (User) getIntent().getSerializableExtra("User");
        tvUser = findViewById(R.id.text);
        if (user != null) {
            tvUser.setText("WELCOME " + user.getUserName());
        }
        /*********/
        myDialog = new Dialog(this);
      final  DrawerLayout  drawerLayout = findViewById(R.id.homeDrawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
      final   ImageView bookmark = findViewById(R.id.item_bookmark);
      bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* switch(bookmark.getDrawable().getCurrent()) {
                    case R.drawable.filled_bookmark:
                        bookmark.setBackgroundResource(R.drawable.icons8_ruban_marque_page);
                        break;
                    case R.drawable.icons8_ruban_marque_page:
                    default:
                        bookmark.setBackgroundResource(R.drawable.filled_bookmark);
                        break;
                }*/

                bookmark.setBackgroundResource(R.drawable.filled_bookmark);

            }
        });
      final TextView itemTitle = findViewById(R.id.item_title);
      itemTitle.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(HomeActivity.this, DetailsPage.class);
              getWindow().getContext().startActivity(intent);
          }
      });
      //final RoundedImageView profileImage = findViewById(R.id.profile_image_on_header);
       }
    public void ShowPopup(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.add_popup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        //  btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }
}