--Ʈ����� : �۾�����

CREATE TABLE account(
no varchar2(3) primary key,
balance number(6)
);

INSERT INTO account(no, balance) VALUES ('101', 100); --tx-0 ����
INSERT INTO account(no, balance) VALUES ('102', 100);
COMMIT; --tx-0 �Ϸ�(DB �ݿ�)
--������ü
UPDATE account SET balance = balance - 10 WHERE no = '101'; --tx-1 ����
UPDATE account SET balance = balance + 10 WHERE no = '102';
SELECT * FROM account; --Ȯ��
COMMIT; --tx-1 �Ϸ�(DB �ݿ�)

UPDATE account SET balance = balance - 10 WHERE no = '101'; --1�� : ��ݼ��� --tx-2 ����
UPDATE account SET balance = balance + 10 WHERE no = 'xxx'; --0�� : �Աݽ���
SELECT * FROM account; --Ȯ��

UPDATE account SET balance = balance - 10 WHERE no = 'yyy'; --0�� : ��ݽ���
UPDATE account SET balance = balance + 10 WHERE no = '102'; --1�� : �Աݽ���
SELECT * FROM account; --Ȯ��
ROLLBACK; --�߰��� ���а� ����Ƿ� tx-2 ���(DB�� �ݿ�x)
SELECT * FROM account; --Ȯ��

INSERT INTO account(no, balance) VALUES('103', 0);
SAVEPOINT p1;

UPDATE account SET balance=balance+10 WHERE no='103';
SAVEPOINT p2;

DELETE account WHERE no = '103';

ROLLBACK TO p2; --DELETE ���
ROLLBACK TO p1; --UPDATE ���
ROLLBACK;--INSERT ���

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
DELETE product WHERE prod_name='���Ӻ��������';

INSERT INTO product VALUES('F0003', 'ġŲ������ġ', null);
SELECT * FROM PRODUCT;
INSERT INTO product VALUES('D0001', '���Ӻ��������', 3000);
COMMIT;

UPDATE product SET prod_price = 1500 WHERE prod_no='C0001';
ROLLBACK;