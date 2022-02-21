import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class BloodEvent extends Frame {
	Panel p1, p2;
	Label l1, result;
	CheckboxGroup group;
	Checkbox cb1, cb2, cb3, cb4;
	Button ok;
	
	String str; // 기본값은 null
	Font f1 = new Font("Serif", Font.BOLD, 32);
	
	BloodEvent(String title) {
		super(title);

		// 제목표시줄 앞에 아이콘 넣고 싶을 경우, 
		// src와 bin 폴더와 같은 경로인 부분에 images 폴더를 만들고 
		// 그 안에 icon.jpg 가 있으면 나옴!
		this.setIconImage(new ImageIcon("images/icon.jpg").getImage()); // 프레임 아이콘 설정
		
		// 레이블 부분
		l1 = new Label("혈액형 선택", Label.CENTER); // 레이블 가운데 정렬
		l1.setFont(f1);

		// 혈액형 패널 부분
		p1 = new Panel(); // p1은 기본레이아웃(FlowLayout 사용)
		
		group = new CheckboxGroup();
		cb1 = new Checkbox("A", group, false); // 체크 안된 상태로 시작(라디오버튼)
		cb2 = new Checkbox("B", group, false);
		cb3 = new Checkbox("AB", group, false); 
		cb4 = new Checkbox("O", group, false); 
		
		cb1.setFont(f1);
		cb2.setFont(f1);
		cb3.setFont(f1);
		cb4.setFont(f1);
		
		p1.add(cb1); p1.add(cb2); p1.add(cb3); p1.add(cb4);
	
		
		
		// 버튼, 레이블 패널 부분
		p2 = new Panel();
		p2.setLayout(null); // p2은 레이아웃 사용안함(좌표 사용)
		
		ok = new Button("확인");
		ok.setFont(f1);
		ok.setBounds(50, 10, 150, 60);
		
		
		// ok 버튼 누를 때 이벤트 처리 부분
		ok.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(str == null) {
					result.setText("혈액형을 선택!");
				} else {			
					result.setText(str + "형 이군요~!!");
				}
			}
		});	
		
		// 체크박스 이벤트 처리 부분
		cb1.addItemListener(new EventA());
		cb2.addItemListener(new EventA());
		cb3.addItemListener(new EventA());
		cb4.addItemListener(new EventA());
		
		
		result = new Label("", Label.CENTER); // 처음에는 문자열 없이 시작
		result.setFont(f1);
		result.setBackground(Color.black);
		result.setForeground(Color.yellow);
		result.setBounds(250, 10, 350, 60);
		
		p2.add(ok); p2.add(result);
		
		
		
		// 프레임에 컴포넌트 붙이기
		add(l1); add(p1); add(p2);
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		// 프레임 위치 설정(중앙에 위치 시키기)
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비,높이의 정보를 screenSize에 대입
		this.setBounds(screenSize.width/2-350, screenSize.height/2-200, 700, 400);
		
		this.setLayout(new GridLayout(3,1)); // 프레임 레이아웃을 GridLayout으로 설정
		setVisible(true); // 프레임 화면에 보이기
	}
	
	class EventA implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			Checkbox cb = (Checkbox)e.getSource(); 
			str = cb.getLabel();
		}
	}
}
	
	