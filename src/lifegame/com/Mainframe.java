package lifegame.com;

//import main.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Mainframe {
	Panel chessboard=new Panel();
	int[][] anumyuan=new int[42][42];
	int count=0;
	public void Mainframe() {
		JFrame frame=new JFrame();
		frame.setTitle("生命游戏");
		frame.setSize(500, 800);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		chessboard.setSize(400, 400);
		chessboard.setBackground(Color.white);
		chessboard.setLayout(null);
		chessboard.setBounds(45, 30, 400, 400);
		
		JLabel l1=new JLabel("长度");
		JTextField te1=new JTextField(20);
		JLabel l2=new JLabel("宽度");
		JTextField te2=new JTextField(20);
		JLabel l3=new JLabel("当前代数");
		JTextField te3=new JTextField(20);
		te1.setSize(50, 20);
		te2.setSize(50, 20);
		te3.setSize(50, 20);
		l1.setSize(50, 10);
		l2.setSize(50, 10);
		l3.setSize(80, 10);
		l1.setBounds(65, 500, 50, 20);
		te1.setBounds(65, 540, 50, 20);
		te1.setEnabled(true);
		l2.setBounds(185, 500, 50, 20);
		te2.setBounds(185, 540, 50, 20);
		te2.setEnabled(true);
		l3.setBounds(315, 500, 80, 20);
		te3.setBounds(315, 540, 50, 20);
		te3.setEnabled(false);
		te3.setText(Integer.toString(count));
		
		
		JButton b1=new JButton("随机初始化");
		JButton b2=new JButton("代数清零");
		JButton b3=new JButton("细胞清零");
		JButton b4=new JButton("繁衍");
		JButton b5=new JButton("自然生长");
		b1.setSize(110, 20);
		b2.setSize(110, 20);
		b3.setSize(110, 20);
		b4.setSize(110, 20);
		b5.setSize(90, 20);
		b1.setBounds(65, 610, 110, 20);
		b2.setBounds(295, 610, 110, 20);
		b3.setBounds(65, 650, 110, 20);
		b4.setBounds(295, 650, 110, 20);
		b5.setBounds(190, 690, 90, 20);
		b1.addActionListener(new b1(frame,te1,te2));
		b2.addActionListener(new b2(te3));
		b3.addActionListener(new b3(te1,te2));
		b4.addActionListener(new b4(anumyuan,te1,te2,te3));
		b5.addActionListener(new b5(anumyuan,te1,te2,te3));
		
		frame.add(chessboard);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(te1);
		frame.add(te2);
		frame.add(te3);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		
		frame.setVisible(true);
		
	}
	public class b1 implements ActionListener {
		public JTextField t1 = new JTextField();
	    public JTextField t2 = new JTextField();
	    public JFrame frame=new JFrame();
		String s1,s2;
		int chang,kuan;
		JButton[][] a=new JButton[40+2][40+2];
		
		b1(JFrame frame,JTextField te1,JTextField te2){
			this.frame=frame;
			this.t1=te1;
			this.t2=te2;
		}
			
		public void actionPerformed(ActionEvent e) {
			s1=t1.getText();
			s2=t2.getText();
			chang=Integer.parseInt(s1);
			kuan=Integer.parseInt(s2);
			int i,j;
			chessboard.removeAll();
			for( i=1;i<chang+1;i++) {
				for( j=1;j<kuan+1;j++) {
					a[i][j]=new JButton();
					a[i][j].setSize(10, 10);
					a[i][j].setBackground(Color.white);
					//a[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
					a[i][j].setLocation(i*10, j*10);
					a[i][j].setEnabled(true);
					chessboard.add(a[i][j]);
					chessboard.repaint();
					a[i][j].addActionListener(new action(i,j));
					
				}
				 
			}
			
		}
		
		public class action implements ActionListener{
			int i1,j1;
			action(int i,int j){
				this.i1=i;
				this.j1=j;
			}
			public void actionPerformed(ActionEvent e) {
				a[i1][j1].setBackground(Color.black);
				anumyuan[i1][j1]=1;
				}			
		}
	}
	
		
	public class b4 implements ActionListener{
		public JTextField t1=new JTextField();
		public JTextField t2=new JTextField();
		public JTextField t3=new JTextField();
		public JFrame frame=new JFrame();
		String s1,s2;
		int chang,kuan;
		int [][] yuan=new int[42][42];
		int [][] xian=new int[42][42];
		JButton[][] a=new JButton[40+2][40+2];
			
		b4(int[][] a,JTextField te1,JTextField te2,JTextField te3){
			this.t1=te1;
			this.t2=te2;
			this.t3=te3;
			this.yuan=a;
		}
			
		public void actionPerformed(ActionEvent e) {
			s1=t1.getText();
			s2=t2.getText();
			chang=Integer.parseInt(s1);
			kuan=Integer.parseInt(s2);
			Traverse_judge b1=new Traverse_judge(chang+2,kuan+2);
			xian=b1.traverse(yuan);
			
			chessboard.removeAll();
			for(int i=1;i<chang+1;i++) {
				for(int j=1;j<kuan+1;j++) {
					a[i][j]=new JButton();
					a[i][j].setSize(10, 10);
					if(xian[i][j]==1)
					    a[i][j].setBackground(Color.black);
					else
						a[i][j].setBackground(Color.white);
					a[i][j].setLocation(i*10, j*10);
					chessboard.add(a[i][j]);
					chessboard.repaint();
					a[i][j].setEnabled(false);
					
				}
				 
			}
			
			count++;
			t3.setText(Integer.toString(count));
			System.out.println();
			for(int i=1;i<chang+1;i++) {
				 for(int j=1;j<kuan+1;j++) {
					anumyuan[i][j]=xian[i][j];
				 }
				 System.out.println();
			 }
			
		}
		
	}
	
	public class b2 implements ActionListener{
		public JTextField t3=new JTextField();
		b2(JTextField te3){
			this.t3=te3;
		}
		
		public void actionPerformed(ActionEvent e) {
			count=0;
			t3.setText(Integer.toString(count));
		}
	}
	
	public class b3 implements ActionListener{
		public JTextField t1=new JTextField();
		public JTextField t2=new JTextField();
		JButton[][] a=new JButton[40+2][40+2];
		String s1,s2;
		int chang,kuan;
		b3(JTextField te1,JTextField te2){
			this.t1=te1;
			this.t2=te2;
		}
		
		public void actionPerformed(ActionEvent e) {
			s1=t1.getText();
			s2=t2.getText();
			chang=Integer.parseInt(s1);
			kuan=Integer.parseInt(s2);
			chessboard.removeAll();
			for(int i=1;i<chang+1;i++) {
				for(int j=1;j<kuan+1;j++) {
					a[i][j]=new JButton();
					a[i][j].setSize(10, 10);
					a[i][j].setBackground(Color.white);
					a[i][j].setLocation(i*10, j*10);
					chessboard.add(a[i][j]);
					chessboard.repaint();
					a[i][j].setEnabled(false);
					
				}
				 
			}
		}
	}
	
	public class b5 implements ActionListener{
		public JTextField t1=new JTextField();
		public JTextField t2=new JTextField();
		public JTextField t3=new JTextField();
		public JFrame frame=new JFrame();
		String s1,s2;
		int chang,kuan;
		int [][] yuan=new int[42][42];
		int [][] xian=new int[42][42];
		JButton[][] a=new JButton[40+2][40+2];
			
		b5(int[][] a,JTextField te1,JTextField te2,JTextField te3){
			this.t1=te1;
			this.t2=te2;
			this.t3=te3;
			this.yuan=a;
		}
			
		public void actionPerformed(ActionEvent e) {
			new Thread() {
				@Override
				public void run() {
					super.run();
					s1=t1.getText();
					s2=t2.getText();
					chang=Integer.parseInt(s1);
					kuan=Integer.parseInt(s2);
					Traverse_judge b1=new Traverse_judge(chang+2,kuan+2);
					do {
					xian=b1.traverse(yuan);
					
					chessboard.removeAll();
					for(int i=1;i<chang+1;i++) {
						for(int j=1;j<kuan+1;j++) {
							a[i][j]=new JButton();
							a[i][j].setSize(10, 10);
							if(xian[i][j]==1)
							    a[i][j].setBackground(Color.black);
							else
								a[i][j].setBackground(Color.white);
							a[i][j].setLocation(i*10, j*10);
							chessboard.add(a[i][j]);
							chessboard.repaint();
							a[i][j].setEnabled(false);
							
						}
						 
					}
					
					count++;
					t3.setText(Integer.toString(count));
					for(int i=1;i<chang+1;i++) {
						 for(int j=1;j<kuan+1;j++) {
							anumyuan[i][j]=xian[i][j];
						 }
					 }
					try {
						Thread.sleep(100*10);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}while(true);
					
				}
			}.start();
		}
	}
}
