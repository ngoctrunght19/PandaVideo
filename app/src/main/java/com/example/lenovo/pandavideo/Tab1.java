package com.example.lenovo.pandavideo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by lenovo on 11/16/2016.
 */

public class Tab1 extends Fragment {

    String mTitle = "hello";

    public Tab1() {}

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab1, container, false);
    }

    public CharSequence getContentDescription() {
        return mTitle;
    }
}
