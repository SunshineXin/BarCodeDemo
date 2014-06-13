package com.luckysun.barcode.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.luckysun.barcode.R;
import com.zxing.activity.CaptureActivity;
import com.zxing.encoding.EncodingHandler;

/**
 * 
 */
public class ZxingBarCodeActivity extends Activity 
{
	
	private EditText qrStrEditText;
	private ImageView qrImgImageView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_zxing);
        
        qrStrEditText = (EditText) this.findViewById(R.id.et_qr_string);
        qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);
        
        Button generateQRCodeButton = (Button) this.findViewById(R.id.btn_add_qrcode);
        generateQRCodeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					String contentString = qrStrEditText.getText().toString();
					if (contentString != null && contentString.trim().length() > 0) {
						//根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
						Bitmap qrCodeBitmap =EncodingHandler.createBarcode128(contentString, 800,200);
						qrImgImageView.setImageBitmap(qrCodeBitmap);
					}else {
						Toast.makeText(ZxingBarCodeActivity.this, "Text can not be empty", Toast.LENGTH_SHORT).show();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

}