/*

create sequence seq_member_m_idx

create table member
(
	m_idx 	int,
	m_id	varchar2(100) not null,
	m_pwd	varchar2(100) not null,
	m_name 	varchar2(100) not null,
	m_email varchar2(100) not null
)

alter table member
	add constraint pk_m_idx primary key(m_idx)
	
alter table member
	add constraint uq_m_id unique(m_id)


-- ���õ�����
insert into member values(seq_member_m_idx.nextVal, 'hong', '123', 'ȫ�浿', 'hong@gmail.com');
insert into member values(seq_member_m_idx.nextVal, 'hana', '123', '���ϳ�', 'hana@gmail.com');
insert into member values(seq_member_m_idx.nextVal, 'duna', '123', '�̵γ�', 'duna@gmail.com');


-- Ȯ��
select * from member

*/