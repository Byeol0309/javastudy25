desc emp; -- emp 테이블 구조보기
select * from emp; -- emp 테이블 전체(*) 내용보기
select empno, ename from emp; -- emp 테이블의 empno열, ename열 보기
select empno, deptno from emp; -- emp 테이블의 empno열, deptno열 보기
select distinct deptno from emp; -- emp 테이블의 deptno열의 중복을 제외하고 보기
select sal from emp ; -- emp 테이블의 sal열 보기
select distinct sal from emp ; -- emp테이블의 sal열의 중복을 제외하고 보기
select job from emp ; -- emp 테이블의 job 열 보기
select distinct job from emp; -- emp 테이블의 job열의 중복을 제외하고 보기
select distinct deptno from emp ; -- emp 테이블의 deptno열의 중복을 제외하고 보기
select distinct job, deptno from emp ; -- emp 테이블의 job, deptno열의 중복을 제외하고 보기, deptno,job열이 모두 중복된 데이터는 한번만 출력됨.
select all job, deptno from emp; -- all을 사용하여 출력할경우 모든 열이 출력된다. (distinct를 사용하지 않은 출력값과 같은 결과)
select ename, sal, sal*12+comm, comm from emp; -- 열에 연산식을 사용하여 출력할수있다. 연산식을 사용하여 출력한 경우 열의 이름이 연산식으로 출력되었음. NULL값이 있는 열의 경우 연산식의 데이터가 출력되지 않았음.
select ename, sal, sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+comm from emp ; -- 곱하기 연산자를 사용하지 않고 sal*12+comm 출력해보기 (열의 이름이 너무 길게 나온다.)
select ename, sal, sal*12+comm as annsanl , comm from emp; -- 별칭을 지정하여 (sal*12+comm) 출력하기. 별칭은 연산, 가공된 문장 이후 한칸 띄운후 as 한칸 뒤에 별칭을 지정한다.(4가지방법)
select ename, sal, sal*12+comm "annsal", comm from emp; -- (연산,가공문장)띄고"별칭" . 연산 및 가공된 문장 이후 한칸 띄우고 별칭을 큰따옴표("")로 묶어서 지정하기.
select ename, sal, sal*12+comm as "annsal", comm from emp; -- (연산 가공문장)띄고as"별칭". 연산 및 가공된 문장 이후 한칸 띄우고 as 한칸 뒤에 별칭을 큰따옴포("")로 묶어서 지정하기.
select ename, sal, sal*12+comm annsal,comm from emp; -- (연산 가공문장)띄고별칭지정 . 연산 및 가공된 문장 이후 한칸 띄우고 별칭 지정.
select * from emp order by sal ; -- emp 테이블의 모든 열을 급여 기준으로 오름차순 정렬하기. order by를 통해 데이터를 정렬하여 출력한다. order by에 지정한 열을 우선으로 정렬하고, 여러절중 가장 마지막에 쓴다.
select * from emp order by job ; -- asc는 ascending의 약자로 오름차순을 뜻한다.
select * from emp order by empno; -- empno를 기준으로 오름차순 정렬하기
select * from emp order by deptno; -- deptno를 기준으로 오름차순 정렬하기
select * from emp order by deptno desc ; -- desc는  descending의 약자로 내림차순을 뜻한다.
select * from emp order by sal desc ; -- emp 테이블의 모든 열을 급여 기준으로 내림차순 정렬하기. 
select * from emp order by deptno asc, sal desc ; -- order by절에는 우선순위를 고려하여 여러개의 정렬기준을 지정할수있다. order by 절에 첫번째로 명시된 deptno열을 기준으로 먼저 오름차순 정렬 -> deptno열이 값은 경우 sal값이 내림차순으로 정렬된다.
select distinct job from emp ; -- distinct 는 중복된 데이터를 출력하지 않는다.

