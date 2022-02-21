
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends Frame {
	Image img;
	
	Help(String title) {
		super(title);
		
		this.setIconImage(new ImageIcon("images/icon.jpg").getImage()); // ������ ������ ����
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("images/help.jpg");
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	
		// ������ ��ġ ����(�߾ӿ� ��ġ ��Ű��)
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�,������ ������ screenSize�� ����
		this.setBounds(screenSize.width/2-350, screenSize.height/2-350, 700, 700);

		this.setLayout(null); // ������ ���̾ƿ� ��� ����(��ǥ ���)
		setVisible(true); // ������ ȭ�鿡 ���̱�
	}

	
	// paint() ȣ�� ����
	// 1. ȭ���� ó�� ������ ��
	// 2. �ٸ� ȭ�鿡 �������ٰ� �ٽ� ������ ��
	// 3. �ּ�ȭ�ƴٰ� �ٽ� ������  ��
	public void paint(Graphics g) { // �������̵�
		g.drawImage(img, 0, 0, this);
	}
	
}




