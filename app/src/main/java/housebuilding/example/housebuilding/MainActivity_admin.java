package housebuilding.example.housebuilding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import housebuilding.example.housebuilding.adapter.Ad_new_adapter;
import housebuilding.example.housebuilding.adapter.New_adapter;
import housebuilding.example.housebuilding.model.News;

public class MainActivity_admin extends Activity {
    TabHost tabHost;
    DatabaseReference mData ;
    Ad_new_adapter adapter_cn,adapter_th,adapter_nt,adapter_bt, adapter_np;
    ListView lv1,lv2,lv3,lv4,lv5;
    ArrayList<News> ds_cn , ds_th ,  ds_nt, ds_Bt, ds_np ;
    ImageButton imbtn_back,ibtn_poster,ibnt_thongtinlienhe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mData = FirebaseDatabase.getInstance().getReference();
        ds_th = new ArrayList<>();
        ds_cn = new ArrayList<>();
        ds_np = new ArrayList<>();
        ds_nt = new ArrayList<>();
        ds_Bt = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        addcontroll();
        addevent();
        getdata();



    }

    private void addevent() {
        imbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_admin.this, Home.class);
                startActivity(intent);
                finishAffinity();

            }
        });
        ibtn_poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity_poster.class));
            }
        });
        ibnt_thongtinlienhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity_lien_he_nha.class));
            }
        });
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (s.equalsIgnoreCase("Công nghiệp")){
                    adapter_cn = new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_cn);
                    lv1.setAdapter(adapter_cn);
                    adapter_cn.notifyDataSetChanged();
//                    adapter_cn.notifyDataSetChanged();


                }else if (s.equalsIgnoreCase("Trường học")){
                    adapter_th = new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_th);
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
                    adapter_nt = new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_nt);
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
                    adapter_bt = new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_Bt);
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
                    adapter_np= new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_np);
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
              String nd = ds_cn.get(i).getTitle();
              String id = ds_cn.get(i).getId();
                opendialog_thongbao(Gravity.CENTER,nd,id);
            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nd = ds_th.get(i).getTitle();
                String id = ds_th.get(i).getId();
                opendialog_thongbao(Gravity.CENTER,nd,id);
            }
        });
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nd = ds_nt.get(i).getTitle();
                String id = ds_nt.get(i).getId();
                opendialog_thongbao(Gravity.CENTER,nd,id);
            }
        });
        lv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nd = ds_Bt.get(i).getTitle();
                String id = ds_Bt.get(i).getId();
                opendialog_thongbao(Gravity.CENTER,nd,id);
            }
        });
        lv5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nd = ds_np.get(i).getTitle();
                String id = ds_np.get(i).getId();
                opendialog_thongbao(Gravity.CENTER,nd,id);
            }
        });
    }

    private void addcontroll() {
        tabHost =findViewById(R.id.tab_ad);
        tabHost.setup();
        creatTabHost();
        lv1 = findViewById(R.id.lv_ad_tab_congnghiep);
        lv2 = findViewById(R.id.lv_ad_tab_truonghoc);
        lv3 = findViewById(R.id.lv_ad_tab_noithat);
        lv4 = findViewById(R.id.lv_ad_tab_bietthu);
        lv5 = findViewById(R.id.lv_ad_tab_nhapho);
        imbtn_back = findViewById(R.id.imbtn_back);
        ibtn_poster = findViewById(R.id.ibtn_poster);
        ibnt_thongtinlienhe = findViewById(R.id.ibnt_thongtinlienhe_);
    }

    private void creatTabHost() {
        TabHost.TabSpec tab_cn;
        tab_cn = tabHost.newTabSpec("Công Nghiệp");
        tab_cn.setContent(R.id.tab_congnghiep);
        tab_cn.setIndicator("Công Nghiệp");
        tabHost.addTab(tab_cn);

        TabHost.TabSpec tab_th;
        tab_th = tabHost.newTabSpec("Trường Học");
        tab_th.setContent(R.id.tab_truonghoc);
        tab_th.setIndicator("Trường Học");
        tabHost.addTab(tab_th);

        TabHost.TabSpec tab_nt;
        tab_nt = tabHost.newTabSpec("Nội thất");
        tab_nt.setContent(R.id.tab_noithat);
        tab_nt.setIndicator("Nội thất");
        tabHost.addTab(tab_nt);

        TabHost.TabSpec tab_bt;
        tab_bt = tabHost.newTabSpec("Biệt thự");
        tab_bt.setContent(R.id.tab_bietthu);
        tab_bt.setIndicator("Biệt thự");
        tabHost.addTab(tab_bt);

        TabHost.TabSpec tabNhaPho;
        tabNhaPho = tabHost.newTabSpec("Nhà Phố");
        tabNhaPho.setContent(R.id.tab_nhapho);
        tabNhaPho.setIndicator("Nhà Phố");
        tabHost.addTab(tabNhaPho);
    }
    private void getdata(){
        mData.child("New").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                News  news = snapshot.getValue(News.class);
                if (news.getLoai()==1){
                    ds_cn.add(news);
                    adapter_cn = new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_cn);
                    lv1.setAdapter(adapter_cn);
                    adapter_cn.notifyDataSetChanged();
                } else if (news.getLoai()==2){
                    ds_th.add(news);
                    adapter_th = new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_th);
                    lv2.setAdapter(adapter_th);
                    adapter_th.notifyDataSetChanged();
                }else if (news.getLoai()==3){
                    ds_nt.add(news);
                    adapter_nt = new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_nt);
                    lv3.setAdapter(adapter_nt);
                    adapter_nt.notifyDataSetChanged();
                }else if (news.getLoai()==4){
                    ds_Bt.add(news);
                    adapter_bt = new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_Bt);
                    lv4.setAdapter(adapter_bt);
                    adapter_bt.notifyDataSetChanged();
                }else if (news.getLoai()==5){
                    ds_np.add(news);
                    adapter_np= new Ad_new_adapter(MainActivity_admin.this, R.layout.it_ad_tabhost, ds_np);
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
    private void opendialog_thongbao(int gravity , String nd, String id) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_thongbao);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);

        if (Gravity.CENTER == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);

        }
        Button btn_yes = dialog.findViewById(R.id.btn_yes);
       Button btn_no = dialog.findViewById(R.id.btn_no);
        TextView txt_thongbao = dialog .findViewById(R.id.txt_thongbao);
        txt_thongbao.setText("Bạn muốn xóa "+nd);
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }

        });
        btn_yes.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
      del(id);
       dialog.dismiss();
   }
}
        );
        dialog.show();
    }
    public void del(String id_del){
        mData.child("New").orderByChild("id").equalTo(id_del)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        for (DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            ds.getRef().removeValue();

                            Toast.makeText(MainActivity_admin.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(getIntent());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError)
                    {
                        Toast.makeText(MainActivity_admin.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}