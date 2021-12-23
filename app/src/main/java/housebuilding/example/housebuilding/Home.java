package housebuilding.example.housebuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button mauNhaDep = findViewById(R.id.btnMauNhaDep);
        mauNhaDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MauNhaDep.class));
            }
        });


        Button duToan = findViewById(R.id.btnDuToan);
        duToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Caculation.class));

            }
        });

        Button timKiemNhaThau = findViewById(R.id.btnTimKiemNhaThau);
        timKiemNhaThau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
    }
}