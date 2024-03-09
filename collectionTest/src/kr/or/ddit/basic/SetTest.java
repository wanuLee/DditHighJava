package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	 
	public static void main(String[] args) {
		/*
		 * List와 Set의 차이점
		 * 1.List
		 * - 데이터의 순서(index)가 있다.
		 * - 중복되는 데이터를 저장할 수 있다.
		 * 
		 * 2.Set
		 * - 데이터의 순서가(index)가 없다.
		 * - 중복되는 데이터를 저장할 수 없다.
		 */
		
		HashSet hs1 = new HashSet();
		
		
		System.out.println("Set의 갯수 : "+hs1.size());
		System.out.println();
		
		//Set에 데이터를 추가할 때도 add()메서드를 사용한다.
		hs1.add("dd");
		hs1.add("aa");
		hs1.add(2);
		hs1.add("cc");
		hs1.add("bb");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set의 데이터들 >>"+hs1);
		System.out.println("Set의 갯수 : "+hs1.size());
		System.out.println();
		
		
		//Set에 중복되는 데이터를 추가하면 false를반환하고, 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을때의 반환값 >>"+isAdd);
		System.out.println("Set의 데이터들 >>"+hs1);
		System.out.println();
		
		isAdd = hs1.add("aa");
		System.out.println("중복될 때의 반환값 >>"+isAdd);
		System.out.println("Set의 데이터들 >>"+hs1);
		System.out.println();
		
		
		// Set의 데이터를 수정하는 명령(메서드)이 없기 때문에 
		// 해당 자료를 삭제한 후 새로우 데이터를 추가해주는 방법 사용
		
		// 삭제하는 메서드 : remove(삭제할 자료) ==> 반환값 : 삭제성공(true), 실패(falsse)
		// 				 clear() ==> 전체 삭제
		
		// 예) "FF"데이터를 "EE"로 변경하기
		hs1.remove("FF");
		System.out.println("삭제 후 데이터 >>"+hs1);
		System.out.println();
		
		hs1.add("EE");
		System.out.println("추가 후 데이터 >>"+hs1);
		System.out.println();
		
//		hs1.clear();
//		System.out.println("clear후 데이터 :"+hs1);
		
		/*
		 Set의 데이터들은 순서(index)가 없기 때문에 List처럼 Index로 데이터를 하나씩 꺼내올 슈 없다.
		 그래서 테이터를 하나씩 차례대로 얻기 위해서는 Iterator형 객체로 변환
		 
		 -Set형의 데이터를 Iterator형 객체로 뱐환하는 메서드 ==> Iterator()
		 
		 */
		Iterator it = hs1.iterator();// Set데이터를Iterator로 변환하기
		// Iterator의 hasNext()메서드
		// 		==> Iterator의 포인터가 가리키 곳의 다음 번째에 데이터가 있느느지 검사한다.
		//		==> 반환값 : 다음번쟤에 데이터가 있으면 true, 없으면 false
		
		while(it.hasNext()) {
			//Iterator의 next()메서드
			//==>Iterator의 포인터를 다음번쨰의 위치로 이동한 후 그 곳의 데이터를 반환한다.
			System.out.println(it.next());
		}
		System.out.println();
		
		System.out.println("향상된 for문이용");
		for(Object obj : hs1) {
			System.out.println(obj
					);
		}
		// 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해보자
		// 번호는 1번 부터 25번까지 잇고, 추첨할 인원은 3명이 있다.
		// 당첨번호를 출력하시오
		
		// 시작값부터 종료값 사이의 정수형 난수 만들기
		// (int)(Math.random() * (종료값-시작값+1) +시작값)
		
		HashSet<Integer> testSet = new HashSet<Integer>();
		
		while(testSet.size()<6) {
			int num = (int)(Math.random()*45+1);
			testSet.add(num);
		}
		System.out.println("당첨자 번호 : "+testSet);
		
		// Set유형의자료를  List형으로 변환해서 사용
		ArrayList<Integer>testList = new ArrayList<Integer>(testSet);
		System.out.println("List데이터 출력하기");
		for (int i = 0; i < testList.size(); i++) {
			System.out.print(testList.get(i)+" ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
