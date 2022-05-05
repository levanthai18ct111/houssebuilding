package housebuilding.example.housebuilding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Main_ extends AppCompatActivity {
    ListView listView;
    ArrayList<congTy> ds;
    Web_Apdapter web_apdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tesswed);
        addcontroll();
        addcongty();
        addevent();




        web_apdapter = new Web_Apdapter(Main_.this,R.layout.item_web , ds);
        listView.setAdapter(web_apdapter);

    }

    private void addevent() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Main_.this,WebActivity.class);
                intent.putExtra("link",ds.get(i).getUrl());
                startActivity(intent);
            }
        });
    }

    private void addcongty() {
        ds = new ArrayList<>();
        ds.add(new congTy("Kiến Trức Mới","kientrucmoi.vn/",R.drawable.lg1));
        ds.add(new congTy("Kiến trúc Hoàng Đạt","kientruchoangdat.com/",R.drawable.lg2));
        ds.add(new congTy("Xây dựng Hòa Bình","hbcg.vn/",R.drawable.lg3));
    }

    private void addcontroll() {
        listView = findViewById(R.id.lv_view);
    }
}
