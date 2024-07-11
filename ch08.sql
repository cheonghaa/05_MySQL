-- ch08 실습
-- drop database tabledb;

-- create database tabledb;

DROP TABLE IF EXISTS buytbl;
DROP TABLE IF EXISTS usertbl;

CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    NAME VARCHAR(10) NOT NULL,
    BIRTHYEAR INT NOT NULL,
    ADDR CHAR(2) NOT NULL,
    MOBILE1 CHAR(3) NULL,
    MOBILE2 CHAR(8) NULL,
    HEIGHT SMALLINT NULL,
    MDATE DATE NULL
    );
    


CREATE TABLE buytbl(
	num INT auto_increment NOT NULL PRIMARY KEY,
    userid CHAR(8) NOT NULL,
    prodName CHAR(6) NOT NULL,
    groupName CHAR(4) NULL,
    price INT NOT NULL,
    amount SMALLINT NOT NULL,
    FOREIGN KEY(userid) REFERENCES usertbl(userID)
    );
    
insert into usertbl VALUES ('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
insert into usertbl VALUES ('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
insert into usertbl VALUES  ('kkh', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

-- INSERT into buytbl VALUES ('KBS', '운동화', NULL, 30, 2);
-- INSERT into buytbl VALUES ('KBS', '노트북', '전자', 1000, 1);
-- INSERT into buytbl VALUES ('JYP', '모니터', '전자', 200, 1);
-- 에러가 나게 되는 이유 : 입력한 value들이 컬럼의 개수와 맞지 않기 때문

-- DROP TABLE IF EXISTS buytbl;
-- DROP TABLE IF EXISTS usertbl;

-- CREATE TABLE usertbl(
-- 	userID CHAR(8) NOT NULL PRIMARY KEY,
--     NAME VARCHAR(10) NOT NULL,
--     BIRTHYEAR INT NOT NULL
--     );
    
DROP TABLE IF EXISTS prodtbl;
CREATE TABLE prodTBL (
	prodCode CHAR(3) NOT NULL,
    prodID VARCHAR(4) NOT NULL,
    prodDate DATETIME NOT NULL,
    prodCur CHAR(10) NULL,
    CONSTRAINT PK_prodTbl_prodCode_proID
				primary key(prodCode, prodID)
    );
    
SHOW INDEX from prodtbl;
