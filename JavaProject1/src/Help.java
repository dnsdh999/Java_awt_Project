
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends Frame {
	Image img;
	
	Help(String title) {
		super(title);
		
		this.setIconImage(new ImageIcon("images/icon.jpg").getImage()); // 프레임 아이콘 설정
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("images/help.jpg");
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	
		// 프레임 위치 설정(중앙에 위치 시키기)
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비,높이의 정보를 screenSize에 대입
		this.setBounds(screenSize.width/2-350, screenSize.height/2-350, 700, 700);

		this.setLayout(null); // 프레임 레이아웃 사용 안함(좌표 사용)
		setVisible(true); // 프레임 화면에 보이기
	}

	
	// paint() 호출 시점
	// 1. 화면이 처음 보여질 때
	// 2. 다른 화면에 가려졌다가 다시 보여질 때
	// 3. 최소화됐다가 다시 보여질  때
	public void paint(Graphics g) { // 오버라이딩
		g.drawImage(img, 0, 0, this);
	}
	
}




