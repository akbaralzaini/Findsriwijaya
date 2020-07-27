package com.akbaralzaini.findsriwijaya;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSetting extends Fragment {


    public FragmentSetting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Setting");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_setting, container, false);
    }

}
