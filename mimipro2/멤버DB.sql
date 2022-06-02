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


-- 샘플데이터
insert into member values(seq_member_m_idx.nextVal, 'hong', '123', '홍길동', 'hong@gmail.com');
insert into member values(seq_member_m_idx.nextVal, 'hana', '123', '일하나', 'hana@gmail.com');
insert into member values(seq_member_m_idx.nextVal, 'duna', '123', '이두나', 'duna@gmail.com');


-- 확인
select * from member

*/