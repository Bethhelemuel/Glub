package com.spacehead.glub;

import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.spacehead.glub.Utility.Model;
import com.spacehead.glub.Utility.Request;
import com.spacehead.glub.Utility.Utility;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TabActivity";

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    public Button sendRequest;
    EditText text;

    private static Context mContext;

    private static String translator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        sendRequest=(Button)findViewById(R.id.sendRequest);
        text=(EditText)findViewById(R.id.text);

        mContext= this;

        final ArrayList<DisplayItem> list = new ArrayList<DisplayItem>();
        list.add(new DisplayItem("pirate"));
        list.add(new DisplayItem("yoda"));
        list.add(new DisplayItem("minion"));
        // list.add(new DisplayItem("test4", ContextCompat.getColor(this, R.color.color4)));

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), list, true);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(Integer.MAX_VALUE / 2);

        // start from the middle

        // access your linear layout
        // load the xml structure of your row



        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //Log.d(TAG, "onPageScrolled() called with: " + "position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        
        
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Utility.isConnected(MainActivity.this)){



                    String words=Utility.percentEncode(text.getText().toString());



                    if(!words.isEmpty()){

                                Toast.makeText(MainActivity.this, "Request", Toast.LENGTH_SHORT).show();
                                Request request=new Request();
                                request.execute(getRequestTranslator()+words);
                            }else{
                                Toast.makeText(MainActivity.this, "Cannot be empty ", Toast.LENGTH_SHORT).show();
                            }

                }else{

                    Toast.makeText(MainActivity.this, "not Connected", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

public String getRequestTranslator(){

        String req=null;

        switch(getTranslator()){


            case "pirate":

                req=Utility.request+"pirate?text=";
                break;

            case "yoda":
                req=Utility.request+"yoda?text=";
                break;


            case "minion":
                req=Utility.request+"minion?text=";
                break;

        }

        return req;
    }
    public static void showTranslation(Model m) {

        Toast.makeText(mContext,m.getTranslated(),Toast.LENGTH_LONG).show();
    }


    public String getTranslator() {
        return translator;
    }

    public static void setTranslator(String t) {
        Toast.makeText(mContext, t, Toast.LENGTH_SHORT).show();
        translator = t;
    }
}