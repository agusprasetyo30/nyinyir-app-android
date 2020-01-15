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
				String filter = et_kalimat.getText().toString().trim();
				Toast.makeText(MainActivity.this, "Generate Sukses", Toast.LENGTH_SHORT).show();
				et_hasil.setText(filter);
				
				break;
				
			case R.id.btn_copy :
				myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
				String text;
				text = et_hasil.getText().toString();
				
				myClip = ClipData.newPlainText("text", text);
				myClipboard.setPrimaryClip(myClip);
				
				Toast.makeText(getApplicationContext(), "Text Copied",Toast.LENGTH_SHORT).show();
				break;
		}
	
	}
}
