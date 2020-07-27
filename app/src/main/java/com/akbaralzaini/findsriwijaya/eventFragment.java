package com.akbaralzaini.findsriwijaya;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class eventFragment extends Fragment {

    private DetailEventFragment DetailEventFragment;

    public eventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_event, container, false);
        // Inflate the layout for this fragment

        DetailEventFragment = new DetailEventFragment();

        View linierlayout = (View) rootview.findViewById(R.id.ustad1);

        linierlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(DetailEventFragment);
            }
        });

        return rootview;
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, fragment).addToBackStack(null);
        fragmentTransaction.commit();

    }



}
