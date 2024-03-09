package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

/*
처리속도 제일 빠른 것 CPU / 제일 느린 것
속도가 느린 장치와 속도 빠른 장치 있다 그러면 중간에 빠르고 느린속도 사이의 중간속도 내는 기억장치를 만든다.
중간에 있는 것을 거쳐서 작업
예) 입력 
버퍼 임시 기억장소 속도가 CPU보다 느리지만 입력장치보다 빠름
버퍼한테 입력해라 입력값 있으면 나한테 줘 그럼 버퍼가 자기가 가지고 있는 데이터 중 한개를 CPU 줌
만약 CPU가 달라했는데 버퍼에 데이터 없어 그러면 입력장치에서 데이터 가져와야함
입력장치에서 데이터 가져오는 역할 버퍼가 함 CPU는 명령 내리기만 하면됨 그 시간만 걸림 이후 자기 할일함
이렇게하면서 속도차이 보완해줌
(버퍼, 캐쉬, .. 중간 속도 빠르게 하기 위한 임시 기억 장치이다.)
입출력 관련된 임시기억장치를 버퍼라고 함
입력과 관련된 것 -> 입력버퍼, 출력 관련된 것 -> 출력 버퍼

키보드

입력 버퍼

CPU
(next 뒤에 타입 )
- scan.next()/nextint()nextfloat() ...  | (결다른 것) nextLine()
  -> 이것들은 입력버퍼에 명령 데이터 가져오라고
  그러고 입력버퍼에 없으면 키보드에 명령?
  
  키보드에서 입력한 것이 버퍼에 저장되는데 
 1 2 3 enter 했다. 그러면 버퍼에 저장 -> cpu 주는데 cpu는 그 값들을 구별한다.
 뭘로? 사이띄기(공백), tab키, enter키로 구분해서 구분된 데이터를 보낸다.(버퍼가 cpu에 보낼때)
 
버퍼에 데이터 이미 있으면 빠르게 cpu에 갈 수 있지.

예)
키보드: 대전시 중구 입력

입력버퍼: 
이름, 전화번호 데이터넘어갔는데
주소 '대전시 중구' 저장 왜 오류 났을까?
next(string타입) 은 데이터 '대전시'만 보내졌음 (중구 버퍼에 남아있음)
insert 메서드 끝나면 호출했던 곳으로 돌아가겠지 더이상 처리할것없으니 break만나지
그러면 switch문 나가겠지. 이후 반복문 만나니 true 또 실행해
displayMenu()
retrun scan.nextint() -> 이거 받는데 '중구' 데이터 받는다. 
숫자로 바꿀 수 없으니까.. 그래서 에러가 났음

그럴때는 ? scan.nextLine();
-> 한줄 전체를 모두 가져간다. (엔터키도 포함)
  (반환할때는 엔터키를 제외하고 반환)

전화번호 입력하고 next 엔터키 남아있지 그런데 nextLine
엔터키 남아있어 -> 반환은 엔터키 빼고하니 반환할거 없어 ㅇ.ㅇ? 
(등록할때 주소는 nextLine enter 가져와서-> 공백반환됨 -> 주소 못적음..)

이거 해결하려면? 엔터 없애야지
실제 주소 받기 전에 nextLine 한번 더 실행하면된다. enter 가져간건 쓸모없음 그거안쓰면 돼

전화번호 >> scan.next();찌꺼기를 nextLine 사용 전에 없애주기
scan.nextLine(); 입력 버퍼 지우기

*/

/*
 문제) 이름, 전화번호, 주소르 멤버로 갖는 Phone클래스르 작성한다
 Map을 이용하여 전화번호 장부를 관리하는 프로그램을 작성하시오
 
 (Map의 구조는 key값으로 '사람의 이름을 사용하고 value값으로는 'Phone클래스의 인스턴스'로 한다)
 HashMap<String, Phone>변수명;
 
 아래 메뉴의 기능을 구현하시오(삭제, 검색 기능 에서는 '이름'을 입력받아 처리한다.)
 
 실행예시)
 
 	1. 전화번호 등록
 	2. 전화번호 수정
 	3. 전화번호 삭제
 	4. 전화번호 검색
 	5. 전화번호 전체 출력
 	0. 프로그램 종료
 	----------------------
 	번호 입력 >>1
 	
 	새롭게 등록할 전화번호 정보를 입력하세요
 	이름 >> 홍길동
 	전화전호 >>010-1234-5678
 	주  소>> 대전시 중구 오류동
 	
 	'홍길동'씨의 전화번호 등록이 완료되었습니다.
 	
 	1. 전화번호 등록
 	2. 전화번호 수정
 	3. 전화번호 삭제
 	4. 전화번호 검색
 	5. 전화번호 전체 출력
 	0. 프로그램 종료
 	----------------------
 	번호 입력 >>1
 	
 	새롭게 등록할 전화번호 정보를 입력하세요
 	이름 >> 홍길동
 	'홍길동'씨는 이미 등록된 사람입니다.
 	
 	1. 전화번호 등록
 	2. 전화번호 수정
 	3. 전화번호 삭제
 	4. 전화번호 검색
 	5. 전화번호 전체 출력
 	0. 프로그램 종료
 	----------------------
 	번호 입력 >>5
 	
 	---------------------------------------
 	번호		이름		전화번호			주소
 	---------------------------------------
 	1		홍길동	010-1234-5678 대전시 중구 오류동
	---------------------------------------
	
	
	
	
 */


