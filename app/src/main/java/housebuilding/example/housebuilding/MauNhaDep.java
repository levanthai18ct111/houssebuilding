package housebuilding.example.housebuilding;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import housebuilding.example.housebuilding.adapter.New_adapter;
import housebuilding.example.housebuilding.model.Admin;
import housebuilding.example.housebuilding.model.News;
import java.time.format.DateTimeFormatter;


public class MauNhaDep extends AppCompatActivity {

    TabHost tabHost;

    ArrayList<News> ds_cn , ds_th ,  ds_nt, ds_Bt, ds_np ;
    New_adapter adapter_cn,adapter_th,adapter_nt,adapter_bt, adapter_np;
    ListView lv1,lv2,lv3,lv4,lv5;
    DatabaseReference mData ;
    String img , titile,boddy,lh;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mau_nha_dep);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();

        mData = FirebaseDatabase.getInstance().getReference();
        ds_th = new ArrayList<>();
        ds_cn = new ArrayList<>();
        ds_np = new ArrayList<>();
        ds_nt = new ArrayList<>();
        ds_Bt = new ArrayList<>();
        addcontroll();
        addevent();
        getdata();;
    // Tạo dữ liệu

//        News n1 = new News("KIẾN TRÚC VƯƠNG AN Với đội ngũ cán bộ kỹ thuật nhiều kinh nghiệm và phục vụ hết mình. Chúng tôi mong muốn đem lại cho khách hàng những sản phẩm đảm bảo chất lượng tốt nhất trong thời gian sớm nhất và trên hết là sự hài lòng cho khách hàng đối với các sản phẩm, dịch vụ của chúng tôi.\n" +
//                "\n" +
//                "Chất lượng cuả sản phẩm và sự sáng tạo trong kỹ thuật với mục đính đưa ra các mẫu thiết kế với giá thành và điều kiện thương mại tốt nhất mà vẫn đảm bảo được công năng, thẩm mỹ, kỹ thuật cao nhất, đạt tiêu chuẩn trong và ngoài nước.\n" +
//                "\n" +
//                "Với một đội ngũ cán bộ, công nhân viên được đào tạo bài bản, nhiều kinh nghiệm cùng phong cách phục vụ chuyên nghiệp, nhiệt huyết. CÔNG TY TNHH KIẾN TRÚC VƯƠNG AN tin tưởng vào năng lực của mình có thể đáp ứng nhu cầu ngày càng cao của quý khách hàng.", "https://xaydungvuongan.com/upload/hinhthem/xaydungtruonghoc7831170x103-2603.jpg", 1, "MÔ HÌNH THIẾT KẾ TRƯỜNG HỌC","Quý khách có nhu cầu xây dựng nhà xưởng, hãy liên hệ ngay với chúng tôi: \n" +
//                "\n" +
//                "CÔNG TY TNHH KIẾN TRÚC XÂY DỰNG VƯƠNG AN\n" +
//                "\n" +
//                "Mã số thuế: 3603574909\n" +
//                "Địa chỉ: Số 170/20/102, Tổ 50A, KP 11, P.Tân Phong, Tp. Biên Hoà, Đồng Nai.\n" +
//                "Điện thoại: 0979 239 652 - 0969 728 062\n" +
//                "Email: Xaydungvuongan@gmail.com\n" +
//                "Website: Xaydungvuongan.com",String.valueOf(java.tetime.LocalDa.now()));
//        mData.child("New").push().setValue(n1);



    }

    private void addevent() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (s.equalsIgnoreCase("Công nghiệp")){
                    adapter_cn = new New_adapter(MauNhaDep.this, R.layout.item_news, ds_cn);
                    lv1.setAdapter(adapter_cn);
                    adapter_cn.notifyDataSetChanged();
//                    adapter_cn.notifyDataSetChanged();


                }else if (s.equalsIgnoreCase("Trường học")){
                    adapter_th = new New_adapter(MauNhaDep.this, R.layout.item_news, ds_th);
                    lv2.setAdapter(adapter_th);
                    adapter_th.notifyDataSetChanged();
//                    ds_truongHoc.clear();
//                    for (int i=0;i<dsnew.size();i++){
//                        if (dsnew.get(i).getLoai()==1){
//                            ds_truongHoc.add(dsnew.get(i));
//                            adapter_truongHoc= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_truongHoc);
//                            lv_truongHoc.setAdapter(adapter_truongHoc);
//                            adapter_truongHoc.notifyDataSetChanged();
//                        }
//
//                    }
                }else if (s.equalsIgnoreCase("Nội thất")){
                    adapter_nt = new New_adapter(MauNhaDep.this, R.layout.item_news, ds_nt);
                    lv3.setAdapter(adapter_nt);
                    adapter_nt.notifyDataSetChanged();
//                    ds_noiThat.clear();
//                    for (int i=0;i<dsnew.size();i++){
//                        if (dsnew.get(i).getLoai()==2){
//                            ds_noiThat.add(dsnew.get(i));
//                 adapter_noiThat= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_noiThat);
//                lv_noiThat.setAdapter(adapter_nhapho);
//                adapter_noiThat.notifyDataSetChanged();
//                        }
//                    }
                }else if (s.equalsIgnoreCase("Biệt thự")){
                    adapter_bt = new New_adapter(MauNhaDep.this, R.layout.item_news, ds_Bt);
                    lv4.setAdapter(adapter_bt);
                    adapter_bt.notifyDataSetChanged();
//                    ds_BietThu.clear();
//                    for (int i=0;i<dsnew.size();i++){
//                        if (dsnew.get(i).getLoai()==3){
//                            ds_BietThu.add(dsnew.get(i));
//                 adapter_bietthu= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_BietThu);
//                lv_bietthu.setAdapter(adapter_bietthu);
//                adapter_bietthu.notifyDataSetChanged();
//                        }
                    }

