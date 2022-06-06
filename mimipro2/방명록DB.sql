/*

create sequence seq_visit_v_idx

drop sequence seq_visit_v_id


create table visit
(
	idx 	int,
	m_id 	varchar2(100),
	pwd		varchar2(100),
	content varchar2(4000),
	ip		varchar2(100),
	regdate date
)


alter table visit
	add constraint pk_visit_idx primary key(v_idx);


insert into visit values(seq_visit_v_idx.nextVal, 'hana',  '1234', '우왕꿀잼', '192.168.0.9', sysdate)
insert into visit values(seq_visit_v_idx.nextVal, 'duna',  '1234', '이게들어가네?', '192.168.0.10', sysdate)
insert into visit values(seq_visit_v_idx.nextVal, 'hong',  '12345', '아버지를 아버지라 부르지 못하고', '192.168.0.11', sysdate)

insert into visit(idx, '', '', ip, regdate) where m_id = 

update visit set m_id='hong', pwd='1234', content='서럽다', ip='192.168.0.11', regdate=sysdate where idx = 4


drop table visit cascade constraints


select * from visit order by idx desc

delete from visit where idx = 25

*/
