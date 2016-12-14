package com.drolmen.coffeeadapterdemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drolmen.coffeeadapter.CoffeeHolder;
import com.drolmen.coffeeadapter.base.CoffeeAdapter;
import com.drolmen.coffeeadapter.interfaces.OnRvItemClickListener;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mContentRecyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentRecyView = (RecyclerView) findViewById(R.id.contentRecyView);

        //制造数据
        ArrayList<Student> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Student s = new Student();
            s.name = "I am " + i;
            s.age = random.nextInt()%30;
            arrayList.add(s);
        }
        final TestSimpleAdapter adapter = new TestSimpleAdapter(this, arrayList);
        adapter.setViewClickListener(R.id.alertBtn, new OnRvItemClickListener<Student>() {
            @Override
            public void onItemClick(int position, Student student, View view) {
                //1.弹窗
                Toast.makeText(MainActivity.this, "I am " + position + "button", Toast.LENGTH_SHORT).show();
                //2.修改数据并更新
//                student.age = 18;
//                adapter.notifyDataSetChanged();
            }
        });

        adapter.setViewClickListener(R.id.rootItem, new OnRvItemClickListener() {
            @Override
            public void onItemClick(int position, Object o, View view) {
                Toast.makeText(MainActivity.this, "I am itemView" + position, Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);

        TextView textView = new TextView(this);
        textView.setText("-----> 我是footer <------");

        adapter.addHeaderView(imageView);
        adapter.addFooterView(textView);

        mContentRecyView.setLayoutManager(new GridLayoutManager(this,2));
        mContentRecyView.setAdapter(adapter);
    }
}
