package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.VisitVo;

public class VisitDao {

	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static VisitDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static VisitDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new VisitDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private VisitDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Visit order by idx desc";

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
				VisitVo vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
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
	
	//�α��� �� ȸ���� �� �۸� ��ȸ
	public List<VisitVo> selectListOne(String m_id) {
		
		List<VisitVo> list = new ArrayList<VisitVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Visit where m_id = ? order by idx desc";
		
		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);
			
			//3.ResultSet ������
			pstmt.setString(1, m_id);
			
			rs = pstmt.executeQuery();
			
			//4.����(record -> Vo -> list)
			
			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.
				
				//Vo�� ����
				VisitVo vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
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
	
	//�۾��� Dao �޼���
	public int insert(VisitVo vo) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "insert into visit values(seq_visit_v_idx.nextVal,?, ?, ?, ?, sysdate)";
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//3.pstmt�� ����ó���� parameter ��������
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIp());
			
			
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
	
	
	
	//idx�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public VisitVo selectListOne(int idx) {

		VisitVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//	parameter(���� ����) index
		String sql = "select * from visit where idx = ?";

		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);

			//3.pstmt����
			pstmt.setInt(1, idx);
			
			
			//4.ResultSet ������

			rs = pstmt.executeQuery();

			//5.����(record -> Vo)
			if (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.

				//Vo�� ����
				vo = new VisitVo();
				vo.setM_id(rs.getString("m_id"));
				vo.setIdx(rs.getInt("idx"));
				vo.setPwd(rs.getString("pwd"));
				vo.setContent(rs.getString("content"));
				
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
	
	//����
	public int delete(int idx) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "delete from visit where idx = ?";
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//3.pstmt�� ����ó���� parameter ��������
			pstmt.setInt(1, idx);
			
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
	
	public int update(VisitVo vo) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "update visit set m_id=?, pwd=?, content=?, ip=?, regdate=sysdate where idx = ?";
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//3.pstmt�� ����ó���� parameter ��������
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getIdx());
			
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

