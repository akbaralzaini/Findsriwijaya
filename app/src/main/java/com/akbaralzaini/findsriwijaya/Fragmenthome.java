package com.akbaralzaini.findsriwijaya;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmenthome extends Fragment implements View.OnClickListener{

    private eventFragment eventFragment;
    private aboutFragment aboutFragment;
    private KulinerFragment kulinerFragment;
    private vitualFragment vitualFragment;

    public Fragmenthome() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Find Sriwijaya");
        View rootView = inflater.inflate(R.layout.fragment_fragmenthome, container, false);
        // Inflate the layout  nfor this fragment
        eventFragment = new eventFragment();
        aboutFragment = new aboutFragment();
        kulinerFragment = new KulinerFragment();
        vitualFragment = new vitualFragment();

        ImageView event =(ImageView) rootView.findViewById(R.id.event);
        ImageView vr =(ImageView) rootView.findViewById(R.id.vr);
        ImageView kuliner =(ImageView) rootView.findViewById(R.id.kuliner);
        ImageView about =(ImageView) rootView.findViewById(R.id.about);

       /* image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(eventFragment);
            }
        }); */

        event.setOnClickListener(this);
        vr.setOnClickListener(this);
        kuliner.setOnClickListener(this);
        about.setOnClickListener(this);
        return rootView;
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, fragment).addToBackStack(null);
        fragmentTransaction.commit();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.event :
                setFragment(eventFragment);
                break;
            case R.id.kuliner :
                setFragment(kulinerFragment);
                break;
            case R.id.vr:
                setFragment(vitualFragment);
                break;
            case R.id.about:
                setFragment(aboutFragment);
                break;
        }
    }
}
