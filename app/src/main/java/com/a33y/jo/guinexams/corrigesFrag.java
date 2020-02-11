package com.a33y.jo.guinexams;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class corrigesFrag extends Fragment {
    RecyclerView recyclerView;
    Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Subject s;
    LinearLayout loading;
    public corrigesFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sujetfrag,container,false);
        Bundle b = getArguments();
        s= (Subject) getArguments().getSerializable("subject");
        loading = v.findViewById(R.id.progressbar);
        loading.setVisibility(View.GONE);
        recyclerView = v.findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        adapter = new Adapter(s,getContext(),1,true,loading);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return v;
    }

}
