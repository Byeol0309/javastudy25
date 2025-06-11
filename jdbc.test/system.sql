-- 실행은 블럭설정 후 Alt + C 로 줄단위로 실행한다.

create user jdbctest identified by jdbctest
-- id : jdbctest / pw : jdbctest
grant resource, connect to jdbctest
-- 일반 계정 권한과 연결 접속 권한을 jdbctest계정에 부여
alter user jdbctest default tablespace users
-- jdbctest 계정이 사용될 기본 데이터베이스는 users
alter user jdbctest temporary tablespace temp
-- jdbctest 계정이 임시로 사용할 데이터베이스는 temp로 지정 
