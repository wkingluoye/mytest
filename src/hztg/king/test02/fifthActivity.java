package hztg.king.test02;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class fifthActivity extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifth);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 =new HashMap<String, String>();
		HashMap<String, String> map3 =new HashMap<String, String>();
		
		map1.put("user_name", "King1");
		map1.put("user_ip", "192.168.0.1");
		map2.put("user_name", "King2");
		map2.put("user_ip", "192.168.0.2");
		map3.put("user_name", "King3");
		map3.put("user_ip", "192.168.0.3");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		SimpleAdapter listAdapter = new SimpleAdapter(this, list, 
				R.layout.fifth_listview, 
				new String[]{"user_name","user_ip"}, 
				new int[]{R.id.user_name,R.id.user_ip});
		setListAdapter(listAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		System.out.println(position+"|"+ l.getItemAtPosition(position).toString() );
		
		
		
	}

}
