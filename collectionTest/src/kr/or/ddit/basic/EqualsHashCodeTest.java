package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");

		Person p2 = new Person();
//		p2.setNum(2);
//		p2.setName("일지매");
		p2.setNum(1);
		p2.setName("홍길동");

		Person p3 = p1;

		System.out.println(p1 == p2);
		System.out.println(p1 == p3);
		System.out.println();
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println();
		
		HashSet<Person> testSet =  new HashSet<Person>();
		testSet.add(p1);
		testSet.add(p2);
		System.out.println("Set의 개수 : "+ testSet.size());

		
		System.out.println("p1 hashcode : "+p1.hashCode());
		System.out.println("p2 hashcode : "+p2.hashCode());
		System.out.println("p3 hashcode : "+p3.hashCode());
		System.out.println();
		System.out.println("p1 : "+p1);
		System.out.println("p2 : "+p2);
		System.out.println("p3 : "+p3);
		
		
		
	}

	

}

class Person extends Object {
	private int num;
	private String name;

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
	
	
	// equals 재정의
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { // 참조값이 같은지 검사
			return true;
		}
		if (obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {// 같은 유형의 클래스인지 검사
			return false;
		}
		
		Person that = (Person)obj; //매개변수의 값을 현재 객체 유혀으로 형변환 한다.
		// Objects.equals(객체1, 객체2) ==> 객체1과 객체2가 같으면 true, 다르면 false 반환
		return this.num ==that.num && Objects.equals(this.name, that.name);
	
	
	
	}
}