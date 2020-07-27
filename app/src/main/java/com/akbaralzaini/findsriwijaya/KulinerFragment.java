package com.akbaralzaini.findsriwijaya;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class KulinerFragment extends Fragment implements ListView.OnItemClickListener{

    private ListView listView;

    private String JSON_STRING;


    public KulinerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_kuliner, container, false);
        listView = (ListView) RootView.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getJSON();
        return RootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), dkuliner.class);
        HashMap map =(HashMap)parent.getItemAtPosition(position);
        String mhsid = map.get(Config.TAG_ID).toString();
        intent.putExtra(Config.ID,mhsid);
        startActivity(intent);
    }


    private void showEmployee(){
        JSONObject jsonObject;
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Config.TAG_ID);
                String name = jo.getString(Config.TAG_NAMA);
                String foto = jo.getString(Config.TAG_FOTO);
                String jenis = jo.getString(Config.TAG_JENIS);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(Config.TAG_ID,id);
                employees.put(Config.TAG_NAMA,name);
                employees.put(Config.TAG_FOTO,foto);
                employees.put(Config.TAG_JENIS,jenis);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                getActivity(), list, R.layout.list_item,
                new String[]{Config.TAG_NAMA, Config.TAG_JENIS},
                new int[]{R.id.nama, R.id.deskripsi});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(getActivity(),"Mengambil Data","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Config.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


}
