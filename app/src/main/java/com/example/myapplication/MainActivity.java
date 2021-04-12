package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, onClick {

    Button button;
    EditText products;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = findViewById(R.id.button);
        button.setOnClickListener(this);
        this.products = findViewById(R.id.product);
        this.textView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        textView.setText("Загрузка");
        String product = products.getText().toString();
        Log.e("as","start");
        if (product == null){
            textView.setText("Пустая ячейка ввода");
        }
        else if (product != null){
            Document doc = null;
            ThreadCheker tc = new ThreadCheker();
            tc.start();
            try {
                tc.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doc = tc.ret;
            Elements doc2 = (Elements) doc.getElementsByTag(product);
            Log.e("as","22222");
            if (doc2 == null){
                textView.setText("нет такого продукта");
            }
            else if(doc2 != null){
                textView.setText("Такой продукт есть");
            }
        }
    }
}