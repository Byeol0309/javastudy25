-- 데이터 정의어(DDL) : 관리자 계정으로 사용한다.
-- 객체(OBJECT)를 생성, 변경, 삭제한다.
-- CREATE   : 객체를 생성
-- ALTER    : 객체를 변경
-- RENAME   : 
-- TRUNCATE :
-- DROP     : 객체를 삭제
-- ( COMMIT ) : 데이터 정의어를 실행하면 자동으로 반영(COMMIT)된다. (ROLLBACK으로 실행 취소가 불가하다.)

CREATE TABLE EMP_DDL ( EMPNO NUMBER(4), ENAME VARCHAR2(10), JOB VARCHAR2(9), MAG NUMBER(4), HIREDATE DATE, SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2)) ;
DESC EMP_DDL;

CREATE TABLE DEPT_DDL AS SELECT * FROM DEPT;