select empno as employee_no, ename as employee_name, mgr as manaser, sal as salary, comm as commission, deptno as department_no from emp order by empno desc, empno asc ;
select * from emp ;
select * from emp where deptno = 30; -- where : select문으로 데이터를 조회할 때 특정 조건을 기준으로 원하는 행을 출력하는데 사용한다.
select * from emp where empno = 7782 ;
select * from emp where deptno = 30 ;
select * from emp where job = 'SALESMAN' ; -- JOB = 'SALESMAN', 문자열 데이터는 반드시 대문자로 작성해야한다.
SELECT * from EMP WHERE DEPTNO = 30 AND JOB = 'SALESMAN'; -- where절에서 비교하는 데이터가 문자열일경우 ('')작은따옴표로 묶어준다.
select * from emp where empno = 7499 and deptno = 30 ; -- emp 테이블에서 empno가 7499이고 deptno가 30인 데이터를 출력한다.
select * from emp where deptno = 30 or JOB = 'CLERK'; -- SQL문에 사용하는 기본 형식은 대,소문자를 구별하지 않고 사용할 수 있지만 테이블 안에 들어있는 문자 또는 문자열 데이터는 대소문자를 구별한다.
select * from emp where deptno = 20 or JOB = 'SALESMAN'; -- emp 테이블에서 deptno가 20 이거나 job이 'SALESMAN'인 데이터를 출력한다.
select * from emp where sal * 12 = 36000; -- 산술연산자 : + 더하기 , - 빼기 , * 곱하기, / 나누기
select * from emp where sal >= 3000;
select * from emp where sal >= 2500 and JOB = 'ANALYST'; 
select * from emp where ename >= 'F'; --  문자를 대소연산자로 비교할수있다. 문자열을 비교할때 영어사전처럼 알파벳 순서로 문자열의 '대소'를 비교한다.
select * from emp where ENAME <= 'FORZ'; -- ename의 값이 'FORZ'를 포함한 문자열보다 알파벳순서로 앞에 있는 행을 출력한다.
select * from emp where sal = 3000 ; -- 등가 비교 연산자 : = 본래 기호 의미 그대로 양쪽 데이터가 같은지 다른지 확인한다.
select * from emp where sal != 3000; 
select * from emp where sal <> 3000;
select * from emp where sal ^= 3000;
select * from emp where not sal = 3000; -- 논리 부정 연산자 : NOT 
select * from emp where JOB = 'MANAGER' or JOB = 'SALESMAN' or JOB = 'CLERK' ;
select * from emp where JOB in('MANAGER', 'SALESMAN','CLERK'); -- IN 연산자 : 특정 열에 해당하는 조건을 여러개 지정할수있다.
select * from emp where JOB != 'MANAGER' and JOB <> 'SALESMAN' and JOB ^='CLERK';
select * from emp where JOB NOT IN ('MANAGER', 'SALESMAN','CLERK'); -- IN 연산자와 NOT : 간단하게 반대의 경우를 출력할 수 있다.
select * from emp where deptno in(10,20);
select * from emp where sal >= 2000 and sal <= 3000; -- 대소 비교 연산자와 AND 연산자를 사용하여 출력하기.
select * from emp where sal between 2000 and 3000; -- BETWEEN A AND B 연산자 : 일정 범위 내의 데이터를 조회할 때 사용. 열이름 BETWEEN 최솟값 AND 최댓값;
select * from emp where sal NOT between 2000 and 3000; -- NOT BETWEEN A AND B : 논리 부정 연산자를 붙여서 사용할 수 있다.
select * from emp where ename like 'S%'; -- Like 연산자 : 일부 문자열이 포함된 데이터를 조회할때 사용한다. % : 길이와 상관 없이 (문자가 없는경우도 포함) 모든 문자 데이터를 의미한다.
select * from emp where ename like '_L%'; -- Like 연산자 : _는 어떤 값이든 상관 없이 한개의 문자 데이터를 의미한다.
select * from emp where ename like '%AM%';
select * from emp where ename NOT like '%AM%'; -- NOT Like : 논리 부정연산자를 함께 사용할 수 있다.
select * from emp where comm is null ; -- IS NULL : 존재하지 않는 데이터만 출력한다.
select * from emp where comm is not null; -- IS NOT NULL : 존재하는 데이터만 출력한다.
select * from emp where mgr is not null; 
select * from emp where sal > null and comm is null;
select * from emp where sal > null or comm is null;
select empno, ename, sal, deptno from emp where deptno = 10 union select empno, ename, sal, deptno from emp where deptno = 20;
select empno, ename, sal, deptno from emp where deptno = 10 union select sal, job, deptno, sal from emp where deptno = 20 ;
select empno, ename, sal, deptno from emp where deptno = 10 union select empno, ename, sal, deptno from emp where deptno = 10; -- UNION : 연결된 select문의 결과 값을 합집합으로 묶어준다. 결과 값의 중복은 제거된다.
select empno, ename, sal, deptno from emp where deptno = 10 union all select empno, ename, sal, deptno from emp where deptno = 10 ; --UNION ALL : 중복데이터도 모두 출력한다. 
select ename, upper(ename), lower(ename), initcap(ename) from emp; -- UPPER(문자열) : 모두 대문자로 변환하여 반환 , LOWER(문자열) : 모두 소문자로 변환하여 반환, INITCAP(문자열) : 첫글자는 대문자, 나머지는 소문자로 변환
select * from emp where upper(ename) = upper('scott'); -- 대소문자 상관 없이 같은 문자열을 출력하기 위해, UPPER를 사용하여 ename열과 검색어 'scott'을 대문자로 변환하였다.
select * from emp where upper(ename) like upper('%scott%');
select upper (ename) from emp; -- UPPER를 활용하여 ename열을 대문자로 변환하였다.
select lower (ename) from emp; -- LOWER를 활용하여 ename열을 소문자로 변환하였다.
select initcap(ename) from emp; -- Initcap를 활용하여 ename열의 첫번째 문자는 대문자,나머지는 소문자로 변환하였다.
select upper (job) from emp; -- UPPER를 활용하여 jab열을 대문자로 변환하였다.
select lower (job) from emp;  -- LOWER를 활용하여 job열을 소문자로 변환하였다.
select initcap (job) from emp; -- Initcap을 활용하여 job열의 첫번째 문자는 대문자, 나머지 문자는 소문자로 변환하였다.
select ename, length(ename) from emp;
select ename, length(ename) from emp where length(ename) >= 5 ;
select * from emp where length(job) >=6;
select length('한글'), lengthb('한글') from dual;
select job, substr(job,1,2), substr(job,3,2),substr(job,5) from emp; -- SUBSTR : 문자열 일부를 추출할때 사용한다.
select job, substr(job,1) from emp; -- SUBSTR(문자열데이터, 시작위치) : 시작위치부터 끝까지 추출
select job, substr(job,1,2) from emp; -- SUBSTR(문자열 데이터, 시작위치, 추출길이) : 시작 위치부터 추출 길이만큼 추출. 시작 위치가 음수일경우 마지막 위치부터 거슬러 올라간 위치에서 시작
select ename, substr(ename, 3) from emp; -- ename문자열의 3번째 자리부터 끝까지 출력한다.
select job, substr(job, -length(job)) from emp; -- job열의 길이만큼 뺀 자리부터 끝까지 출력한다.
select job, substr(job, -length(job),2) from emp; -- job열의 길이만큼 뺀 자리의 번째부터, 두글자를 출력한다.
select job, substr(job, -3) from emp; -- job열의 -3 자리부터 문자열 끝까지 출력한다.
select instr('HELLO, ORACLE!', 'L') as instr_1 from dual; -- 대소문자 구별해서 써야한다. 문자열을 찾는것이기 때문에.
select instr('HELLO, ORACLE!', 'L', 5) as instr_2 from dual;
-- 찾으려는 대상 문자열 데이터(필수) 'HELLO, ORACLE' , 위치를 찾으려는 부분 문자(필수) 'L'
select * from emp where instr(ename, 'S') > 0;
select * from emp where ename like '%S%';

select '010-1234-5678' as REPLACE_BEFORE, replace('010-1234-5678', '-', ' ') as REPLACE_1, replace('010-1234-5678','-') as REPLACE_2 from dual;
-- REPLACE : 특정 문자열 데이터를 대체한다.
-- replace('문자열데이터 또는 열이름(필수)', '찾는문자', '대체문자(생략시 삭제)') from 데이터

-- LPAD, RPAD : 데이터의 빈공간을 특정 문자로 채우는 함수.
select 'Oracle', LPAD('Oracle', 10, '#') as LPAD_1 from dual; -- LPAD : Lefr Padding, 남은 빈공간을 왼쪽에 채운다.
select 'Oracle', RPAD('Oracle', 10, '*') as RPAD_1 from dual; -- RPAD : Right Padding, 남은 빈공간을 오른쪽에 채운다.
select 'Oracle', LPAD('Oracle', 10) as LPAD_2 from dual ; -- 채울 문자를 입력하지 않을 경우 왼쪽 빈공간으로 남겨둔다.
select 'Oracle', RPAD('Oracle', 10) as RPAD_2 from dual ;-- 채울 문자를 입력하지 않을 경우 오른쪽 빈공간으로 남겨둔다.
--'Oracle'문자열이 6자리이기때문에 나머지 4자리가 채워져서 출력되었음.

