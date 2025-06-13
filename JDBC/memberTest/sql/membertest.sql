
------------------------------------------member table------------------------------------------
create table member(
mno 	number(5) not null,
mname 	nvarchar2(5) not null,
id 	  	nvarchar2(10) primary key,
pw	  	nvarchar2(10) not null,
memail 	varchar2(100) not null,
regidate date default sysdate not null,
use_yn char(1) default 'Y' not null, -- default 설정시 데이터를 입력하지 않으면 default로 저장한 값으로 입력된다.
admin char(1)	default 'N' not null
) ;

create sequence member_seq increment by 1 start with 1 nocycle nocache ; -- 시퀀스 생성

-- 부모 더미데이터 입력
insert into member(mno, mname, id, pw, memail, regidate, use_yn, admin)
values (member_seq.nextval, '관리자', 'admin', '1234', 'admin@coco', sysdate, 'Y', 'Y') ; -- 관리자용 데이터

insert into member(mno, mname, id, pw, memail, regidate)
values (member_seq.nextval, '김샛별', 'podo', '1234', 'podo@coco', sysdate);

insert into member(mno, mname, id, pw, memail, regidate)
values (member_seq.nextval, '이하늘', 'haha', '1234', 'haha@coco', sysdate);

insert into member(mno, mname, id, pw, memail, regidate, use_yn, admin)
values (member_seq.nextval, '배혜민', 'hehe', '1234', 'hehe@coco', sysdate, 'Y', 'N');

drop table member ; -- member테이블 삭제용
select * from member ;


