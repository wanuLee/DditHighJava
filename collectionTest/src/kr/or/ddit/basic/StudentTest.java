package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다
 * 이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
 * 
 * 이 student 개게는 List에 저장하여 관리한다.
 * 
 * List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현한다
 * 그리고 총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬하는 외부정렬기준 클래스를
 * 작성하여 정렬된 결과를 출력하시오
 * (등수는 구하지 않아도 됨)
 */


public class StudentTest {
	
	
	public void createRank(List<Student> stuList) {
		for(Student stu1 : stuList) {// 기준데이터 구하기 위한 반복문
			int rank =1;			// 처음에는 1등으로 설정해놓고 시작
			
			// 기준보다 비교대상이 큰값을 만나면 rank값을 증가시킨다.
			for(Student stu2 : stuList) {
				if(stu1.getSum() < stu2.getSum()) {
					rank ++;
				}
			}//비교 반복문 종료
			stu1.setCnt(rank);
		}//기존 반복문 종료
		
	}
	public static void main(String[] args, List<Student> stuList) {
		List<Student> student = new ArrayList<Student>();

		student.add(new Student("1", "이원우", 40, 65, 80));
		student.add(new Student("2", "김수로", 80, 95, 90));
		student.add(new Student("4", "홍길동", 87, 45, 70));
		student.add(new Student("5", "강감찬", 86, 95, 90));
		student.add(new Student("3", "고주몽", 65, 30, 90));
		
		// 등수 구하느 메서드 호출하기
		StudentTest stuTest = new StudentTest();
		stuTest.createRank(stuList);
		
		
		
		
		
		
		System.out.println("정렬 전  ");
		for (Student stu : student) {
			System.out.println(stu);

		}
		System.out.println("---------------------------------------");

		Collections.sort(student);

		System.out.println("학번 순 정렬 후(내부 정렬) ");
		for (Student stu : student) {
			System.out.println(stu);
		}
		
		
		System.out.println("---------------------------------------");
		Collections.sort(student, new Student1());
		
		
		System.out.println("총점이 큰 순");
		for(Student stu : student) {
			System.out.println(stu);
		}
	}
}

class Student1 implements Comparator<Student>{

	@Override
	public int compare(Student stu1, Student stu2) {
		if (stu1.getSum() == stu2.getSum()) {
            return -1;
        } 
        else if (stu1.getSum() < stu2.getSum()) {
            return 1;
        } 
        else {
            return stu1.getName().compareTo(stu2.getName());
        }
	}
	
}

class Student implements Comparable<Student> {
	private String num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int cnt;

	public Student(String num, String name, int kor, int eng, int math) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
		this.cnt = cnt;
	}

	
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", cnt=" + cnt + "]";
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Student stu) {
		return  0;
	}
}