select rpad('971225-', 14, '*') as RPAD_JMNO from dual ; -- 데이터의 일부만 노출해야하는 개인정보를 출력할때 사용하기도 한다.
select rpad('010-1234-', 13, '*') as RPAD_PHONE from dual;


-- CONCAT : 두개의 문자열 데이터를 하나로 연결해주는 역할을 한다.
select concat (empno, ename) , concat(empno, concat( ' : ',ename)) from emp where ename = 'SCOTT' ;

-- || 연산자 : CONCAT함수와 유사하게 열이나 문자열을 연결한다.
select empno || ename, empno || ' : ' || ename from emp ;


-- TRIM, LTRIM, RTRIM : 특정 문자를 지우기 위해 사용하는 함수이다.
-- TRIM 비교 출력용 
select '[' || trim('__Oracle__') ||']' as TRIM from dual;                      -- 삭제 할 문자를 지정하지 않는 경우 공백문자가 삭제된다.
select '[' || trim(leading from '__Oracle__') ||']' as TRIM_LEADING from dual; -- LEADING : 왼쪽에 있는 글자를 삭제 후 출력한다
select '[' || trim(trailing from '__Oracle__')||']' as TRIM_TRAILING from dual; -- TRAILING : 오른쪽에 있는 글자를 삭제 후 출력한다
select '[' || trim(both from '__Oracle__') ||']' as TRIM_BOTH from dual;        -- BOTH : 양쪽에 있는 글자를 모두 삭제 후 출력한다

select '[' || trim('__Oracle__') || ']' as TRIM, '[' || trim(leading from '__Oracle__') ||']' as TRIM_LEADING, '[' || trim(trailing from '__Oracle__')||']' as TRIM_TRAILING, '[' || trim(both from '__Oracle__') ||']' as TRIM_BOTH from dual;
select '[' || trim('_' from '__Oracle__') || ']' AS TRIM, '[' || trim (leading '_' from '__Oracle__') || ']' AS TRIM_LEADING, '[' || trim (trailing '_' from '__Oracle__')|| ']' as TRIM_TRAILING, '[' || trim (both '_' from '__Oracle__') ||']' as TRIM_BOTH from dual;

-- TRIM 함수로 삭제할 문자 _ 삭제 후 출력하기
select '[' || trim('_' from '__Oracle__') || ']' AS TRIM from dual;
select '[' || trim (leading '_' from '__Oracle__') || ']' AS TRIM_LEADING from dual; -- LEADING : 왼쪽에 있는 '_'를 삭제 후 출력한다
select '[' || trim (trailing '_' from '__Oracle__')|| ']' as TRIM_TRAILING from dual; -- TRAILING : 오른쪽에 있는 '_'를 삭제 후 출력한다
select '[' || trim (both '_' from '__Oracle__') ||']' as TRIM_BOTH from dual;         -- BOTH : 양족에 있는 '_'를 삭제 후 출력한다

select '[' || TRIM('_Oracle_') || ']' as TRIM from dual;
select '[' || LTRIM(' _Oracle_ ') || ']' as LTRIM from dual;

select * from emp, dept order by empno; 

-- 조인 : from절에 여러 테이블을 명시할때 쉼표(,)를 구분자로 사용하여 지정한다. 
--       WHERE, GROUP BY, ORDER BY절등 다른절도 그대로 사용할 수 있다.
--       DETPNO 열이 일치한 데이터만 출력하도록 WHERE 조건을 지정하였다.
--                                         (WHERE EMP.DEPTNO = DEPT.DEPTNO)
select * from emp, dept where emp.deptno = dept.deptno order by empno;  -- EMP의 DEPTONO와 DEPT의 DEPTNO가 일치하는 열만 오름차순으로 출력한다.

-- 테이블 이름 별칭으로 표현하기 : FROM EMP(테이블이름) E(별칭이름)
select * from emp E, dept D where E.DEPTNO = D.DEPTNO order by empno;
-- from emp E ( emp는 E로 별칭 지정) , dept D (dept는 D로 별칭 지정) E.DEPTNO (emp의 DEPTNO열) = D.DEPTNO (dept의 DEPTNO열)

select E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, E.DEPTNO, D.DNAME, D.LOC from EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ORDER BY EMPNO;

SELECT E.EMPNO, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ORDER BY EMPNO; -- 열 이름에 각각 테이블 이름도 함께 명시해야한다. (조인하고자 하는 두 테이블의 열이 중복될 경우 오류가 발생함)

SELECT E.EMPNO, E.ENAME, D.DEPTNO, D.DNAME, D.LOC from EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ORDER BY D.DEPTNO, E.EMPNO;

-- WHERE절에 추가로 조건식 넣어 출력하기
SELECT E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME, D.LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND SAL >= 3000; -- WHERE절에 AND 연산을 추가하여 SAL값이 3000이상으로 출력범위를 설정하였다.
-- A와 B 테이블을 조인할경우 A와 B를 정확하게 연결해주는 열이 필요하다.
-- 각 테이블을 정확히 연결하는 조건식이 최소한 테이블수보다 하나 적은 수 만큼은 있어야한다!  (  E.DEPTNO = D.DEPTNO  )

SELECT E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME, D.LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.SAL >= 2500 AND D.DEPTNO <=9999 ORDER BY E.EMPNO ;


CREATE TABLE DEPT_TEMP AS SELECT * FROM DEPT; -- CREATE 
SELECT * FROM DEPT_TEMP;
DROP TABLE DEPT_TEMP; -- DROP TABLE : 테이블 삭제 DROP TABLE 테이블이름 ;

CREATE TABLE EMP_TEMP10 AS SELECT * FROM EMP ; -- EMP 테이블을 복사하여 EMP_TEMP10테이블을 생성한다.
DROP TABLE EMP_TEMP10 ;

