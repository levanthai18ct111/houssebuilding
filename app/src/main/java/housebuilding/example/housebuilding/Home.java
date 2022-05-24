package housebuilding.example.housebuilding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import housebuilding.example.housebuilding.model.Admin;

public class Home extends Activity {
    DatabaseReference mData ;
    ArrayList<Admin> ds_ad ;

    TextView fb ;

    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mData = FirebaseDatabase.getInstance().getReference();
//        Admin admin = new Admin("thaioc123", "123123");
//        mData.child("admin").push().setValue(admin);
        ds_ad = new ArrayList<>();

        ImageButton mauNhaDep = findViewById(R.id.btnMauNhaDep);
        mauNhaDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MauNhaDep.class));
            }
        });


        ImageButton duToan = findViewById(R.id.btnDuToan);
        duToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Caculation.class));

            }
        });

        ImageButton timKiemNhaThau = findViewById(R.id.btnTimKiemNhaThau);
        timKiemNhaThau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Main_lienhe.class));

            }
        });

        fb  = findViewById(R.id.fb);

        callbackManager = CallbackManager.Factory.create();

        ImageButton ibtn_admin = findViewById(R.id.ibtn_admin);
        ibtn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendilog(Gravity.CENTER);
                mData.child("admin").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        Admin admin = snapshot.getValue(Admin.class);
                        ds_ad.add(admin);
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
        });

    }
    private void opendilog(int gravity ){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_login);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);

        if (Gravity.CENTER == gravity){
            dialog.setCancelable(true);
        }
        else{
            dialog.setCancelable(false);
        }
        EditText edt_tk = dialog.findViewById(R.id.edt_tk);
        EditText edt_mk = dialog.findViewById(R.id.edt_mk);
        Button btn_login = dialog.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0 ; i<ds_ad.size();i++){
                    if (edt_tk.getText().toString().equalsIgnoreCase(ds_ad.get(i).getTk())&&edt_mk.getText().toString().equals(ds_ad.get(i).getMk())){
                        startActivity(new Intent(getApplicationContext(),MainActivity_admin.class));
                        dialog.dismiss();
                    } else {
                        Toast.makeText(Home.this, "Sai Tai khoan , mat khau", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });


        dialog.show();
    }
}