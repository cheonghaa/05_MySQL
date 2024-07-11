-- world.city 테이블에서
-- district가 2개이상인 국가들을 대상으로
-- 국가, district별로 인구수합을 구하기.
-- (국가별 소합계도 표시)

use world;

select * from city;

select countrycode, District, sum(population)
from city
WHERE countrycode = (select countrycode
						from city
						group by district
                        having count(*) >= 2)
GROUP BY countrycode, district with ROLLUP;


 -- country code가 같으면서 district 의 카운트를 세어야함
 -- 이 district의 카운트가 2개 이상이어야 함
        