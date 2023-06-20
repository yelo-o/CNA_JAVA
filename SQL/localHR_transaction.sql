--트랜잭션 : 작업단위

CREATE TABLE account(
no varchar2(3) primary key,
balance number(6)
);

INSERT INTO account(no, balance) VALUES ('101', 100); --tx-0 생성
INSERT INTO account(no, balance) VALUES ('102', 100);
COMMIT; --tx-0 완료(DB 반영)
--계좌이체
UPDATE account SET balance = balance - 10 WHERE no = '101'; --tx-1 생성
UPDATE account SET balance = balance + 10 WHERE no = '102';
SELECT * FROM account; --확인
COMMIT; --tx-1 완료(DB 반영)

UPDATE account SET balance = balance - 10 WHERE no = '101'; --1건 : 출금성공 --tx-2 생성
UPDATE account SET balance = balance + 10 WHERE no = 'xxx'; --0건 : 입금실패
SELECT * FROM account; --확인

UPDATE account SET balance = balance - 10 WHERE no = 'yyy'; --0건 : 출금실패
UPDATE account SET balance = balance + 10 WHERE no = '102'; --1건 : 입금실패
SELECT * FROM account; --확인
ROLLBACK; --중간에 실패가 생기므로 tx-2 취소(DB에 반영x)
SELECT * FROM account; --확인

INSERT INTO account(no, balance) VALUES('103', 0);
SAVEPOINT p1;

UPDATE account SET balance=balance+10 WHERE no='103';
SAVEPOINT p2;

DELETE account WHERE no = '103';

ROLLBACK TO p2; --DELETE 취소
ROLLBACK TO p1; --UPDATE 취소
ROLLBACK;--INSERT 취소

DELETE account WHERE no = '101';
SELECT * FROM account;
DELETE account WHERE no = '102';
ROLLBACK;

SELECT *
FROM (SELECT rownum rn, a.*
        FROM(SELECT *
            From product
            ORDER BY prod_name) a
            )
WHERE rn BETWEEN 4 AND 6;
DELETE product WHERE prod_name='라임블렌디드음료';

INSERT INTO product VALUES('F0003', '치킨샌드위치', null);
SELECT * FROM PRODUCT;
INSERT INTO product VALUES('D0001', '라임블렌디드음료', 3000);
COMMIT;

UPDATE product SET prod_price = 1500 WHERE prod_no='C0001';
ROLLBACK;