//                }
                else if(s.equalsIgnoreCase("Nhà phố")) {
                    adapter_np= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_np);
                    lv5.setAdapter(adapter_np);
                    adapter_np.notifyDataSetChanged();
                }
//                    ds_pho.clear();
//                    for (int i=0;i<dsnew.size();i++){
//                        if (dsnew.get(i).getLoai()==4){
//                            ds_pho.add(dsnew.get(i));
//                            adapter_nhapho= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_pho);
//                            lv_nhapho.setAdapter(adapter_nhapho);
//                            adapter_nhapho.notifyDataSetChanged();
//                        }
//                    }
//
//                }
            }
        });
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MainNews.class);
                Bundle bundle = new Bundle();
                bundle.putString("img", img = ds_cn.get(i).getImage().toString());
                bundle.putString("titile", titile = ds_cn.get(i).getTitle().toString());
                bundle.putString("body", boddy = ds_cn.get(i).getBody().toString());
                bundle.putString("lh", lh=ds_cn.get(i).getLh());
                startActivity(intent.putExtras(bundle));
//                img = ds_cn.get(i).getImage().toString();
//                titile = ds_cn.get(i).getTitle().toString();
//                boddy = ds_cn.get(i).getBody().toString();
            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MainNews.class);
                Bundle bundle = new Bundle();
                bundle.putString("img", img = ds_th.get(i).getImage().toString());
                bundle.putString("titile", titile = ds_th.get(i).getTitle().toString());
                bundle.putString("body", boddy = ds_th.get(i).getBody().toString());
                bundle.putString("lh", lh=ds_th.get(i).getLh());
                startActivity(intent.putExtras(bundle));
