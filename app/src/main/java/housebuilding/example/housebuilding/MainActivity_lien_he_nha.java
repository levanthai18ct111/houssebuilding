package housebuilding.example.housebuilding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import housebuilding.example.housebuilding.adapter.Ad_new_adapter;
import housebuilding.example.housebuilding.adapter.LienHe_adapter;
import housebuilding.example.housebuilding.model.LienHe;

public class MainActivity_lien_he_nha extends Activity {
    ListView lv_linehe;
    ArrayList<LienHe> list = new ArrayList();
    LienHe_adapter lienHe_adapter;
    DatabaseReference mData ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lien_he_nha);
        mData = FirebaseDatabase.getInstance().getReference();
        addcontroll();
        addevent();
        getdata();
    }

    private void addevent() {
        lv_linehe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MainActivity_chitiet.class);
                Bundle bundle = new Bundle();
                String id = list.get(i).getId();

                bundle.putString("id", id);

                startActivity(intent.putExtras(bundle));
            }
        });
        ImageButton back= findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void addcontroll() {
        lv_linehe = findViewById(R.id.lv_linehe);
    }
    private void getdata() {
        mData.child("Lienhe").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                LienHe lienHe = snapshot.getValue(LienHe.class);
                list.add(lienHe);
                lienHe_adapter = new LienHe_adapter(MainActivity_lien_he_nha.this, R.layout.item_lienhe, list);
                lv_linehe.setAdapter(lienHe_adapter);
                lienHe_adapter.notifyDataSetChanged();
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

}