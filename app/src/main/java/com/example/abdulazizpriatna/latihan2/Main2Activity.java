package com.example.abdulazizpriatna.latihan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent2 = getIntent();
        EditText eNama = (EditText) findViewById(R.id.etNama);
        EditText eAlamat =(EditText) findViewById(R.id.etAlamat);
        EditText eTelp = (EditText) findViewById(R.id.etTelp);

        eNama.setText(intent2.getStringExtra(MainActivity.EXTRA_NAMA));
        eAlamat.setText(intent2.getStringExtra(MainActivity.EXTRA_ALAMAT));
        eTelp.setText(intent2.getStringExtra(MainActivity.EXTRA_TELP));
    }

    public void klikSimpan(View v) {
        Intent intent2 = getIntent();
        EditText eNama = (EditText) findViewById(R.id.etNama);
        EditText eAlamat =(EditText) findViewById(R.id.etAlamat);
        EditText eTelp = (EditText) findViewById(R.id.etTelp);

        intent2.putExtra(MainActivity.EXTRA_NAMA, eNama.getText().toString());
        intent2.putExtra(MainActivity.EXTRA_ALAMAT, eAlamat.getText().toString());
        intent2.putExtra(MainActivity.EXTRA_TELP, eTelp.getText().toString());

        setResult(RESULT_OK,intent2);
        finish();
    }
}
