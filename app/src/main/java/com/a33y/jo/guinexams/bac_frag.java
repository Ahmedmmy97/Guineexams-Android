package com.a33y.jo.guinexams;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class bac_frag extends Fragment {
    Button ss;
    Button sm;
    Button se;
    public bac_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a,container,false);
        getViews(v);
        return v;
    }
    void getViews(View v){
        ss = v.findViewById(R.id.ss);
        sm = v.findViewById(R.id.sm);
        se = v.findViewById(R.id.se);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment fragment = new Subjects_frag();
                ft.setCustomAnimations(R.animator.enter_anim_right,R.animator.exit_anim_left,R.animator.enter_anim_left,R.animator.exit_anim_right);
                Bundle b = new Bundle();
                b.putString("title",ss.getText().toString());
                fragment.setArguments(b);
                ft.replace(R.id.frag,fragment)   ;
                ft.addToBackStack(null);
                ft.commit();*/
                Intent intent = new Intent(getActivity(),Subjects_frag.class);
                intent.putExtra("title",ss.getText().toString());
                startActivity(intent);

            }
        });
        sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment fragment = new Subjects_frag();
                ft.setCustomAnimations(R.animator.enter_anim_right,R.animator.exit_anim_left,R.animator.enter_anim_left,R.animator.exit_anim_right);
                Bundle b = new Bundle();
                b.putString("title",sm.getText().toString());
                fragment.setArguments(b);
                ft.replace(R.id.frag,fragment)   ;
                ft.addToBackStack(null);
                ft.commit();*/
                Intent intent = new Intent(getActivity(),Subjects_frag.class);
                intent.putExtra("title",sm.getText().toString());
                startActivity(intent);
            }
        });
        se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment fragment = new Subjects_frag();
                ft.setCustomAnimations(R.animator.enter_anim_right,R.animator.exit_anim_left,R.animator.enter_anim_left,R.animator.exit_anim_right);
                Bundle b = new Bundle();
                b.putString("title",se.getText().toString());
                fragment.setArguments(b);
                ft.replace(R.id.frag,fragment)   ;
                ft.addToBackStack(null);
                ft.commit();*/
                Intent intent = new Intent(getActivity(),Subjects_frag.class);
                intent.putExtra("title",se.getText().toString());
                startActivity(intent);
            }
        });
    }
}
