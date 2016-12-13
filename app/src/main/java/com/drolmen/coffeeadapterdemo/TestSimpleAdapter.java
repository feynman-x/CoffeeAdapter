package com.drolmen.coffeeadapterdemo;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.drolmen.coffeeadapter.CoffeeHolder;
import com.drolmen.coffeeadapter.base.CoffeeAdapter;

import java.util.ArrayList;

/**
 * Created by drolmen on 2016/12/13.
 */

public class TestSimpleAdapter extends CoffeeAdapter<Student>{

    public TestSimpleAdapter(Context context, ArrayList<Student> arrayList) {
        super(context, arrayList);
    }

    @Override
    public int getLayoutResId(int viewType) {
        return R.layout.test_simple_layout ;
    }

    @Override
    public boolean isMultLayoutEnable() {
        return false;
    }

    @Override
    public void bindView(CoffeeHolder holder, Student t) {
        holder.setText(R.id.nameTxt,t.name);
        holder.setText(R.id.ageTxt,String.valueOf(t.age));
    }
}
