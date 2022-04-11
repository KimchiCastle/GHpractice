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

public class 채팅프로그램_김치성 extends JFrame {

	//폰트 전역변수
	Font font = new Font("굴림체", Font.BOLD, 15);
	
	//채팅 출력창 전역변수
	JTextArea jta_display;
	
	//채팅 입력창
	JTextField jtf_message;
	//닉네임 입력창
	JTextField jtf_nickname;
	
	
	//콤보박스 안의 부서명 배열
	String [] buser_name_array = {"인사부", "기획부", "총무부", "영업부", "전체 전송" };
	// 배열에 할당할 IP주소(Multicast) 배열, 전체전송은Broadcast로
	String [] buser_addr_array = {"224.0.0.1", "224.0.0.2", "224.0.0.3", "224.0.0.4", "255.255.255.255"}; 
	
	//부서 그룹설정 콤보박스
	JComboBox<String> jcb_buser;
	
	String buser = "";
	
	//대화명 설정
	String nickname = "김치성";
	
	//소켓
	MulticastSocket socket;
	
	//네트워크 연결상태정보
	boolean bConnect = false; 
	
	
	
	//ArrayList로 관리할 데이터
	//그룹리스트
	List<String> groupList = new ArrayList<String>();
	//부서명 리스트
	List<String> buser_name_list = new ArrayList<String>();
	//부서에 연결되어있는지?
	
	
	
	//목록출력창
	JList<String> jlist_group = new JList<String>();
	
	

	
	public 채팅프로그램_김치성() {
		// TODO Auto-generated constructor stub
		super("멀티캐스트 채팅프로그램");

		//출력화면 초기화
		init_display();
		
		//입력창 초기화
		init_inputs();
		
		//그룹 목록창 초기화
		init_group_list();
		
		//메세지 출력을 위한 KeyEvent 초기화
		init_key_event();
		
		init_socket();
		
		
		//위치		 x	  y
		this.setLocation(200, 100);

		//크기
		//패킹
		this.setSize(400,400);
		pack();
		
		
		//보여주기 가시적으로 보여주는 메소드
		this.setVisible(true);

		//종료							
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	
	//네트워크 통신을 위한 소켓 생성
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
			// 읽어온 데이터를 넣을 버퍼를 지정
			DatagramPacket dp = new DatagramPacket(read_buff, read_buff.length);
			
			socket.receive(dp);

			//아이피 알아내기
			InetAddress you_ia = dp.getAddress();
			
			//System.out.println(you_ia);
			
			
			String read_data = new String(dp.getData()).trim();

			
			String[] read_data_array = read_data.split("#");

			// 출력메시지 생성
			String display_message = String.format("[%s]님 : %s\r\n", read_data_array[0], read_data_array[1]);

			jta_display.append(display_message);

			int position = jta_display.getDocument().getLength();// 전체길이 구하기
			jta_display.setCaretPosition(position);

			//알아낸 ip 콘솔창에 띄우기
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
		
		//메세지 읽어오기
		String message = jtf_message.getText().trim();
		nickname = jtf_nickname.getText().trim();
		
		/*
		 * if (bConnect == false) { JOptionPane.showMessageDialog(this,
		 * "먼저 그룹에 가입하세요."); }
		 */
		if(bConnect==false) {
			JOptionPane.showMessageDialog(this, "그룹을 가입하세요");
			return;
		}
		
		if(message.isEmpty()) {
			JOptionPane.showMessageDialog(this, "메세지를 입력하세요.");
			jtf_message.setText("");
			return;
		}
		
		if(nickname.isEmpty()) {
			JOptionPane.showMessageDialog(this, "닉네임을 설정하세요.");
			return;
		}
		
		
		
		//네트워크 작업
		//선택한 부서의 인덱스값
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
		
		//출력후 메세지 초기화
		jtf_message.setText("");
		
		
	}

