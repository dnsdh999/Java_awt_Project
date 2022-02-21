import java.awt.*; // ������Ʈ, �����̳�, �޴� ����ϱ� ����
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class MouseEventTest extends Frame {
	Label location;
	Font f1 = new Font("Serif", Font.BOLD, 25);
	
	MouseEventTest(String title) {
		super(title);
		
		// ���̺� ���� �κ�
		location = new Label("Mouse Pointer Location : ");
		location.setBounds(20, 80, 430, 50);
		location.setBackground(Color.gray);
		location.setFont(f1);
				
		// �̺�Ʈ ó�� �κ�
		this.addMouseMotionListener(new EventMouse());
		
		// ������ �ݱ� ��ư ������ �����ϴ� �κ�!
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			} 
		});
		
		// ������ ���� �κ�
		// ������ �߾ӿ� ��ġ��Ű��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-350, screenSize.height/2-250, 700, 500);

		this.setLayout(null); // ������ ���̾ƿ� ��� ����(��ǥ ���)
		this.add(location); // �����ӿ� Label ���̱�
		this.setVisible(true); // ������ ȭ�鿡 ���̱�
 	}

	class EventMouse extends MouseMotionAdapter {
		public void mouseMoved(MouseEvent e) {
			location.setText("Mouse Pointer Location : (" + e.getX() + ", " + e.getY() + ")");
		}
	}

}
