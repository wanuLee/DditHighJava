package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Maptest {

	public static void main(String[] args) {
		/*
		 Map ==> key값과 value값을 한 쌍으로 관리하난 개체
		 1) key 값은 중복을 허용하지 않고 순서가 없다. (Set의 특징을 갖는다)
		 2) value 값은 중복을 허용한다
		 */
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		//자료 추가하기 ==> put(key 값, value값)
		map.put("name", "홍길동");
		map.put("add", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map ==> "+map);
		System.out.println("map size ==> "+map.size());
		System.out.println();
		
		// 자료 수정하기 ==> 데이터를 추가할때 key 값이 같으면 나중에 추가한 값이 저장된다
		map.put("add", "서울");
		System.out.println("map ==> "+map);
		System.out.println();
		
		// 자료 삭제하기 ==> remove(key 값)
		// 				- key값이 같은 차료를 찾아서 삭제한다
		//				- 반환값 : 삭제된 자료의  value값이 반환
		
//		String removeTel = map.remove("tel");
//		System.out.println(" 삭제후 map ==> "+map);
//		System.out.println("삭제된 value값==> "+removeTel);
		
		// 자료 읽어오기 ==>get(key값)
		//				- key값과 짝이 되는 value값을 반환한다
		System.out.println("이름 : "+ map.get("name"));
		System.out.println();
		
		
		//key값이 존재하는지 여부를 나타내는 메서드 : containsKey(검색할key값)
		// 			=> 해당 key값이 있으면 true, 없으면 false
		System.out.println("tel 키값의 존재 여부 : "+ map.containsKey("tel"));
		System.out.println("age 키값의 존재 여부 : "+ map.containsKey("age"));
		System.out.println();
		
		//------------------------------------------------------------------
		
		//Map에 저장된 전체 데이터들을 차례로 가져와 처리하기
		//1. key값들을 이용하여 처리하기 ==>keySet()메서드 이용
		//	  keySet()메서드 ==> Map의 모든  key값들을 읽어와 Set형으로 반환한다
		
		//1-1) 방법1 => Iterator이용하기
		Set<String>keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key+" : "+value);
		}
		System.out.println("---------------------------------------");
		
		//1-2 방법 2 => keyset데이터를 향상된 for문으로터리하기
		for(String key : keySet) {
			String value = map.get(key);
			System.out.println(key+"==>"+value);
		}
		System.out.println("-------------------------------");

		
		// 2. value값들만 익어와 처리하기 ==> values()메서드
		for(String value : map.values()) {
			System.out.println(value);
		}
		
		System.out.println("-------------------------------");
		
		
		
		
		
		
		
		
		
		
	
	
	
	}

}
