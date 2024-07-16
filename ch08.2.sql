-- VIEW 실습

use sqldb;

select * from buytbl;

select userID, sum(amount)
from buytbl
group by userId;