package com.msf.mycarousellayout.ui;

/**
 * Created by marco.granatiero on 03/02/2015.
 */
public class GameEntity {
    public int imageResId;
    public int titleResId;
    public String titleRes;

   /* public GameEntity(int imageResId, int titleResId){
        this.imageResId = imageResId;
        this.titleResId = titleResId;
    }*/

    public GameEntity(int circle_btn_bg, String s) {

        this.imageResId = circle_btn_bg;
        this.titleRes = s;

    }
}
