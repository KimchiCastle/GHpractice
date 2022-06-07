package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVo;

public class MemberDao {

	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static MemberDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static MemberDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new MemberDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member order by m_idx";

		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet ������

			rs = pstmt.executeQuery();

			//4.����(record -> Vo -> list)

			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.

				//Vo�� ����
				MemberVo vo = new MemberVo();
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_email(rs.getString("m_email"));
				
				
				//list�� �߰�

				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	
	//m_email�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public MemberVo selectListOne(String m_email) {
		MemberVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//	parameter(���� ����) index
		String sql = "select m_email from member where m_email = ?";

		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);

			//3.pstmt����
			pstmt.setString(1, m_email);
			
			//4.ResultSet ������

			rs = pstmt.executeQuery();

			//5.����(record -> Vo)
			if (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.

				//Vo�� ����
				vo = new MemberVo();
				vo.setM_email(rs.getString("m_email"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}
	
	
	//�α��� �޼ҵ�
	public MemberVo selectlogin(String m_id) {
		// TODO Auto-generated method stub
		MemberVo vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//	parameter(���� ����) index
		String sql = "select * from member where m_id = ?";
		
		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);
			
			//3.pstmt����
			pstmt.setString(1, m_id);
			
			//4.ResultSet ������
			
			rs = pstmt.executeQuery();
			
			//5.����(record -> Vo)
			if (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.
				
				//Vo�� ����
				vo = new MemberVo();
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_email(rs.getString("m_email"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	//m_id�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public MemberVo selectlistOneId(String m_id) {
		// TODO Auto-generated method stub
		MemberVo vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//	parameter(���� ����) index
		String sql = "select m_id from member where m_id = ?";
		
		try {
			conn  = DBService.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			//3.pstmt����
			pstmt.setString(1, m_id);
			//4.ResultSet ������
			rs = pstmt.executeQuery();
			
			//5.����(record -> Vo)
			if (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.
				
				//Vo�� ����
				vo = new MemberVo();
				vo.setM_id(rs.getString("m_id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	
	public int insert(MemberVo vo) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "insert into member values(seq_member_m_idx.nextVal, ?, ?, ?, ?)";
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//3.pstmt�� ����ó���� parameter ��������
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_pwd());
			pstmt.setString(3, vo.getM_name());
			pstmt.setString(4, vo.getM_email());
			
			//4.DML(insert/update/delete)��� ����, res�� ó���� �������ȯ
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//�ݱ� (���� ����)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//������ 0���� ������ ��� ����!
		return res;
	}
	
	
}
