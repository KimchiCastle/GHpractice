package mymaim;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ä�����α׷�_��ġ�� extends JFrame {

	//��Ʈ ��������
	Font font = new Font("����ü", Font.BOLD, 15);
	
	//ä�� ���â ��������
	JTextArea jta_display;
	
	//ä�� �Է�â
	JTextField jtf_message;
	//�г��� �Է�â
	JTextField jtf_nickname;
	
	
	//�޺��ڽ� ���� �μ��� �迭
	String [] buser_name_array = {"�λ��", "��ȹ��", "�ѹ���", "������", "��ü ����" };
	// �迭�� �Ҵ��� IP�ּ�(Multicast) �迭, ��ü������Broadcast��
	String [] buser_addr_array = {"224.0.0.1", "224.0.0.2", "224.0.0.3", "224.0.0.4", "255.255.255.255"}; 
	
	//�μ� �׷켳�� �޺��ڽ�
	JComboBox<String> jcb_buser;
	
	String buser = "";
	
	//��ȭ�� ����
	String nickname = "��ġ��";
	
	//����
	MulticastSocket socket;
	
	//��Ʈ��ũ �����������
	boolean bConnect = false; 
	
	
	
	//ArrayList�� ������ ������
	//�׷츮��Ʈ
	List<String> groupList = new ArrayList<String>();
	//�μ��� ����Ʈ
	List<String> buser_name_list = new ArrayList<String>();
	//�μ��� ����Ǿ��ִ���?
	
	
	
	//������â
	JList<String> jlist_group = new JList<String>();
	
	

	
	public ä�����α׷�_��ġ��() {
		// TODO Auto-generated constructor stub
		super("��Ƽĳ��Ʈ ä�����α׷�");

		//���ȭ�� �ʱ�ȭ
		init_display();
		
		//�Է�â �ʱ�ȭ
		init_inputs();
		
		//�׷� ���â �ʱ�ȭ
		init_group_list();
		
		//�޼��� ����� ���� KeyEvent �ʱ�ȭ
		init_key_event();
		
		init_socket();
		
		
		//��ġ		 x	  y
		this.setLocation(200, 100);

		//ũ��
		//��ŷ
		this.setSize(400,400);
		pack();
		
		
		//�����ֱ� ���������� �����ִ� �޼ҵ�
		this.setVisible(true);

		//����							
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	
	//��Ʈ��ũ ����� ���� ���� ����
	private void init_socket() {
		// TODO Auto-generated method stub
		
		try {
			
			socket = new MulticastSocket(6500);
			
			
			new Thread() {
				
				public void run() {
					
					while(true) read_message();					
				};			
				
			}.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void read_message() {
		// TODO Auto-generated method stub
		
		try {

			byte[] read_buff = new byte[512];
			// �о�� �����͸� ���� ���۸� ����
			DatagramPacket dp = new DatagramPacket(read_buff, read_buff.length);
			
			socket.receive(dp);

			//������ �˾Ƴ���
			InetAddress you_ia = dp.getAddress();
			
			//System.out.println(you_ia);
			
			
			String read_data = new String(dp.getData()).trim();

			
			String[] read_data_array = read_data.split("#");

			// ��¸޽��� ����
			String display_message = String.format("[%s]�� : %s\r\n", read_data_array[0], read_data_array[1]);

			jta_display.append(display_message);

			int position = jta_display.getDocument().getLength();// ��ü���� ���ϱ�
			jta_display.setCaretPosition(position);

			//�˾Ƴ� ip �ܼ�â�� ����
			System.out.printf("[%s]%s", you_ia.getHostAddress(), display_message);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}

	private void init_key_event() {
		// TODO Auto-generated method stub
	
		jtf_message.addKeyListener( new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//super.keyPressed(e);
				
				int key = e.getKeyCode();
				
				if(key == KeyEvent.VK_ENTER) {
					
					send_message();
					
					
				}
				
				
			}
			
			
		});
	}

	protected void send_message() {
		// TODO Auto-generated method stub
		
		//�޼��� �о����
		String message = jtf_message.getText().trim();
		nickname = jtf_nickname.getText().trim();
		
		/*
		 * if (bConnect == false) { JOptionPane.showMessageDialog(this,
		 * "���� �׷쿡 �����ϼ���."); }
		 */
		if(bConnect==false) {
			JOptionPane.showMessageDialog(this, "�׷��� �����ϼ���");
			return;
		}
		
		if(message.isEmpty()) {
			JOptionPane.showMessageDialog(this, "�޼����� �Է��ϼ���.");
			jtf_message.setText("");
			return;
		}
		
		if(nickname.isEmpty()) {
			JOptionPane.showMessageDialog(this, "�г����� �����ϼ���.");
			return;
		}
		
		
		
		//��Ʈ��ũ �۾�
		//������ �μ��� �ε�����
		int index = jcb_buser.getSelectedIndex();
		String ip = buser_addr_array[index];
		
		try {
			
			
			InetAddress ia = InetAddress.getByName(ip);
			
			String send_data = String.format("%s#%s", nickname, message);
			
			byte [] send_bytes = send_data.getBytes();
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 6500);
			
			socket.send(dp);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����� �޼��� �ʱ�ȭ
		jtf_message.setText("");
		
		
	}

	private void init_group_list() {
		// TODO Auto-generated method stub
		
		JPanel p = new JPanel(new BorderLayout());
		
		JLabel jlb_list = new JLabel("  �׷���");
		jlb_list.setPreferredSize(new Dimension(100,30));
		
		
		jlb_list.setFont(font);
		jlist_group.setFont(font);
		
		JScrollPane jsp = new JScrollPane(jlist_group);
		jsp.setPreferredSize(new Dimension(100,0));
		
		
		p.add(jlb_list,"North");
		p.add(jsp);
		
		
		this.add(p,"West");
	}

	private void init_inputs() {
		// TODO Auto-generated method stub
		
		JPanel p1 = new JPanel(new GridLayout(3,1));
		
		//1��°�� �޺��ڽ� ����
		jcb_buser = new JComboBox<String>(buser_name_array);
		jcb_buser.setFont(font);
		
		//���� Ż���ư ����
		JPanel p2 = new JPanel(new GridLayout(1,2));
		
		JButton jbt_join = new JButton("����");
		JButton jbt_leave = new JButton("Ż��");
		jbt_join.setFont(font);
		jbt_leave.setFont(font);
		
		
		p2.add(jbt_join);
		p2.add(jbt_leave);
		
		//�޼��� �Է�â,�г���â ����
		
		JPanel p3 = new JPanel(new BorderLayout());
		jtf_nickname = new JTextField("�г���");
		jtf_message = new JTextField();
		
		jtf_nickname.setPreferredSize(new Dimension(100,0));
		
		jtf_nickname.setFont(font);
		jtf_message.setFont(font);
		
		p3.add(jtf_nickname, "West");
		p3.add(jtf_message);
		
		
		//��ư �ֱ�
		p1.add(jcb_buser);
		p1.add(p2);
		p1.add(p3);
		
	
		this.add(p1,"South");
		
		
		// �׷��޺��ڽ� �̺�Ʈó��
		/*
		jcb_buser.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {

					buser = (String) jcb_buser.getSelectedItem();

					System.out.println(buser);
				}

			}

		});
		 */
		
		
		//��ư�̺�Ʈ ó��
		jbt_join.addActionListener( e -> { on_button_join(); } );
		jbt_leave.addActionListener( e -> { on_button_leave(); } );
		
		
		
	}
	
	protected void on_button_join() {
		
		//System.out.println(groupList.size());
		
		int index = jcb_buser.getSelectedIndex();
		
		String buser_name = buser_name_array[index];
		String ip		  = buser_addr_array[index];
		
		//System.out.println(buser_name + ip);
		
		if(groupList.contains(ip)) {
			JOptionPane.showMessageDialog(this, "�̹� ���ԵǾ� �ִ� �ּ��Դϴ�.");
			return;
		}
		
		if(ip.equals("255.255.255.255")) {
			JOptionPane.showMessageDialog(this, "������ �� ���� �ּ��Դϴ�.");
			return;
		}
		
		bConnect = true;
		
		
		//��Ʈ��ũ �ֱ�
		
		try {
			InetAddress ia = InetAddress.getByName(ip);
			socket.joinGroup(ia);
			
			//���Ե� �ּҸ� ArrayList�ִ´�
		
			
			groupList.add(ip);
			buser_name_list.add(buser_name);
			
			//�׷�â ����
			update_group_list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	protected void on_button_leave() {
		
		
		
		int index = jlist_group.getSelectedIndex();
		
		
		//�׷���â���� �������� �ʾ������
		if( index == -1 ) {
			
			JOptionPane.showMessageDialog(this, "Ż���� �׷��� �����ϼ���.");
			return;
			
		}
		
		String ip = groupList.get(index); 
		//Ż��� ��Ȯ��
		int result = JOptionPane.showConfirmDialog(this, 
                "�׷쿡�� Ż���Ͻðڽ��ϱ�?",
                "�׷�Ż��", 
                JOptionPane.YES_NO_OPTION);
		
		if( result != JOptionPane.YES_OPTION) return;
		
		
		
		
		
		//��Ʈ��ũ �۾�
		
		try {
			InetAddress ia = InetAddress.getByName(ip);
			socket.leaveGroup(ia);
			
			groupList.remove(index);
			
			buser_name_list.remove(index);
			
			//System.out.println(groupList.size());
			
			//����ȭ�� ����
			update_group_list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		  if(groupList.size() == 0) { bConnect = false; }
		 
		
		
		
	}
	
	private void update_group_list() {
		// TODO Auto-generated method stub
		
	
		
		//ArrayList -> Array����
		String [] group_array = new String[buser_name_list.size()];
		buser_name_list.toArray(group_array);
				
		jlist_group.setListData(group_array);
		
	}

	
	
	private void init_display() {
		// TODO Auto-generated method stub
		
		jta_display = new JTextArea();
		
		//���â ��Ʈ����
		jta_display.setFont(font);
		
		//��ũ�� ���̱�
		JScrollPane jsp = new JScrollPane(jta_display);
		//ũ��
		jsp.setPreferredSize(new Dimension(400, 400));
		
		this.add(jsp);
		
		//���â �б��������� ����
		jta_display.setEditable(false);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ä�����α׷�_��ġ��();
	}

}
