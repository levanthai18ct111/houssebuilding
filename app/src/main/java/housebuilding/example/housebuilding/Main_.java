package housebuilding.example.housebuilding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;


public class Main_ extends Activity {

    TextInputEditText edtName, edtADD, edtMobile, edtTopic, edtContext, edtEmail;
    TextInputLayout layout_Name, layout_Add, layout_Mobile, layout_Topic, layout_Context, layout_Email;
    Button btnSend , btnDel ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tesswed);
        addcontroll();


         btnSend.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (edtName.getText().toString().equals("")||(edtName.getText().toString().equals(""))){
                     Toast.makeText(getApplicationContext(), "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();}

             }
         });





    }



    private void addcontroll() {
        edtName = findViewById(R.id.edt_width);
        edtName = findViewById(R.id.edtADD);
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
