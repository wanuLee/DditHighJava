package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {
	public static void main(String[] args) {
		// ArrayList의 기본 사용법은Vector와 같음
		ArrayList<Comparable> list1 = new ArrayList<Comparable>();
		
		// add()메서드를 이용해서 데이터를 추가한다
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);
		
		System.out.println("list1 => " +list1);
		System.out.println("size => " +list1.size());
		System.out.println();
		
		
		// get() 메소드를 이용해서 데이터를 꺼내온다
		System.out.println("1번째 자료 : "+ list1.get(1));
		System.out.println();
		
		// 데이터 끼워넣기
		list1.add(3,"zzzz");
		System.out.println("list1 =>"+list1);
		System.out.println();
		
		//데이터 변경하기
		String sTemp = (String)list1.set(3, "YYY");
		System.out.println("list1 =>"+list1);
		System.out.println("sTemp =>"+sTemp);
		System.out.println();
		
		// 삭제
		list1.remove(3);
		System.out.println("3번째 자료 삭제 후 list1 =>"+list1);
		System.out.println();
		
		list1.remove("bbb");
		System.out.println("bbb 자료 삭제 후 list1 =>"+list1);
		System.out.println();
		
		
		// 제네릭 사용
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("aaaaa");
		list2.add("bbbbb");
		list2.add("ccccc");
		list2.add("ddddd");
		list2.add("eeeee");
		list2.add("fffff");
		list2.add("eeeee");
		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i+"번째 데이터 : "+list2.get(i));
			
		}
		System.out.println("--------------------------------------");
		System.out.println();
		
		for(String str2 : list2) {
			System.out.println(str2);
		}
		System.out.println("--------------------------------------");
		
		// contains(비교데이터) ==> List에 저장된 데이터 중에서 '비교데이터'가 있으면 true
		//						  없으면 false를 반환						 	
		
		System.out.println("ddddd값의 존재 여부"+list2.contains("ddddd"));
		System.out.println("ZZZZZ값의 존재 여부"+list2.contains("ZZZZZ"));
		System.out.println();
		
		// indexOf(비교데이터)
		// lastIndexO(비교데이터)
		// ==> List 안에 '비교데이터'가 잇으면 '비교데이터'가 지정된 index값을 반환하고
		// 							없으면 -1 반환
		// ==> indexOf()메서드는 앞에서부터뒤족으로 검색
		//     lastIndexOf()메서드는 뒤쪽부터 앞족으로 검색
		// ==> List 안에 검색된 '비교데이터'가 여러개있으면 첫번째로 검샏된 데이터의 위치값을 반혼
		
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		list2.add("FFFF");
		System.out.println("list2 => "+list2);
		
		System.out.println("DDDD의 위치값"+list2.indexOf("DDDD"));
		System.out.println("ZZZZ의 위치값"+list2.indexOf("ZZZZ"));
		System.out.println("DDDD의 위치값"+list2.lastIndexOf("DDDD"));
		System.out.println("-------------------------------------------");
		
		// toArray() ==> List안의 데이터를 배열로 변환해서 반환
		//           ==> 기본적으로 Object형 배열로 변환
		Object[] strArr = list2.toArray();
		
		System.out.println("list2의 개수 : "+ list2.size());
		System.out.println("배열의 개수 : "+strArr.length);
		
		for (int i = 0; i < strArr.length; i++) {
			
			System.out.println(i+ "번째 자료 : "+strArr[i]);
		}
		System.out.println("-------------------------------------------");
		
		
		//제네릭타입의 배열로 변환해서 가져오기
		String[] strArr2 = list2.toArray(new String[0]);
		for(String s : strArr2) {
			System.out.println(s);
		}
		
		
		
		
		
	}
}
