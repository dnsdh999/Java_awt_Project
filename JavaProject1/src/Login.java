import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Login extends Frame {
	Label lid;
	Label lpwd;
	TextField tfld;
	TextField tfPwd;
	Button ok;
	Login(String title){
		super(title);
		
		lid = new Label("ID :", Label.RIGHT);
		lpwd = new Label("Password :", Label.RIGHT);
		
		tfld = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');
		
		ok = new Button("OK");
		
		tfld.addActionListener(new EventHandler());
		tfPwd.addActionListener(new EventHandler());
		ok.addActionListener(new EventHandler());
		
		setLayout(new FlowLayout());
		add(lid);
		add(tfld);
		add(lpwd);
		add(tfPwd);
		add(ok);
		this.setBounds(400, 400, 450, 75);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String id = tfld.getText();
			String password = tfPwd.getText();
			if(!id.equals("nam")) {
				JOptionPane.showMessageDialog(null, "�Է��Ͻ� id�� ��ȿ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				tfld.requestFocus();
				tfld.selectAll();
			}
			else if (!password.equals("1234")) {
				JOptionPane.showMessageDialog(null, "�Է��Ͻ� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.");
				tfPwd.requestFocus();
				tfPwd.selectAll();
			}
			else {
				JOptionPane.showMessageDialog(null, "���������� �α��� �Ǿ����ϴ�.");
				dispose();
				new MouseEventTest(id + "���� ���콺�̺�Ʈ");
			}
			
		}
	}
	
}

