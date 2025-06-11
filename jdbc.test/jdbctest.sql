
-------------------- 학생 테이블 ----------------------------

create table HS_STUDENTS( -- 학생 테이블
	hs_stu_id 		varchar2(10), 		   -- 기본키 학생 번호
	class_off_id 	varchar2(10) not null, -- 외래키 학과 번호
	hs_prof_id		varchar2(10) not null, -- 외래키 교수 번호
	hs_stu_name		varchar2(15) not null, -- 학생 이름
	hs_stu_jumin	varchar2(14) not null, -- 학생 주민번호
	hs_stu_addr		varchar2(100) not null, -- 학생 주소
	hs_stu_phnum	varchar2(15) not null, -- 학생 전화번호
	hs_stu_email	varchar2(100) not null, -- 학생 이메일
	hs_stu_image	long,					-- 학생 사진
	hs_stu_sub		varchar2(3) not null);	-- 학년 / 학기

-- select * from HS_STUDENTS ; -- 교수번호 수정 
insert into HS_STUDENTS values ('04154123', '1234', '145', '서창호', '750813-1234567', '서울시 성동구', '010-4322-9876', 'sch@ab.com', null, '2-1');
insert into HS_STUDENTS values ('05154123', '1234', '145', '김포도', '940303-2111111', '경기도 수원시', '010-1233-4545','popo@dp', null, '2-2') ;
insert into HS_STUDENTS values ('05164123', '1234', '145', '김초코', '950505-2111111', '경기도 화성시', '010-1212-3434', 'coco@ko', null, '2-2');
insert into HS_STUDENTS values ('05171234', '1235', '146', '김전자', '960606-1666666', '경기도 수원시', '010-2323-3434', 'gogo@gp', null, '2-2');
alter table HS_STUDENTS modify(hs_stu_id constraint HSS_STU_ID_NN not null); 
-- hs_stu_id에 HSS_STU_ID_NN로 not null 제약 조건을 넣었다.
alter table HS_STUDENTS modify(hs_stu_id constraint HSS_STU_ID_U unique); -- 학생번호

---alter table HS_STUDENTS modify(class_off_id constraint HSS_STCLAID_U unique); -- 학과번호에 유니크 설정
--alter table HS_STUDENTS drop constraint HSS_STCLAID_U; -- 학과 번호에 유니크 드랍.

--alter table HS_STUDENTS modify(hs_prof_id constraint HSS_STUPRO_ID_U unique); -- 교수번호에 유니크 설정
-- alter table HS_STUDENTS drop constraint HSS_STUPRO_ID_U ; --교수번호에 유니크 드랍

--alter table HS_STUDENTS drop constraint HSS_STU_ID_U ; -- 유니크 삭제
--delete from HS_STUDENTS where class_off_id  = '145' ;
--delete from HS_STUDENTS where hs_prof_id = '1234';
-- update HS_STUDENTS set class_off_id = '1234' , hs_prof_id = '145' where hs_stu_id = '04154123';
alter table HS_STUDENTS ADD constraint HS_STUDENTS_PK primary key (hs_stu_id);

--alter table HS_STUDENTS ADD constraint STUFK_STUID_FK foreign key (hs_stu_id) REFERENCES REGIS_COURSE(hs_stu_id);
-- 학생테이블의 학생 번호열이 REGIS_COURSE 수강 테이블의 (hs_stu_id)를 참조하는 FK 설정
--alter table HS_STUDENTS drop constraint STUFK_STUID_FK ;-- 외래키 삭제 (부모값을 잘못설정함)
--alter table HS_STUDENTS drop constraint HS_STUDENTS_PK ; -- 기본키삭제
--alter table HS_STUDENTS add constraint STUFK_CLAOFFID_FK foreign key (class_off_id) references HS_CLASS_OFFICE(class_off_id);
-- 학생테이블에서 학과테이블의 학과 번호를 참조하는 외래키 등록 HS_CLASS_OFFICE 테이블을 참조하는 (class_off_id) 외래키등록
--alter table HS_STUDENTS drop constraint STUFK_CLAOFFID_FK ; -- 외래키 삭제

--alter table HS_STUDENTS add constraint STUFK_PROID_FK foreign key (hs_prof_id) references REGIS_COURSE (hs_prof_id);
--alter table HS_STUDENTS drop constraint STUFK_PROID_FK ; -- 외래키 삭제 (부모값을 잘못설정함)

