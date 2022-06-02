/*


create or replace view visit_view
as
select 
	m.m_id,
	idx,
	pwd,
	content,
	ip,
	regdate
from member m full outer join visit v on m.m_id = v.m_id 



select m_idx from visit_view

*/


