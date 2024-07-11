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
    