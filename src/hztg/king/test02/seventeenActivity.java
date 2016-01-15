package hztg.king.test02;

import java.util.ArrayList;
import java.util.Map;
import java.util.zip.Inflater;

import util.SevenTeenDataModel;
import view.DrawView;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class seventeenActivity extends Activity implements OnItemClickListener {
	public static final int ReLoad_ID = Menu.FIRST;
	public static final int EXIT_ID  = Menu.FIRST+1;
	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
	private DrawView dv;
	
	private RadioGroup rg;
	private int mColor=Color.YELLOW;
	private RadioGroup.LayoutParams rgParams;
	private LinearLayout.LayoutParams params;
	private LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.seventeen);
		showLayout();
	}
	public void showLayout(){
		layout =  new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		params = new LinearLayout.LayoutParams(400, 600);
		params.leftMargin =10;
		dv = new DrawView(this);
		layout.addView(dv,params);
		
		Button btn = new Button(this);
		btn.setBackgroundColor(mColor);
		btn.setText("Change Color");
		btn.setId(99);
		params = new LinearLayout.LayoutParams(WC,WC);
		params.topMargin = 50;
		btn.setOnClickListener(listener);
		layout.addView(btn,params);
		
		rg = new RadioGroup(this);
		rg.setOrientation(RadioGroup.VERTICAL);
		rgParams = new RadioGroup.LayoutParams(WC,WC);
		rg.setLayoutParams(rgParams);
		rg.setOnCheckedChangeListener(rgListener);
		
		
		RadioButton rbtn1 = new RadioButton(this);
		rbtn1.setId(101);
		rbtn1.setText("Yellow");
		rg.addView(rbtn1,rgParams);
		RadioButton rbtn2 = new RadioButton(this);
		rbtn2.setId(102);
		rbtn2.setText("Blue");
		rg.addView(rbtn2,rgParams);
		
		//layout.addView(rg,rgParams);
		
		setContentView(layout);
	}
	OnCheckedChangeListener rgListener = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			switch (arg0.getCheckedRadioButtonId()) {
			case 101:
				mColor = Color.YELLOW;
				showLayout();
				break;
			case 102:
				mColor = Color.BLUE;
				showLayout();
				break;
			default:
				break;
			}
		}
	};
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case 99:
				//dv.invalidate();
				setContentView(rg);
				break;

			default:
				break;
			}
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 super.onCreateOptionsMenu(menu);
		 menu.add(0,ReLoad_ID,0,"刷新");
		 menu.add(0,EXIT_ID,0,"退出");
		 return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ReLoad_ID:
			//adapter = new ArrayAdapter<String>(this,R.layout.seventeen_listview_item,R.id.textview_17, dm.loadData());
			//lv.setAdapter(adapter);
			break;
		case EXIT_ID:
			finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		//((TextView)arg1.findViewById(R.id.textview_17)).setTextColor(Color.BLUE);
		//Toast.makeText(this, "Choice:"+coll.get(arg2).get("type"), Toast.LENGTH_LONG).show();
		//status[arg2] = !status[arg2];
	}
	
}
