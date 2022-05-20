package housebuilding.example.housebuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainNews extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_news);
        TextView txtTL= findViewById(R.id.txt_titile);
        TextView txt_bd=findViewById(R.id.txt_boddy);
        ImageView img = findViewById(R.id.img_titile);
        TextView txt_lh = findViewById(R.id.txt_lh);
        Bundle bundle = getIntent().getExtras();
        String tl =bundle.getString("titile");
        String bd =bundle.getString("body");
        String img_ = bundle.getString("img");
        String lh =bundle.getString("lh");
        txtTL.setText(tl);
        txt_bd.setText(bd);
        txt_lh.setText(lh);
        Picasso.with(MainNews.this).load(img_).into(img);
    }
}