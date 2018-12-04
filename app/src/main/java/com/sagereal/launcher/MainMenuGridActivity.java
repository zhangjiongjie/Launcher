package com.sagereal.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MainMenuGridActivity extends Activity {

    private SimpleAdapter adapter;
    private List<Map<String, Object>> gridList;
    private int highLightItem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        GridView gridView = findViewById(R.id.mainmenu_gridview);
        TextView title = (TextView)findViewById(R.id.title);
        //adapter = new SimpleAdapter(this, getGridData(), R.layout.grid_item, new String[]{"normalIcon"}, new int[]{R.id.mainmenu_icon});
        gridView.setAdapter(new MainMenuAdapter(this, gridView, title));
    }




}

