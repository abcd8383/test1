select * from member

create table qna(
	qno number primary key,
	title varchar2(100 byte),
	content varchar2(4000 byte),
	wdate date default sysdate,
	writer varchar2(25 byte),
	status number default 0,
	response varchar2(4000 byte)
	
)

create sequence qno_seq start with 1;
select * from qna


select * from (select ceil(rownum / 5) as page, qno, title, content, wdate, writer, status, response
from (select * from qna order by status asc, qno desc)) where page = 1;

select * from member where grade = 0