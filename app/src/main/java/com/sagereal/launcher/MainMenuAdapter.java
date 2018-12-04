package com.sagereal.launcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;


public class MainMenuAdapter extends BaseAdapter {

    private Context mContext;
    private GridView mGridView;
    private TextView mTitle;
    private ArrayList<MenuItem> menuItems;
    private int highLightItem = 0;
    public MainMenuAdapter(Context context, final GridView gridView, TextView title){
        mContext = context;
        mGridView = gridView;
        mTitle = title;
        menuItems = getAllMenuList();
        mGridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                highLightItem = i;
                android.util.Log.e("zjj","high" + highLightItem);
                String title = ((MenuItem)getItem(i)).getTitleString();
                mTitle.setText(title);
                notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String className = ((MenuItem)getItem(highLightItem)).getClassName();
                Intent mIntent = new Intent(className);

            }
        });
    }
    @Override
    public int getCount() {

        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        //if(convertView == null){
            //holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item,null);
            //holder.iv = (ImageView) convertView.findViewById(R.id.mainmenu_icon);
            ImageView iv = convertView.findViewById(R.id.mainmenu_icon);
            if(highLightItem == position){
                iv.setImageDrawable(((MenuItem)getItem(position)).getHighlightIcon());
            }else{
                iv.setImageDrawable(((MenuItem)getItem(position)).getNormalIcon());
            }
            //convertView.setTag(holder);
//        }else{
//            holder = (Holder) convertView.getTag();
//        }
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                mGridView.getHeight() / 3);
        convertView.setLayoutParams(params);
        return convertView;
    }
    class Holder {
        ImageView iv;
    }
    public ArrayList<MenuItem> getAllMenuList(){
        ArrayList<MenuItem> allAppList = new ArrayList<MenuItem>();
        try {
            XmlResourceParser parser = mContext.getResources().getXml(R.xml.mainmenulist);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            final int depth = parser.getDepth();
            int type = -1;
            while (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT){
                if(type != XmlPullParser.START_TAG){
                    continue;
                }
                TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.MenuList);
                String packageName = a.getString(R.styleable.MenuList_packageName);
                String className = a.getString(R.styleable.MenuList_className);
                PackageManager packageManager = mContext.getPackageManager();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                    CharSequence title = packageInfo.applicationInfo.loadLabel(packageManager);
                    Drawable normalIcon = packageManager.getApplicationIcon(packageName);
                    Drawable highLightIcon = mContext.getResources().getDrawable(R.drawable.ic_launcher_foreground);
                    allAppList.add(new MenuItem(normalIcon, highLightIcon, title.toString(), className));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                //allAppList.add(new MenuData(a.get))
            }
        }catch (XmlPullParserException e){
            Log.e("launcher", "Got XmlPullParserException while parsing toppackage.", e);
        }catch (IOException e){
            Log.e("launcher", "Got IOException while parsing toppackage.", e);
        }

        return allAppList;
    }

}
