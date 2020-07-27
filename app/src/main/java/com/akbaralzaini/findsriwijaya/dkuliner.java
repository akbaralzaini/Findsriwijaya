package com.akbaralzaini.findsriwijaya;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dkuliner extends AppCompatActivity {

    private TextView namaa,jeniss,deskripsii;
    private ImageView fotos;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dkuliner);

        Intent intent = getIntent();
        id = intent.getStringExtra(Config.ID);

        namaa = (TextView) findViewById(R.id.nama);
        jeniss = (TextView) findViewById(R.id.jenis);
        deskripsii = (TextView) findViewById(R.id.deskripsi);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(dkuliner.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_GET_KULINER,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String nama = c.getString(Config.TAG_NAMA);
            String jenis = c.getString(Config.TAG_JENIS);
            String deskripsi = c.getString(Config.TAG_DESKRIPSI);
           // String fotoss = c.getString(Config.TAG_FOTO);

            namaa.setText(nama);
            jeniss.setText(jenis);
            deskripsii.setText(deskripsi);
       //     fotos.setImageBitmap(fotoss);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
