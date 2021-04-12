package com.example.myapplication;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ThreadCheker extends Thread {
    Document ret;

    @Override
    public void run() {
        try {
            ret = (Document) Jsoup.connect("https://5ka.ru/").get();
        } catch (IOException e) {
            Log.e("as","asss");
            e.printStackTrace();
        }
    }
}
