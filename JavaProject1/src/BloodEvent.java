import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class BloodEvent extends Frame {
	Panel p1, p2;
	Label l1, result;
	CheckboxGroup group;
	Checkbox cb1, cb2, cb3, cb4;
	Button ok;
	
	String str; // �⺻���� null
	Font f1 = new Font("Serif", Font.BOLD, 32);
	
	BloodEvent(String title) {
		super(title);

		// ����ǥ���� �տ� ������ �ְ� ���� ���, 
		// src�� bin ������ ���� ����� �κп� images ������ ����� 
		// �� �ȿ� icon.jpg �� ������ ����!
		this.setIconImage(new ImageIcon("images/icon.jpg").getImage()); // ������ ������ ����
		
		// ���̺� �κ�
		l1 = new Label("������ ����", Label.CENTER); // ���̺� ��� ����
		l1.setFont(f1);

		// ������ �г� �κ�
		p1 = new Panel(); // p1�� �⺻���̾ƿ�(FlowLayout ���)
		
		group = new CheckboxGroup();
		cb1 = new Checkbox("A", group, false); // üũ �ȵ� ���·� ����(������ư)
		cb2 = new Checkbox("B", group, false);
		cb3 = new Checkbox("AB", group, false); 
		cb4 = new Checkbox("O", group, false); 
		
		cb1.setFont(f1);
		cb2.setFont(f1);
		cb3.setFont(f1);
		cb4.setFont(f1);
		
		p1.add(cb1); p1.add(cb2); p1.add(cb3); p1.add(cb4);
	
		
		
		// ��ư, ���̺� �г� �κ�
		p2 = new Panel();
		p2.setLayout(null); // p2�� ���̾ƿ� ������(��ǥ ���)
		
		ok = new Button("Ȯ��");
		ok.setFont(f1);
		ok.setBounds(50, 10, 150, 60);
		
		
		// ok ��ư ���� �� �̺�Ʈ ó�� �κ�
		ok.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(str == null) {
					result.setText("�������� ����!");
				} else {			
					result.setText(str + "�� �̱���~!!");
				}
			}
		});	
		
		// üũ�ڽ� �̺�Ʈ ó�� �κ�
		cb1.addItemListener(new EventA());
		cb2.addItemListener(new EventA());
		cb3.addItemListener(new EventA());
		cb4.addItemListener(new EventA());
		
		
		result = new Label("", Label.CENTER); // ó������ ���ڿ� ���� ����
		result.setFont(f1);
		result.setBackground(Color.black);
		result.setForeground(Color.yellow);
		result.setBounds(250, 10, 350, 60);
		
		p2.add(ok); p2.add(result);
		
		
		
		// �����ӿ� ������Ʈ ���̱�
		add(l1); add(p1); add(p2);
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		// ������ ��ġ ����(�߾ӿ� ��ġ ��Ű��)
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�,������ ������ screenSize�� ����
		this.setBounds(screenSize.width/2-350, screenSize.height/2-200, 700, 400);
		
		this.setLayout(new GridLayout(3,1)); // ������ ���̾ƿ��� GridLayout���� ����
		setVisible(true); // ������ ȭ�鿡 ���̱�
	}
	
	class EventA implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			Checkbox cb = (Checkbox)e.getSource(); 
			str = cb.getLabel();
		}
	}
}
	
	