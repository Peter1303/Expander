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
	
	public static class ExpanderFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
		
		@Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            super.onPreferenceTreeClick(preferenceScreen, preference);
            if(preference==findPreference("xposed")) {
				startActivity(new Intent(getActivity(),XposedModActivity.class));
            } else if(preference==findPreference("viperfx")){
				StartActivity(getActivity(),AppUtils.VIPERFX,AppUtils.VIPERFX_CLASS);
			} else if(preference==findPreference("edge")){
				StartActivity(getActivity(),AppUtils.EDGE,AppUtils.EDGE_CLASS);
			} else if(preference==findPreference("applock")){
				StartActivity(getActivity(),AppUtils.APPLOCK,AppUtils.APPLOCK_CLASS);
			} else if(preference==findPreference("adaway")){
				StartActivity(getActivity(),AppUtils.ADAWAY,AppUtils.ADAWAY_CLASS);
			} else if(preference==findPreference("supersu")){
				StartActivity(getActivity(),AppUtils.SUPERSU,AppUtils.SUPERSU_CLASS);
			} else if(preference==findPreference("nowakelock")){
				StartActivity(getActivity(),AppUtils.NOWAKELOCK,AppUtils.NOWAKELOCK_CLASS);
			} else if(preference==findPreference("screen_recorder")){
				StartActivity(getActivity(),AppUtils.SCREEN_RECORDER);
			}
            return false;
        }
		/*
		public DetailsFragment newInstance(int index) {
			DetailsFragment f = new DetailsFragment();

			// Supply index input as an argument.
			Bundle args = new Bundle();
			args.putInt("index", index);
			f.setArguments(args);
			return f;
		}
		*/
		
		
    }
	
	
	
	/*
	public void webIntent(String url){
		Uri uri = Uri.parse(url);
		Intent intent=new Intent(Intent.ACTION_VIEW,uri);
		startActivity(intent);
	}
	*/
	
	
}
