import java.awt.*; // AWT 컴포넌트 위해
import java.awt.event.*; // 이벤트 처리 위해

import javax.swing.ImageIcon;

class ExitWin extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}	//닫기 버튼을 눌렀을때 호출되는 메소드
}

public class JavaMenu extends Frame {
	
	TextField tf = new TextField();
	TextArea ta = new TextArea();
	
	Font font1 = new Font("맑은 고딕", Font.PLAIN,12);
	Color c1 = new Color(221,234,205);  
	Color c2 = new Color(0,10,112);
	Color c6 = new Color(164,13,144);
	
	JavaMenu(String title) {
		super(title); // Frame("자바프로젝트_홍길동");
		
		this.setIconImage(new ImageIcon("images/menuc.png").getImage());
		
		tf = new TextField();
		ta = new TextArea();
		add(ta,"Center");
		add(tf,"South");
		tf.setText("201510306_남윤오");
		tf.setForeground(c6);
		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.append("채팅자 : " + tf.getText() + "\n");
				tf.setText("");
				tf.requestFocus();
				
			}
		});
		
		//도움말 settext로 설명
		ta.setText("안녕하세요. 남윤오의 자바 awt 프로젝트입니다.\n"
				+ "프로젝트들은 이벤트활용에 3가지가 구현되어 있습니다.\n"
				+ "아래에는 각 프로젝트에 따른 도움말이 설명되어있습니다.\n\n\n"
				+ "첫번째 프로젝트는 커피자판기 입니다.\n"
				+ "수업시간의 예시화면을 참고하여 만들었고 금액투입 기능과 수량선택 이벤트를 추가하였습니다.\n\n\n"
				+ "두번째 프로젝트는 관부가세 계산기입니다.\n"
				+ "관부가세란 관세 + 부가세의 개념으로 해외에서 물건을 직구할때 일정 금액을 초과하면\n"
				+ "부과되는 세금을 뜻합니다. 실제 무게 계산의 정확한 계산방법은 알수 없었기 때문에\n"
				+ "나라와 품목을 불문하고 0.1kg이 올라갈수록 500원이 추가되게 프로그래밍 하였고\n"
				+ "해당 기능 외에는 실제와 비슷하게 최대한 구현했습니다.\n"
				+ "각 세금 이름 옆에 있는 '?' 아이콘에는 이미지변경과 팁텍스트가 지정되어있습니다.\n"
				+ "미입력과 오입력 예외처리 완료했습니다.\n"
				+ "계산 버튼이 있는 패널에서 오른쪽버튼을 누르면 결과 영수증을 메모장에 저장해주는 기능이 있습니다.\n"
				+ "정보는 아래와 같습니다.\n\n"
				+ "미국 : 200$ 이상인 경우 관부가세 부가\n"
				+ "일본 : 150$ 이상인 경우 관부가세 부가\n"
				+ "유럽연합 : 150$ 이상인 경우 관부가세 부가\n\n\n"
				+ "세번째 프로젝트는 그림판입니다.\n"
				+ "메뉴바를 통해 펜 모양을 구현해 보았고 펜 색깔과 지우개, 모두 지우기 기능이 있습니다.\n"
				+ "메뉴바를 이용해 상태값을 변경할 경우 콘솔창에 바뀐 내용이 표시됩니다.\n"
				+ "마우스의 휠을 올리거나 내리면 그리고 있는 펜의 크기가 변합니다.\n"
				+ "오른쪽 화살표(ASCII로39번)를 누르면 캔버스의 배경색이 바뀝니다.\n\n\n"
				+ "감사합니다.\n\n");
		
		ta.setForeground(c2);
		ta.setEditable(false);
		ta.setBackground(c1);
		setSize(300,200);
		tf.requestFocus();
		
		MenuBar mb = new MenuBar(); // 메뉴바 추가 부분
		
		Menu mFile = new Menu("파일"); 
		MenuItem miExit = new MenuItem("닫기"); 
		miExit.addActionListener(new Exit());
		mFile.add(miExit);	
		
		Menu mEvent1 = new Menu("이벤트 연습"); 
		MenuItem miEvent1_1 = new MenuItem("마우스 이벤트"); 
		MenuItem miEvent1_2 = new MenuItem("혈액형 이벤트"); 
		MenuItem miEvent1_3 = new MenuItem("로그인 이벤트"); 
		
		mEvent1.add(miEvent1_1);
		mEvent1.add(miEvent1_2);
		mEvent1.add(miEvent1_3);
		
		miEvent1_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new MouseEventTest("마우스 이벤트 프로그램");
			} 
		});
		
		miEvent1_2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new BloodEvent("혈액형 프로그램");
			} 
		});
		
		miEvent1_3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new Login("로그인");
			} 
		});
		
		
		
		Menu mEvent2 = new Menu("이벤트 활용"); 
		MenuItem miEvent2_1 = new MenuItem("커피자판기");
		mEvent2.add(miEvent2_1);
		miEvent2_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new CoffeeMachine("커피자판기");
			} 
		});
		
		
		MenuItem miEvent2_2 = new MenuItem("관부가세 계산기");
		mEvent2.add(miEvent2_2);
		miEvent2_2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//new Login("로그인");
				new Psychological_test("관부가세 계산기");
			} 
		});
		
		MenuItem miEvent2_3 = new MenuItem("그림판");
		mEvent2.add(miEvent2_3);
		miEvent2_3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new Paintpan("그림판");
			} 
		});
		
		Menu mHelp = new Menu("도움말"); 
		MenuItem miHelp = new MenuItem("프로그램 설명"); 
		mHelp.add(miHelp);
		
		miHelp.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new Help("프로그램 설명");
			} 
		});
		
		
		// 메뉴바에 메뉴 붙이기
		mb.add(mFile);
		mb.add(mEvent1);
		mb.add(mEvent2);
		mb.add(mHelp);

		
		// 프레임 설정 부분
		// 프레임 중앙에 위치시키기
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비와 높이를 구함
		setBounds(screenSize.width/2-300, screenSize.height/2-250, 600, 500);

		this.setBackground(Color.gray);
		this.addWindowListener(new ExitWin());
		this.setMenuBar(mb); // 프레임에 메뉴바 붙이기
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaMenu("자바프로젝트_남윤오");
	}
}
