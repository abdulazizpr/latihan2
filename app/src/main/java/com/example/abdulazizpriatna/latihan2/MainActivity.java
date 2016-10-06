package com.example.abdulazizpriatna.latihan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_NAMA = "com.example.abdulazizpriatna.app1.NAMA";
    public final static String EXTRA_ALAMAT = "com.example.abdulazizpriatna.app1.ALAMAT";
    public final static String EXTRA_TELP = "com.example.abdulazizpriatna.app1.TELP";
    static final int ACT2_REQUEST = 99;  // request code

    String nama;
    String alamat;
    String telepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tNama = (TextView) findViewById(R.id.tvNama);
        TextView tAlamat = (TextView) findViewById(R.id.tvAlamat);
        TextView tTelp = (TextView) findViewById(R.id.tvTelp);

        nama = tNama.getText().toString();
        alamat = tAlamat.getText().toString();
        telepon = tTelp.getText().toString();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // cek request code
        if (requestCode == ACT2_REQUEST) {

            nama = data.getStringExtra(EXTRA_NAMA);
            alamat = data.getStringExtra(EXTRA_ALAMAT);
            telepon = data.getStringExtra(EXTRA_TELP);

            TextView tNama = (TextView) findViewById(R.id.tvNama);
            TextView tAlamat = (TextView) findViewById(R.id.tvAlamat);
            TextView tTelp = (TextView) findViewById(R.id.tvTelp);

            tNama.setText(nama);
            tAlamat.setText(alamat);
            tTelp.setText(telepon);

            Toast toast = Toast.makeText(getApplicationContext(), "Data telah diubah", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //simpan variabel
        //method ini dipanggil sebelum onStop

        savedInstanceState.putString("state_nama", nama);
        savedInstanceState.putString("state_alamat", alamat);
        savedInstanceState.putString("state_telepon", telepon);

        //jangan lupa panggil parent
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore nilai
        nama = savedInstanceState.getString("state_nama");
        alamat = savedInstanceState.getString("state_alamat");
        telepon = savedInstanceState.getString("state_telepon");
    }



    public void klikEdit(View v){
        Intent intent2 = new Intent(this, Main2Activity.class);
        intent2.putExtra(EXTRA_NAMA,nama);
        intent2.putExtra(EXTRA_ALAMAT,alamat);
        intent2.putExtra(EXTRA_TELP,telepon);
        startActivityForResult(intent2,ACT2_REQUEST);
    }
}
