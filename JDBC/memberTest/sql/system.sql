-- system sql에서 membertest 사용자를 생성해보자.
create user membertest identified by membertest ;
grant resource, connect to membertest ;
alter user membertest default tablespace users ;
alter user membertest temporary tablespace temp ; 