
------------------------------------------member table------------------------------------------
create table member(
mno 	number(5) not null,
mname 	nvarchar2(5) not null,
id 	  	nvarchar2(10) primary key,
pw	  	nvarchar2(10) not null,
memail 	varchar2(100) not null,
regidate date default sysdate not null,
use_yn char(1) default 'Y' not null, -- default ������ �����͸� �Է����� ������ default�� ������ ������ �Էµȴ�.
admin char(1)	default 'N' not null
) ;

create sequence member_seq increment by 1 start with 1 nocycle nocache ; -- ������ ����

-- �θ� ���̵����� �Է�
insert into member(mno, mname, id, pw, memail, regidate, use_yn, admin)
values (member_seq.nextval, '������', 'admin', '1234', 'admin@coco', sysdate, 'Y', 'Y') ; -- �����ڿ� ������

insert into member(mno, mname, id, pw, memail, regidate)
values (member_seq.nextval, '�����', 'podo', '1234', 'podo@coco', sysdate);

insert into member(mno, mname, id, pw, memail, regidate)
values (member_seq.nextval, '���ϴ�', 'haha', '1234', 'haha@coco', sysdate);

insert into member(mno, mname, id, pw, memail, regidate, use_yn, admin)
values (member_seq.nextval, '������', 'hehe', '1234', 'hehe@coco', sysdate, 'Y', 'N');

drop table member ; -- member���̺� ������
select * from member ;


