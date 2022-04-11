package prac;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class �ֻ���2 extends JFrame {

	JButton button;
	JTextArea jta_display;

	public �ֻ���2() {
		// TODO Auto-generated constructor stub

		super("�ֻ���������");

		init_display(); // pack���� �����ϸ� preferredsize�� ������ �ȵ�
		init_button();
		// init_algorithm();

		this.setLocation(600, 300); // ���� super���� this�� ���� ��
		pack();
		this.setVisible(true);// �����ֱ� �̰� ���ϸ� ������â �Ⱥ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// close������ ��� �����Ұų�

	}

	private void init_display() {
		// TODO Auto-generated method stub

		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		jsp.setPreferredSize(new Dimension(200, 200));

		this.add(jsp, "Center");

	}

	private void init_button() {
		// TODO Auto-generated method stub

		JPanel p = new JPanel(new BorderLayout());
		// �׸��� : ĭ�� ������ / ���� : ĭ ũ�� ���� ����
		button = new JButton("�ֻ��� ��");

		p.add(button);
		this.add(p, "South");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				on_button();

			}
		});

	}

	protected void on_button() {
		// TODO Auto-generated method stub

		int[] dice = new int[3];
		Random random = new Random();
		int money = 1000;

		boolean bTrue = true;
		int dice_same = 0;
		int dice_min = 0;
		int count = 0;

		for (int i = 0; i < dice.length; i++) {

			int su = random.nextInt(6) + 1;
			dice[i] = su;
		}

		for (int i = 0; i < dice.length; i++) {
			for (int k = i + 1; k < dice.length; k++) { // 4 3 5

				if (dice[i] > dice[k]) {
					dice_min = dice[k];
					dice[i] = dice[k];
					dice[k] = dice_min;
				}
			}

		}

//		System.out.println(dice[0]);
//		System.out.println(dice[1]);
//		System.out.println(dice[2]);

		for(int i=0; i<dice.length; i++) {
			for(int j=i+1; j<dice.length; j++) {
				
				if(dice[i]==dice[j]) {
					dice_same = dice[i];
					count++;
				}
			}
			}
		
		
		
		
		
		
		switch(count) {
		
		case 0  : money = dice[2]*100;
		
		jta_display.setText(Arrays.toString(dice)+String.format("[%d]",money));
		
		break;
		
		case 1 : money = dice_same*100 + 1000;
		
		jta_display.setText(Arrays.toString(dice)+String.format("[%d]",money));
		
		break;
		
		default : money = dice_same * 1000 + 10000;
		
		jta_display.setText(Arrays.toString(dice)+String.format("[%d]",money));
		
		break;
		
		}
		
		
				
		//jta_display.setText(String.format();
		
		//jta_display.setText(Arrays.toString(dice)+String.format("[%d]",money));
		
		// String dice_su = String.format("�ֻ��� >> %s %s %s\r\n
		// ",dice[0],dice[1],dice[2]);
		//jta_display.setText("1212 \n dsadsadasds");
		
		//jta_display.setText(String.format("[%d]",money));	
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new �ֻ���2();

	}

}
