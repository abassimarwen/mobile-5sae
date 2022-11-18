package com.example.app;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.app.adapters.PublicationAdapter;
import com.example.app.database.AppDataBase;
import com.example.app.entity.Clothe;
import com.example.app.entity.Furniture;
import com.example.app.entity.Pet;
import com.example.app.entity.Publication;
import com.example.app.entity.SchoolSupplies;
import com.example.app.entity.Toy;
import com.makeramen.RoundedImageView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class HomeActivity extends AppCompatActivity {
    Button addButton;
    private AppDataBase database ;
    String spinnerType;
    Spinner addType;
    Dialog myDialog;
    EditText title ;
    EditText desc;
    EditText brand;
    EditText clotheSize;
    EditText toyMaxAge;
    EditText toyMinAge;
    EditText bread;
    EditText age;
    EditText kind;
    EditText schoolAge;
    Clothe clothe = new Clothe();
    Toy toy = new Toy();
    Pet pet = new Pet();
    SchoolSupplies schoolSupplies = new SchoolSupplies();
    Furniture furniture = new Furniture();
    List<Toy> toys;
    List<Publication> publications = new ArrayList<>();
    RecyclerView rv ;
    PublicationAdapter adapter;
    ImageView delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myDialog = new Dialog(this);
        //db
        database = AppDataBase.getAppDatabase(this);
       toys = database.toyDao().getAll();
      //---> publications.addAll(toys);
       rv=findViewById(R.id.items);
       rv.setAdapter(new PublicationAdapter(toys,this));
        rv.setLayoutManager(new LinearLayoutManager(this));
      /*  delete =myDialog.findViewById(R.id.item_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.toyDao().delete(rv.);
            }
        });*/



        //db
       //menu
      final  DrawerLayout  drawerLayout = findViewById(R.id.homeDrawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        //menu
    //  final   ImageView bookmark = findViewById(R.id.item_bookmark);
     /* bookmark.setOnClickListener(new View.OnClickListener() {
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

             /*   bookmark.setBackgroundResource(R.drawable.filled_bookmark);

            }
        });*/
        //details
    /*  final TextView itemTitle = findViewById(R.id.item_title_toy);
      itemTitle.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(HomeActivity.this, DetailsPage.class);
              getWindow().getContext().startActivity(intent);
          }
      });*/
      //details
      //final RoundedImageView profileImage = findViewById(R.id.profile_image_on_header);

       }
    public void ShowPopup(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.add_popup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);

        //  btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();

            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
        //add block
        addType =myDialog.findViewById(R.id.type_spinner);
        brand = myDialog.findViewById(R.id.add_brand);
        toyMaxAge = myDialog.findViewById(R.id.add_toy_age_max);
        toyMinAge = myDialog.findViewById(R.id.add_toy_age_min);
        clotheSize = myDialog.findViewById(R.id.add_clothe_size);
        bread = myDialog.findViewById(R.id.add_pet_breed);
        kind = myDialog.findViewById(R.id.add_pet_kind);
        schoolAge = myDialog.findViewById(R.id.add_school_age);
        age = myDialog.findViewById(R.id.add_pet_age);
         addButton = (Button) myDialog.findViewById(R.id.b_add_pub);

        addType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
               spinnerType =   parent.getItemAtPosition(position).toString();

                switch (spinnerType){
                    case "toy" :
                        bread.setVisibility(View.INVISIBLE);
                        toyMaxAge.setVisibility(View.INVISIBLE);
                        toyMinAge.setVisibility(View.INVISIBLE);
                        clotheSize.setVisibility(View.INVISIBLE);
                        kind.setVisibility(View.INVISIBLE);
                        age.setVisibility(View.INVISIBLE);
                        schoolAge.setVisibility(View.INVISIBLE);
                        toyMaxAge.setVisibility(View.VISIBLE);
                        toyMinAge.setVisibility(View.VISIBLE);
                        brand.setVisibility(View.VISIBLE);
                         addButton.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                 desc = myDialog.findViewById(R.id.add_desc);
                                 brand = myDialog.findViewById(R.id.add_brand);
                                 toyMaxAge = myDialog.findViewById(R.id.add_toy_age_max);
                                 toyMinAge = myDialog.findViewById(R.id.add_toy_age_min);
                                 title = myDialog.findViewById(R.id.add_title);
                                 toy.setTitle(title.getText().toString());
                                 toy.setDescription(desc.getText().toString());
                                 toy.setBrand(brand.getText().toString());
                                 toy.setMaxAgeRange(toyMaxAge.getInputType());
                                 toy.setMinAgeRange(toyMinAge.getInputType());
                                 database.toyDao().insertOne(toy);

                               // adapter.notifyChange(database.toyDao().getAll());
                                 myDialog.dismiss();

                             }
                         });
                        break;
                    case "clothe" :
                        kind.setVisibility(View.INVISIBLE);
                        schoolAge.setVisibility(View.INVISIBLE);
                        bread.setVisibility(View.INVISIBLE);
                        toyMaxAge.setVisibility(View.INVISIBLE);
                        toyMinAge.setVisibility(View.INVISIBLE);
                        age.setVisibility(View.INVISIBLE);
                        brand.setVisibility(View.VISIBLE);
                        clotheSize.setVisibility(View.VISIBLE);
                        addButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                title = myDialog.findViewById(R.id.add_title);
                                desc = myDialog.findViewById(R.id.add_desc);
                                clotheSize = myDialog.findViewById(R.id.add_clothe_size);
                                clotheSize = myDialog.findViewById(R.id.add_clothe_size);
                                clothe.setTitle(title.getText().toString());
                                clothe.setDescription(desc.getText().toString());
                                clothe.setBrand(brand.getText().toString());
                                clothe.setSize(clotheSize.getText().toString());
                                database.clotheDao().insertOne(clothe);
                                myDialog.dismiss();
                            }
                        });
                        break;
                    case "pet" :
                        schoolAge.setVisibility(View.INVISIBLE);
                        toyMaxAge.setVisibility(View.INVISIBLE);
                        toyMinAge.setVisibility(View.INVISIBLE);
                        clotheSize.setVisibility(View.INVISIBLE);
                        brand.setVisibility(View.INVISIBLE);
                        bread.setVisibility(View.VISIBLE);
                        kind.setVisibility(View.VISIBLE);
                        age.setVisibility(View.VISIBLE);

                        addButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bread = myDialog.findViewById(R.id.add_pet_breed);
                                kind = myDialog.findViewById(R.id.add_pet_kind);
                                age = myDialog.findViewById(R.id.add_pet_age);
                                title = myDialog.findViewById(R.id.add_title);
                                desc = myDialog.findViewById(R.id.add_desc);
                                pet.setTitle(title.getText().toString());
                                pet.setDescription(desc.getText().toString());
                                pet.setBreed(bread.getText().toString());
                                pet.setKind(kind.getText().toString());
                                pet.setAge(age.getInputType());
                                database.petDao().insertOne(pet);
                                myDialog.dismiss();
                            }
                        });
                        break;
                    case "school supplies" :
                        toyMaxAge.setVisibility(View.INVISIBLE);
                        toyMinAge.setVisibility(View.INVISIBLE);
                        clotheSize.setVisibility(View.INVISIBLE);
                        bread.setVisibility(View.INVISIBLE);
                        kind.setVisibility(View.INVISIBLE);
                        age.setVisibility(View.INVISIBLE);
                        schoolAge.setVisibility(View.VISIBLE);
                        brand.setVisibility(View.VISIBLE);

                        addButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                title = myDialog.findViewById(R.id.add_title);
                                desc = myDialog.findViewById(R.id.add_desc);
                                brand = myDialog.findViewById(R.id.add_brand);
                                schoolAge = myDialog.findViewById(R.id.add_school_age);
                                schoolSupplies.setTitle(title.getText().toString());
                                schoolSupplies.setDescription(desc.getText().toString());
                                schoolSupplies.setBrand(brand.getText().toString());
                                schoolSupplies.setMaxAgeRange(schoolAge.getInputType());
                                database.schoolSuppliesDao().insertOne(schoolSupplies);
                                myDialog.dismiss();
                            }
                        });

                        break;
                    case "furniture" :
                        toyMaxAge.setVisibility(View.INVISIBLE);
                        toyMinAge.setVisibility(View.INVISIBLE);
                        clotheSize.setVisibility(View.INVISIBLE);
                        bread.setVisibility(View.INVISIBLE);
                        kind.setVisibility(View.INVISIBLE);
                        schoolAge.setVisibility(View.INVISIBLE);
                        age.setVisibility(View.INVISIBLE);
                        brand.setVisibility(View.VISIBLE);

                        addButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                title = myDialog.findViewById(R.id.add_title);
                                desc = myDialog.findViewById(R.id.add_desc);
                                brand = myDialog.findViewById(R.id.add_brand);
                                furniture.setTitle(title.getText().toString());
                                furniture.setDescription(desc.getText().toString());
                                furniture.setBrand(brand.getText().toString());
                                database.furnitureDao().insertOne(furniture);
                                myDialog.dismiss();
                            }
                        });
                        break;

                }

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        // end add block

    }
}