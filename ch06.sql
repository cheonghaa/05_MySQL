use employees;

select * from employees
where first_name = 'georgi';

use world;
select * from city
Where countrycode = 'kor'
order by population desc;

-- 우리나라에서 제주의 인구수보다 작은 도시를 찾아 인구수를 내림차순으로 출력해보기
Select name, population from city
Where countrycode = 'kor' and
population < (
select population
From city
where name='cheju')
order by population DESC;

-- use employees;
-- create table users
-- (Select first_name as name, gender from employees);

use world;
select * from city
where countrycode = 'kor';

-- create table kor_city
-- (select id, name, district, population 
-- from city 
-- where countrycode = 'kor');

select * from kor_city;

-- 	city 테이블을 사용하여 국가별 총 인구수
use world;
SELECT countrycode, sum(population) as '인구수'
FROM city
GROUP BY countrycode
HAVING sum(population) > 10000000
ORDER BY sum(population) desc;
-- 별칭(여기선 '인구수')으로 order by를 사용할 수는 없다.