//                img = ds_cn.get(i).getImage().toString();
//                titile = ds_cn.get(i).getTitle().toString();
//                boddy = ds_cn.get(i).getBody().toString();
            }
        });
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MainNews.class);
                Bundle bundle = new Bundle();
                bundle.putString("img", img = ds_nt.get(i).getImage().toString());
                bundle.putString("titile", titile = ds_nt.get(i).getTitle().toString());
                bundle.putString("body", boddy = ds_nt.get(i).getBody().toString());
                bundle.putString("lh", lh=ds_nt.get(i).getLh());
                startActivity(intent.putExtras(bundle));
//                img = ds_cn.get(i).getImage().toString();
//                titile = ds_cn.get(i).getTitle().toString();
//                boddy = ds_cn.get(i).getBody().toString();
            }
        });
        lv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MainNews.class);
                Bundle bundle = new Bundle();
                bundle.putString("img", img = ds_Bt.get(i).getImage().toString());
                bundle.putString("titile", titile = ds_Bt.get(i).getTitle().toString());
                bundle.putString("body", boddy = ds_Bt.get(i).getBody().toString());
                bundle.putString("lh", lh=ds_Bt.get(i).getLh());
                startActivity(intent.putExtras(bundle));
//                img = ds_cn.get(i).getImage().toString();
//                titile = ds_cn.get(i).getTitle().toString();
//                boddy = ds_cn.get(i).getBody().toString();
            }
        });
        lv5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MainNews.class);
                Bundle bundle = new Bundle();
                bundle.putString("img", img = ds_np.get(i).getImage().toString());
                bundle.putString("titile", titile = ds_np.get(i).getTitle().toString());
                bundle.putString("body", boddy = ds_np.get(i).getBody().toString());
                bundle.putString("lh", lh=ds_np.get(i).getLh());
                startActivity(intent.putExtras(bundle));

//                img = ds_cn.get(i).getImage().toString();
//                titile = ds_cn.get(i).getTitle().toString();
//                boddy = ds_cn.get(i).getBody().toString();
            }
        });

    }
    private void getdata(){
       mData.child("New").addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
             News  news = snapshot.getValue(News.class);
             if (news.getLoai()==1){
                 ds_cn.add(news);
                 adapter_cn = new New_adapter(MauNhaDep.this, R.layout.item_news, ds_cn);
                lv1.setAdapter(adapter_cn);
               adapter_cn.notifyDataSetChanged();
             } else if (news.getLoai()==2){
                 ds_th.add(news);
                 adapter_th = new New_adapter(MauNhaDep.this, R.layout.item_news, ds_th);
                 lv2.setAdapter(adapter_th);
                 adapter_th.notifyDataSetChanged();
             }else if (news.getLoai()==3){
                 ds_nt.add(news);
                 adapter_nt = new New_adapter(MauNhaDep.this, R.layout.item_news, ds_nt);
                 lv3.setAdapter(adapter_nt);
                 adapter_nt.notifyDataSetChanged();
             }else if (news.getLoai()==4){
                 ds_Bt.add(news);
                 adapter_bt = new New_adapter(MauNhaDep.this, R.layout.item_news, ds_Bt);
                 lv4.setAdapter(adapter_bt);
                 adapter_bt.notifyDataSetChanged();
             }else if (news.getLoai()==5){
                 ds_np.add(news);
                 adapter_np= new New_adapter(MauNhaDep.this, R.layout.item_news, ds_np);
                 lv5.setAdapter(adapter_np);
                 adapter_np.notifyDataSetChanged();
             }
//               dsnew.add(news);
//               System.out.println("-----------------------"+dsnew.toString());
//
//
//               adapter = new New_adapter(MauNhaDep.this, R.layout.item_news, dsnew);
//               lv_all.setAdapter(adapter);
//               adapter.notifyDataSetChanged();

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
        lv1 = findViewById(R.id.lv_cn);
        lv2 = findViewById(R.id.lv_truongHoc);
        lv3 = findViewById(R.id.lv_cap4);
        lv4 = findViewById(R.id.lv_2);
        lv5 = findViewById(R.id.lv_pho);
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
    }


}