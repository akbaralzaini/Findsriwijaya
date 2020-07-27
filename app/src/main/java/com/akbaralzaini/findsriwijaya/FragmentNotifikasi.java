package com.akbaralzaini.findsriwijaya;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNotifikasi extends Fragment {


    public FragmentNotifikasi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Notifikasi");
        return inflater.inflate(R.layout.fragment_fragment_notifikasi, container, false);
    }

}