-- INSERT : 테이블에 데이터를 추가하는데 사용한다. INSERT INTO 테이블이름 (열1, 열2, 열3,) VALUE (열1에 들어갈 데이터1, 열2에 들어갈 데이터2, 열3에 들어갈 데이터3) ;
INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC) VALUES (50, 'DATABASE', 'SEOUL');
INSERT INTO DEPT_TEMP VALUES (60, 'NETWORK', 'BUSAN'); -- 열 지정 없이 데이터 추가하기 . 열의 개수, 자료형 및 길이는 맞춰주어야함.
INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC) VALUES (70, 'WEB', NULL) ; -- 테이블에 NULL 데이터를 입력할 수 있다.
INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC) VALUES (80, 'MOBILE', '') ;
SELECT * FROM DEPT_TEMP;  -- '' 공백 으로도 NULL 값을 넣을 수 있다.
INSERT INTO DEPT_TEMP (DEPTNO, LOC) VALUES (90,'INCHEON'); -- NULL의 암시적 입력, 열 데이터를 넣지 않는 방식으로 NULL 데이터 입력하기

-- 테이블에 날짜 데이터 입력하기 
-- ENP테이블 복사하여 EMP_TEMP테이블을 생성한다. WHERE 1<>1 을 각 행에 조건식 에 대입하면 값은 항상 FALSE 가 되어 행은 만들어지지 않는다.
CREATE TABLE EMP_TEMP AS SELECT * FROM EMP WHERE 1<>1; -- EMP 테이블의 열구조만 같은 테이블을 생성하였다.
INSERT INTO EMP_TEMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10);
SELECT * FROM EMP_TEMP;

-- 날짜 데이터를 입력할때는 '2025/06/03' , '2025-06-03' 를 사용할 수 있다.
-- 년/월/일 순서와 반대로 , 일/월/년/ 순서로 데이터를 입력하면 오류가 발생한다. (오라클이 설치된 운영체제 종류나 언어군에 따라 날짜 표기 방식이 다르기 때문)
INSERT INTO EMP_TEMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20);
SELECT * FROM EMP_TEMP;
-- TO_DATE : TO_DATE('03/06/2025' , 'DD/MM/YYYY') 변환한 날짜 데이터의 일(DD), 월(MM), 년(YYYY)을 인식할 수 있도록 하는 함수.
INSERT INTO EMP_TEMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (2111, '이순신', 'MANAGER', 9999, TO_DATE('07/01/2001', 'DD/MM/YYYY'), 4000, NULL, 20);

-- SYSDATE : 현재 시점으로 날짜를 입력할 경우 처리하는 방법.
INSERT INTO EMP_TEMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (3111, '심청이', 'MANAGER', '9999', SYSDATE, 4000, NULL, 30);

-- 서브쿼리를 사용하여 한번에 여러 데이터 추가하기.
INSERT INTO EMP_TEMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, E.DEPTNO FROM EMP E, SALGRADE S WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL AND S.GRADE = 1;

-- UPDATE : 테이블에 있는 데이터 수정하기
SELECT * FROM DEPT_TEMP2;
CREATE TABLE DEPT_TEMP2 AS SELECT * FROM DEPT; -- DEPT 테이블을 복사하여 DEPT_TEMP2 테이블을 생성하였다.

-- 테이블 전체 수정하기 ( SET )
--UPDATE 테이블이름 SET 변경할 열 = 변경할 데이터
UPDATE DEPT_TEMP2 SET LOC = 'SEOUL' ; -- DEPT_TEMP2 테이블의 LOC열의 데이터를 모두 'SEOUL'로 수정한다.
ROLLBACK; -- UPDATE 명령어를 실행한 이전 상태로 돌아간다. ( COMMIT의 반대임)

-- 테이블 일부분만 수정하기 ( SET , WHERE )
UPDATE DEPT_TEMP2 SET DNAME = 'DATABASE', LOC = 'SEOUL' WHERE DEPTNO = 40 ; -- WHERE DEPTNO = 40 DEPTNO열이 40인 , DNAME열을 'DATABASE'로 수정한다. LOC열을 'SEOUL'로 수정한다.

UPDATE EMP_TEMP SET COMM = 50 WHERE SAL <= 2500;
SELECT * FROM EMP_TEMP;

-- 서브쿼리를 사용하여 데이터 수정하기
-- 두열의 값을 한번에 변경하기
UPDATE DEPT_TEMP2 SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT WHERE DEPTNO = 40) WHERE DEPTNO = 40 ;
SELECT DNAME, LOC FROM DEPT_TEMP2 ;
SELECT * FROM DEPT ;
-- 열 하나 하나를 수정하기
UPDATE DEPT_TEMP2 SET DNAME = (SELECT DNAME FROM DEPT WHERE DEPTNO = 40 ), LOC = (SELECT LOC FROM DEPT WHERE DEPTNO = 40) WHERE DEPTNO = 40 ;

-- WHERE 절에 서브쿼리를 사용하여 데이터를 수정하는 경우
UPDATE DEPT_TEMP2 SET LOC = 'SEOUL' WHERE DEPTNO = (SELECT DEPTNO FROM DEPT_TEMP2 WHERE DNAME = 'OPERATIONS');
SELECT * FROM DEPT_TEMP2 ;

-- UPDATE 문을 실행하기 전에 SELECT 문으로 WHERE문을 적용하여 결과 값을 먼저 확인하여 검증한다.
SELECT * FROM DEPT_TEMP2 WHERE DEPTNO = 40; 
UPDATE DEPT_TEMP2 SET DNAME = 'DATABASE', LOC = 'SEOUL'  WHERE DEPTNO = 40; -- 변경할 DEPTNO = 40 열을 위에서 검증 후 실행하는 것이 좋다.

-- DELETE : 테이블에 있는 데이터 삭제하기.
CREATE TABLE EMP_TEMP2 AS SELECT * FROM EMP ;
SELECT * FROM EMP_TEMP2;

-- WHERE 사용하여 데이터 일부분만 삭제하기
SELECT * FROM EMP_TEMP2 WHERE JOB = 'MANAGER'; -- DELETE 실행 전에 검증을 해본다.
DELETE FROM EMP_TEMP2 WHERE JOB = 'MANAGER' ;
SELECT * FROM EMP_TEMP2 ;

