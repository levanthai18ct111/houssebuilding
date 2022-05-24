package housebuilding.example.housebuilding;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

import housebuilding.example.housebuilding.model.LienHe;


public class Main_lienhe extends Activity {

    TextInputEditText edtName, edtADD, edtMobile, edtTopic, edtContext, edtEmail;
    TextInputLayout layout_Name, layout_Add, layout_Mobile, layout_Topic, layout_Context, layout_Email;
    Button btnSend,btnDel ;
    DatabaseReference mData ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_main_lienhe);
        addcontroll();


         btnSend.setOnClickListener(new View.OnClickListener() {
             @RequiresApi(api = Build.VERSION_CODES.O)
             @Override
             public void onClick(View view) {
                 if (edtName.getText().toString().equals("")||(edtName.getText().toString().equals(""))){
                     Toast.makeText(getApplicationContext(), "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();}
                 else {
                     Random id = new Random(19900828);
                     String name = edtName.getText().toString();
                     String dc =edtADD.getText().toString();
                     String email = edtEmail.getText().toString();
                     String phone = edtMobile.getText().toString();
                     String tp = edtTopic.getText().toString();
                     String nd = edtContext.getText().toString();
                     LienHe lienHe = new LienHe(String.valueOf(id),name,dc,email
                             ,phone,tp,nd,String.valueOf(java.time.LocalDate.now()),0);
                     mData.child("Lienhe").push().setValue(lienHe);
                     Toast.makeText(Main_lienhe.this, "Gửi thành công", Toast.LENGTH_SHORT).show();
                 }

             }
         });
         btnDel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 edtADD.setText("");
                 edtContext.setText("");
                 edtEmail.setText("");
                 edtMobile.setText("");
                 edtName.setText("");
                 edtTopic.setText("");
             }
         });





    }



    private void addcontroll() {
        edtName = findViewById(R.id.edtName);
        edtADD = findViewById(R.id.edtADD);
        edtMobile = findViewById(R.id.edtMobile);
        edtTopic = findViewById(R.id.edtTopic);
        edtContext = findViewById(R.id.edtContext);
        edtEmail = findViewById(R.id.edtEail);

        layout_Name = findViewById(R.id.layout_edt4);
        layout_Add = findViewById(R.id.layout_ADD);
        layout_Mobile = findViewById(R.id.layout_Mobile);
        layout_Topic = findViewById(R.id.layout_Topic);
        layout_Context = findViewById(R.id.layout_Context);
        layout_Email = findViewById(R.id.layout_Email);

        btnSend = findViewById(R.id.btn_Send);
        btnDel = findViewById(R.id.btn_Delete);

    }
}
