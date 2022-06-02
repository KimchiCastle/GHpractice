package vo;

public class VisitVo {

	int idx;
	
	String m_id, pwd, content, ip, regdate;

	
	public VisitVo() {
		// TODO Auto-generated constructor stub
	}
	

	public VisitVo(String m_id, String pwd, String content, String ip) {
		super();
		this.m_id = m_id;
		this.pwd = pwd;
		this.content = content;
		this.ip = ip;
	}
	

	public VisitVo(int idx, String m_id, String pwd, String content, String ip) {
		super();
		this.idx = idx;
		this.m_id = m_id;
		this.pwd = pwd;
		this.content = content;
		this.ip = ip;
	}


	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
