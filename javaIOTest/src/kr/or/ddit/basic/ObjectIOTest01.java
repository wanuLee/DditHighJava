package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectIOTest01 {
	
	public static void main(String[] args) {
		// Member의 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("이순신", 21, "청주");
		Member mem3 = new Member("강감찬", 22, "옥천");
		Member mem4 = new Member("이원우", 23, "대구");
		
		// 객체를 파일에 저장하기
		try {
			// 출력용 스트림 객체 생성
			FileOutputStream fout = 
					new FileOutputStream("d:/d_other/memObj.dat");
			
			BufferedOutputStream bout = 
					new BufferedOutputStream(fout);
			
			ObjectOutputStream oout =
					new ObjectOutputStream(bout);
			
			// 쓰기 (저장)작업
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);

			// 객체를 저장할때 마지막에 null을 추가하여 EOFException이
			// 발생하는 것을 방지할 수 있다.
			oout.writeObject(null);
			
			System.out.println("객체 저장 완료");
			
			oout.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
