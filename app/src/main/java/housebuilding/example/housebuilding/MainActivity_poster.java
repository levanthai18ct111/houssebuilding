package housebuilding.example.housebuilding;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import housebuilding.example.housebuilding.model.News;

public class MainActivity_poster extends Activity {
    ImageView image_;
    EditText edt_titile,edt_noidung,edt_lienhe;
    Uri imgUri;
    Button post;
    ImageButton back;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    DatabaseReference mData ;
    private int l=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_main_poster);
        addcontroll();
        addevent();
       Spinner spnCategory_dannhMuc = (Spinner) findViewById(R.id.spnCategory);
        List<String> list = new ArrayList<>();
        list.add("Công Nghiệp");
        list.add("Trường Học");
        list.add("Nội Thất");
        list.add("Biết Thự");
        list.add("Nhà Phố");

        ArrayAdapter<String> adapter_spiner = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter_spiner.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        spnCategory_dannhMuc.setAdapter(adapter_spiner);
        spnCategory_dannhMuc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long t) {
                if (spnCategory_dannhMuc.getSelectedItem().equals("Công Nghiệp")){
                    l=1;
                }else if (spnCategory_dannhMuc.getSelectedItem().equals("Trường Học")){
                    l=2;
                }else if (spnCategory_dannhMuc.getSelectedItem().equals("Nội Thất")){
                    l=3;
                }else if (spnCategory_dannhMuc.getSelectedItem().equals("Biết Thự")){
                    l=4;
                }else if (spnCategory_dannhMuc.getSelectedItem().equals("Nhà Phố")){
                    l=5;
                }
                }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addevent() {
        image_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage = FirebaseStorage.getInstance();
                storageReference = storage.getReference();
                cloosePicture();
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadPicture();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_poster.this, MainActivity_admin.class);
                startActivity(intent);
            }
        });
    }

    private void addcontroll() {
        image_ = findViewById(R.id.image_);
        edt_titile = findViewById(R.id.edt_titile);
        edt_noidung = findViewById(R.id.edt_noidung);
        edt_lienhe = findViewById(R.id.edt_lienhe);
        post = findViewById(R.id.post);
        back = findViewById(R.id.back);
    }
    private void cloosePicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imgUri= data.getData();
            image_.setImageURI(imgUri);

        }
    }
    private void uploadPicture() {
        Random id = new Random(19900828);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Đang Thêm ....");
        progressDialog.show();
        StorageReference mountainsRef = storageReference.child("images_/"+String.valueOf(id));
        mountainsRef.putFile(imgUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        mountainsRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onSuccess(Uri uri) {
                                String tl = edt_titile.getText().toString();
                                String nd = edt_noidung.getText().toString();
                                String lh = edt_lienhe.getText().toString();
                                Random generator = new Random(19900828);
                                News news = new News(String.valueOf(generator),nd,String.valueOf(uri),l,tl,lh,String.valueOf(java.time.LocalDate.now()));
                                mData.child("New").push().setValue(news);
                                edt_lienhe.setText("");
                                edt_noidung.setText("");
                                edt_titile.setText("");
                                image_.setBackground(getDrawable(R.drawable.ic_baseline_camera_alt_24));



                            }
                        });

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Lỗi Thêm ",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                        double progressPencent = (100.000*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount()) ;
                        progressDialog.setMessage("Percentage: "+(int)progressPencent+"%");
                        if (progressPencent == 100.000){
                            progressDialog.dismiss();

                        }

                    }
                });

    }
}