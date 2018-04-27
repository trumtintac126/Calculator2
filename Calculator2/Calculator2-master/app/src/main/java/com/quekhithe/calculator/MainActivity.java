package com.quekhithe.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Float soThuNhat;
    Float soThuHai;
    double ketqua, soCan;
    String toanTu, sXuatManHinh="";
    int i;

    TextView txtPhepToan, txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPhepToan= findViewById(R.id.txtPhepToan);
        txtKetQua = findViewById(R.id.txtKetQua);

        int idButton[] = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8,
                R.id.btn9, R.id.btnCong, R.id.btnTru, R.id.btnNhan, R.id.btnChia, R.id.btnAc, R.id.btnCham, R.id.btnMu,
                R.id.btnMotChiaX, R.id.btnBang, R.id.btnXoa};

        for (int id: idButton) {
            View view = findViewById(id);
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCong:
                if (toanTu == "+" || toanTu == "-" || toanTu == "x" || toanTu== "/" || toanTu == "^" || toanTu == "1/x" ) break;
                toanTu = "+";
                i = txtPhepToan.getText().toString().length();
                soThuNhat= Float.parseFloat(txtPhepToan.getText().toString());
                sXuatManHinh = sXuatManHinh + "+";
                txtPhepToan.setText(sXuatManHinh);
                Log.d("i", String.valueOf(i));
                break;
            case R.id.btnTru:
                if (toanTu == "+" || toanTu == "-" || toanTu == "x" || toanTu== "/" || toanTu == "^" || toanTu == "1/x" ) break;
                toanTu = "-";
                i = txtPhepToan.getText().toString().length();
                soThuNhat= Float.parseFloat(txtPhepToan.getText().toString());
                sXuatManHinh = sXuatManHinh + "-";
                txtPhepToan.setText(sXuatManHinh);
                break;
            case R.id.btnNhan:
                if (toanTu == "+" || toanTu == "-" || toanTu == "x" || toanTu== "/" || toanTu == "^" || toanTu == "1/x" ) break;
                toanTu = "x";
                i = txtPhepToan.getText().toString().length();
                soThuNhat= Float.parseFloat(txtPhepToan.getText().toString());
                sXuatManHinh = sXuatManHinh + "x";
                txtPhepToan.setText(sXuatManHinh);
                break;
            case R.id.btnChia:
                if (toanTu == "+" || toanTu == "-" || toanTu == "x" || toanTu== "/" || toanTu == "^" || toanTu == "1/x" ) break;
                toanTu = "/";
                i = txtPhepToan.getText().toString().length();
                soThuNhat= Float.parseFloat(txtPhepToan.getText().toString());
                sXuatManHinh = sXuatManHinh + "/";
                txtPhepToan.setText(sXuatManHinh);
                break;
            case R.id.btnMu:
                if (toanTu == "+" || toanTu == "-" || toanTu == "x" || toanTu== "/" || toanTu == "^" || toanTu == "1/x" ) break;
                toanTu = "^";
                i = txtPhepToan.getText().toString().length();
                soThuNhat= Float.parseFloat(txtPhepToan.getText().toString());
                sXuatManHinh = sXuatManHinh + "^";
                txtPhepToan.setText(sXuatManHinh);
                break;
            case R.id.btnMotChiaX:
                if (toanTu == "+" || toanTu == "-" || toanTu == "x" || toanTu== "/" || toanTu == "^" || toanTu == "1/x" ) break;
                toanTu = "1/x";
                soThuNhat= Float.parseFloat(txtPhepToan.getText().toString());
                ketqua = 1/soThuNhat;
                txtKetQua.setText(String.valueOf(ketqua));
                break;
            case R.id.btnXoa:
                sXuatManHinh = txtPhepToan.getText().toString().substring(0, txtPhepToan.getText().toString().length() -1);
                txtPhepToan.setText(sXuatManHinh);
                break;

            case R.id.btnBang:
                if (toanTu == "+") {
                    soThuHai = Float.parseFloat(txtPhepToan.getText().toString().substring(i+1, txtPhepToan.getText().toString().length()));
                    ketqua = soThuNhat + soThuHai;
                    txtKetQua.setText(String.valueOf(ketqua));
                    toanTu = "";
                }
                if (toanTu == "-") {
                    soThuHai = Float.parseFloat(txtPhepToan.getText().toString().substring(i+1, txtPhepToan.getText().toString().length()));
                    ketqua = soThuNhat - soThuHai;
                    txtKetQua.setText(String.valueOf(ketqua));
                    toanTu = "";
                }
                if (toanTu == "x") {
                    soThuHai = Float.parseFloat(txtPhepToan.getText().toString().substring(i+1, txtPhepToan.getText().toString().length()));
                    ketqua = soThuNhat*soThuHai;
                    txtKetQua.setText(String.valueOf(ketqua));
                    toanTu = "";
                }
                if (toanTu == "/") {
                    soThuHai = Float.parseFloat(txtPhepToan.getText().toString().substring(i+1, txtPhepToan.getText().toString().length()));
                    ketqua = soThuNhat/soThuHai;
                    txtKetQua.setText(String.valueOf(ketqua));
                    toanTu = "";
                }
                if (toanTu == "^") {
                    soThuHai = Float.parseFloat(txtPhepToan.getText().toString().substring(i+1, txtPhepToan.getText().toString().length()));
                    ketqua = Math.pow(soThuNhat, soThuHai);
                    txtKetQua.setText(String.valueOf(ketqua));
                    toanTu = "";
                }

                break;

            case R.id.btnAc:
                soThuNhat = 0f;
                soThuHai = 0f;
                sXuatManHinh = "";
                txtPhepToan.setText("0");
                txtKetQua.setText("0");
                break;


            default:
                sXuatManHinh += ((Button)view).getText().toString();
                txtPhepToan.setText(sXuatManHinh);
        }
    }
}
