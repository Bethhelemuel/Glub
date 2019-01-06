package com.spacehead.glub;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_STRING = "section_string";
    private static final String ARG_SECTION_COLOR = "section_color";

    public Context context;

    public PlaceholderFragment( ) {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(String textToDisplay) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_STRING, textToDisplay);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);

        ImageView imageView=(ImageView) rootView.findViewById(R.id.image);

        setImage(getArguments().getString(ARG_SECTION_STRING),imageView);

        Log.v("ASAP",getArguments().getString(ARG_SECTION_STRING));
        return rootView;
    }


    public void setImage(String text,ImageView imageView){

        switch (text){

            case "pirate":
                Glide.with(this).load(R.drawable.pirate).into(imageView);
                //MainActivity.setTranslator("pirate");
                break;

            case "yoda":
                Glide.with(this).load(R.drawable.yoda).into(imageView);
               // MainActivity.setTranslator("yoda");
                break;


            case "minion":
                Glide.with(this).load(R.drawable.minion).into(imageView);
               // MainActivity.setTranslator("minion");
                break;
        }
    }
}
