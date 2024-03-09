package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		// 객체 생성
		Vector v1 = new Vector();
		
		System.out.println("처음크기 : " + v1.size());
		
		// 데이터 추가하기1 : add(추가할 데이터)
		// 반환값 : 추가성공(true), 추가실패(false)
		v1.add("aaaa");
		v1.add(new Integer(1111));
		v1.add(123); //Auto Boxing/Unboxing 지원
		v1.add('a');
		v1.add(true);
		
		
		boolean r = v1.add(3.14);
		
		
		System.out.println("현재크기 : " + v1.size());
		System.out.println("반환값 : " + r);
		System.out.println("v1 =>" + v1);// toString() 삭제 가능
		System.out.println();
		
		// 데이터 추가하기2 : addElement(추가할 데이터)
		// ==> 이전버전의 프로그램과의 호환성을 위해서 남아있는 메소드
		v1.addElement("cccc");
		System.out.println("v1 => "+v1);
		System.out.println();
		
		//데이터 추가하기 3 :  add(index,  데이터)
		// ==> 'index' 번쟤에 데이터를 끼워넣음
		// ==> 'index' 는 0부터 시작한다,반홤값 없음
		v1.add(1,"KKKK");
		System.out.println("v1 =>" + v1);
		
		//데이터 꺼내오기 : get(index)
		// ==> 'index' 번쟤의 데이터를 거내서 반환한다
		System.out.println("0번째 데이터 : "+v1.get(0));
		System.out.println();
		
		
		// 변수 저장
		// int iTemp = v1.get(2); 오류 //부모객체는 Object로 저장
		int iTemp =(int) v1.get(2); //꺼내올때 Object를 형변환 해줘야댐
		System.out.println("꺼내온 2번째 데이터 : "+iTemp);
		System.out.println();
		// 오류
//		String sTemp =(String) v1.get(2); //꺼내올때 Object를 형변환 해줘야댐
//		System.out.println("꺼내온 2번째 데이터 : "+sTemp);
		
		
		// 데이터 수정하기 : set(index, 새로운 데이터)
		// ==> 'index'번째의 데이터를 '새로운 데이터'로 변경한다
		// ==> 반환값 : 변경되기전의 원래의 데이터
		String sTemp = (String)v1.set(0, "zzzz");
		System.out.println("v1 ==>"+v1);
		System.out.println("원래의 데이터 : "+sTemp);
		System.out.println();
		
		
		// 데이터 삭제하기1 : remove(index)
		// ==> 'index'번째의 데이터를 삭제한다
		// ==> 반환값 : 삭제한 데이터
		v1.remove(0);
		System.out.println("삭제 후 v1 =>"+ v1);
		System.out.println();
		
		sTemp = (String)v1.remove(0);
		System.out.println("삭제 후 v1 =>"+ v1);
		System.out.println("삭제된 데이터 :  "+sTemp);
		System.out.println();
		
		// 데이터 삭제하기 2 : remove(삭제할 데이터)
		// ==> '삭제할 데이터'를 찾아서 삭제한다
		// ==> '삭제할 데이터'가 여러개이면 이들 중에서 첫번째로 찾아진 자료를 삭제한다
		// ==> 반환값 : 삭제성공(true), 삭제실패(false)
		// ==> '삭제할 데이터'가 정수형이거나 char형일 경우에는 반드시 객체로 변환해서 사용
		v1.remove("cccc");
		System.out.println("cccc 삭제후 v1 => "+v1);
		System.out.println();
		
		
		// 객체화 ㅅ시켜서 저장
		//v1.remove(123);// 오류남(인덱스로 인식)
		//v1.remove(new Integer(123)); 1번 (자바 1.9이상에서는 사용불가)
		v1.remove(Integer.valueOf(123));//2번
		System.out.println("123 삭제후 v1 => "+v1);
		System.out.println();
		
		// 오류
		//v1.remove('a');
		v1.remove(Character.valueOf('a'));
		System.out.println("'a' 삭제 후  v1 =>"+v1);
		System.out.println();
		
		
		v1.remove(true);
		v1.remove(3.14);
		System.out.println("삭제 후 v1 =>"+v1);
		System.out.println();
		
		// 전체 데이터 삭제 : clear();
		v1.clear();
		System.out.println("clear 후 v1"+ v1);
		System.out.println("-----------------------------------------------");
		
		
		
		
		
		/*
		 * 제네릭 타입(generic Type) ==> 클래스 내부에서 사용할 데이터의 타입을 객체로 생성할때
		 * 외부에서 지정해주는 기법으로 객체를 선언할때 <>안에 그 ㅐㄱ체의 내부에서
		 * 사용할 데이터의 타입을 정해주는 것
		 * 
		 * 이런식으로 선언하게 되면 그 데이터 타입 이외의 다른 종류의 데이터들으 저장할 수 없다
		 * 이 때 제네릭으로 선언 될 수 있는 데이터 타입은 '클래스형'이엉 한다
		 * 그래서 int는 Integer, boolean은 Boolean, char는 Charactor 등으로 사용
		 * 제네릭 타입으로 선언하게 되면 데이터를 꺼내올때 별도의 형변환이 필요없음 
		 * 
		 */
		Vector<Integer> v2 = new Vector<Integer>();// int형 자료만 가능
		Vector<String> v3 = new Vector<String>();// String형 자료만 가능
		Vector<String> v4 = new Vector<String>();
		
		v3.add("안녕하세요");
//		v3.add(100); 오류 : 지정한 제네릭 타입과 다른타입의 데이터 저장 안됨
		
		String sTemp2 = v3.get(0);//형변환 필요 없음
		Vector<Vector> vv = new Vector<Vector>();//2차원 배열의 느낌
		
		
		v3.clear();
		System.out.println("v3의 사이즈 : "+v3.size());
		System.out.println();
		
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v3 => "+v3);
		System.out.println("v4 => "+v4);
		System.out.println();
		
		
		// 데이터 삭제하기3 : removeALL(Collection 객체)
		// ==> 벡터의 데이터중에서 '컬렉션 객체'가 가지고 있는 모든 데이터들을 삭제한다
		// ==> 반환값 : 성공(true), 실패(false)
		
		v3.removeAll(v4);//v3의 데이터들 중에서 v4가 가지고있는 데이터들을 모두 삭제한다
		System.out.println("삭제 후 v3 =>"+v3);
		System.out.println();
		
		v3.clear();
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		v3.add("FFF");
		
		for (int i = 0; i < v3.size(); i++) {
			System.out.println((i+1)+ "번째 데이터 : "+  v3.get(i));
		}
		System.out.println("--------------------------------------------");
		
		//향상된 for문
		for(String str : v3) {
			System.out.println(str);
		}
		System.out.println("--------------------------------------------");
		
		
		
	
	}
}
