package com.drolmen.coffeeadapter.interfaces;

import android.view.View;

import com.drolmen.coffeeadapter.CoffeeHolder;

/**
 * Created by 董猛 on 2016/10/24.
 */

public interface OnRvItemClickListener<T> {
    void onItemClick(int position, T t, View view);
}
