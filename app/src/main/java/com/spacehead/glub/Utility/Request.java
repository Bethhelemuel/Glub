package com.spacehead.glub.Utility;

import android.os.AsyncTask;

import com.spacehead.glub.MainActivity;

public class Request extends AsyncTask<String,Void,Model> {


    String json;
    Model translation;


    @Override
    protected void onPostExecute(Model m) {

        MainActivity.showTranslation(m);

        super.onPostExecute(m);
    }

    @Override
    protected Model doInBackground(String... strings) {

        json=Utility.getJson(strings[0]);
        translation=Utility.parseJson(json);

        return translation;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
