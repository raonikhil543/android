package com.scrapper.subbu.newsscrolling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Indian extends AppCompatActivity {

    private String noti;
    private String descp;


    public Indian(String noti,String descp) {
        this.noti = noti;
        this.descp = descp;

    }

    public String getNoti() {
        return noti;
    }

    public String getDescp() {
        return descp;
    }

    public void setNoti(String noti) {
        this.noti = noti;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
}
