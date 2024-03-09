package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogFileCopyTest {

	public static void main(String[] args) {
		DialogFileCopyTest test = new DialogFileCopyTest();
		
		
//		File file = new File("d:/d_other/펭귄.jpg");
		File file = test.DialogOpen("OPEN");
		
		if (file == null) {
			System.out.println("원본 파일 선택에 실패했습니다.");
			System.out.println("복사 작업을 중지합니다.");
			
		}

		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + " 파일이 없습니다.");
			System.out.println("복사 작업을 중단합니다.");
			return;
		}
		FileInputStream f = null;
		FileOutputStream fo = null;

		try {
			f = new FileInputStream(file);
			
			File targetFile = test.DialogOpen("SAVE");
			if(targetFile == null) {
				System.out.println("대상 파일 선택에 실패했습니다.");
				System.out.println("파일선택을 중지합니다.");
			}
			
			fo = new FileOutputStream("d:/d_other/연습용/펭귄_복사본.jpg");

			System.out.println("복사 작업 시작");

			int c;

			while ((c = f.read()) != -1) {
				fo.write(c);
			}

			System.out.println("복사 작업 완료");

		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException e) {
				}
			if (fo != null)
				try {
					fo.close();
				} catch (IOException e) {
				}
		}
	}

	private File DialogOpen(String type) {
		// SWING의 파일 열기, 저장 창 연습

		JFileChooser chooser = new JFileChooser();

		// 선택한 파일의 확장자 설정
		FileNameExtensionFilter txt = new FileNameExtensionFilter("Text파일(*.txt)", "txt");

		FileNameExtensionFilter doc = new FileNameExtensionFilter("MS Word File", new String[] { "docx", "doc" });

		FileNameExtensionFilter img = new FileNameExtensionFilter("Images File", "png", "jpg", "jpeg", "gif");

		FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF File", "pdf");

		// 선택한 파일 목록 중 '모든 파일'목록의 표시 여부 결정
		// (true: 표시 (기본값), false: 표시하지 않는다.)
		chooser.setAcceptAllFileFilterUsed(false);

		// 선택한 파일 목록 중 기본값으로 선택되게 하고 싶은 파일 목록 이름 설정
		chooser.setFileFilter(img);

		// '찾는 위치'(처음부터 작업할 폴더) 설정하기
		chooser.setCurrentDirectory(new File("d:/d_other"));

		chooser.addChoosableFileFilter(txt);

		chooser.addChoosableFileFilter(doc);

		chooser.addChoosableFileFilter(img);

		chooser.addChoosableFileFilter(pdf);

		// Dialog창 띄우기
		int result;
		if ("SAVE".equals(type.toUpperCase())) {
			result = chooser.showSaveDialog(new Panel()); // 열기용 창
		} else if ("OPEN".equals(type.toUpperCase())) {
			result = chooser.showOpenDialog(new Panel()); // 저장용 창
		} else {
			return null;
		}
		// Dialog창에서 선택한 파일 정보 구하기
		// '열기' 버튼 또는 '저장'버튼을 눌렀는지 여부 검사
		File selectFile = null;
		if (result == JFileChooser.APPROVE_OPTION) {
			selectFile = chooser.getSelectedFile(); // 선택한 파일 정보를 반환
		}
		return selectFile;
	}
}
