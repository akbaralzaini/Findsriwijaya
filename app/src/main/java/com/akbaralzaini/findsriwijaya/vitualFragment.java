package com.akbaralzaini.findsriwijaya;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class vitualFragment extends Fragment {

    private ViewvrFragment viewvrFragment;
    private vrkFragment vrkFragment;

    public vitualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_vitual, container, false);
        // Inflate the layout for this fragment

        viewvrFragment = new ViewvrFragment();
        vrkFragment = new vrkFragment();

        View linierlayout = (View) rootview.findViewById(R.id.alquran);
        View liniervrk = (View) rootview.findViewById(R.id.pulaukemaro);

        linierlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(viewvrFragment);
            }
        });

        liniervrk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(vrkFragment);
            }
        });

        return rootview;
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_vitual, container, false);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, fragment).addToBackStack(null);
        fragmentTransaction.commit();

    }

}
