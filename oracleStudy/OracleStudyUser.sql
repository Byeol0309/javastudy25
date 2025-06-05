--------------------
-- 사용자, 권한, 롤관리
--------------------- 
-- 신규 생성 사용자는 아무런 권한이 없으므로 권한을 부여해주어야한다.
-- USER : 사용자
-- CREATE USER  : 사용자 생성
-- GRANT : 권한 부여
----- ROLE : 여러 권한을 묶어 놓은 그룹
-----  CONNECT   : 사용자가 데이터베이스에 접속하는데 필요한 CREATE SESSION 권한을 묶어놓은 ROLE
-----             ALTER SESSION, CREATE CLUSTER, CRATE DATABASE LINK, CRATE SEQUENCE, CREATE SESSION, 
-----             CREATE SYNONYM, CRATE TABLE, CRATE VIEW
-----  RESOURCE  : 사용자가 테이블, 시퀀스를 비롯한 여러 객체를 생성할 수 있는 기본 시스템 권한을 묶어놓은 ROLE
-----             CREATE TRIGGER, CREATE SEQUENCE, CREATE TYPE, CREATE PROCEDURE, 
-----             CREATE CLUSTER, CREATE OPERATOR, CREATE INDEXTYPE, CREATE TABLE
-----  DBA       : 데이터 베이스를 관리하는 시스템 권한을 대부분 가지고 있다.
-----  사용자정의롤: 필요에 의해 직접 권한을 포함시킨 롤 ( 롤을 생성하려면 데이터 관리 권한이 있는 사용자가 필요하다.)
-----              CREATE ROLE문으로 롤을 생성, 
-----              GRANT 명렁어로 생성한 롤에 권한을 포함시킨다.
-----              GRANT 명령어로 권한이 포함된 롤을 특정 사용자에게 부여
-----              REVOKE 명령어로 롤을 취소시킨다.



-- 사용자 생성 ( 권한자만 생성할 수 있다 )
CREATE USER ORACLSTUDY IDENTIFIED BY ORACLE;
CREATE USER ORCLSTUDY IDENTIFIED BY ORACLE;
-- 사용자가 생성 된 후 CONN 권한을 부여해야 접속할 수 있다.

----- USER 사용자 권한
-- GRANT 권한부여
GRANT CREATE SESSION TO ORACLSTUDY;
GRANT RESOURCE, CREATE SESSION, CREATE TABLE TO ORCLSTUDY; -- ORCLSTUDY 사용자에게 RESOURCE, SESSION 권한을 부여하였다.
-- ALTER QUOTA 
ALTER USER ORCLSTUDY QUOTA 2M ON USERS;
-- REVOKE FROM 권한 취소
REVOKE RESOURCE, CREATE TABLE FROM ORCLSTUDY;




-- 사용자 정보 조회
SELECT * FROM ALL_USERS WHERE USERNAME = 'ORACLSTUDY';
SELECT * FROM DBA_USERS WHERE USERNAME = 'ORACLSTUDY';
SELECT * FROM DMA_OBJECTS WHERE OWNER = 'ORACLSTUDY';

-- 사용자 변경 ( ALTER USER )
ALTER USER ORACLSTUDY IDENTIFIED BY ORCL;  -- 패스워드 변경
DROP USER ORCLSTUDY; -- 사용자 삭제
DROP USER ORACLSTUDY CASCADE;


-- 사용자 정의 롤 생성 
-- ROLESTUDY롤에 CONNECT, RESOURCE, VIEW, CRATE VIEW, CREATESYNONYM 포함시켜보기.
CREATE ROLE ROLESTUDY;
GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE SYNONYM TO ROLESTUDY ;
-- 생성한 롤을 사용자에게 적용해보기.
GRANT ROLESTUDY TO ORCLSTUDY;
-- 부여된 롤의 권한 확인해보기. 
--(USER_SYS_PRIVS, USER_ROLE_PRIVS 데이터 사전을 사용), 데이터 권한을 가진 계정은 (DBA_SYS_PRIVS, DBA_ROLE_PRIVS)

-- 부여된 롤 취소 ( REVOKE )
REVOKE ROLESTUDY FROM ORCLSTUDY;

-- 롤 삭제 (DROP)
DROP ROLE ROLESTUDY;