-- 서브쿼리 사용하여 데이터 삭제하기
SELECT EMPNO, SAL FROM EMP_TEMP2;
SELECT LOSAL, HISAL, GRADE FROM SALGRADE ;
SELECT DISTINCT EMPNO, SAL, LOSAL, HISAL, GRADE FROM EMP_TEMP2, SALGRADE ;
SELECT LOSAL, HISAL, GRADE FROM SALGRADE ;
DELETE FROM EMP_TEMP2 WHERE EMPNO IN (SELECT E.EMPNO FROM EMP_TEMP2 E , SALGRADE S WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL AND S.GRADE = 3 AND DEPTNO = 30);
SELECT * FROM EMP_TEMP2;

--EMP_TEMP 테이블에서 급여가 3000이상인 사원을 삭제하는 코드
DELETE FROM EMP_TEMP WHERE SAL >= 3000;
-- 데이터 전체 삭제하기 ( DELETE FROM 삭제할 테이블 이름 )

CREATE TABLE CHAP10HW_EMP AS SELECT * FROM EMP ;
CREATE TABLE CHAP10HW_DEPT AS SELECT * FROM DEPT ;
CREATE TABLE CHAP10HW_SALGRADE AS SELECT * FROM SALGRADE;

SELECT * FROM DEPT ;
INSERT INTO CHAP10HW_DEPT (DEPTNO, DNAME, LOC) VALUES (50, 'ORACLE','BUSAN');
INSERT INTO CHAP10HW_DEPT VALUES (60, 'SQL', 'ILSAN');
INSERT INTO CHAP10HW_DEPT VALUES (70, 'SELECT', 'INCHEON');
INSERT INTO CHAP10HW_DEPT (DEPTNO, DNAME, LOC) VALUES (80, 'DML','BUNDANG');

SELECT * FROM CHAP10HW_EMP ;
INSERT INTO CHAP10HW_EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7201, 'TEST_USER1', 'MANAGER', 7788, '2016-01-02', 4500, NULL, 50) ;
INSERT INTO CHAP10HW_EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) VALUES (7202, 'TEST_USER2', 'CLERK', 7201, '2016-02-21', 1800,50);
----------------------------------------------------------
-- 데이터 정의어
CREATE TABLE EMP_DDL (EMPNO NUMBER(4), ENAME VARCHAR2(10), JOB VARCHAR2(9), MGR NUMBER(4), HIREDATE DATE, SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2));
DESC EMP_DDL;

CREATE TABLE DEPT_DDL AS SELECT * FROM DEPT ;
DESC DEPT_DDL;
SELECT * FROM DEPT_DDL ;
SELECT * FROM EMP WHERE DEPTNO = 30;

SELECT DEPTNO FROM EMP WHERE DEPTNO = 30 ;
-- 다른 테이블의 일부를 복사하여 테이블 생성하기
CREATE TABLE EMP_DDL_30 AS SELECT * FROM EMP WHERE DEPTNO = 30;  -- EMP_DDL_30 테이블을 생성하여 EMP테이블의 DEPTNO가 30인 열의 복사값을 넣는다.
SELECT * FROM EMP_DDL_30 ;

-- 다른 테이블을 복사하여 테이블 생성하기
CREATE TABLE EMPDEPT_DDL AS SELECT E.EMPNO, E.ENAME, E.JOB, E.HIREDATE, E.SAL, E.COMM, D.DEPTNO, D.DNAME, D.LOC FROM EMP E, DEPT D WHERE 1<>1;

SELECT * FROM EMPDEPT_DDL;

-- ALTER : TABLE 구조 변경 (새열 추가, 삭제, 자료형 OR 길이변경)
---- ADD    : TABLE - 열을 추가
---- MODIFY : TABLE - 열의 자료형이나 길이를 변경
---- DROP   : TABLE - 열을 삭제 ( DROP COLUMN 해당 열의 데이터도 함께 삭제된다)
---- RENAME : TABLE - 열 이름을 변경(RENAME COLUMN 기존열이름 TO 변경할열이름 )
--------------------
-- RENAME   : TABLE 이름을 변경 (RENAME TO )
-- TRUNCATE : TALBE 데이터를 삭제 ( 특정 테이블의 모든 데이터 삭제. 데이터만 삭제하므로 테이블 구조에는 영향을 주지 않음) 
CREATE TABLE EMP_ALTER AS SELECT * FROM EMP;
SELECT * FROM EMP_ALTER;
DESC EMP_ALTER;

--ALTER ADD
ALTER TABLE EMP_ALTER ADD HP VARCHAR2(20); -- ADD 명령어를 사용하여 HP열을 추가하였다.
--ALTER RENAME
ALTER TABLE EMP_ALTER RENAME COLUMN HP TO TEL ;
--ALTER MODIFY
ALTER TABLE EMP_ALTER MODIFY EMPNO NUMBER(5) ;
--ALTER DROP
ALTER TABLE EMP_ALTER DROP COLUMN TEL ;
------------
-- RENAME
RENAME EMP_ALTER TO EMP_RENAME;
DESC EMP_ALTER; -- 변경 후에는 기존 이름을 사용할 수 없다.
SELECT * from EMP_RENAME;

-- TRUNCATE ( DELETE와 다른점 : ROLLBACK 불가능함 )
TRUNCATE TABLE EMP_RENAME;
SELECT * FROM EMP_RENAME;

-- DROP ( ROLLBACK 불가능 )
DROP TABLE EMP_RENAME;


------------
CREATE TABLE EMP_HW (EMPNO NUMBER(4), ENAME VARCHAR2(10), JOB VARCHAR2(9), MGR NUMBER(4), HIREDATE DATE, SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2));
DESC EMP_HW;

ALTER TABLE EMP_HW ADD BIGO VARCHAR2(20); -- ALTER TABLE 테이블이름 ADD 추가할열이름 자료형 ;
ALTER TABLE EMP_HW MODIFY BIGO VARCHAR2(30); -- ALTER TABER 테이블 이름 MODIFY 변경할 열이름 변경내용 ;
ALTER TABLE EMP_HW RENAME COLUMN BIGO TO REMARK ;
SELECT * FROM EMP_HW;

-- EMP_HW테이블에 EMP테이블의 값을 넣는다.
INSERT INTO EMP_HW SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, NULL FROM EMP;
DROP TABLE EMP_HW ; -- DROP은 ROLLBACK 불가능
ROLLBACK ;


---------------------
-- DICTONARY : DICT 데이터 사전
SELECT * FROM DICT ;


