package housebuilding.example.housebuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
public class Home extends AppCompatActivity {

    TextView fb ;

    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


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
                startActivity(new Intent(getApplicationContext(),Main_.class));

            }
        });

        fb  = findViewById(R.id.fb);

        callbackManager = CallbackManager.Factory.create();

    }
}