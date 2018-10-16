package com.onpu.jsonsimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.onpu.jsonsimple.Recycler.Adapter;
import com.onpu.jsonsimple.Recycler.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Item> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter adapter;
    Item item;
    private TextView name, city, work, skills;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        String nameJ = intent.getStringExtra("name");
        String cityJ = intent.getStringExtra("city");
        String workJ = intent.getStringExtra("work");
        String skillsJ = intent.getStringExtra("skills");
        String iconJ = intent.getStringExtra("icon");
        String[] sertificationJ = intent.getStringArrayExtra("sertification");

        imageView = (ImageView) findViewById(R.id.image);

        Picasso.get().load(iconJ).into(imageView);
        name = (TextView) findViewById(R.id.name);
        city = (TextView) findViewById(R.id.city);
        work = (TextView) findViewById(R.id.work);
        skills = (TextView) findViewById(R.id.skills);
        name.setText(nameJ);
        city.setText(cityJ);
        work.setText("Work: " + workJ);
        skills.setText("Skills: " + skillsJ);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        adapter = new Adapter(itemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        for (int i = 0; i < sertificationJ.length; i++) {
            item = new Item(i, sertificationJ[i]);
            itemList.add(item);
        }
        adapter.notifyDataSetChanged();
    }
}