public class PhoneBookTest {

	public static void main(String[] args) {
		PhoneBookTest pbt = new PhoneBookTest();
		HashMap<String,Object> map = new HashMap<String, Object>() ;
		pbt.menu(map);

	}
	
	public void menu(HashMap<String,Object> map) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("-----------------------");
		System.out.println("번호 입력 >> ");
		int sel = sc.nextInt();
		
		switch (sel) {
		case 1:
			Input(map);
		case 2:
			Update(map);
		case 3:
			Delete(map);
		case 4:
			Search(map);
		case 5:
			List(map);
		case 0:
			break;
		default:
			menu(map);
		}
		
	}
	private void List(HashMap<String, Object> map) {
		System.out.println("=====================================");
		System.out.println("이름\t번호\t\t주소");
		System.out.println("=====================================");
		for(String key : map.keySet()) {
		System.out.println(map.get(key));
	}	
		System.out.println("=====================================");
		menu(map);
		
		
	}

	private void Search(HashMap<String, Object> map) {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요.");
		String name = sc.next();
		if(map.containsKey(name)) {
			System.out.println(" 검색 결과");
			System.out.println("=====================================");
			System.out.println("이름\t번호\t\t주소");
			System.out.println("=====================================");
			System.out.println(map.get(name));
			System.out.println("=====================================");
		}else if(!map.containsKey(name)) {
			System.out.println("그런 사람 없습니다.");
		}
		
		menu(map);
		
		
	}

	private void Delete(HashMap<String, Object> map) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================");
		System.out.println("이름\t\t번호\t\t주소");
		System.out.println("=====================================");
		for(String key : map.keySet()) {
		System.out.println(map.get(key));
	}	
		System.out.println("삭제할 이름을 입력하세요");
		System.out.println("이름 >>");
		String name = sc.next();
		map.remove(name);
		System.out.println("삭제가 완료되었습니다.");
		
		menu(map);
		
	}

	public void Input(HashMap<String,Object> map) {
		/*  번호 입력 >> 1
		 *  
		 *  새롭게 등록할 전화번호 정보를 입력하세요.
		 *  이 름 >> 홍길동
		 *  전화번호>> 010-1234-5678
		 *  주 소>> 대전시 중구 오류동
		 *  '홍길동'씨의 전화번호 등록이 완료되었습니다...
		 */  	
		Scanner sc = new Scanner(System.in);

		
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >>");
		String name = sc.next();
			if(map.containsKey(name)) {
				System.out.println("중복입니다. 다시시도하세요.");
				Input(map);
			}
		System.out.println("전화번호 >>");
		String tel = sc.next();
		System.out.println("주소 >>");
		String add = sc.next();
		
		Phone phone = new Phone(name, tel, add);
		map.put(name, phone);
		
		System.out.println(name+"님의 등록이 완료되었습니다.");
		menu(map);
		
		
//		for(String key : map.keySet()) {
//			System.out.println(map.get(key));
//		}
	}
	
	public void Update(HashMap<String,Object> map) {
		Scanner sc = new Scanner(System.in);
		System.out.println("======================================");
		System.out.println("이름\t번호\t\t주소");
		System.out.println("======================================");
		for(String key : map.keySet()) {
		System.out.println(map.get(key));
	}	
		System.out.println("업데이트 할 이름을 입력하세요");
		System.out.println("이름 >>");
		String name = sc.next();
			if(!map.containsKey(name)) {
				System.out.println("그런 사람 없습니다.");
				Update(map);
			}
		System.out.println("수정할 전화번호 >>");
		String tel = sc.next();
		System.out.println("수정할 주소 >>");
		String add = sc.next();
		
		Phone phone = new Phone(name, tel, add);
		map.put(name, phone);
		
		System.out.println(name+"님의 수정이 완료되었습니다.");
		
		
		menu(map);
	}

}

/* 문제) 이름, 전화번호, 주소를 멤버로 갖는 Phone클래스를 작성한다.
* Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
* 
* (Map의 구조는 key값으로 '사람의 이름'을 사용하고 value값으로는 'Phone클래스의 인스턴스'로 한다.)
* 
* 			아래의 메뉴의 기능을 구현하시오. (삭제, 검색 기능에서는 '이름'을 입력 받아 처리한다.)*/
class Phone{
	private String name;
	private String tel;
	private String add;
	public Phone(String name, String tel, String add) {
		super();
		this.name = name;
		this.tel = tel;
		this.add = add;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	@Override
	public String toString() {
		return name+"\t\t"+tel+"\t\t"+add;
	}
	
	
}

