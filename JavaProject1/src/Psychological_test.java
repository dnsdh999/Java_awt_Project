import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Date;

public class Psychological_test extends JFrame{
	
	
	Font f1 = new Font("돋움체", Font.BOLD, 32);
	Font f2 = new Font("돋움체", Font.BOLD, 28);
	Font f3 = new Font("돋움체", Font.BOLD, 20);
	Font f4 = new Font("돋움체", Font.BOLD, 16);
	Font f5 = new Font("돋움체", Font.BOLD, 13);
	Font f6 = new Font("돋움체", Font.PLAIN, 9);
	
	Color c1 = new Color(183,217,200);  
	Color c2 = new Color(223,210,191);
	Color c3 = new Color(0,10,112);
	Color c4 = new Color(55,57,128);
	Color c5 = new Color(67,114,153);
	Color c6 = new Color(64,63,44);
	
	JButton Confirm;
	JButton qm1, qm2, qm3;
	
	CheckboxGroup group;
	Checkbox usa, jap, eur;
	int indexm, indexs;
	double i =0;
	
	Choice Main, Side, Nation;
	Label l1, l2, l3, l4,l5, l6, l7, l8,l9, l10, l11, l12;
	Panel p1,p2,p3,p4,p5,p6,p7,p8;
	
	String Mcategory,Side1, Side2, Side3, Nations, nationcheck, money, kilo, check, check2;
	
	int count, TotalMoney = 0;
	int Money = 0;
	int gram = 0;
	
	double Kilo = 0;
	
	Label Price, won;
	Label Weight, kg;
	TextField tfp;
	TextField tfw;
	
	int USDMoney,JPYMoney = 0;
	int EURMoney = 0;
	
	double c,v;
	
	int cu,va,CheckMoney = 0;
	boolean onoff = false;
	
	int customs,VAT = 0;
	
