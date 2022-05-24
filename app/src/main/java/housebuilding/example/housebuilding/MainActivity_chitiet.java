package housebuilding.example.housebuilding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import housebuilding.example.housebuilding.model.LienHe;

public class MainActivity_chitiet extends Activity {
    DatabaseReference mData ;
    ArrayList<LienHe> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chitiet);
        mData = FirebaseDatabase.getInstance().getReference();
        TextView txt_lh_noidung = findViewById(R.id.txt_lh_noidung);
        TextView txt_lh_chude = findViewById(R.id.txt_lh_chude);
        TextView txt_lien_sdt = findViewById(R.id.txt_lien_sdt);
        TextView txt_lh_email = findViewById(R.id.txt_lh_email);
        TextView txt_lh_Diachi =findViewById(R.id.txt_lh_Diachi);
        TextView lh_hoten = findViewById(R.id.lh_hoten);
        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Bundle bundle = getIntent().getExtras();
        String id =bundle.getString("id");

        mData.child("Lienhe").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                LienHe lienHe = snapshot.getValue(LienHe.class);
                if (lienHe.getId().equalsIgnoreCase(id)){
                    txt_lh_chude.setText(lienHe.getChude());
                    txt_lh_Diachi.setText(lienHe.getAddress());
                    txt_lh_email.setText(lienHe.getEmail());
                    txt_lien_sdt.setText(lienHe.getPhone());
                    txt_lh_noidung.setText(lienHe.getNoidung());
                    lh_hoten.setText(lienHe.getName());
                }

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