package com.drolmen.coffeeadapter.base;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drolmen.coffeeadapter.CoffeeHolder;
import com.drolmen.coffeeadapter.R;
import com.drolmen.coffeeadapter.interfaces.OnRvItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 董猛 on 2016/10/23.
 */

public abstract class CoffeeAdapter<T> extends RecyclerView.Adapter<CoffeeHolder> {

    protected Context mContext ;

    private LayoutInflater mInflater ;

    private ArrayList<T> mDatas;

    private RecyclerView mOwnerRecyclerView ;

    private HashMap<Integer,OnRvItemClickListener> mClickMaps ;

    public CoffeeAdapter(Context context, ArrayList<T> arrayList) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = new ArrayList(arrayList);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        examAdapter();
    }

    /**
     * position 对应的ViewType
     */
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public final CoffeeHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CoffeeHolder holder = null ;

        View inflate = mInflater.inflate(getLayoutResId(viewType), parent, false);
        bindClickListener(inflate);

        holder = new CoffeeHolder(inflate);
        return holder;
    }

    private void bindClickListener(View view) {
        for (Integer integer : mClickMaps.keySet()) {
            final OnRvItemClickListener onRvItemClickListener = mClickMaps.get(integer);
            View viewById = view.findViewById(integer);
            if (viewById != null){
                viewById.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = (int) v.getTag(R.id.tag_for_position);
                        onRvItemClickListener.onItemClick(position,mDatas.get(position),v);
                    }
                });
            }
        }
    }

    @Override
    public final void onBindViewHolder(CoffeeHolder holder, int position) {
        holder.itemView.setTag(R.id.tag_for_position,position);
        for (Integer integer : mClickMaps.keySet()) {
            View viewById = holder.getView(integer);
            if (viewById != null){
                viewById.setTag(R.id.tag_for_position,position);
            }
        }
        bindView(holder,mDatas.get(position));
    }

    @Override
    public final int getItemCount() {
        return mDatas.size();
    }

    /**
     * 检查子类继承关系是否合法
     */
    private void examAdapter(){
    }

    public void setViewClickListener(@IdRes int id, OnRvItemClickListener listener){
        if (listener == null){
            return;
        }
        if (mClickMaps == null){
            mClickMaps = new HashMap<>();
        }
        mClickMaps.put(id, listener);
    }

    /**
     * viewType 对应的layout
     */
    @LayoutRes
    public abstract int getLayoutResId(int viewType) ;

    /**
     * 是否支持多布局，此方法被设计为需要多布局的时候重写
     */
    public abstract boolean isMultLayoutEnable() ;

    /**
     * 子类须重写此方法，进行view和数据的绑定。
     * PS:holder中储存有position已经对应的viewType
     */
    public abstract void bindView(CoffeeHolder holder, T t) ;
}
