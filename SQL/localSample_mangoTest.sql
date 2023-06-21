--1. ACCOUNT ���̺� ����
CREATE TABLE account(
    user_id VARCHAR2(10) ,
    user_pwd VARCHAR2(20),
    user_type NUMBER(1),
    user_status NUMBER(1)
);
--ACCOUNT ��������
ALTER TABLE account
ADD CONSTRAINT user_id_pk PRIMARY KEY(user_id); --user_id�� PK �������� �߰�

--2. SHOP ���̺� ����
CREATE TABLE shop(
    shop_no NUMBER(5),
    shop_name VARCHAR2(20)
);
--SHOP ��������
ALTER TABLE shop
ADD CONSTRAINT shop_no_pk PRIMARY KEY(shop_no); --shop_no�� PK �������� �߰�

--3. REVIEW ���̺� ����
CREATE TABLE review(
    review_no NUMBER(5),
    review_content VARCHAR2(100),
    review_rating NUMBER(1),
    review_date DATE,
    user_id VARCHAR2(20),
    shop_no NUMBER(5)
);
--REVIEW ��������
ALTER TABLE review
ADD CONSTRAINT review_no_pk PRIMARY KEY(review_no)--review_no�� PK �������� �߰�
ADD CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES account(user_id)
ADD CONSTRAINT shop_no_fk FOREIGN KEY(shop_no) REFERENCES shop(shop_no);

--4. MENU ���̺� ����
CREATE TABLE menu(
    menu_no NUMBER(5),
    shop_no NUMBER(5),
    menu_price NUMBER(10),
    CONSTRAINT menu_no_pk PRIMARY KEY(menu_no),
    CONSTRAINT menu_shop_no_fk FOREIGN KEY(shop_no) REFERENCES shop(shop_no)
);

--����� 'id1','id2' �߰�
INSERT INTO account(user_id, user_pwd, user_type, user_status)
VALUES ('id1', 'pwd1', 1, 1);
INSERT INTO account(user_id, user_pwd, user_type, user_status)
VALUES ('id2', 'pwd2', 1, 1);

--������ 'shop1', 'shop2' �߰�
INSERT INTO shop(shop_no, shop_name)
VALUES (1, 'shop1');
INSERT INTO shop(shop_no, shop_name)
VALUES (2, 'shop2');

--���� �߰�
INSERT INTO review(review_no, review_content, review_rating, review_date, user_id, shop_no)
VALUES (1, '�ʹ� ���־��!', 5, SYSDATE, 'id1', 1);

INSERT INTO review(review_no, review_content, review_rating, review_date, user_id, shop_no)
VALUES (2, '���밡������� �Ф�', 1, SYSDATE, 'id2', 2);

--���� ����
DELETE review WHERE user_id='id1' AND shop_no=1;

--���� ���� ����
update review SET review_content = '�Ҽ��� ���̳׿�' WHERE user_id='id2' AND shop_no=2;

--�ǵ�����(Ŀ�� �� ���� ����)
REVOKE;

DROP TABLE shop;
DROP TABLE review;
DROP TABLE account;
DROP TABLE menu;
commit;
SELECT review_no FROM review;

SELECT * FROM shop WHERE shop_name LIKE '%shop%';

ALTER TABLE review
MODIFY review_content VARCHAR2(30);