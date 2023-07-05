--mango_user ���̺� ���� ����
--�÷� �̸� ����
ALTER TABLE mango_user RENAME COLUMN ADRESS TO ADDRESS;

--shop_review ���̺� ���� ����
--1. ���� �÷� �߰�
ALTER TABLE shop_review ADD review_rating Number(1);

--2. ���� ��������(not null) �߰�
ALTER TABLE shop_review
MODIFY review_rating CONSTRAINT review_rating_nn NOT NULL;
--3. Ŀ��
COMMIT;

--3. ���䵥���� �߰�
INSERT INTO shop_review(shop_no, review_no, writer, review_content, review_date, review_rating)
VALUES(1, 1, 'flyordig', 'very good', SYSDATE, 5);

--���䵥���� ����
UPDATE shop_review SET review_content='very good' WHERE review_no=0;

--���䵥���� ����
DELETE shop_review WHERE review_no = 2;