---------------------
-- 제약조건 확인
-- OWNER : 제약 조건 소유 계정
-- CONSTRAINT_NAME : 제약 조건의 이름 (직접 지정하지 않을 경우 오라클이 자동으로 지정함)
-- CONSTRAINT_TYPE : 제약조건 종류
--               C : CHECK, NOT NULL
--               U : UNIQUE
--               P : PRIMARY KEY
--               R : FOREIGN KEY
-- TABLE_NAME : 제약 조건을 지정한 테이블 이름
SELECT OWNER CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;
-- TABLE_NAME 을 지정하지 않으면, 어떤 테이블에 걸린 제약 조건인지 알아보기 어렵기때문에, 제약 조건의 이름은 넣어주는 것이 좋다.



---------------------
-- 제약조건
-- NOT NULL    : NULL을 허용하지 않는다. 
-- UNIQUE      : 중복을 허용하지 않는다. 유일한값 (NULL은 중복 대상에서 제외된다, NULL은 여러개 존재할 수 있다.)
-- PRIMARY KEY : (기본키 P)테이블의 데이터를 식별하는 유일한 값
-- FOREIGN KEY : (외래키 R)서로 다른 테이블 간 관계를 정의하는데 사용하는 제약조건
-- CHECK       : 열에 저장할 수 있는 값의 범위 또는 패턴을 정의한다.
---------------------
-- DEFAULT     : 특정 열에 저장할 값이 지정되지 않았을 경우 기본값을 지정하는 키워드
---------------------
-- 제약조건 활성화 / 비활성화
--- DISABLE : 비활성화   (  ALTER TABLE 테이블 이름 (NㅑOVALIDATE / VALIDATE) CONSTRAINT 제약조건이름 ; 
-- ( NOVALIDATE : 기존 데이터는 검사하지 않음. )
-- ( VALIDATE   : 기존 데이터가 제약 조건을 만족하는지 검사함.)
--- ENABLE  : 활성화  
-- ( NOVALIDATE : 신규 입력값부터 체크, 기존 데이터 체크 안함. )
-- ( VALIDATE : 기존 데이터가 제약 조건을 만족하는지 검사함. PK는 옵션 사용 불가)
--------------------
---------------------
-- NOT NULL
-- 테이블을 생성할때 NOT NULL 설정하기.
CREATE TABLE TABLE_NOTNULL(LOGIN_ID VARCHAR2(20) NOT NULL, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR(20));
DESC TABLE_NOTNULL;
-- INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD, TEL) VALUES ('TEST_ID_01', NULL, '010-1234-5678');
INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD) VALUES ('TEST_ID_01','1234');--제약조건 ( NOT NULL ) 로 인해 NULL값을 입력할 수 없다.
SELECT * FROM TABLE_NOTNULL;
UPDATE TABLE_NOTNULL SET LOGIN_PWD =NULL WHERE LOGIN_ID = 'TEST_ID_01'; -- 제약조건( NOT NULL )로 인해 NULL값으로 수정할 수 없다.

-- 제약조건( NOT NULL ) 이름 설정 ( CONSTRAINT 테이블 이름 NOT NULL )
CREATE TABLE TABLE_NOTNULL(LOGIN_ID VARCHAR2(20) NOT NULL, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR(20)); -- 제약 조건 테이블 이름 설정 안함.
CREATE TABLE TABLE_NOTNULL2(LOGIN_ID VARCHAR(20) CONSTRAINT TBlNN2_LOGID_NN NOT NULL, LOGIN_PWD VARCHAR(20) CONSTRAINT TBLNN2_LOGPW_NN NOT NULL, TEL VARCHAR2(30));
SELECT * FROM USER_CONSTRAINTS; -- 제약조건 살펴보기

-- 생성한 테이블에 제약 조건( NOT NULL ) 추가하기 ( ALTER MODIFY 사용)
ALTER TABLE TABLE_NOTNULL MODIFY(TEL NOT NULL); -- TEL 필드 구조를 NOT NULL로 변경하겠다. (ALTER,구조변경 MODIFY,수정)
-- TEL에 이미 NULL값에 있으므로 설정이 불가하다. 
-- TEL 열을 삭제하고 다시 생성하기 OR TEL에 값을 넣은 후 제약 조건 넣기
UPDATE TABLE_NOTNULL SET TEL = '010-1234-5678' WHERE LOGIN_ID = 'TEST_ID_01'; -- TEL열에 값을 넣었다.
SELECT * FROM TABLE_NOTNULL;

-- TEL에 값을 넣은 후 제약 조건( NOT NULL ) 지정하기.
ALTER TABLE TABLE_NOTNULL MODIFY (TEL NOT NULL); -- NULL이 없으므로 제약 조건을 넣을 수 있다.
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;

-- 제약 조건( NOT NULL )에 이름 지정해서 추가하기 ( ALTER, MODIFY, CONSTRANINT )
ALTER TABLE TABLE_NOTNULL2 MODIFY(TEL CONSTRAINT TBLNN_TEL_NN NOT NULL);
SELECT * FROM USER_CONSTRAINTS;
DESC TABLE_NOTNULL2;

-- 이미 생성된 제약 조건( NOT NULL ) 이름 변경하기. ( ALTER, RENAME CONSTRAINT TO )
ALTER TABLE TABLE_NOTNULL2 RENAME CONSTRAINT TBLNN_TEL_NN TO TBLNN2_TEL_NN;

-- 제약 조건( NOT NULL ) 삭제하기 (ALTER DROP CONSTRAINT )
ALTER TABLE TABLE_NOTNULL2 DROP CONSTRAINT TBLNN2_TEL_NN;


--------------------- 
--- UNIQUE : 유일한값 (중복 허용하지 않지만 NULL은 중복이 가능하다)
-- 제약 조건 ( UNIQUE ) 지정하기 ( CREATE UNIQUE )
CREATE TABLE TABLE_UNIQUE (LOGIN_ID VARCHAR2(20) UNIQUE, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR2(20));
DESC TABLE_UNIQUE;

-- 제약 조건( UNIQUE ) 확인 ( TABLE_NAME = 제약 조건을 지정한 테이블 이름)
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TABLE_UNIQUE' ;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TABLE_UNIQUE';
INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES('TEST_ID_01', 'PWD01','010-1234-5678');
SELECT* FROM TABLE_UNIQUE;
INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES('TEST_ID_02', 'PWD01', '010-1234-5678');
INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES(NULL, 'PWD01', '010-2345-6789');

