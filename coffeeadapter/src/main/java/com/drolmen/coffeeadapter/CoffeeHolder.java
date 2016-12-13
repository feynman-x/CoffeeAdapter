package com.drolmen.coffeeadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by 董猛 on 2016/10/23.
 */

public class CoffeeHolder extends RecyclerView.ViewHolder {

    private HashMap<Integer,View> mViewsMap ;

    public CoffeeHolder(View itemView) {
        super(itemView);
        mViewsMap = new HashMap<>();
    }

    public <T extends View> T getView(int viewId){
        View view = mViewsMap.get(viewId) ;
        if (view == null){
            view = itemView.findViewById(viewId);
            mViewsMap.put(viewId, view);
        }
        return (T) view;
    }

    public void setText(int id,String str){
        ((TextView) getView(id)).setText(str);
    }
}
