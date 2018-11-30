package com.sagereal.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class MainMenuGridActivity extends Activity {

    private SimpleAdapter adapter;
    private List<Map<String, Object>> gridList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        GridView gridView = findViewById(R.id.mainmenu_gridview);
        //adapter = new SimpleAdapter(this, getGridData(), R.layout.grid_item, new String[]{"normalIcon"}, new int[]{R.id.mainmenu_icon});
        gridView.setAdapter(new MainMenuAdapter(this, gridView));
    }




}

