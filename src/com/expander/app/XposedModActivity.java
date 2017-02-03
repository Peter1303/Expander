package com.expander.app;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.expander.app.utils.AppUtils;

public class XposedModActivity extends BaseActivity
{
	private FrameLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout=(FrameLayout)findViewById(R.id.main_FrameLayout);
		getFragmentManager().beginTransaction().replace(R.id.main_FrameLayout, new XposedFragment()).commit();
		
		ImageView back=(ImageView)findViewById(R.id.ic_back);
		back.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					finish();
				}
			});
		
		setAppTitle("Xposed与模块");
	}
	
	public static class XposedFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.xposed_preferences);
        }

		@Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            super.onPreferenceTreeClick(preferenceScreen, preference);
            if(preference==findPreference("xposed")) {
				StartActivity(getActivity(),AppUtils.XPOSED);
            } else if(preference==findPreference("fsbi")){
				StartActivity(getActivity(),AppUtils.FSBI);
			} else if(preference==findPreference("tsb")){
				StartActivity(getActivity(),AppUtils.XPOSEDSTORE);
			} else if(preference==findPreference("greenify")){
				StartActivity(getActivity(),AppUtils.GREENIFY);
			} else if(preference==findPreference("gravitybox")){
				StartActivity(getActivity(),AppUtils.GRAVITYBOX);
			} else if(preference==findPreference("xposedstore")){
				StartActivity(getActivity(),AppUtils.XPOSEDSTORE);
			}
            return false;
        }
    }
	
}
