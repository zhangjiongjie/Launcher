package com.sagereal.launcher;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class MenuItem {
    private Drawable normalIcon = null;
    private Drawable highlightIcon = null;
    private String titleString = null;
    private String className = null;
    public MenuItem(Drawable normalIcon, Drawable highlightIcon, String titleString, String className){
        this.normalIcon = normalIcon;
        this.highlightIcon = highlightIcon;
        this.titleString = titleString;
        this.className = className;
    }


    public Drawable getNormalIcon() {
        return normalIcon;
    }

    public Drawable getHighlightIcon() {
        return highlightIcon;
    }

    public String getTitleString() {
        return titleString;
    }

    public String getClassName() {
        return className;
    }
}
