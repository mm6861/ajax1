package ajax1.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam01 {
	public static void main(String[] args) {
		List<Map<String,String>> mapList = new ArrayList<>();
		Map<String,String> m = new HashMap<>();
		for(int i=0;i<=2;i++) {
			m.put("key", i+"");
			mapList.add(m);
		}
		System.out.println(mapList);
	}
}
