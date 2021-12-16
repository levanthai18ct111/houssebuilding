
package housebuilding.example.housebuilding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView reWeb;
    WebAdapter webAdapter;
    List<WebModel> webModelList = new ArrayList<WebModel>(3);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reWeb = findViewById(R.id.listItem);
        getData();

        buildReWeb();



    }
    private void getData() {
        webAdapter = new WebAdapter();
        List<WebModel> data = getFakeData();
        webAdapter.setDate(data);
    }

    private void buildReWeb() {


        webAdapter.setOnWebListener((webModel, i) -> {
            webAdapter.setSelect(i);
            Log.d("link2",webModel.toString());
            openWeb();
        });


        reWeb.setHasFixedSize(true);
        reWeb.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        reWeb.setAdapter(webAdapter);

    }
    private List<WebModel> getFakeData() {

       webModelList.add(new WebModel("google","kientrucmoi.vn/", R.drawable.lg1));

        webModelList.add(new WebModel("youtube","youtube.com",R.drawable.lg2));

        webModelList.add(new WebModel("faceboook","facebook.com",R.drawable.lg3));

        Log.d("listModleWeb",webModelList.toString());

        return webModelList;
    }

    private void openWeb() {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("link", webModelList.get(0).getUrl());
        intent.putExtra("link2",webModelList.get(1).getUrl().toString().trim());
        intent.putExtra("link3",webModelList.get(2).getUrl().toString().trim());
        startActivity(intent);

    }

}