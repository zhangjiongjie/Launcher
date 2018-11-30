package com.sagereal.launcher;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class MenuItem {
    private Drawable normalIcon = null;
    private Bitmap highlightIcon = null;
    private String titleString = null;
    private String className = null;
    public MenuItem(Drawable normalIcon, Bitmap highlightIcon, String titleString, String className){
        this.normalIcon = normalIcon;
        this.highlightIcon = highlightIcon;
        this.titleString = titleString;
        this.className = className;
    }


    public Drawable getNormalIcon() {
        return normalIcon;
    }

    public Bitmap getHighlightIcon() {
        return highlightIcon;
    }

    public String getTitleString() {
        return titleString;
    }

    public String getClassName() {
        return className;
    }
}
