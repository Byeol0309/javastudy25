drop table board -- 기존 board테이블 삭제
drop sequence board_seq -- 자동번호 생성 제거

create table board(
bno number(5) primary key, 
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null,
bdate date not null ) ;

create sequence board_seq increment by 1 start with 1 nocycle nocache ;

insert into BOARD(bno, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '덥네요', '오늘도 힘내세요', '김초코', sysdate) ;

insert into BOARD(bno, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '안녕하세요', '오늘 저녁 식사도 맛있게 하세요', '김초코', sysdate) ;

insert into BOARD(bno, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '화이팅', '저녁에 소고기 먹고싶다', '김망고', sysdate);

insert into BOARD(bno, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '에어컨', '오늘은 에어컨 키셨나요', '김망고', sysdate);

select * from board ;