package com.expander.app;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.expander.app.utils.AppUtils;

public class MainActivity extends BaseActivity
{
	//private ExpanderFragment expanderFragment;
	private FrameLayout layout;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		layout=(FrameLayout)findViewById(R.id.main_FrameLayout);
		getFragmentManager().beginTransaction().replace(R.id.main_FrameLayout, new ExpanderFragment()).commit();
		ImageView back=(ImageView)findViewById(R.id.ic_back);
		back.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					finish();
				}
			});
			
		setAppTitle("拓展功能");
		
    }
	
	public class ExpanderFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
		
		@Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            super.onPreferenceTreeClick(preferenceScreen, preference);
            if(preference==findPreference("xposed")) {
				startActivity(new Intent(MainActivity.this,XposedModActivity.class));
            } else if(preference==findPreference("viperfx")){
				StartActivity(AppUtils.VIPERFX);
			} else if(preference==findPreference("edge")){
				StartActivity(AppUtils.EDGE);
			} else if(preference==findPreference("applock")){
				StartActivity(AppUtils.APPLOCK);
			} else if(preference==findPreference("adaway")){
				StartActivity(AppUtils.ADAWAY);
			} else if(preference==findPreference("supersu")){
				StartActivity(AppUtils.SUPERSU);
			} else if(preference==findPreference("nowakelock")){
				StartActivity(AppUtils.NOWAKELOCK);
			} else if(preference==findPreference("screen_recorder")){
				StartActivity(AppUtils.SCREEN_RECORDER);
			}
            return false;
        }
    }
	
	
	
	/*
	public void webIntent(String url){
		Uri uri = Uri.parse(url);
		Intent intent=new Intent(Intent.ACTION_VIEW,uri);
		startActivity(intent);
	}
	*/
	
	
}
