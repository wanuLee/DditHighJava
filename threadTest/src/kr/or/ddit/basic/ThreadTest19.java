package kr.or.ddit.basic;

public class ThreadTest19 {

	public static void main(String[] args) {
		DataBox box = new DataBox();

		ProducerThread pt = new ProducerThread(box);
		ConsumerThread ct = new ConsumerThread(box);

		pt.start();
		ct.start();
	}
}

// 데이터를 공통으로 사용하는 클래스
class DataBox {
	private String value;

	// value 변수의 값이 null이면 value변수에 문자열이 채워질때까지 기다리고,
	// value 변수에 값이 있으면 해당 문자열을 반환하고, value변수는 null로 만든다.
	public synchronized String getValue() {
		if (value == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		} else {
		}
		String temp = value;

		System.out.println("Thread가 읽은 데이터 : " + temp);

		value = null;

		notify();

		return temp;
	}

	// value변수에 값이 있으면 value변수가 null이 될때까지 기다린다.
	// value변수가 null이 되면 새로운 값을 저장한다.
	public synchronized void setValue(String value) {
		if (this.value != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		this.value = value;

		System.out.println("쓰레드가 새롭게 저장한 데이터 : " + this.value);

		notify();
	}
}

// 데이터를 넣어주는 쓰레드(DataBox의 setValue()메서드만 호풀하는 쓰레드)
class ProducerThread extends Thread {
	private DataBox dataBox;

	public ProducerThread(DataBox dataBox) {
		this.dataBox = dataBox;

	}

	@Override
	public void run() {
		String[] nameArr = { "이순신", "강감찬", "홍길동" };

		for (int i = 0; i < nameArr.length; i++) {
			dataBox.setValue(nameArr[i]);
		}
	}
}

// 데이터를 꺼내서 사용하는 쓰레드
// (DataBox의 getValue()메서드만 호출하는 쓰레드
class ConsumerThread extends Thread {
	private DataBox dataBox;

	public ConsumerThread(DataBox dataBox) {
		this.dataBox = dataBox;
	}

	@Override
	public void run() {	
		for (int i = 0; i < 3; i++) {
			String data = dataBox.getValue();
		}

	}
}
