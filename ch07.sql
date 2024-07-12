

SELECT * FROM employees.employees;

USE employees;

SELECT * FROM dept_emp
WHERE to_date = '9999-01-01';


-- select u.userId, u.name, b.prodName, u.addr,
-- 	concat(u.mobile1, u.mobile2) as 연락처
--     From usertbl u
-- 		left outer join buytbl b
--         on u.userID = b.userid
--         order by u.userID;

use sakila;

-- 3개의 테이블 조인
select a.first_name, a.last_name, f.title
from film f 
	Inner join film_actor fa
	on f.film_id = fa.film_id
    inner join actor a
    On fa.actor_id = a.actor_id
order by f.title;

-- Q7 실습
-- LV.1
 
-- 1. sqldb 데이터베이스에서 다음 조건을 처리하세요
-- 사용자 별로 구매 이력을 출력함
-- 모든 컬럼을 출력
-- 구매 이력이 없는 정보는 출력하지 않음
-- 1-1. userID가 'JYP' 인 데이터만 출력하세요

use sqldb;

SELECT * 
FROM buytbl
	INNER JOIN usertbl
    ON buytbl.userId = usertbl.userID
WHERE buytbl.userID = 'JYP';


-- OUTERJOIN 실습
SELECT U.userID, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as '연락처'
	FROM usertbl U
		LEFT OUTER JOIN buytbl B
        ON U.userID = B.userID
	order by U.userID ASC;
        

-- sqldb 사용자를 모두 조회하되, 전화가 없는 사람 제외 후 출력하기
SELECT name, concat(mobile1, mobile2) as '전화번호' 
	FROM usertbl
    WHERE name NOT In (SELECT name FROM usertbl WHERE mobile1 IS NULL);

-- sqldb의 사용자를 모두 조회하되 전화가 없는 사람만 출력하세요
SELECT name 
	FROM usertbl
    WHERE name In (SELECT name FROM usertbl WHERE mobile1 IS NULL);
    
    
-- LV.2
USE SQLDB;

-- CREATE table stdtbl;
-- create table clubtbl;
-- create table stdclubtbl;

-- CREATE TABLE stdtbl (
-- 	stdName VARCHAR(10) NOT NULL PRIMARY KEY,
--     addr CHAR(4) NOT NULL
-- );

-- CREATE TABLE clubtbl (
-- 	clubName VARCHAR(10) NOT NULL PRIMARY KEY,
--     roomNo Char(4) NOT NULL
--     );
--     
-- CREATE TABLE stdclubtbl(
-- 	num int auto_increment not null primary key,
--     stdName varchar(10) not null,
--     clubName varchar(10) not null,
--     FOREIGN KEY(stdName) references stdbl(stdName),
--     FOREIGN KEY(clubName) references clubtbl(clubName)
-- );

INSERT INTO stdtbl VALUES ('김범수','경남'), ('성시경','서울'), ('조용필','경기'), ('은지원','경북'),('바비킴','서울');
INSERT INTO clubtbl VALUES ('수영','101호'), ('바둑','102호'), ('축구','103호'), ('봉사','104호');
INSERT INTO stdclubtbl VALUES (NULL, '김범수','바둑'), (NULL,'김범수','축구'), (NULL,'조용필','축구'), (NULL,'은지원','축구'), (NULL,'은지원','봉사'), (NULL,'바비킴','봉사');

SELECT S.stdName, S.addr, SC.clubName, C.roomNo
   FROM stdtbl S 
      INNER JOIN stdclubtbl SC
           ON S.stdName = SC.stdName
      INNER JOIN clubtbl C
           ON SC.clubName = C.clubName 
   ORDER BY S.stdName;
  
SELECT C.clubName, C.roomNo, S.stdName, S.addr
   FROM  stdtbl S
      INNER JOIN stdclubtbl SC
         ON SC.stdName = S.stdName
      INNER JOIN clubtbl C
          ON SC.clubName = C.clubName
    ORDER BY C.clubName;
