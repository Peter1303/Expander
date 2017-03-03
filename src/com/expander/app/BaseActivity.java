package com.expander.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
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
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
	
	public static void StartActivity(Context c,String packageName,String className){
		try{
			Intent intent = new Intent();
			ComponentName cn = new ComponentName(packageName,className);
			intent.setComponent(cn);
			intent.setAction("android.intent.action.MAIN");
			c.startActivity(intent);
			//overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		} catch(Exception e){
			showErroDialog(c,e.toString());
		}
	}
	
	public static void StartActivity(Context c,String p){
		try{
			Intent intent = new Intent(); 
			PackageManager packageManager = c.getPackageManager(); 
			intent = packageManager.getLaunchIntentForPackage(p); 
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ; 
			c.startActivity(intent);
		} catch(Exception e){
			showErroDialog(c,e.toString());
		}
	}
	
	//出现错误的dialog
	public static void showErroDialog(Context c,String s){
		AlertDialog.Builder alert=new AlertDialog.Builder(c);
		alert.setMessage("哎呀，居然发生错误了 :(\n"+s);
		alert.setPositiveButton("确定",null);
		alert.setCancelable(false);
		alert.create();
		alert.show();
	}
	
}
