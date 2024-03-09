package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {
	
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		
		memList.add(new Member(1,"홍길동", "010-1111-1111"));
		memList.add(new Member(2,"이순신", "010-2222-2222"));
		memList.add(new Member(4,"성춘향", "010-3333-5768"));
		memList.add(new Member(9,"강감찬", "010-4144-5768"));
		memList.add(new Member(5,"일지매", "010-5555-5768"));
		memList.add(new Member(3,"엄복동", "010-7777-5768"));
		
		System.out.println("정렬 전  ");
		for(Member mem : memList) {
			System.out.println(mem);
			
		}
		System.out.println();
		System.out.println("---------------------------------------");
		
		Collections.sort(memList);
		
		System.out.println("정렬 후  ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println();
		//Member의 num값의 내림차순으로 정렬하는 외부정렬 기준 클래스를 이용하여 정렬하시오
		//(클래스명 : SortNumDesc)
		System.out.println("---------------------------------------");
		
		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("num의 내림차순 정렬 후");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		
	}
}

class SortNumDesc implements Comparator<Member>{
	@Override
	public int compare(Member mem1, Member mem2) {
//		if (mem1.getNum() > mem2.getNum()) {
//			return -1;
//		} else if (mem1.getNum() < mem2.getNum()) {
//			return 1;
//		} else {
//			return 0;
//		}
//
//	Wrapper 클래스를 이용한 방법
//	return new Integer(mem1.getNum()).compareTo(mem2.getNum()) *-1;
		
		return Integer.compare(mem1.getNum(),mem2.getNum())*-1;
	}
}



// Member클래스의 회원 이름을 기준으로 오름차순이 되도록 내부 정렬 기준을 추가하기
// 			==> Comparable 인터페이스르 구현한다
class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	@Override
	public String toString() {
		return "회원 정보   [회원번호 = " + num + ", 이름 = " + name + ", 전화번호 = " + tel + "]";
	}
	
	
	// 회원 이름에 대한 오름차순 정렬 기준
	@Override
	public int compareTo(Member mem) {
//		리턴 식  풀이
//		if(this.getName().compareTo(mem.getName())>0) {
//			return 1;
//		}
//		else if(this.getName().compareTo(mem.getName())<0) {
//			return -1;
//		}
//		else {
//			return 0;
//		}
		
		return this.getName().compareTo(mem.getName());
	}
}





