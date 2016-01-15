package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SevenTeenDataModel {
	public SevenTeenDataModel() {
		
	}
	
	public ArrayList<Map<String, Object>> loadData(){
		ArrayList<Map<String, Object>> coll = new ArrayList<Map<String,Object>>();
		Map<String, Object> item ;
		item = new HashMap<String, Object>();
		item.put("na","LINUX");
		item.put("type","ST");
		coll.add(item);
		item = new HashMap<String, Object>();
		item.put("na","WINDOWS");
		item.put("type","MOBILE");
		coll.add(item);
		return coll;
	}
	
}
