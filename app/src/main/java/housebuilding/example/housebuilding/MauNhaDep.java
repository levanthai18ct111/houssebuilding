package housebuilding.example.housebuilding;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import housebuilding.example.housebuilding.adapter.New_adapter;
import housebuilding.example.housebuilding.model.News;

public class MauNhaDep extends AppCompatActivity {

    TabHost tabHost;

    ArrayList<News> dsnew , ds_noiThat ,  ds_pho , ds_BietThu, ds_truongHoc;
    New_adapter adapter,adapter_noiThat,adapter_nhapho,adapter_bietthu, adapter_truongHoc;
    ListView lv_all,lv_noiThat,lv_nhapho,lv_bietthu, lv_truongHoc;
    DatabaseReference mData ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mau_nha_dep);
        mData = FirebaseDatabase.getInstance().getReference();
        addcontroll();
        addevent();
        getdata();

    // Tạo dữ liệu

       News n = new News(" Covid-19 đã thay đổi tâm lý mua bất động sản của người dân. Họ tập trung vào những bất động sản vừa có tiện ích kế cận, đẳng cấp vừa có không gian sống xanh mát, thoáng đạt.  Tuy nhiên, những yêu cầu cao cấp, khắt khe này không phải dễ kiếm mà chỉ những dự án với quy mô khổng lồ mới đáp ứng được. Trường hợp bắt buộc phải nộp thuế", "https://baoxaydung.com.vn/stores/news_dataimages/nga/122021/24/10/in_article/1256_2.jpg", 2, "Những quy định cụ thể về thuế thu nhập cá nhân khi bán nhà đất");
       mData.child("New").push().setValue(n);



        mData.addValueEventListener(new ValueEventListener() {
            @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               mData.child("Remorqueurs").setValue("aaaaaaaaaaaa");
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
    }

    private void addevent() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (s.equalsIgnoreCase("Công nghiệp")){
                    adapter.notifyDataSetChanged();


                }else if (s.equalsIgnoreCase("Trường học")){
                    ds_truongHoc.clear();
                    for (int i=0;i<dsnew.size();i++){
                        if (dsnew.get(i).getLoai()==1){
                            ds_truongHoc.add(dsnew.get(i));
                            adapter_truongHoc= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_truongHoc);
                            lv_truongHoc.setAdapter(adapter_truongHoc);
                            adapter_truongHoc.notifyDataSetChanged();
                        }

                    }
                }else if (s.equalsIgnoreCase("Nội thất")){
                    ds_noiThat.clear();
                    for (int i=0;i<dsnew.size();i++){
                        if (dsnew.get(i).getLoai()==2){
                            ds_noiThat.add(dsnew.get(i));
                 adapter_noiThat= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_noiThat);
                lv_noiThat.setAdapter(adapter_nhapho);
                adapter_noiThat.notifyDataSetChanged();
                        }
                    }
                }else if (s.equalsIgnoreCase("Biệt thự")){
                    ds_BietThu.clear();
                    for (int i=0;i<dsnew.size();i++){
                        if (dsnew.get(i).getLoai()==1){
                            ds_BietThu.add(dsnew.get(i));
                 adapter_bietthu= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_BietThu);
                lv_bietthu.setAdapter(adapter_bietthu);
                adapter_bietthu.notifyDataSetChanged();
                        }
                    }

                }
                else if(s.equalsIgnoreCase("Nhà phố")) {
                    ds_pho.clear();
                    for (int i=0;i<dsnew.size();i++){
                        if (dsnew.get(i).getLoai()==2){
                            ds_pho.add(dsnew.get(i));
                            adapter_nhapho= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_pho);
                            lv_nhapho.setAdapter(adapter_nhapho);
                            adapter_nhapho.notifyDataSetChanged();
                        }
                    }

                }
            }
        });

    }
    private void getdata(){
        dsnew = new ArrayList<>();
        ds_noiThat = new ArrayList<>();
        ds_pho = new ArrayList<>();
        ds_BietThu = new ArrayList<>();
        ds_truongHoc = new ArrayList<>();
       mData.child("New").addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
             News  news = snapshot.getValue(News.class);
               dsnew.add(news);
               System.out.println("-----------------------"+dsnew.toString());


               adapter = new New_adapter(MauNhaDep.this, R.layout.item_news, dsnew);
               lv_all.setAdapter(adapter);
               adapter.notifyDataSetChanged();

           }

           @Override
           public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

           }

           @Override
           public void onChildRemoved(@NonNull DataSnapshot snapshot) {

           }

           @Override
           public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
    }

    private void addcontroll() {
        tabHost = findViewById(R.id.tabh);
        tabHost.setup();
        crearTab();
        lv_all = findViewById(R.id.lv_all);
        lv_noiThat = findViewById(R.id.lv_cap4);
        lv_nhapho = findViewById(R.id.lv_pho);
        lv_bietthu = findViewById(R.id.lv_biethu);
        lv_truongHoc = findViewById(R.id.lv_truongHoc);
    }

    private void crearTab() {
        TabHost.TabSpec tabAll;
        tabAll = tabHost.newTabSpec("Công Nghiệp");
        tabAll.setContent(R.id.tab1);
        tabAll.setIndicator("Công Nghiệp");
        tabHost.addTab(tabAll);

        TabHost.TabSpec tabcoffee;
        tabcoffee = tabHost.newTabSpec("Trường Học");
        tabcoffee.setContent(R.id.tab2);
        tabcoffee.setIndicator("Trường Học");
        tabHost.addTab(tabcoffee);

        TabHost.TabSpec tabmilkTea;
        tabmilkTea = tabHost.newTabSpec("Nội thất");
        tabmilkTea.setContent(R.id.tab3);
        tabmilkTea.setIndicator("Nội thất");
        tabHost.addTab(tabmilkTea);

        TabHost.TabSpec tabdirk;
        tabdirk = tabHost.newTabSpec("Biệt thự");
        tabdirk.setContent(R.id.tab4);
        tabdirk.setIndicator("Biệt thự");
        tabHost.addTab(tabdirk);

        TabHost.TabSpec tabNhaPho;
        tabNhaPho = tabHost.newTabSpec("Nhà Phố");
        tabNhaPho.setContent(R.id.tabNhaPho);
        tabNhaPho.setIndicator("Nhà Phố");
        tabHost.addTab(tabNhaPho);

    }

    @Override
    protected void onStart() {
        super.onStart();
        News n = new News("---", "",1 , "");
        mData.child("New").push().setValue(n);
    }
}