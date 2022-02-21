import java.awt.*; // AWT ������Ʈ ����
import java.awt.event.*; // �̺�Ʈ ó�� ����

import javax.swing.ImageIcon;

class ExitWin extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}	//�ݱ� ��ư�� �������� ȣ��Ǵ� �޼ҵ�
}

public class JavaMenu extends Frame {
	
	TextField tf = new TextField();
	TextArea ta = new TextArea();
	
	Font font1 = new Font("���� ���", Font.PLAIN,12);
	Color c1 = new Color(221,234,205);  
	Color c2 = new Color(0,10,112);
	Color c6 = new Color(164,13,144);
	
	JavaMenu(String title) {
		super(title); // Frame("�ڹ�������Ʈ_ȫ�浿");
		
		this.setIconImage(new ImageIcon("images/menuc.png").getImage());
		
		tf = new TextField();
		ta = new TextArea();
		add(ta,"Center");
		add(tf,"South");
		tf.setText("201510306_������");
		tf.setForeground(c6);
		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.append("ä���� : " + tf.getText() + "\n");
				tf.setText("");
				tf.requestFocus();
				
			}
		});
		
		//���� settext�� ����
		ta.setText("�ȳ��ϼ���. �������� �ڹ� awt ������Ʈ�Դϴ�.\n"
				+ "������Ʈ���� �̺�ƮȰ�뿡 3������ �����Ǿ� �ֽ��ϴ�.\n"
				+ "�Ʒ����� �� ������Ʈ�� ���� ������ ����Ǿ��ֽ��ϴ�.\n\n\n"
				+ "ù��° ������Ʈ�� Ŀ�����Ǳ� �Դϴ�.\n"
				+ "�����ð��� ����ȭ���� �����Ͽ� ������� �ݾ����� ��ɰ� �������� �̺�Ʈ�� �߰��Ͽ����ϴ�.\n\n\n"
				+ "�ι�° ������Ʈ�� ���ΰ��� �����Դϴ�.\n"
				+ "���ΰ����� ���� + �ΰ����� �������� �ؿܿ��� ������ �����Ҷ� ���� �ݾ��� �ʰ��ϸ�\n"
				+ "�ΰ��Ǵ� ������ ���մϴ�. ���� ���� ����� ��Ȯ�� ������� �˼� ������ ������\n"
				+ "����� ǰ���� �ҹ��ϰ� 0.1kg�� �ö󰥼��� 500���� �߰��ǰ� ���α׷��� �Ͽ���\n"
				+ "�ش� ��� �ܿ��� ������ ����ϰ� �ִ��� �����߽��ϴ�.\n"
				+ "�� ���� �̸� ���� �ִ� '?' �����ܿ��� �̹�������� ���ؽ�Ʈ�� �����Ǿ��ֽ��ϴ�.\n"
				+ "���Է°� ���Է� ����ó�� �Ϸ��߽��ϴ�.\n"
				+ "��� ��ư�� �ִ� �гο��� �����ʹ�ư�� ������ ��� �������� �޸��忡 �������ִ� ����� �ֽ��ϴ�.\n"
				+ "������ �Ʒ��� �����ϴ�.\n\n"
				+ "�̱� : 200$ �̻��� ��� ���ΰ��� �ΰ�\n"
				+ "�Ϻ� : 150$ �̻��� ��� ���ΰ��� �ΰ�\n"
				+ "�������� : 150$ �̻��� ��� ���ΰ��� �ΰ�\n\n\n"
				+ "����° ������Ʈ�� �׸����Դϴ�.\n"
				+ "�޴��ٸ� ���� �� ����� ������ ���Ұ� �� ����� ���찳, ��� ����� ����� �ֽ��ϴ�.\n"
				+ "�޴��ٸ� �̿��� ���°��� ������ ��� �ܼ�â�� �ٲ� ������ ǥ�õ˴ϴ�.\n"
				+ "���콺�� ���� �ø��ų� ������ �׸��� �ִ� ���� ũ�Ⱑ ���մϴ�.\n"
				+ "������ ȭ��ǥ(ASCII��39��)�� ������ ĵ������ ������ �ٲ�ϴ�.\n\n\n"
				+ "�����մϴ�.\n\n");
		
		ta.setForeground(c2);
		ta.setEditable(false);
		ta.setBackground(c1);
		setSize(300,200);
		tf.requestFocus();
		
		MenuBar mb = new MenuBar(); // �޴��� �߰� �κ�
		
		Menu mFile = new Menu("����"); 
		MenuItem miExit = new MenuItem("�ݱ�"); 
		miExit.addActionListener(new Exit());
		mFile.add(miExit);	
		
		Menu mEvent1 = new Menu("�̺�Ʈ ����"); 
		MenuItem miEvent1_1 = new MenuItem("���콺 �̺�Ʈ"); 
		MenuItem miEvent1_2 = new MenuItem("������ �̺�Ʈ"); 
		MenuItem miEvent1_3 = new MenuItem("�α��� �̺�Ʈ"); 
		
		mEvent1.add(miEvent1_1);
		mEvent1.add(miEvent1_2);
		mEvent1.add(miEvent1_3);
		
		miEvent1_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new MouseEventTest("���콺 �̺�Ʈ ���α׷�");
			} 
		});
		
		miEvent1_2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new BloodEvent("������ ���α׷�");
			} 
		});
		
		miEvent1_3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new Login("�α���");
			} 
		});
		
		
		
		Menu mEvent2 = new Menu("�̺�Ʈ Ȱ��"); 
		MenuItem miEvent2_1 = new MenuItem("Ŀ�����Ǳ�");
		mEvent2.add(miEvent2_1);
		miEvent2_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new CoffeeMachine("Ŀ�����Ǳ�");
			} 
		});
		
		
		MenuItem miEvent2_2 = new MenuItem("���ΰ��� ����");
		mEvent2.add(miEvent2_2);
		miEvent2_2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//new Login("�α���");
				new Psychological_test("���ΰ��� ����");
			} 
		});
		
		MenuItem miEvent2_3 = new MenuItem("�׸���");
		mEvent2.add(miEvent2_3);
		miEvent2_3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new Paintpan("�׸���");
			} 
		});
		
		Menu mHelp = new Menu("����"); 
		MenuItem miHelp = new MenuItem("���α׷� ����"); 
		mHelp.add(miHelp);
		
		miHelp.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new Help("���α׷� ����");
			} 
		});
		
		
		// �޴��ٿ� �޴� ���̱�
		mb.add(mFile);
		mb.add(mEvent1);
		mb.add(mEvent2);
		mb.add(mHelp);

		
		// ������ ���� �κ�
		// ������ �߾ӿ� ��ġ��Ű��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-300, screenSize.height/2-250, 600, 500);

		this.setBackground(Color.gray);
		this.addWindowListener(new ExitWin());
		this.setMenuBar(mb); // �����ӿ� �޴��� ���̱�
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaMenu("�ڹ�������Ʈ_������");
	}
}
