import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CoffeeMachine extends Frame {
	Panel p0,p1, p2, p3, p4, p5;
	Label l0, l1, l2, l3, result, total;
	CheckboxGroup group;
	Checkbox cf1, cf2, cf3;
	CheckboxGroup group1;
	Checkbox sz1, sz2, sz3;
	Button ok, Cal, coin1, coin2, cal;
	Choice count;
	
	 Color c1 = new Color(102,051,000);  
	 Color c2 = new Color(153,051,051);
	 Color c3 = new Color(153,102,000);
	 Color c4 = new Color(102,102,102);
	 
	String Cprice, Sprice, count1;
	boolean bool = false;
	int Cp, Sp, temp;
	int quantity = 1;
	int totalp = 0;
	
	Font f1 = new Font("Serif", Font.BOLD, 32);
	Font f2 = new Font("Serif", Font.PLAIN, 26);
	
	
	CoffeeMachine(String title) {
		super(title);

		this.setIconImage(new ImageIcon("images/icon.jpg").getImage()); 
		
		p5 = new Panel();
		p5.setBackground(c4);
		p5.setForeground(c3);
		p5.setLayout(null);
		
		coin1 = new Button("500원 투입");
		coin1.setFont(f2);
		coin1.setBounds(120, 10, 150, 60);
		
		coin2 = new Button("1000원 투입");
		coin2.setFont(f2);
		coin2.setBounds(300, 10, 150, 60);
		
		coin1.addActionListener(new ActionListener() {		//버튼으로 500원 더하는 이벤트
			public void actionPerformed(ActionEvent e) {
				totalp = totalp + 500;
				total.setText(totalp + "원");
			}	
			});	
		
		coin2.addActionListener(new ActionListener() {		// 버튼으로 1000원 더하는 이벤트
			public void actionPerformed(ActionEvent e) {
				totalp = totalp + 1000;
				total.setText(totalp + "원");
			}	
			});	
		
		total = new Label("금액 투입", Label.CENTER);
		total.setFont(f1);
		total.setBackground(Color.black);
		total.setForeground(Color.yellow);
		total.setBounds(580, 10, 200, 60);
		
		p5.add(coin1);p5.add(coin2); p5.add(total);
		
		
		l1 = new Label("커피 선택", Label.CENTER);
		l1.setFont(f1);
		l1.setBackground(c1);
		l1.setForeground(Color.yellow);
		
		p0 = new Panel();
		p0.setLayout(new FlowLayout(FlowLayout.CENTER,120,0));
		p0.setBackground(c1);
		p0.setForeground(Color.white);
		
		ImageIcon image1 = new ImageIcon("images/AMERICANO.png");
		JLabel lb = new JLabel(image1);
		
		ImageIcon image2 = new ImageIcon("images/CAFELATTE.png");
		JLabel lb1 = new JLabel(image2);
		
		ImageIcon image3 = new ImageIcon("images/CAPPUCCINO.png");
		JLabel lb2 = new JLabel(image3);
		
		p0.add(lb);	p0.add(lb1); p0.add(lb2);

		p1 = new Panel(); 
		p1.setBackground(c1);
		p1.setForeground(Color.white);
		
		group = new CheckboxGroup();
		cf1 = new Checkbox("아메리카노(1000원)", group, false); 
		cf2 = new Checkbox("카페라떼(1500원)", group, false);
		cf3 = new Checkbox("카푸치노(2000원)", group, false); 
		
		cf1.setFont(f2);
		cf2.setFont(f2);
		cf3.setFont(f2);
		
		p1.add(cf1); p1.add(cf2); p1.add(cf3);
		
		l2 = new Label("사이즈 선택", Label.CENTER);
		l2.setFont(f1);
		l2.setBackground(c2);
		l2.setForeground(Color.white);
		

		p3 = new Panel(); 
		p3.setBackground(c2);
		p3.setForeground(Color.white);
		
		group1 = new CheckboxGroup();
		sz1 = new Checkbox("작은사이즈(+0원)", group1, false); 
		sz2 = new Checkbox("중간사이즈(+500원)", group1, false);
		sz3 = new Checkbox("큰사이즈(+1000원)", group1, false); 
		
		sz1.setFont(f2);
		sz2.setFont(f2);
		sz3.setFont(f2);
		
		p3.add(sz1); p3.add(sz2); p3.add(sz3);
	
		p4 = new Panel();
		p4.setBackground(c3);
		p4.setLayout(null);
		
		l3 = new Label("수량 선택", Label.CENTER); 
		l3.setFont(f1);
		l3.setBackground(c3);
		l3.setForeground(Color.blue);
		l3.setBounds(120, 20, 200, 60);
		
		count = new Choice();
		count.add("1");
		count.add("2");
		count.add("3");
		count.add("4");
		count.add("5");
		
		count.setBounds(500, 30, 250, 60);
		
		p4.add(l3); p4.add(count);
		

		p2 = new Panel();
		p2.setBackground(c3);
		
		p2.setLayout(null); 
		
		ok = new Button("가격확인");
		ok.setFont(f2);
		ok.setBounds(80, 0, 150, 60);
		
		
		// ok 구현
		ok.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if((Cprice == null)||(Sprice == null)) {
					result.setText("선택해주세요.");
				}
				else {
					temp = (Cp + Sp) * quantity;
					result.setText(temp + "원");
					bool = true;
					}
			}	
			});	
		
		//리스너 추가
		cf1.addItemListener(new EventA());
		cf2.addItemListener(new EventA());
		cf3.addItemListener(new EventA());
		
		sz1.addItemListener(new EventB());
		sz2.addItemListener(new EventB());
		sz3.addItemListener(new EventB());
		
		count.addItemListener(new EventC());
		
		result = new Label("", Label.CENTER); 
		result.setFont(f1);
		result.setBackground(Color.black);
		result.setForeground(Color.yellow);
		result.setBounds(300, 0, 350, 60);
		
		cal = new Button("계산");
		cal.setFont(f1);
		cal.setBounds(700, 0, 150, 60);
		
		// 계산 이벤트
		cal.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(totalp<temp) {
					result.setText("돈이 모자랍니다.");
				}
				else if(bool == true) {
					result.setText("계산되었습니다.");
					totalp = totalp - temp;
					total.setText(totalp + "원");
				}
				else {
					result.setText("가격확인해주세요");
				}
			}	
			});	
		
		p2.add(ok); p2.add(result); p2.add(cal);
		


		add(p5); add(l1); add(p0); add(p1); add(l2); add(p3); add(p4); add(p2);
		

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});


		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		this.setBounds(screenSize.width/2-350, screenSize.height/2-200, 900, 700);
		
		this.setLayout(new GridLayout(8,1));
		setVisible(true); 
	}
	
	class EventA implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			bool = false;
			Checkbox cb = (Checkbox)e.getSource(); 
			Cprice = cb.getLabel();
			if(Cprice == "아메리카노(1000원)") {
				Cp = 1000;
			}
			else if(Cprice == "카페라떼(1500원)") {
				Cp = 1500;
			}
			else {
				Cp = 2000;
			}
		}
	}
	
	

	class EventB implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			Checkbox cb = (Checkbox)e.getSource(); 
			Sprice = cb.getLabel();
			bool = false;
			if(Sprice == "작은사이즈(+0원)") {
				Sp = 0;
			}
			else if(Sprice == "중간사이즈(+500원)") {
				Sp = 500;
			}
			else {
				Sp = 1000;
			}
		}
	}
	
	class EventC implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			bool = false;
			Choice cb = (Choice)e.getSource(); 
			count1 = cb.getSelectedItem();
			if(count1 == "1") {
				quantity = 1;
			}
			else if(count1 == "2") {
				quantity = 2;
			}
			else if(count1 == "3") {
				quantity = 3;
			}
			else if(count1 == "4") {
				quantity = 4;
			}
			else if(count1 == "5") {
				quantity = 5;
			}
		}
	}
}
	
	