--alter table HS_STUDENTS add constraint STUFK_BESTID_FK foreign key (hs_stu_id) references HS_BELONG (hs_stu_id);
--alter table HS_STUDENTS drop constraint STUFK_BESTID_FK ;-- 외래키 삭제 (부모값을 잘못설정함)
-- 학생 테이블에서 담당 테이블의 학생 번호를 참조하는 외래키를 등록하였다. 


------- 리팩토링
-- 위에 외래키 설정의 방향을 잘못 입력하여서 다시 입력함.
-- 학생테이블 HS_STUDENTS(자식)에서는 학과테이블 HS_CLASS_OFFICE(부모)의 학과 번호 class_off_id 를 참조한다 
alter table HS_STUDENTS add constraint STUDENTFK_CLAOFFID_FK foreign key (class_off_id) references HS_CLASS_OFFICE(class_off_id);

-- 표에 교수 번호 정보가 없음

select * from HS_STUDENTS ;






-------------------- 학과테이블 ----------------------------
create table HS_CLASS_OFFICE( -- 학과 테이블
	calss_off_id   		varchar2(10) not null, -- 학과 번호 기본키 -- class_off_id 로 변경함
	calss_off_name 		varchar2(20) not null, -- 학과 명		  -- classs_off_name로 변경함
	calss_off_phnum		varchar2(15) not null); -- 학과 전화번호 -- class_off_phnum로 변경함
	
alter table HS_CLASS_OFFICE modify(calss_off_id constraint HSC_CAL_OF_ID_U unique); -- 학과번호
--calss_off_id에 HSC_CAL_OF_ID_U 이름으로 unique 제약 조건을 넣었다
insert into HS_CLASS_OFFICE values ( '145', '컴퓨터공학과', '111-1111') ;
--alter table HS_CLASS_OFFICE add constraint HS_CLASS_OFFICE_PK primary key (calss)
alter table HS_CLASS_OFFICE RENAME column calss_off_id TO class_off_id;
alter table HS_CLASS_OFFICE RENAME column calss_off_name TO classs_off_name;
alter table HS_CLASS_OFFICE RENAME column classs_off_name TO class_off_name;
alter table HS_CLASS_OFFICE RENAME column calss_off_phnum TO class_off_phnum;
alter table HS_CLASS_OFFICE drop constraint HSC_CAL_OF_ID_U ; -- 위에서 설정한 class_of_id의 유니크 제약조건을 드롭함.
alter table HS_CLASS_OFFICE add constraint HS_CLASS_OFFICE_PK primary key (class_off_id); -- class_off_id로 기본키 설정

--alter table HS_CLASS_OFFICE add constraint CLAOFFFK_CLAID_FK foreign key(class_off_id) references HS_STUDENTS (class_off_id);
--alter table HS_CLASS_OFFICE drop constraint HS_CLASS_OFFICE_PK ; -- 부모키 삭제
-- 참조하려고 하는 부모 테이블 HS_STUDENTS 의 class_off_id가 유니크가 아니어서 외래키 설정이 되지 않았다.
-- 부모 테이블에서 class_off_id에 유니크 제약 조건을 넣은 후 외래키 설정을 시도하니 외래키로 설정됨.
-- alter table HS_CLASS_OFFICE drop constraint CLAOFFFK_CLAID_FK ; -- 외래키 삭제 (부모값 잘못입력함)

--alter table HS_CLASS_OFFICE add constraint CLAOFFFK_CLAID_FK2 foreign key(class_off_id) references HS_PROFESSOR (class_off_id);
-- 학과 테이블에서(부모) 교수테이블을(자식) 참조하는 외래키 학과번호 실행 안됨 ORA-02298 -- 값이 없어서 실행이 안되던거였음. 실행됨.
--alter table HS_CLASS_OFFICE drop constraint CLAOFFFK_CLAID_FK2 ; -- 외래키 삭제 (부모값 잘못입력함)
-- class_off_id 학과번호키를 1234로 변경해야함.
--delete from HS_CLASS_OFFICE where class_off_id = '145' ;
--update HS_CLASS_OFFICE set class_off_id = '1234' where class_off_name = '컴퓨터공학과';

insert into HS_CLASS_OFFICE values ( '1234', '컴퓨터공학과', '111-1111') ; -- 삭제 후 다시 넣었음.
insert into HS_CLASS_OFFICE values ('1235', '전자공학과','222-2222');
insert into HS_CLASS_OFFICE values ('1236', '전기공학과', '333-3333');
select * from HS_CLASS_OFFICE;








