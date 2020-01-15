package com.agus.nyinyirtextgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private ClipboardManager myClipboard;
	private ClipData myClip;
	private EditText et_kalimat, et_hasil;
	private Button btn_generate, btn_copy;
	private String vokal = "[aueo]";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et_kalimat = findViewById(R.id.et_kalimat);
		et_hasil = findViewById(R.id.et_hasil);
		btn_generate = findViewById(R.id.btn_generate);
		btn_copy = findViewById(R.id.btn_copy);
		
		et_kalimat.requestFocus();
		
		btn_generate.setOnClickListener(this);
		btn_copy.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btn_generate :
				if (et_kalimat.getText().toString().isEmpty()) {
					Toast.makeText(MainActivity.this, "Anda belum mengisi kalimat", Toast.LENGTH_SHORT).show();
					et_kalimat.requestFocus();
				} else {
					String filter = et_kalimat.getText().toString().trim();
					filter = filter.replaceAll(vokal, "i");
					Toast.makeText(MainActivity.this, "Generate Sukses", Toast.LENGTH_SHORT).show();
					et_hasil.setText(filter);
				}
				break;
				
			case R.id.btn_copy :
				if (et_hasil.getText().toString().isEmpty()) {
					Toast.makeText(MainActivity.this, "Anda belum mengisi kalimat", Toast.LENGTH_SHORT).show();
					et_kalimat.requestFocus();
				} else {
					myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
					String text;
					text = et_hasil.getText().toString();
					
					myClip = ClipData.newPlainText("text", text);
					myClipboard.setPrimaryClip(myClip);
					
					Toast.makeText(getApplicationContext(), "Text berhasil di copy.", Toast.LENGTH_SHORT).show();
					
					et_kalimat.setText("");
					et_hasil.setText("");
				}
				break;
		}
	
	}
}
