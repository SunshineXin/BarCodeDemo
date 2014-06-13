package com.luckysun.barcode.activity;

import com.luckysun.barcode.R;
import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BarCodeAictivity extends Activity implements OnClickListener{
	private TextView mResultTextView;
	private Button mZxingBtn;
	private Button mJBarCodeBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mResultTextView = (TextView) this.findViewById(R.id.tv_scan_result);
		mZxingBtn = (Button) findViewById(R.id.btn_zxing);
		mZxingBtn.setOnClickListener(this);
		mJBarCodeBtn = (Button) findViewById(R.id.btn_jbarcode);
		mJBarCodeBtn.setOnClickListener(this);
		findViewById(R.id.btn_scan_barcode).setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.btn_zxing:
			intent.setClass(BarCodeAictivity.this, ZxingBarCodeActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_jbarcode:
			intent.setClass(BarCodeAictivity.this, JBarCodeActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_scan_barcode:
			//打开扫描界面扫描条形码或二维码
			Intent openCameraIntent = new Intent(BarCodeAictivity.this, CaptureActivity.class);
			startActivityForResult(openCameraIntent, 0);
			break;
		case R.id.btn_qrcode:
			
			
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//处理扫描结果（在界面上显示）
		if (resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			mResultTextView.setText(scanResult);
		}
	}
	
}