-------------------- 교수테이블 ----------------------------

create table HS_PROFESSOR ( -- 교수 테이블
	hs_prof_id 		varchar2(10) not null, -- 교수 번호 기본키
	prof_name		varchar2(15) not null, -- 교수 이름
	prof_jumun		varchar2(14) not null, --  교수 주민번호 (유니크 설정)
	-- prof_jumin으로 열 이름 변경함.
	prof_addr		varchar2(100) not null, -- 교수 주소
	prof_phnum		varchar2(15) not null, -- 교수 전화번호
	prof_email		varchar2(100) not null, -- 교수 이메일
	prof_image		long,				  -- 교수 사진
	class_off_id	varchar2(10) not null -- 학과번호 외래키 
	);
alter table HS_PROFESSOR rename column prof_jumun to prof_jumin;
alter table HS_PROFESSOR modify(prof_jumin constraint HSP_PR_J_U unique); -- 교수 주민번호에 unique 제약 조건을 넣었다
insert into HS_PROFESSOR values ('145', '김기원', '811111-1111111', '수원시 장안구', '010-1234-5678', 'kkw@kk', null, '1234');
insert into HS_PROFESSOR values ('146', '김교수', '802222-2222222', '수원시 영통구', '010-4545-4545', '123@nn', null, '1235');
insert into HS_PROFESSOR values ('147', '이교수', '900330-1212121', '수원시 팔달구', '010-7676-7676', '777@nn', null, '1236');
alter table HS_PROFESSOR drop constraint HSP_PR_J_U ; -- 교수 주민번호 유니크 제약조건 드롭. 기본키 설정이 안됨.
alter table HS_PROFESSOR add constraint HS_PRO_PK primary key (hs_prof_id); -- 교수테이블에 hs_prof_id 교수 번호로 기본키 설정함.

alter table HS_PROFESSOR modify(class_off_id constraint HSP_PR_CLAID_U unique); -- 학과 번호에 unique 제약 조건을 넣었다.

--alter table HS_PROFESSOR add constraint PROFK_PROID_FK foreign key(hs_prof_id) references HS_BELONG (hs_prof_id);
-- 교수 테이블에서 담당 테이블의 hs_prof_id 를 참조하는 외래키를 설정하였다.
--alter table HS_PROFESSOR drop constraint PROFK_PROID_FK ; -- 외래키 삭제 (부모값 잘못입력함)
select * from HS_PROFESSOR;

-------- 리팩토링
-- 교수테이블HS_PROFESSOR(자식)에서는 학과테이블HS_CLASS_OFFICE(부모)의 class_off_id학과번호를 참조한다
alter table HS_PROFESSOR add constraint PRO_CLAOFID_FK foreign key (class_off_id) references HS_CLASS_OFFICE(class_off_id);


-------------------- 강좌 테이블 ----------------------------

create table HS_LECTURE ( -- 강좌 테이블
	lec_id 		varchar2(10) not null, -- 강좌번호 기본키
	hs_prof_id  varchar2(10) not null, -- 교수번호 외래키
	lec_name 	varchar2(15) not null, -- 강좌명
	lec_arch_grade char(1) not null,   -- 취득학점
	lec_time number(1) not null,	   -- 강의시간
	lec_room varchar2(10) not null	   -- 강의실
);
alter table HS_LECTURE modify(lec_id constraint HSL_LET_U unique); -- 강좌번호에 unique 제약 조건을 넣었다.
--insert into HS_LECTURE values ('202506', '1234', 'jdbc', 3, 3, '202');
insert into HS_LECTURE values ('202507', '145', 'jdbc', 3, 3, '202');
insert into HS_LECTURE values ('202508', '146', 'jdbc전자', 3, 3, '302') ;
insert into HS_LECTURE values ('202509', '147', 'jdbc전기', 2, 2, '101') ;
alter table HS_LECTURE drop constraint HSL_LET_U ; -- 강좌번호 유니크 드롭함.
alter table HS_LECTURE add constraint HS_LEC_PK primary key (lec_id); -- 강좌테이블에 lec_id 강좌번호로 기본키 설정함.
select * from HS_LECTURE;

