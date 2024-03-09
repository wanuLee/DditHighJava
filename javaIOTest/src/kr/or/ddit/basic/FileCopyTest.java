package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
	/*
	 * 문제) 'd:/d_other' 폴더에 있는 '펭귄.jpg'파일을 'd:/d_other/연습용' 폴더에 '펭귄_복사본.jpg'파일로 복사하는
	 * 프로그램을 작성하시오.
	 */

	public static void main(String[] args) {
		File file = new File("D:/D_Other/펭귄.jpg");

		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + " 파일이 없습니다.");
			System.out.println("복사 작업을 중단합니다.");
			return;
		}
		FileInputStream f = null;
		FileOutputStream fo = null;

		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;

		try {

			f = new FileInputStream(file);
			bin = new BufferedInputStream(f);

			fo = new FileOutputStream("D:/D_Other/연습용/펭귄_복사본.jpg");
			bout = new BufferedOutputStream(fo);

			System.out.println("복사 작업 시작");

			int c;

//			while ((c = f.read()) != -1) {
//				fo.write(c);
//			}

			while ((c = bin.read()) != -1) {
				bout.write(c);
			}

			System.out.println("복사 작업 완료");

		} catch (IOException e) {
			// TODO: handle exception
		} finally {
//			if (f != null)
//				try {
//					f.close();
//				} catch (IOException e) {
//				}
//			if (fo != null)
//				try {
//					fo.close();
//				} catch (IOException e) {
//				}
			if (bin != null)
				try {
					bin.close();
				} catch (IOException e) {
				}
			if (bout != null)
				try {
					bout.close();
				} catch (IOException e) {
				}
		}
	}
}