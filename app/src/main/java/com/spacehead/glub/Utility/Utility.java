package com.spacehead.glub.Utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utility {

    public static String request="http://api.funtranslations.com/translate/";
    public static Model model;

    public static  boolean isConnected(Context mContext) {

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);


        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else{
            connected = false;

        }

        return connected;
    }

    public static String getJson(String base_url){

        String returnedJson="";
        try {
            URL url=new URL(base_url);

            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));

            String line="";


            while(line !=null){

                line=bufferedReader.readLine();
                returnedJson= returnedJson + line;
            }




        } catch (Exception e) {
            Log.v("Message E", e.getMessage());
            e.printStackTrace();

            Log.v("Error ma G: ", " " + e.getMessage());
        }
        Log.v("ASDFGZGH",returnedJson);

        return returnedJson;
    }

    public static Model parseJson(String json) {

        model= new Model();

        try {
            JSONObject jsonObject=new JSONObject(json);

            JSONObject response= jsonObject.getJSONObject("contents");


                model.setTranslation(response.getString("translation"));
                model.setTranslated(response.getString("translated"));
                model.setText(response.getString("text"));



        } catch (JSONException e) {
            e.printStackTrace();
        }


        return model;

    }

    public static String percentEncode(String encodeMe) {
        if (encodeMe == null) {
            return "";
        }
        String encoded = encodeMe.replace("%", "%25");
        encoded = encoded.replace(" ", "%20");
        encoded = encoded.replace("!", "%21");
        encoded = encoded.replace("#", "%23");
        encoded = encoded.replace("$", "%24");
        encoded = encoded.replace("&", "%26");
        encoded = encoded.replace("'", "%27");
        encoded = encoded.replace("(", "%28");
        encoded = encoded.replace(")", "%29");
        encoded = encoded.replace("*", "%2A");
        encoded = encoded.replace("+", "%2B");
        encoded = encoded.replace(",", "%2C");
        encoded = encoded.replace("/", "%2F");
        encoded = encoded.replace(":", "%3A");
        encoded = encoded.replace(";", "%3B");
        encoded = encoded.replace("=", "%3D");
        encoded = encoded.replace("?", "%3F");
        encoded = encoded.replace("@", "%40");
        encoded = encoded.replace("[", "%5B");
        encoded = encoded.replace("]", "%5D");
        return encoded;
    }

}
