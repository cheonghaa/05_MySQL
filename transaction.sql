use sqldb;
select * from buytbl;

START transaction;
DELETE FROM buytbl WHERE num = 1;
DELETE from buytbl WHERE num = 2;

SELECT * FROM buytbl;

ROLLBACK;
