package com.example.applicationdata;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Student> list;
    LayoutInflater inflater;

    public MyAdapter(Context context, List<Student> list) {
        this.context=context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.coustom_list_view,null);
        TextView id = view.findViewById(R.id.id);
        TextView name = view.findViewById(R.id.name);
        TextView email = view.findViewById(R.id.email);
        id.setText(String.valueOf(list.get(i).getId()));
        name.setText(list.get(i).getName());
        email.setText(list.get(i).getEmail());

        return view;
    }
}