-- 제약 조건 ( UNUQUE ) 데이터 수정하기
UPDATE TABLE_UNIQUE SET LOGIN_ID = 'TEST_ID_01' WHERE LOGIN_ID IS NULL; -- UNIQUE는 중복값이 허용되지 않기 때문에 실행되지 않는다.

-- 테이블 생성할 때 제약조건 ( UNIQUE ) 설정하기 ( CREATE CONSTRAINT UNIQUE )
CREATE TABLE TABLE_UNIQUE2 (LOGIN_ID VARCHAR2(20) CONSTRAINT TBLUNQ2_LOGIN_UNQ UNIQUE, LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLUNQ2_LGNPW_NN NOT NULL, TEL VARCHAR2(20)) ; -- LOGIN_ID에는 UNIQUE, LOGIN_PWD에는 NOT NULL 제약 조건을 넣었다.
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

-- 이미 생성한 테이블에 제약조건 ( UNIQUE ) 추가하기  ( ALTER MODIFY UNIQUE )
ALTER TABLE TABLE_UNIQUE MODIFY(TEL UNIQUE); -- 이미 중복열이 존재하므로 실행이 불가하다, TEL열 값을 모두 NULL로 변경한 후 실행해보기.
UPDATE TABLE_UNIQUE SET TEL = NULL;
SELECT * FROM TABLE_UNIQUE;

-- 제약 조건 ( UNIQUE )이름 지정하기. ( ALTER MODIFY CONSTRAINT UNIQUE )
ALTER TABLE TABLE_UNIQUE2 MODIFY(TEL CONSTRAINT TBLUNQ_TEL_UNQ UNIQUE);
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%' ; -- TABLE_NAME(제약조건이름이) LIKE 'TABLE_UNIQUE%'

-- 이미 만들어진 제약조건 ( UNIQUE ) 이름 수정하기 ( ALTER RENAME CONSTRAINT TO )
ALTER TABLE TABLE_UNIQUE2 RENAME CONSTRAINT TBLUNQ_TEL_UNQ TO TBLUNQ2_TEL_UNQ ; 

-- 제약 조건 ( UNIQUE ) 삭제하기
ALTER TABLE TABLE_UNIQUE2 DROP CONSTRAINT TBLUNQ2_TEL_UNQ;


--------------------- 
-- PRIMARY KEY : 테이블에 하나, 데이터 중복과 NULL 모두 허용하지 않는다. PRIMARY KEY로 지정하면 해당 열에 자동으로 인덱스가 생성된다
-- 기본키 ( P ) : 테이블의 데이터를 식별하는 유일한 값
-- 제약 조건 ( PRIMARY KEY ) 지정하기 ( CREATE PRIMARY KEY )
CREATE TABLE TABLE_PK ( LOGIN_ID VARCHAR2(20)PRIMARY KEY, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR2(20));
DESC TABLE_PK;
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_PK%';
SELECT INDEX_NAME, TABLE_OWNER, TABLE_NAME FROM USER_INDEXES WHERE TABLE_NAME LIKE 'TABLE_PK%';

-- 테이블 생성할 때 제약조건 ( PRIMARY KEY ) 설정하기 ( CREATE CONSTRAINT UNIQUE )
CREATE TABLE TABLE_PK2 (LOGIN_ID VARCHAR2(20) CONSTRAINT TBLPK2_LGNID_PW PRIMARY KEY, LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLPK2_LGNPW_NN NOT NULL, TEL VARCHAR2(20));
DESC TABLE_PK2;

-- PRIMARY KEY 제약조건 열 확인하기. 
INSERT INTO TABLE_PK(LOGIN_ID, LOGIN_PWD, TEL) VALUES ('TEST_ID_01', 'PWD01','010-1234-5678');
SELECT * FROM TABLE_PK;

--  테이블에 중복되는 데이터 입력해보기 ( PRIMARY KEY )
INSERT INTO TABLE_PK (LOGIN_ID, LOGIN_PWD, TEL) VALUES ('TEST_ID_01', 'PWD01','010-1234-5678'); -- 무결성 제약조건에 위배됨.

-- NULL 값을 명시적으로 입력해보기 ( PRIMARY KEY )
INSERT INTO TABLE_PK(LOGIN_ID, LOGIN_PWD, TEL) VALUES (NULL, 'PWD02', '010-2345-6789'); -- NULL을 삽입할 수 없음.

-- NULL 값을 암시적으로 입력해보기 ( PRIMARY KEY )
INSERT INTO TABLE_PK(LOGIN_PWD, TEL) VALUES ('PWD02', '010-2345-6789'); -- NULL을 삽입할 수 없음.

------------------------------------------
-- CREATE 문 제약 조건을 지정하는 다른 방식
-- 인라인 (inline) , 열레벨 (column-level)
CREATE TABLE TABLE_NAME (COL1 VARCHAR2(20) CONSTRAINT CONSTRAINT_NAME PRIMARY KEY, COL2 VARCHAR2(20) NOT NULL, COL3 VARCHAR2(20));

-- 아웃오브라인 ( out-of-line), 테이블 레벨 ( table-level )
CREATE TABLE TABLE_NAME (COL1 VARCHAR2(20), COL2 VARCHAR2(20), COL3 VARCHAR2(20), PRIMARY KEY (COL1), CONSTRAINT CONSTRAINT_NAME UNIQUE (COL2));
------------------------------------------

--------------------- 
-- FOREIGN KEY : 서로 다른 테이블 간 관계를 정의하는데 사용하는 제약조건
-- 외래키 ( R ) : 참조하는 열이 있음 (관계) PK_DEPT (DEPT TABLE의 PK(PRIMARY KEY)를 참조한다는 뜻)
-- EMP 테이블과 DEPT 테이블의 제약 조건 보기 
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_OWNER, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME IN('EMP','DEPT');
-- R_CONSTRAINT_NAME

INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (9999, '홍길동', 'CLERK', '7788', TO_DATE('2017/04/30', 'YYYY/MM/DD'), 1200, NULL, 50);
-- 부모키가 없으므로 실행 불가능 (SCOTT.FK_DEPTNO) DEPTNO에 존재하지 않은 값을 입력함.

