package com.expander.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.expander.app.R;
import com.expander.app.manager.SystemBarTintManager;

public class BaseActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			//透明状态栏
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			SystemBarTintManager tintManager = new SystemBarTintManager(this);  
			tintManager.setStatusBarTintEnabled(true);  
			tintManager.setNavigationBarTintEnabled(true);  
			tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
		}
	}
	
	public void setAppTitle(String Title){
		TextView title=(TextView)findViewById(R.id.app_title);
		title.setText(Title);
	}
	
	public void StartActivity(String packageName){
		try{
			Intent intent = new Intent(); 
			PackageManager packageManager = getPackageManager(); 
			intent = packageManager.getLaunchIntentForPackage(packageName); 
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED | Intent.FLAG_ACTIVITY_CLEAR_TOP) ; 
			startActivity(intent);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		} catch(Exception e){
			showErroDialog();
		}
	}
	//出现错误的dialog
	public void showErroDialog(){
		AlertDialog.Builder alert=new AlertDialog.Builder(this);
		alert.setMessage("哎呀，居然发生错误了，是不是没有安装这个程序呢 :(");
		alert.setPositiveButton("确定",null);
		alert.setCancelable(false);
		alert.create();
		alert.show();
	}
	
}
