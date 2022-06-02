/*

create sequence seq_visit_v_idx

create table visit
(
	m_id 	varchar2(100),
	idx 	int,
	pwd		varchar2(100),
	content varchar2(4000),
	ip		varchar2(100),
	regdate date
)


alter table visit
	add constraint pk_visit_id primary key(m_id);


insert into visit values('hana', seq_visit_v_idx.nextVal, '1234', '우왕꿀잼', '192.168.0.9', sysdate)
insert into visit values('duna', seq_visit_v_idx.nextVal, '1234', '이게들어가네?', '192.168.0.10', sysdate)
insert into visit values('hong', seq_visit_v_idx.nextVal, '12345', '아버지를 아버지라 부르지 못하고', '192.168.0.11', sysdate)

select * from visit

*/