-------- 리팩토링
alter table HS_LECTURE modify(hs_prof_id constraint LEC_PROID_UN unique) ; -- 교수번호에 유니크설정함.
-- 강좌테이블HS_LECTURE(자식)에서는 교수테이블HS_PROFESSOR(부모)의 교수번호hs_prof_id 를 참조한다.
alter table HS_LECTURE add constraint LECFK_PROID_FK foreign key (hs_prof_id) references HS_PROFESSOR (hs_prof_id);
-- 교수 번호 일치하지 않게 입력하여  업데이트 하겠다. 교수번호를 1234에서 145로 변경하겠다.
--delete from HS_LECTURE where hs_prof_id  = '1234'; -- 자식레코드로 인해 드롭 후 실행하겠다.
--alter table HS_LECTURE drop constraint LECFK_PROID_FK ; -- hs_prof_id 입력값 드롭 후 다시 외래키 설정하였다.





-------------------- 수강 테이블 ----------------------------

create table REGIS_COURSE ( -- 수강 테이블
hs_stu_id 		varchar2(10) not null, -- 학생번호 기본키 유니크
lec_id 			varchar2(10) not null, -- 강좌번호 기본키 유니크
hs_prof_id 		varchar2(10) not null, -- 교수번호 기본키 유니크
rc_atten_grade  number(2) not null, -- 출석 점수
rc_midterm_grade number(2) not null, -- 중간고사 점수
rc_finalterm_grade number(2) not null,-- 기말고사 점수
rc_else_grade 	number(2) not null,-- 기타 점수
rc_total  		number(3) not null,-- 총점
rc_avg_grade char(1)-- 평점
);

alter table REGIS_COURSE modify (hs_stu_id constraint RE_C_SID_U unique); --hs_stu_id 유니크 제약 조건 넣었다.
alter table REGIS_COURSE modify (lec_id constraint RE_C_LID_U unique);	 -- lec_id 유니크 제약 조건 넣었다.
alter table REGIS_COURSE modify (hs_prof_id constraint RE_C_PID unique); -- hs_prof_id 제약 조건 넣었다.
alter table REGIS_COURSE drop constraint RE_C_LID_U ; -- lec_id 유니크 드랍.
alter table REGIS_COURSE drop constraint RE_C_PID ; -- hs_prof_id 유니크 드랍.
alter table REGIS_COURSE drop constraint RE_C_PID
insert into REGIS_COURSE values ('04154123', '202507', '145', 10, 10, 10, 10, 40, 'D'); -- char도 ''
insert into REGIS_COURSE values ('05154123', '202507', '145', 30, 30, 30, 10, 100, 'A');
insert into REGIS_COURSE values ('05164123', '202507', '145', 20, 20, 20, 20, 80, 'B');
delete from REGIS_COURSE where hs_stu_id = '05154123' ;
delete from REGIS_COURSE where hs_stu_id = '05164123' ;
-- alter table REGIS_COURSE


alter table REGIS_COURSE add constraint REG_PROID_PK primary key (hs_prof_id); -- hs_prof_id REGIS_COURSE 기본키로 설정함.
-- alter table REGIS_COURSE
--alter table REGIS_COURSE drop constraint REG_PROID_PK;
alter table REGIS_COURSE disable novalidate constraint REG_PROID_PK ; -- REG_PROID_PK 비활성화
alter table REGIS_COURSE ENABLE novalidate constraint REG_PROID_PK;	  -- REG_PROID_PK 활성화
--alter table REGIS_COURSE add constraint REG_STUID_PK primary key (hs_stu_id) ;

-------- 리팩토링
-- 수강테이블 REGIS_COURSE(자식) 에서는 학생 테이블 HS_STUDENTS (부모)의 학생 번호 hs_stu_id 를 참조 hs_stu_id 한다.
alter table REGIS_COURSE add constraint RECOUR_STUID_FK foreign key(hs_stu_id) references HS_STUDENTS (hs_stu_id);

-- 수강테이블(자식)에서는 강좌 테이블 HS_LECTURE(부모)의 강좌 번호lec_id를 참조한다
alter table REGIS_COURSE add constraint RECOUR_LECID_FK foreign key(lec_id) references HS_LECTURE(lec_id);