-- 제약 조건 ( FOREIGN KEY ) 지정하기 ( CREATE CONSTRAINT REFERENCES )
--DEPT_FK 테이블 생성하기 ( DEPT_FK의 DEPTNO열에 PRIMARY KEY 제약 조건을 걸었다. 제약 조건 이름은 DEPTFK_DEPTNO_PK
CREATE TABLE DEPT_FK (DEPTNO NUMBER(2) CONSTRAINT DEPTFK_DEPTNO_PK PRIMARY KEY, DNAME VARCHAR2(14), LOC VARCHAR2(13));
DESC DEPT_FK;
SELECT * FROM USER_CONSTRAINTS ;

-- EMP_FK 테이블 생성하기 ( DEPT_FK 테이블의 DEPTNO열을 참조하는 FOREIGN KET 제약 조건을 정의하는 테이블)
CREATE TABLE EMP_FK (EMPNO NUMBER(4) CONSTRAINT EMPFK_EMPNO_PK PRIMARY KEY, ENAME VARCHAR2(10), JOB VARCHAR2(9), MGR NUMBER(4), HIREDATE DATE, SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2) CONSTRAINT EMPFK_DEPTNO_FK REFERENCES DEPT_FK (DEPTNO)) ;
DESC EMP_FK;

INSERT INTO EMP_FK VALUES (999, 'TEST_NMAME', 'TEST_JOB', NULL, TO_DATE('2001/01/01', 'YYYY/MM/DD'), 3000, NULL, 10);
-- EMP_FK가 참조하고 있는 DEPT_FK 테이블에 값이 없으므로 실행되지 않음. (참조할 부모키가 없다.)
-- DEPT_FK 테이블에 데이터를 삽입한다.
INSERT INTO DEPT_FK VALUES(10, 'TAST_DNAME', 'TEST_LOC');
SELECT * FROM DEPT_FK;
SELECT * FROM EMP_FK;

DELETE FROM DEPT_FK WHERE DEPTNO = 10 ; 
-- EMP_FK 테이블에서 DEPT_FK의 DEPTNO를 참조하고 있기 때문에 데이터를 삭제할 수 없다.
--- 참조하는 열의 데이터 삭제할 수 있는 방법 ----
-- 삭제하려는 열 값을 참조하는 데이터를 먼저 삭제한다
-- 현재 삭제하려는 열 값을 참조하는 데이터를 수정한다
-- 현재 삭제하려는 열을 참조하는 자식 테이블의 FOREIGN KEY 제약 조건을 해제한다.
---------------------
-- 추가 옵션 방법
-- 열 데이터를 삭제할 때 이 데이터를 참조하고 있는 데이터도 함께 삭제.
-- 열 데이터를 삭제할 때 이 데이터를 참조하는 데이터를 NULL로 수정

--------------------- 
-- CHECK : 열에 지정할 수 있는 값의 범위 또는 패턴을 정의할 때 사용하는 제약조건
-- 
-- 테이블 생성할때 CHECK 제약조건 설정하기
CREATE TABLE TABLE_CHECK (LOGIN_ID VARCHAR2(20) CONSTRAINT TBLCK_LOGIN_PW PRIMARY KEY, LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLCK_LOGINPW_CK CHECK (LENGTH(LOGIN_PWD) > 3), TEL VARCHAR2(20));
DESC TABLE_CHECK;
INSERT INTO TABLE_CHECK VALUES('TEST_ID', '123','010-1234-5678'); -- 체크 제약조건에 위배되므로 실행되지 않음.
INSERT INTO TABLE_CHECK VALUES('TEST_ID','1234','010-1234-5678'); -- 체크 제약조건 맞음 ( CONSTRAINT TBLCK_LOGINPW_CK CHECK (LENGTH(LOGIN_PWD) > 3 )

-- 제약 조건( CHECK ) 확인하기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_CHECK';

--------------------- 
-- DEFAULT : 특정 열에 저장할 값이 지정되지 않았을 경우 기본값을 지정한다.
---------------------
-- 테이블을 생성할때 DEFAULT 제약 조건 설정하기
CREATE TABLE TABLE_DEFAULT( LOGIN_ID VARCHAR2(20) CONSTRAINT TBLCK2_LOGINID_PK PRIMARY KEY, LOGIN_PWD VARCHAR2(20) DEFAULT '1234', TEL VARCHAR2(20) );
DESC TABLE_DEFAULT;

-- DEFAULT로 지정한 기본값이 입력되는지 INSERT해보기.
INSERT INTO TABLE_DEFAULT VALUES ('TEST_ID', NULL, '010-1234-5678');
INSERT INTO TABLE_DEFAULT (LOGIN_ID, TEL) VALUES ('TEST_ID2', '010-1234-5678');
SELECT * FROM TABLE_DEFAULT; -- NULL 값이 입력되었을때는 DEFAULT로 설정한 기본값이 들어가지 않는다.


---------------------
-- 사용자, 권한, 롤관리
--------------------- 
--- USER : 사용자
-- CREATE USER 사용자 이름 (필수)  : ID
-- IDENTIFIED BY 패스워드 (필수)  :  PW
-- DEFAULT TABLESPACE 테이블 스페이스 이름 (선택)
-- TEMPORARY TABLESPACE 테이블 스페이스(그룹)이름 (선택)
-- QUOTA 테이블 스페이스 크기 ON 테이블 스페이스 이름 (선택)
-- PROFILE 프로파일 이름 (선택)
-- PASSWORD EXPIRE (선택)    : 권한 만료
-- ACCOUNT [LOCK / UNLOCK]

---------------------
-- 사용자 생성 : CREATE USER
CREATE USER ORCLSTUDY IDENTIFIED BY ORACLE ;  -- 권한의 생성은 권한자 계정에서 생성이 가능하다
---- 객체권한 부여
-- ORCLSTUDY 사용자에게 TEMP 테이블 권한 부여하기
CREATE TABLE TEMP (COL1 VARCHAR(20), COL2 VARCHAR(20)); -- TEMP 테이블을 생성하여 ORCLSTUDY에게 SELECT, INSERT 권한을 부여할것이다.

-- GRANT 객체권한 ON 스키마.객체이름 TO 사용자이름 --
GRANT SELECT ON TEMP TO ORCLSTUDY; -- ORCLSTUDY에게 TEMP의 SELECT 권한을 부여한다.
GRANT INSERT ON TEMP TO ORCLSTUDY; -- ORCLSTUDY에게 TEMP의 INSERT 권한을 부여한다.
GRANT SELECT, INSERT ON TEMP TO ORCLSTUDY; -- 여러 권한을 한번에 부여하기.

---- 객체권한 취소
REVOKE SELECT, INSERT ON TEMP FROM ORCLSTUDY;