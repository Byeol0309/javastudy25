-- 2025.06.11 member talbe생성 후 memberDAO, memberDTO 활용하여 회원용 게시판을 구현해보자



--------------------------------------member 테이블 부모로 생성하기----------------------------------------
create table member (
mno number(5) not null,
bwriter nvarchar2(10) not null, 
id nvarchar2(10) primary key, -- board talbe의 bwriter와 FK 관계로 설정하겠다. 타입을 맞춰줘야함.
pw nvarchar2(10) not null,
regidate date default sysdate not null
) ;

-- 부모 더미데이터 입력
insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '김기원', 'kkw', '1234') ;

insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '이하늘', 'lhn', '1234') ;

insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '배혜민', 'bhm', '1234') ;

insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '김샛별', 'ksb', '1234') ;

insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '전혜진', 'jhj', '1234') ;

insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '김보령', 'kbr', '1234');

insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '김진우', 'kjo', '1234');

insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '전민기', 'jmk', '1234');


-- 시퀀스 객체는 이미 생성했기때문에 재사용이 가능하다.
-- 이미 생성한 board_seq 을 사용하겠다.

drop table member ; --member테이블 삭제용
select * from member ;


-----------------------------------member의 자식 board 외래키 생성 필수---------------------------------------

drop table board -- 기존 board테이블 삭제
drop sequence board_seq -- 자동번호 생성 제거

create table board(
bno number(5) primary key, 
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null, -- FK (부모테이블 member)
bdate date not null ) ;


create sequence board_seq increment by 1 start with 1 nocycle nocache ;

alter table board add constraint board_member_fk foreign key (bwriter) references member(id) ;
-- member테이블을 부모로하는 자식테이블로 설정하였다.
-- board_member_fk이름으로 member테이블의 id를 참조하는 FK 설정하였음.
-- board테이블은 member의 자식테이블로 member의 id과 board의 bwriter를 관계설정(FK)

-- alter table board add constraint board_member_fk foreign key (bwiter) references member(mname)
-- -> 이미 자식 테이블에 값이 들어있기때문에 오류발생
--  pk와 fk를 확인하고 연결 ->   자식테이블의 더미데이터를 삭제하고 실행해보자.
-- board에 더미데이터를 넣어보니 
-- ORA-02291: integrity constraint (BOARDTEST.BOARD_MEMBER_FK) violated - parent key not found 
-- 부모테이블에 일치하는 값이 없다.  -> board에 김기원을 id인 kkw로 변경

delete from board ; -- 조건없이 delete를 실행하면 모든 데이터가 삭제된다 -> 외래키를 다시 지정해보자.

insert into BOARD(bno, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '덥네요', '오늘도 힘내세요', '김기원', sysdate) ;

insert into BOARD(bno, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '안녕하세요', '오늘 저녁 식사도 맛있게 하세요', '이하늘', sysdate) ;

insert into BOARD(bno, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '화이팅', '저녁에 소고기 먹고싶다', '김샛별', sysdate);

insert into BOARD(bno, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '에어컨', '오늘은 에어컨 키셨나요', '배혜민', sysdate);

select * from board ;


------------------------------------------------------------------------------------------------------
-- 조인 : 2개 테이블을 연결하여 값을 가져온다.
select b.*, m.bwriter from member m inner join board b on m.id = b.bwriter where id = 'kkw';
-- board에 member를 불러서 join함.