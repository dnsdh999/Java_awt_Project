import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class  Paintpan extends Frame
{
	Panel p1,p2;
	MenuBar mb;
	Menu mPaint, mDraw, mColor, mErase;
	MenuItem Eraser, EraseAll, miBlack, miGreen, miRed, miBlue,miOval, miRect, mi3DRect ;
	MyCanvas can;
	String c;
	Color c1 = new Color(204,189,253);  
	int i;
	
	public Paintpan(String title){
		super(title);
		this.setIconImage(new ImageIcon("images/paint-brush.png").getImage());
		
		//메뉴바와 메뉴들 추가
		mb = new MenuBar(); 
		
		mPaint = new Menu("그림 그리기"); 
		miOval = new MenuItem("Oval"); 
		miRect = new MenuItem("Rect"); 
		mi3DRect = new MenuItem("3DRect"); 
		
		mPaint.add(miOval);	mPaint.add(miRect);	 mPaint.add(mi3DRect);	
		
		mColor = new Menu("펜 색깔"); 
		miBlack = new MenuItem("검정");
		miGreen = new MenuItem("초록");
		miRed = new MenuItem("빨강");
		miBlue = new MenuItem("파랑");
		mColor.add(miBlack);mColor.add(miGreen);mColor.add(miRed);mColor.add(miBlue);
		
		mErase = new Menu("지우기"); 
		Eraser = new MenuItem("지우개"); 
		EraseAll = new MenuItem("모두 지우기"); 
		mErase.add(Eraser); mErase.add(EraseAll);
		
		mb.add(mPaint);
		mb.add(mColor);
		mb.add(mErase);

		//패널과 캔버스 추가
		p1=new Panel();
		p1.setBackground(Color.darkGray);
		p1.setLayout(null);

		add(p1);
		
		can=new MyCanvas();

		can.setBounds(0, 0, 500, 450);;
		can.setBackground(Color.white);	i=0;
		p1.add(can);
		
		miOval.addActionListener(new MyHandler());
		miRect.addActionListener(new MyHandler());
		mi3DRect.addActionListener(new MyHandler());
		
		miRed.addActionListener(new MyHandler());
		miGreen.addActionListener(new MyHandler());
		miBlue.addActionListener(new MyHandler());
		miBlack.addActionListener(new MyHandler());

		Eraser.addActionListener(new MyHandler());
		EraseAll.addActionListener(new MyHandler());

		can.addMouseMotionListener(new MyHandler());
		can.addMouseWheelListener(new wheel());
		
		this.setMenuBar(mb);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비,높이의 정보를 screenSize에 대입
		this.setBounds(screenSize.width/2-250, screenSize.height/2-250, 500, 500);	
		
		can.addKeyListener(new Ke1y());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		this.setResizable(false);
		this.setVisible(true); 
	}

	class MyHandler extends MouseMotionAdapter 
	implements ActionListener
{

	public void mouseDragged(MouseEvent e){
		can.x=e.getX();
		can.y=e.getY();
		can.repaint();
	}//-----
	public void mouseWheelMoved(MouseEvent e){
		can.x=e.getX();
		can.y=e.getY();
		can.repaint();
	}
	public void actionPerformed(ActionEvent e){
		MenuItem cb = (MenuItem)e.getSource(); 
		c = cb.getLabel();
		System.out.println(c);
		can.flag=0;
		if(c=="검정"){
			can.cr=Color.black;
		}else if(c=="빨강"){
			can.cr=Color.red;
		}
		else if(c=="초록"){
			can.cr=Color.green;
		}else if(c=="파랑"){
			can.cr=Color.blue;
		}
		else if(c=="Oval") {
			can.paint = 0;
		}else if(c=="Rect") {
			can.paint = 1;
		}else if(c=="3DRect") {
			can.paint = 2;
		}
		else if(c=="지우개"){
			can.cr=can.getBackground(); //배경색을 칠해서 지우기
		}else if(c=="모두 지우기"){
			can.flag=1;
			can.repaint();
		}
	}
	
}//마우스휠로 글자포인트 전환
	class wheel implements MouseWheelListener {
		public void mouseWheelMoved(MouseWheelEvent e) {
			if(e.getWheelRotation() == -1) {
				System.out.println("현재 글자 포인트 : " + can.w);
				if(can.w<50) {
				can.w++;
				can.h++;
				}
			}
			else if(e.getWheelRotation()==1) {
				System.out.println("현재 글자 포인트 : " + can.w);
				if(can.w >3){
					can.w--;
					can.h--;
				}
			}
		}
	}
	
	class Ke1y extends KeyAdapter{
		//화살표로 글자포인트 전환
		public void keyReleased(KeyEvent e) {

			if(e.getKeyCode()==39) {
				i++;
				if(i==1) {
					can.setBackground(Color.gray);
				}
				else if(i==2) {
					can.setBackground(Color.black);
				}
				else if(i==3) {
					can.setBackground(Color.white);
					i=0;
				}
			}
		}
	}
	

}

class MyCanvas extends Canvas
{
	int x=-13, y=-13, w=7, h=7;
	Color cr=Color.black;
	int flag,paint = 0;
	
	public void paint(Graphics g){
		if(flag==0){ 
			if(paint == 0) {
				g.setColor(cr);
				g.fillOval(x, y, w, h);
			}
			else if(paint == 1) {
				g.setColor(cr);
				g.fillRect(x, y, w, h);
			}
			else if(paint == 2) {
				g.setColor(cr);
				g.fill3DRect(x, y, w, h, true);
			}
		}else if(flag==1){
			g.clearRect(0,0,500, 450);
			flag = 0;
		}
	}
	public void update(Graphics g){
		paint(g);
	}

}
