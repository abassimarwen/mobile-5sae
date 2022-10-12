package com.example.app;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.RoundedImageView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
              Intent intent = new Intent(getWindow().getContext(), DetailsPage.class);
              getWindow().getContext().startActivity(intent);
          }
      });
      //final RoundedImageView profileImage = findViewById(R.id.profile_image_on_header);

    }
}