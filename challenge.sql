-- world.city 테이블에서
-- district가 2개이상인 국가들을 대상으로
-- 국가, district별로 인구수합을 구하기.
-- (국가별 소합계도 표시)

use world;

select * from city;

SELECT countrycode, District, SUM(population)
FROM city
WHERE countrycode IN (
    SELECT countrycode
    FROM city
    GROUP BY countrycode
    HAVING COUNT(distinct district) >= 2
)
GROUP BY countrycode, district WITH ROLLUP;



-- 정답 코드
SELECT countrycode,District,sum(Population) 
from world.city 
WHERE CountryCode 
in (SELECT CountryCode from world.city 
group by CountryCode 
having count(District) > 1 ) 
group by countrycode, District WITH ROLLUP 
-- order by sum(Population) ;

 -- country code가 같으면서 district 의 카운트를 세어야함
 -- 이 district의 카운트가 2개 이상이어야 함
        