-- 수강테이블(자식)에서는 강좌 테이블HS_LECTURE(부모)의 교수 번호hs_prof_id 를 참조한다
alter table REGIS_COURSE add constraint RECOUR_PROID_FK foreign key(hs_prof_id) references HS_LECTURE(hs_prof_id);
-- HS_LECTURE(부모)의 교수 번호 hs_prof_id ORA-02270: 이 열목록에 대해 일치하는 고유 또는 기본 키가 없습니다.
-- 해당 컬럼과 매치되는 유니크나 프라이머리 키가 없다는 내용이다. 즉 참조되어지는 속성은 unique 해야한다! 
-- HS_LECTURE(부모)의 교수 번호 hs_prof_id 유니크 조건제약 설정 후 실행함.

--alter table REGIS_COURSE drop constraint RECOUR_PROID_FK; -- 강좌테이블의 값을 변경하기 위해 임시로 교수번호 외래키를 드롭하였다.
--delete from REGIS_COURSE where hs_prof_id = '1234'; -- 값 수정을 위해 삭제하였다.
-- insert into REGIS_COURSE values ('04154123', '202506', '145', 20, 20, 20, 20, 80, 'B'); -- 값 하나 더 넣어보기 안됨  ORA-00001: 무결성 제약 조건(JDBCTEST.RE_C_SID_U)에 위배
-- primary key (hs_prof_id) 로 인해 중복된 교수번호의 데이터를 넣을 수 없어서 제약 조건을 비활성화 한뒤 삽입해보겠다.


select * from REGIS_COURSE;

-------------------- 담당 테이블 ----------------------------


--create table HS_BELONG ( -- 담당 테이블
--hs_stu_id 		varchar2(10) not null, -- 학생번호 기본키
--hs_prof_id 		varchar2(10) not null, -- 교수번호 외래키 (부모 교수테이블)
--hs_stu_sub		varchar2(3) not null   -- 학년/ 학기
--);
--insert into HS_BELONG values ('04154123', '145', '2-1');
--alter table HS_BELONG  add constraint HS_BE_STUID_PK primary key (hs_stu_id); -- hs_stu_id 기본키로 설정함.
--alter table HS_BELONG modify(hs_prof_id constraint BE_PROID_U unique ); --hs_prof_id에 유니크를 넣었음.

-------- 리팩토링
-- 담당테이블HS_BELONG(자식)에서는 학생테이블HS_STUDENTS(부모)의 학생번호hs_stu_id를 참조한다
--alter table HS_BELONG add constraint BELONG_STUID_FK foreign key (hs_stu_id) references HS_STUDENTS(hs_stu_id);
--alter table HS_BELONG drop constraint BELONG_STUID_FK;
-- 담당테이블HS_BELONG(자식)에서는 교수테이블HS_PROFESSOR (부모)의 교수번호를hs_prof_id 참조한다.
--alter table HS_BELONG add constraint BELONG_PROID_FK foreign key (hs_prof_id ) references HS_PROFESSOR(hs_prof_id);
--alter table HS_BELONG drop constraint BELONG_PROID_FK;

--HS_BELONG 테이블 드롭하기.
--drop table HS_BELONG ;

select * from REGIS_COURSE;
select * from HS_STUDENTS;
select * from HS_CLASS_OFFICE;

-- 교수번호 145에게 수업 받는 학생에 대한 정보를 출력하시오
select S.hs_stu_id, S.class_off_id,  S.hs_stu_name, S.hs_stu_jumin, S.hs_stu_addr, S.hs_stu_phnum, S.hs_stu_email, S.hs_stu_image, S.hs_stu_sub, P.hs_prof_id, P.prof_name, P.prof_jumin, P.prof_addr, P.prof_phnum, P.prof_email, P.prof_image, P.class_off_id 
from HS_STUDENTS S, HS_PROFESSOR P where S.hs_prof_id = P.hs_prof_id AND S.hs_prof_id = '145' order by S.hs_prof_id, P.hs_prof_id ;


-- 컴퓨터공학과에 재학중인 학생과 강의하는 교수에 대한 모든 정보를 출력하시오
select * from HS_STUDENTS S, HS_PROFESSOR P where S.class_off_id = '1234' AND P.class_off_id = '1234' ;

-- 현재 2학년 2학기에 재학중인 학생에 대한 정보를 오름차순으로 정렬하여 출력하시오
select * from HS_STUDENTS order by where hs_stu_sub = '2-2' ;
select * from HS_STUDENTS where hs_stu_sub = '2-2' ;

-- 학생 ID가 04로 시작하는 모든 학생 정보를 출력하시오
select * from HS_STUDENTS where hs_stu_id like '04%' ;










