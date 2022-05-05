package housebuilding.example.housebuilding;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HienThiKQ extends AppCompatActivity {

    private TextView txt_s_tangtret,txt_solau, txt_s_lau,txt_mong, txt_s_mong, txt_mai, txt_s_mai, txt_tong_xaydung, txt_s_tong
            , txt_loai_xaydung, txt_gia_loai_xaydung, txt_chi_phi, txt_gia_cuoicung;
    ImageView img_minhhoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_showkq);
        addcontrol();
        Bundle bundle = getIntent().getExtras();
        String _txt_s_tangtret =  bundle.getString("1");;
        String _txt_solau =  bundle.getString("12");
        String _txt_s_lau =  bundle.getString("2");
        String _txt_mong =  bundle.getString("3");
        String _txt_s_mong = bundle.getString("4");
        String _txt_mai = bundle.getString("5");
        String _txt_s_mai = bundle.getString("6");
        String _txt_s_tong =  bundle.getString("7");
        String _txt_loai_xaydung =  bundle.getString("8");
        String _txt_gia_loai_xaydung =  bundle.getString("9");
        String _txt_chi_phi = bundle.getString("10");
        String _txt_gia_cuoicung =  bundle.getString("11");
        String _tennha = bundle.getString("12");
        System.out.println("--------------------"+_tennha);
        // gán giá trị
        txt_s_tangtret.setText(_txt_s_tangtret);
//        txt_solau.setText(_txt_solau);
        txt_s_lau.setText(_txt_s_lau);
//        txt_mong.setText(_txt_mong);
        txt_s_mong.setText(_txt_s_mong);
//        txt_mai.setText(_txt_mai);
        txt_gia_loai_xaydung.setText(_txt_gia_loai_xaydung);
        txt_gia_cuoicung.setText(_txt_gia_cuoicung);
        txt_s_tong.setText(_txt_s_tong);
        txt_s_mai.setText(_txt_s_mai);

        img_minhhoa.setImageResource(R.drawable.hinhnhabietthu);
        if( _tennha.equalsIgnoreCase("Nhà phố")){
            img_minhhoa.setImageResource(R.drawable.hinhnhapho);
        }else if ( _tennha.equalsIgnoreCase("Nhà cấp bốn")){
            img_minhhoa.setImageResource(R.drawable.hinhnhacapbon);
        }else if( _tennha.equalsIgnoreCase("Biệt  thự")){
            img_minhhoa.setImageResource(R.drawable.hinhnhabietthu);
        }


        txt_s_mai = findViewById(R.id.txt_s_mai);
        txt_tong_xaydung = findViewById(R.id.txt_tong_xaydung);
        txt_s_tong = findViewById(R.id.txt_s_tong);
        txt_loai_xaydung = findViewById(R.id.txt_loai_xaydung);
        txt_gia_loai_xaydung = findViewById(R.id.txt_gia_loai_xaydung);
        txt_chi_phi = findViewById(R.id.txt_chi_phi);
//        txt_gia_cuoicung = findViewById(R.id.txt_gia_cuoi_cung);

    }



    private void addcontrol() {
        txt_s_tangtret = findViewById(R.id.txt_s_tangtret);
//        txt_solau = findViewById(R.id.txt_solau);
        txt_s_lau = findViewById(R.id.txt_s_lau);
        txt_mong = findViewById(R.id.txt_mong);
        txt_s_mong = findViewById(R.id.txt_s_mong);
        txt_mai = findViewById(R.id.txt_mai);
        txt_s_mai = findViewById(R.id.txt_s_mai);
        txt_tong_xaydung = findViewById(R.id.txt_tong_xaydung);
        txt_s_tong = findViewById(R.id.txt_s_tong);
        txt_loai_xaydung = findViewById(R.id.txt_loai_xaydung);
        txt_gia_loai_xaydung = findViewById(R.id.txt_gia_loai_xaydung);
        txt_chi_phi = findViewById(R.id.txt_chi_phi);
        txt_gia_cuoicung = findViewById(R.id.st_dutoan);
        img_minhhoa = findViewById(R.id.img_minhhoa);
    }
}