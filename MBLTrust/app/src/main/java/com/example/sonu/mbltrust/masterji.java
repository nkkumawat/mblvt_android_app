package com.example.sonu.mbltrust;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class masterji extends Fragment {
    Typeface tf;
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_masterji, container, false);

        tv = (TextView) rootView.findViewById(R.id.textView8);
        tf = Typeface.createFromAsset(getActivity().getAssets() , "hindifont.ttf");
        tv.setTypeface(tf);
        return rootView;
    }


}
