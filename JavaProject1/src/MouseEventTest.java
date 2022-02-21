import java.awt.*; // 컴포넌트, 컨테이너, 메뉴 사용하기 위해
import java.awt.event.*; // 이벤트 처리를 위해

public class MouseEventTest extends Frame {
	Label location;
	Font f1 = new Font("Serif", Font.BOLD, 25);
	
	MouseEventTest(String title) {
		super(title);
		
		// 레이블 설정 부분
		location = new Label("Mouse Pointer Location : ");
		location.setBounds(20, 80, 430, 50);
		location.setBackground(Color.gray);
		location.setFont(f1);
				
		// 이벤트 처리 부분
		this.addMouseMotionListener(new EventMouse());
		
		// 프레임 닫기 버튼 누르면 종료하는 부분!
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			} 
		});
		
		// 프레임 설정 부분
		// 프레임 중앙에 위치시키기
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비와 높이를 구함
		setBounds(screenSize.width/2-350, screenSize.height/2-250, 700, 500);

		this.setLayout(null); // 프레임 레이아웃 사용 안함(좌표 사용)
		this.add(location); // 프레임에 Label 붙이기
		this.setVisible(true); // 프레임 화면에 보이기
 	}

	class EventMouse extends MouseMotionAdapter {
		public void mouseMoved(MouseEvent e) {
			location.setText("Mouse Pointer Location : (" + e.getX() + ", " + e.getY() + ")");
		}
	}

}