	private void init_group_list() {
		// TODO Auto-generated method stub
		
		JPanel p = new JPanel(new BorderLayout());
		
		JLabel jlb_list = new JLabel("  그룹목록");
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
		
		//1번째줄 콤보박스 생성
		jcb_buser = new JComboBox<String>(buser_name_array);
		jcb_buser.setFont(font);
		
		//가입 탈퇴버튼 생성
		JPanel p2 = new JPanel(new GridLayout(1,2));
		
		JButton jbt_join = new JButton("가입");
		JButton jbt_leave = new JButton("탈퇴");
		jbt_join.setFont(font);
		jbt_leave.setFont(font);
		
		
		p2.add(jbt_join);
		p2.add(jbt_leave);
		
		//메세지 입력창,닉네임창 생성
		
		JPanel p3 = new JPanel(new BorderLayout());
		jtf_nickname = new JTextField("닉네임");
		jtf_message = new JTextField();
		
		jtf_nickname.setPreferredSize(new Dimension(100,0));
		
		jtf_nickname.setFont(font);
		jtf_message.setFont(font);
		
		p3.add(jtf_nickname, "West");
		p3.add(jtf_message);
		
		
		//버튼 넣기
		p1.add(jcb_buser);
		p1.add(p2);
		p1.add(p3);
		
	
		this.add(p1,"South");
		
		
		// 그룹콤보박스 이벤트처리
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
		
		
		//버튼이벤트 처리
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
			JOptionPane.showMessageDialog(this, "이미 가입되어 있는 주소입니다.");
			return;
		}
		
		if(ip.equals("255.255.255.255")) {
			JOptionPane.showMessageDialog(this, "가입할 수 없는 주소입니다.");
			return;
		}
		
		bConnect = true;
		
		
		//네트워크 넣기
		
		try {
			InetAddress ia = InetAddress.getByName(ip);
			socket.joinGroup(ia);
			
			//가입된 주소를 ArrayList넣는다
		
			
			groupList.add(ip);
			buser_name_list.add(buser_name);
			
			//그룹창 갱신
			update_group_list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	protected void on_button_leave() {
		
		
		
		int index = jlist_group.getSelectedIndex();
		
		
		//그룹목록창에서 선택하지 않았을경우
		if( index == -1 ) {
			
			JOptionPane.showMessageDialog(this, "탈퇴할 그룹을 선택하세요.");
			return;
			
		}
		
		String ip = groupList.get(index); 
		//탈퇴시 재확인
		int result = JOptionPane.showConfirmDialog(this, 
                "그룹에서 탈퇴하시겠습니까?",
                "그룹탈퇴", 
                JOptionPane.YES_NO_OPTION);
		
		if( result != JOptionPane.YES_OPTION) return;
		
		
		
		
		
		//네트워크 작업
		
		try {
			InetAddress ia = InetAddress.getByName(ip);
			socket.leaveGroup(ia);
			
			groupList.remove(index);
			
			buser_name_list.remove(index);
			
			//System.out.println(groupList.size());
			
			//우측화면 갱신
			update_group_list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		  if(groupList.size() == 0) { bConnect = false; }
		 
		
		
		
	}
	
	private void update_group_list() {
		// TODO Auto-generated method stub
		
	
		
		//ArrayList -> Array추출
		String [] group_array = new String[buser_name_list.size()];
		buser_name_list.toArray(group_array);
				
		jlist_group.setListData(group_array);
		
	}

	
	
	private void init_display() {
		// TODO Auto-generated method stub
		
		jta_display = new JTextArea();
		
		//출력창 폰트설정
		jta_display.setFont(font);
		
		//스크롤 붙이기
		JScrollPane jsp = new JScrollPane(jta_display);
		//크기
		jsp.setPreferredSize(new Dimension(400, 400));
		
		this.add(jsp);
		
		//출력창 읽기전용으로 변경
		jta_display.setEditable(false);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new 채팅프로그램_김치성();
	}

}
