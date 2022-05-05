package housebuilding.example.housebuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.NumberFormat;
import java.util.Locale;

public class Caculation extends AppCompatActivity {

    String[] items ={"Nhà phố","Nhà cấp bốn","Biệt  thự"};
    String[] itemStyle ={"Xây nhà phần thô","Xây nhà trọn gói"};
    String[] itemFloor ={"2","3","4","5","6"};
    String[] itemMong ={"Móng đài cọc","Móng bằng","Móng đơn"};
    String[] itemMai ={"Mái bằng đúc BTCT","Mái lợp tôn lạnh","Mái xà gồ thép lợp ngôi","Mái đúc bằng BTCT lợp ngói"};

    ArrayAdapter<String> adapter,adapterStyle,adpterFloor,adapterMong,adapterCoc;

    AutoCompleteTextView autoCompleteHouse, autoCompleteStyle, autoCompleteFloor,autoCompleteMong, autoCompleteMai;
    TextInputEditText edtWidth, edtHeight;
    TextInputLayout layout_edt6;
    Button cal, reset;

    int tong=0;
    TextView tongtien;
    private double   hinhthicxaynha=0, sotiendutinh=0;
    private int s_TangTret = 0, s_Lau=0,tong_s_XayDung=0;
    private int  loaimai=0,loaimong=0;
    private String tenmong="", tenloaimai="",tol, tenhinhthucxaynha="", tennha="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculation);
        cal = findViewById(R.id.btn_cal);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Caculation.this,HienThiKQ.class);
                startActivity(intent);


            }
        });

        autoCompleteHouse = findViewById(R.id.auto_complete_text);
        autoCompleteStyle = findViewById(R.id.auto_complete_style);
        autoCompleteFloor = findViewById(R.id.auto_complete_floor);
        autoCompleteMong = findViewById(R.id.auto_complete_mong);
        autoCompleteMai = findViewById(R.id.auto_complete_coc);

        layout_edt6 = findViewById(R.id.layout_edt6);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        tongtien = findViewById(R.id.texttong);

        adapter = new ArrayAdapter<>(this,R.layout.menu_dropdown,items);
        autoCompleteHouse.setAdapter(adapter);
        autoCompleteHouse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                tennha = item;
                if(item.equals("Nhà cấp bốn")){
                    layout_edt6.setEnabled(false);
                }else{
                    layout_edt6.setEnabled(true);
                }
            }
        });

        adapterStyle = new ArrayAdapter<>(this,R.layout.menu_dropdown,itemStyle);
        autoCompleteStyle.setAdapter(adapterStyle);
        autoCompleteStyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                if(item == parent.getItemAtPosition(0)){
                    hinhthicxaynha = 3300000;
                    tenhinhthucxaynha="Phan tho";
                } else {
                    hinhthicxaynha = 5200000;
                    tenhinhthucxaynha="Phan khong tho";
                }
                //double

            }
        });

        adpterFloor = new ArrayAdapter<>(this,R.layout.menu_dropdown,itemFloor);
        autoCompleteFloor.setAdapter(adpterFloor);
        autoCompleteFloor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                s_Lau = Integer.parseInt(item);
                //int
            }
        });

        adapterMong = new ArrayAdapter<>(this,R.layout.menu_dropdown,itemMong);
        autoCompleteMong.setAdapter(adapterMong);
        autoCompleteMong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                if(item == parent.getItemAtPosition(0)){
                    tenmong ="mong 1";
                    loaimong = (int) (0.5*(Integer.parseInt(edtHeight.getText().toString())*
                                                Integer.parseInt(edtWidth.getText().toString())));
                } else if (item == parent.getItemAtPosition(1)){
                    loaimong = (int) (0.55*(Integer.parseInt(edtHeight.getText().toString())*
                                                Integer.parseInt(edtWidth.getText().toString())));
                    tenmong = "mong2";
                } else {
                    loaimong = (int) (0.3*(Integer.parseInt(edtHeight.getText().toString())*
                                                Integer.parseInt(edtWidth.getText().toString())));
                    tenmong = "mong3";
                }
                //m2
            }
        });

        adapterCoc = new ArrayAdapter<>(this,R.layout.menu_dropdown,itemMai);
        autoCompleteMai.setAdapter(adapterCoc);
        autoCompleteMai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                if(item == parent.getItemAtPosition(0)){
                    loaimai = (int) (0.4*(Integer.parseInt(edtHeight.getText().toString())*
                                                Integer.parseInt(edtWidth.getText().toString())));
                    tenloaimai="Loai mai 1";
                } else if (item == parent.getItemAtPosition(1)){
                    loaimai = (int) (0.25*(Integer.parseInt(edtHeight.getText().toString())*
                                                Integer.parseInt(edtWidth.getText().toString())));
                    tenloaimai="Loai mai 2";
                } else if (item == parent.getItemAtPosition(2)){
                    loaimai = (int) (0.7*(Integer.parseInt(edtHeight.getText().toString())*
                                                Integer.parseInt(edtWidth.getText().toString())));
                    tenloaimai="Loai mai 3";
                }else if (item == parent.getItemAtPosition(3)){
                    loaimai = (int) (1*(Integer.parseInt(edtHeight.getText().toString())*
                                                Integer.parseInt(edtWidth.getText().toString())));
                    tenloaimai="Loai mai 4";
                }


            }
        });

        reset = findViewById(R.id.btn_Reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtWidth.setText("");
                edtHeight.setText("");
                tongtien.setText("");
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtHeight.getText().toString().equals("")||(edtWidth.getText().toString().equals(""))){
                    Toast.makeText(getApplicationContext(), "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    int dai=Integer.parseInt(edtHeight.getText().toString());
                    int rong=Integer.parseInt(edtWidth.getText().toString());
                    s_TangTret = dai*rong;
                    double s_so_Lau = s_Lau * dai*rong;
                    tong_s_XayDung = s_TangTret+s_TangTret*s_Lau+loaimong+loaimai;
                    sotiendutinh = hinhthicxaynha*tong_s_XayDung;
                    Locale localeVN = new Locale("vi", "VN");
                    NumberFormat vn = NumberFormat.getInstance(localeVN);

                    Intent intent = new Intent(getApplicationContext(),HienThiKQ.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("1",String.valueOf(s_TangTret)+"m2");
                    bundle.putString("2",String.valueOf(s_so_Lau));
                    bundle.putString("12",String.valueOf(s_Lau));
                    bundle.putString("3",String.valueOf(tenmong));
                    bundle.putString("4",String.valueOf(loaimong)+"m2");
                    bundle.putString("5",String.valueOf(tenloaimai));
                    bundle.putString("6",String.valueOf(loaimai)+"m2");
                    bundle.putString("7",""+tong_s_XayDung+"m2");
                    bundle.putString("8","Don gia xay nha phan "+tenhinhthucxaynha+" :");
                    bundle.putString("9",String.valueOf(hinhthicxaynha)+"vnd");
                    bundle.putString("10","Chi phi xay nha "+tennha+" xaay nha "+tenhinhthucxaynha+" :");
                    bundle.putString("11",vn.format(sotiendutinh)+"vnd");
                    bundle.putString("12",tennha);
                    startActivity(intent.putExtras(bundle));
                }


            }
        });
    }



}
