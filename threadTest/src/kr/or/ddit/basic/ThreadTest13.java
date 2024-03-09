package kr.or.ddit.basic;

import java.util.Arrays;


/*
문제)  10마리의 말들이 경주하는 경마 프로그램 작성하기
	
	말은 Horse라는 이름의 클래스로 구성하고,
	이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
	그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
	기능이 있다.( Comparable 인터페이스 구현)
	
	경기 구간은 1~50구간으로 되어 있다.(like A~Z)
	
	경기 중 중간 중간에 각 말들의 위치를 나타내시오.
	예)
	1번말   --->------------------------------------
	2번말   ----->----------------------------------
	...
	10번말 ----->----------------------------------
	경기가 끝나면 등수 순으로 출력한다.

*/
public class ThreadTest13 {

	public static void main(String[] args) {
		Horse1[] horseArr = new Horse1[] { 
				new Horse1("01번"), 
				new Horse1("02번"), 
				new Horse1("03번"), 
				new Horse1("04번"),
				new Horse1("05번"), 
				new Horse1("06번"), 
				new Horse1("07번"), 
				new Horse1("08번"), 
				new Horse1("09번"),
				new Horse1("10번") 
				};
		GameState gs = new GameState(horseArr);
		for (Horse1 h : horseArr) {
			h.start();
		}
		
		gs.start();
		for (Horse1 h : horseArr) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		try {
			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println();
		System.out.println("경기 끝");
		System.out.println();

		// 등수의 오름차순으로 정렬하기
		Arrays.sort(horseArr);

		System.out.println("---------경기 결과--------");
		for (Horse1 h : horseArr) {
			System.out.println(h);
		}
	}

}

class Horse1 extends Thread implements Comparable<Horse1> {
	public static int currentRank; // 현재 등수를 지정할 변수

	private String horseName; // 말이름
	private int rank; // 등수
	private int location; // 위치

	public Horse1(String horseName) {
		this.horseName =  horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return horseName+" 경주마는 " + rank + "등 입니다.";
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			location = i; // 말의 현재 위치 저장
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

		// 한 마리의 말이 경주가 끝나면 현재 등수를 구해서 저장한다.
		currentRank++;
		rank = currentRank;
	}

	// 등수의 오름차순 정렬 기준 만들기
	@Override
	public int compareTo(Horse1 horse) {

		return Integer.compare(rank, horse.getRank());
	}
}





//경기 중 중간 중간에 각 말들의 위치를 나타내시오.
//예)
//1번말   --->------------------------------------
//2번말   ----->----------------------------------
//...
//10번말 ----->----------------------------------		
//경기 중 말의 현재 위치를 나타내는 스레드
class GameState extends Thread {
	private Horse1[] horseArr; // 경주에 참가하는 말들이 저장될 배열

	public GameState(Horse1[] horseArr) {
		super();
		this.horseArr = horseArr;
	}

	@Override
	public void run() {
		while (true) {
			// 모든 말들의 달리기가 종료되었는지 여부 검사
			if (Horse1.currentRank == horseArr.length) {
				break;
			}

			for (int i = 0; i < 10; i++) {
				System.out.println();
			}

			for (int i = 0; i < horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName() + " : ");
//				System.out.print(horseArr[i].getLocation());
				for (int j = 1; j <= 50; j++) {
					
					if (horseArr[i].getLocation() == j) { // 현재 위치값 자리에 ">"문자 출력하기
						System.out.print(">");

					} else {
						System.out.print("-");
					}
				}
				System.out.println(); // 줄바꿈
				
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

	}
}
