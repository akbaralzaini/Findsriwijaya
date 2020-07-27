package com.akbaralzaini.findsriwijaya;

import android.widget.ImageView;

public class Config {
    public static final String URL_GET_ALL = "http://wisata.multimediailkom.com/api/get_kuliner.php";
    public static final String URL_GET_KULINER = "http://wisata.multimediailkom.com/api/kuliner.php?id=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_ID = "id";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_JENIS = "jenis";
    public static final String KEY_DESKRIPSI = "deskripsi";
    public static final String KEY_FOTO = "foto";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_JENIS = "jenis";
    public static final String TAG_DESKRIPSI = "deskripsi";
    public static final String TAG_FOTO = "foto";

    //employee id to pass with intent
    public static final String ID = "id";
}