	int pgram, pcustoms, pVAT, pMoney, pcu, pva, pTotalMoney = 0;
	int dialog;
	Psychological_test(String title) {
		JFrame f = new JFrame(title);
		f.getContentPane().setBackground(c1);
		f.setIconImage(new ImageIcon("images/tax.png").getImage());
		

		l1 = new Label("관부가세 계산기", Label.CENTER);
		l1.setFont(f1);
		l1.setForeground(c3);
		
		p1 = new Panel();
		p1.setLayout(null);
		
		l2 = new Label("물품 선택", Label.LEFT); 
		l2.setForeground(c3);
		l2.setFont(f3);
		l2.setBounds(50, 20, 100, 60);
		
		Main = new Choice();
		Main.add("선택해주세요");
		Main.add("의류,패션잡화");
		Main.add("컴퓨터가전");
		Main.add("도서 및 CD");

		Main.setBounds(200, 37, 150, 60);
		Main.setForeground(Color.BLUE);
		Main.addItemListener(new ChangeMain());
		
		Side = new Choice();
		Side.setBounds(400, 37, 150, 60);
		Side1 = "";Side2 = "";Side3 = "";
		Side.add("선택해주세요");
		Side.add(Side1);
		Side.add(Side2);
		Side.add(Side3);
		Side.setForeground(Color.BLUE);
		p1.add(l2); p1.add(Main); p1.add(Side);
		
		p2 = new Panel();
		p2.setLayout(null);
		
		l3 = new Label("구입 국가", Label.LEFT); 
		l3.setForeground(c3);
		l3.setFont(f3);
		l3.setBounds(50, 20, 100, 60);
		
		group = new CheckboxGroup();
		usa = new Checkbox("미국", group, false); 
		usa.setForeground(Color.BLUE);
		jap = new Checkbox("일본", group, false);
		jap.setForeground(Color.RED);
		eur = new Checkbox("유럽", group, false); 
		eur.setForeground(Color.magenta);
		usa.setFont(f3);
		jap.setFont(f3);
		eur.setFont(f3);
		
		usa.setBounds(200, 20, 100, 60);
		jap.setBounds(350, 20, 100, 60);
		eur.setBounds(500, 20, 100, 60);
		
		usa.addItemListener(new ChangeNation());
		jap.addItemListener(new ChangeNation());
		eur.addItemListener(new ChangeNation());
		p2.add(l3);p2.add(usa); p2.add(jap); p2.add(eur);
		
		
		p3 = new Panel();
		p3.setLayout(null);
		
		Price = new Label("물품가격 : ", Label.CENTER);
		Weight = new Label("물품무게 : ", Label.CENTER);
		Price.setForeground(c4);
		Weight.setForeground(c4);
		tfp = new TextField(10);
		tfw = new TextField(10);
		won = new Label("", Label.CENTER);
		won.setForeground(c6);
		kg = new Label("Kg", Label.CENTER);
		kg.setForeground(c6);
		tfp.addFocusListener(new lostfocus1());
		tfw.addFocusListener(new lostfocus2());
		
		Price.setFont(f4);
		Price.setBounds(70, 20, 90, 50);
		tfp.setBounds(170, 35, 120, 20);
		won.setFont(f5);
		won.setBounds(300,35,30,20);
		Weight.setFont(f4);
		Weight.setBounds(350, 20, 90, 50);
		tfw.setBounds(450, 35, 120, 20);
		kg.setFont(f5);
		kg.setBounds(580,35,20,20);
		
		p3.add(Price); p3.add(tfp); p3.add(won); p3.add(Weight); p3.add(tfw); p3.add(kg);
		
		p4 = new Panel();
		p4.setLayout(null);
		
		ImageIcon beforeIcon = new ImageIcon("images/After.png");
		ImageIcon afterIcon = new ImageIcon("images/Before.png");
		
		Confirm = new JButton("", beforeIcon);
		Confirm.setRolloverIcon(afterIcon);
		Confirm.setContentAreaFilled(false);
		Confirm.setFocusPainted(false);
		Confirm.setBorderPainted(false);
		Confirm.setFont(f1);
		Confirm.setBounds(280, 10, 100, 85);
		
		final PopupMenu pMenu = new PopupMenu("Edit");
		MenuItem miCut = new MenuItem("Receipt");
		pMenu.add(miCut);
		p4.add(pMenu);
		
		p4.addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(me.getModifiers()==me.BUTTON3_MASK) {
					pMenu.show(p4, me.getX(), me.getY());
				}
			}
		});
		
		miCut.addActionListener(new Save());
		
		
		
		Confirm.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				
				l4.setVisible(true);	l5.setVisible(true);	qm1.setVisible(true);
				l6.setVisible(true);	l7.setVisible(true);	qm2.setVisible(true);
				l8.setVisible(true);	l9.setVisible(true);	qm3.setVisible(true);
				l10.setVisible(true);	l11.setVisible(true);	l12.setVisible(true);
				
				indexs = Side.getSelectedIndex();
				nationcheck = won.getText();
				money = tfp.getText();	
				kilo = tfw.getText();
				
				try {
					CheckMoney = Integer.parseInt(money);
				}catch(NumberFormatException ee) {
					money = "0";
					CheckMoney = Integer.parseInt(money);
				}
				
				try {
					Kilo = Double.valueOf(kilo).doubleValue();
				}catch(NumberFormatException we) {
					kilo = "0";
					Kilo = Double.valueOf(kilo).doubleValue();
				}

				for(i = 0; i<Kilo; i=i+0.1) {
					gram = gram + 500;
				}
				
				if((indexm == 0)) {
						l4.setText("물품을 선택하세요.");l4.setForeground(Color.RED);
						l5.setVisible(false);	qm1.setVisible(false);
						l6.setVisible(false);	l7.setVisible(false);	qm2.setVisible(false);
						l8.setVisible(false);	l9.setVisible(false);	qm3.setVisible(false);
						l10.setVisible(false);	l11.setVisible(false);	l12.setVisible(false);
				}
				else if((CheckMoney == 0)) {
					l4.setText("가격이 잘못되었습니다.");tfp.setText("");
					l4.setForeground(Color.RED);
					l5.setVisible(false);	qm1.setVisible(false);
					l6.setVisible(false);	l7.setVisible(false);	qm2.setVisible(false);
					l8.setVisible(false);	l9.setVisible(false);	qm3.setVisible(false);
					l10.setVisible(false);	l11.setVisible(false);	l12.setVisible(false);
				}
				else if((Kilo == 0)) {
					l4.setText("무게가 잘못되었습니다.");tfw.setText("");
					l4.setForeground(Color.RED);
					l5.setVisible(false);	qm1.setVisible(false);
					l6.setVisible(false);	l7.setVisible(false);	qm2.setVisible(false);
					l8.setVisible(false);	l9.setVisible(false);	qm3.setVisible(false);
					l10.setVisible(false);	l11.setVisible(false);	l12.setVisible(false);
				}
				
				else {
					l4.setForeground(c4);
					l4.setText("목록통관 관부가세 계산목록입니다.");
				}
				
				if(nationcheck == "USD") {
					USDMoney = Integer.parseInt(money);
					if(USDMoney>200) {
						Money = USDMoney * 1086;
						Money = Money + gram;
						
						if(indexm == 1) {
							if(indexs == 0 || indexs == 2) {
								customs = (int) (Money * 0.13);
								VAT = (int) (Money * 0.1);
							}
							else if(indexs == 1) {
								customs = (int) (Money * 0.08);
								VAT = (int) (Money * 0.1);
							}
						}
						else if(indexm == 2) {
							if(indexs == 0) {
								VAT = (int) (Money * 0.1);
							}
							else if(indexs == 1 || indexs == 2) {
								customs = (int) (Money * 0.08);
								VAT = (int) (Money * 0.1);
							}
						}
						else if(indexm == 3) {
							if(indexs == 0) {
							}
							else if(indexs == 1 || indexs == 2) {
								customs = (int) (Money * 0.08);
								VAT = (int) (Money * 0.1);
							}
						}
						
						TotalMoney = Money + customs + VAT;
						
						c = (double)customs/(double)Money * 100;
						c = (double)Math.round(c*1000)/1000;
						
						cu = (int)c;
						
						v = (double)VAT/(double)Money * 100;
						v = (double)Math.round(v*1000)/1000;
						
						va = (int)v;
						
					}
					else {
						Money = USDMoney * 1086;
						Money = Money + gram;
						TotalMoney = Money + customs + VAT;
					}
				}
				
				else if(nationcheck == "JPY") {
					JPYMoney = Integer.parseInt(money);
					if(JPYMoney>15650) {
						Money = (JPYMoney * 1043) / 100;
						Money = Money + gram;
						
						if(indexm == 1) {
							if(indexs == 0 || indexs == 2) {
								customs = (int) (Money * 0.13);
								VAT = (int) (Money * 0.1);
							}
							else if(indexs == 1) {
								customs = (int) (Money * 0.08);
								VAT = (int) (Money * 0.1);
							}
						}
						else if(indexm == 2) {
							if(indexs == 0) {
								VAT = (int) (Money * 0.1);
							}
							else if(indexs == 1 || indexs == 2) {
								customs = (int) (Money * 0.08);
								VAT = (int) (Money * 0.1);
							}
						}
						else if(indexm == 3) {
							if(indexs == 0) {
							}
							else if(indexs == 1 || indexs == 2) {
								customs = (int) (Money * 0.08);
								VAT = (int) (Money * 0.1);
							}
						}
						
						TotalMoney = Money + customs + VAT;
						
						c = (double)customs/(double)Money * 100;
						c = (double)Math.round(c*1000)/1000;
						
						cu = (int)c;
						
						v = (double)VAT/(double)Money * 100;
						v = (double)Math.round(v*1000)/1000;
						
						va = (int)v;
						
					}
					else {
						Money = (JPYMoney * 1043) / 100;
						Money = Money + gram;
						TotalMoney = Money + customs + VAT;
					}
				}
				
				else if(nationcheck == "EUR") {
					EURMoney = Integer.parseInt(money);
					if(EURMoney>125) {
						Money = EURMoney * 1315;
						Money = Money + gram;
						
						if(indexm == 1) {
							if(indexs == 0 || indexs == 2) {
								customs = (int) (Money * 0.13);
								VAT = (int) (Money * 0.1);
							}
							else if(indexs == 1) {
								customs = (int) (Money * 0.08);
								VAT = (int) (Money * 0.1);
							}
						}
						else if(indexm == 2) {
							if(indexs == 0) {
								VAT = (int) (Money * 0.1);
							}
							else if(indexs == 1 || indexs == 2) {
								customs = (int) (Money * 0.08);
								VAT = (int) (Money * 0.1);
							}
						}
						else if(indexm == 3) {
							if(indexs == 0) {
							}
							else if(indexs == 1 || indexs == 2) {
								customs = (int) (Money * 0.08);
								VAT = (int) (Money * 0.1);
							}
						}
						
						TotalMoney = Money + customs + VAT;
						
						c = (double)customs/(double)Money * 100;
						c = (double)Math.round(c*1000)/1000;
						
						cu = (int)c;
						
						v = (double)VAT/(double)Money * 100;
						v = (double)Math.round(v*1000)/1000;
						
						va = (int)v;
						
					}
					else {
						Money = EURMoney * 1315;
						Money = Money + gram;
						TotalMoney = Money + customs + VAT;
					}
				}
				
				else {
					l4.setText("국가를 선택하세요.");l4.setForeground(Color.RED);
					l5.setVisible(false);	qm1.setVisible(false);
					l6.setVisible(false);	l7.setVisible(false);	qm2.setVisible(false);
					l8.setVisible(false);	l9.setVisible(false);	qm3.setVisible(false);
					l10.setVisible(false);	l11.setVisible(false);	l12.setVisible(false);
				}
				
				DecimalFormat formatter = new DecimalFormat("###,###");
				l6.setText(formatter.format(Money) + " 원");
				l8.setText(formatter.format(customs) + " 원");
				l10.setText(formatter.format(VAT) + " 원");
				l12.setText(formatter.format(TotalMoney) + " 원");
				l7.setText("관세 " + cu + "%"); 
				l9.setText("부가세 " + va + "%"); 
				
				if(cu>0) {
					l7.setForeground(Color.RED);
				}
				else {
					l7.setForeground(c3);
				}
				if(va>0) {
					l9.setForeground(Color.RED);
				}
				else {
					l9.setForeground(c3);
				}
				
				pcustoms = customs; pVAT = VAT; pMoney = Money; pcu = cu; pva = va; pTotalMoney = TotalMoney;
				gram = 0;	customs=0; 	VAT=0;		Money=0; cu = 0; va = 0; TotalMoney =0;
			}
		});	
		
		p4.add(Confirm);
		
		l4 = new Label("목록통관 관부가세 계산목록입니다.", Label.CENTER); 
		l4.setFont(f2);
		l4.setVisible(false);
		l4.setForeground(c5);
		
		p5 = new Panel();
		p5.setLayout(null);
		
		l5 = new Label("과세 가격", Label.CENTER); 
		l5.setFont(f3);
		l5.setForeground(c3);
		l5.setBounds(50, 20, 110, 60);
		l5.setVisible(false);
		
		ImageIcon normalIcon = new ImageIcon("images/question.png");
		ImageIcon rolloverIcon = new ImageIcon("images/information.png");
		
		qm1 = new JButton("", normalIcon);
		qm1.setRolloverIcon(rolloverIcon);
		qm1.setContentAreaFilled(false);
		qm1.setFocusPainted(false);
		qm1.setBorderPainted(false);
		qm1.setFont(f6);
		qm1.setBounds(160, 38, 20, 20);	
		qm1.setToolTipText("제품가격과 무게에 비례하는 가격을 합친 금액입니다.");
		qm1.setVisible(false);
		
		l6 = new Label("", Label.RIGHT);
		l6.setFont(f3);
		l6.setBounds(500, 17, 120, 60);
		l6.setForeground(c3);
		l6.setVisible(false);
		
		p5.add(l5); p5.add(qm1); p5.add(l6);
		
		p6 = new Panel();
		p6.setLayout(null);
		
		l7 = new Label("관세 " + cu + "%", Label.CENTER); 
		l7.setFont(f3);
		l7.setForeground(c3);
		l7.setBounds(50, 20, 110, 60);
		l7.setVisible(false);
		
		qm2 = new JButton("", normalIcon);
		qm2.setRolloverIcon(rolloverIcon);
		qm2.setContentAreaFilled(false);
		qm2.setFocusPainted(false);
		qm2.setBorderPainted(false);
		qm2.setFont(f6);
		qm2.setBounds(160, 40, 20, 20);	
		qm2.setToolTipText("관세 영역을 통해 수출ㆍ수입되거나 통과되는 화물에 대하여 부과되는 세금");
		qm2.setVisible(false);
		
		l8 = new Label("", Label.RIGHT); 
		l8.setFont(f3);
		l8.setBounds(500, 17, 120, 60);
		l8.setVisible(false);
		l8.setForeground(c3);
		p6.add(l7); p6.add(qm2); p6.add(l8);
		
		
		p7 = new Panel();
		p7.setLayout(null);
		
		l9 = new Label("부가세" + va + "%", Label.CENTER); 
		l9.setFont(f3);
		l9.setForeground(c3);
		l9.setBounds(50, 20, 120, 60);
		
		qm3 = new JButton("", normalIcon);
		qm3.setRolloverIcon(rolloverIcon);
		qm3.setContentAreaFilled(false);
		qm3.setFocusPainted(false);
		qm3.setBorderPainted(false);
		qm3.setFont(f6);
		qm3.setBounds(170, 40, 20, 20);	
		qm3.setToolTipText("제품이 생산, 유통되는 모든 단계에서 기업이 만들어낸 가치에 대해 부과되는 세금");
		qm3.setVisible(false);
		
		l10 = new Label("", Label.RIGHT); 
		l10.setFont(f3);
		l10.setBounds(500, 17, 120, 60);
		l10.setForeground(c3);
		
		l9.setVisible(false);l10.setVisible(false);
		p7.add(l9); p7.add(qm3); p7.add(l10);
		
		
		
		p8 = new Panel();
		p8.setLayout(null);
		
		l11 = new Label("총 납부 금액", Label.CENTER); 
		l11.setFont(f3);
		l11.setForeground(c3);
		l11.setBounds(50, 20, 120, 60);
		
		l12 = new Label("", Label.RIGHT); 
		l12.setFont(f3);
		l12.setBounds(500, 17, 120, 60);
		l12.setForeground(c3);
		l11.setVisible(false);l12.setVisible(false);
		p8.add(l11); p8.add(l12);
		
		f.add(l1); f.add(p1); f.add(p2); f.add(p3); f.add(p4); f.add(l4); f.add(p5); f.add(p6); f.add(p7); f.add(p8);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); 
		f.setBounds(screenSize.width/2-350, 100, 700, 1000);
		
		f.setLayout(new GridLayout(10,1,0,-20)); 
		f.setVisible(true); 
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	
	class ChangeMain implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			count++;
			if(count==1) {
				Main.remove(0);
			}
			Choice cb = (Choice)e.getSource(); 
			Mcategory = cb.getSelectedItem();
			if(Mcategory == "의류,패션잡화") {
				indexm = 1;
				Side1 = "의류";
				Side2 = "모자";
				Side3 = "신발";
				Side.removeAll();
				Side.add(Side1);Side.add(Side2);Side.add(Side3);
			}
			else if(Mcategory == "컴퓨터가전") {
				indexm = 2;
				Side1 = "컴퓨터";
				Side2 = "냉장고";
				Side3 = "TV";
				Side.removeAll();
				Side.add(Side1);Side.add(Side2);Side.add(Side3);
			}
			else{
				indexm = 3;
				Side1 = "책 잡지";
				Side2 = "DVD";
				Side3 = "LP";
				Side.removeAll();
				Side.add(Side1);Side.add(Side2);Side.add(Side3);
			}
		}
	}
	
	
	class ChangeNation implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			Checkbox cb = (Checkbox)e.getSource(); 
			Nations = cb.getLabel();
			if(Nations == "미국") {
				won.setText("USD");
				tfp.setForeground(Color.BLUE);
				tfw.setForeground(Color.BLUE);
			}
			else if(Nations == "일본") {
				won.setText("JPY");
				tfp.setForeground(Color.RED);
				tfw.setForeground(Color.RED);
			}
			else if(Nations == "유럽") {
				won.setText("EUR");
				tfp.setForeground(Color.MAGENTA);
				tfw.setForeground(Color.MAGENTA);
			}
		}
	}
	
	class lostfocus1 extends FocusAdapter {
		public void focusLost(FocusEvent fe) {
			int att = 0;
			check = tfp.getText();

			for(int index = 0; index < check.length(); index++) {
				if(check.charAt(index) < '0' || check.charAt(index) > '9') {
					tfp.setText("");
				}
			}
		}
	}
	
	class lostfocus2 extends FocusAdapter {
		public void focusLost(FocusEvent fe) {
			int att = 0;
			check2 = tfw.getText();

			for(int index = 0; index < check2.length(); index++) {
				if((check2.charAt(index) >= '0' && check2.charAt(index) <= '9') ||  check2.charAt(index) == '.') {
					
				}
				else {
					tfw.setText("");
				}
			}
		}
	}
	
	class Save implements ActionListener {
		public void actionPerformed(ActionEvent me) {
		    try {
		    	pgram = JOptionPane.showConfirmDialog(null,"가장 최근에 누른 계산결과를 저장하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
		    	if(pgram == JOptionPane.YES_OPTION) 
		    	{
				    	if(pTotalMoney!=0) {
					        BufferedWriter out = new BufferedWriter(new FileWriter("out.txt",true));
					        Date today = new Date();
					        out.write("영수증");
					        out.write(" 저장시간 : " + today.toString()); out.newLine();out.newLine();
					        out.write("대분류 : " + Main.getSelectedItem() + "  소분류 : " + Side.getSelectedItem() + "  구입국가 : " + Nations);
					        out.newLine();
					        out.write("입력물품가격 : " + money + nationcheck); out.write("  입력물품무게 : " + Kilo + "Kg");
					        out.newLine();out.newLine();out.write("Result : ");out.newLine();
					        out.write("과세가격 : " + pMoney + "원"); out.newLine();
					        out.write("관세" + pcu + "% 적용가격 : " + pcustoms + "원  부가세" + pva + "% 적용가격 : " + pVAT + "원");
					        out.newLine();
					        out.write("총 납부 금액 : " + pTotalMoney + "원"); out.newLine(); out.newLine();
					        out.write("------------------------------------------------------------");
					        out.newLine();out.newLine();
					        out.close();
					        JOptionPane.showMessageDialog(null,"작업 폴더 안 out.txt에 저장되었어요.");
					        
				    	}
				    	else {
				    		JOptionPane.showMessageDialog(null,"먼저 계산을 해주세요!","Message",JOptionPane.ERROR_MESSAGE);
				    	}
		    	}
		    	else {
		    	}
		      } catch (IOException e) {
		          System.err.println(e); 
		          System.exit(1);
		      }

		    }
			}
}
