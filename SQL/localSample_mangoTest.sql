--1. ACCOUNT 테이블 생성
CREATE TABLE account(
    user_id VARCHAR2(10) ,
    user_pwd VARCHAR2(20),
    user_type NUMBER(1),
    user_status NUMBER(1)
);
--ACCOUNT 제약조건
ALTER TABLE account
ADD CONSTRAINT user_id_pk PRIMARY KEY(user_id); --user_id에 PK 제약조건 추가

--2. SHOP 테이블 생성
CREATE TABLE shop(
    shop_no NUMBER(5),
    shop_name VARCHAR2(20)
);
--SHOP 제약조건
ALTER TABLE shop
ADD CONSTRAINT shop_no_pk PRIMARY KEY(shop_no); --shop_no에 PK 제약조건 추가

--3. REVIEW 테이블 생성
CREATE TABLE review(
    review_no NUMBER(5),
    review_content VARCHAR2(100),
    review_rating NUMBER(1),
    review_date DATE,
    user_id VARCHAR2(20),
    shop_no NUMBER(5)
);
--REVIEW 제약조건
ALTER TABLE review
ADD CONSTRAINT review_no_pk PRIMARY KEY(review_no)--review_no에 PK 제약조건 추가
ADD CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES account(user_id)
ADD CONSTRAINT shop_no_fk FOREIGN KEY(shop_no) REFERENCES shop(shop_no);

--4. MENU 테이블 생성
CREATE TABLE menu(
    menu_no NUMBER(5),
    shop_no NUMBER(5),
    menu_price NUMBER(10),
    CONSTRAINT menu_no_pk PRIMARY KEY(menu_no),
    CONSTRAINT menu_shop_no_fk FOREIGN KEY(shop_no) REFERENCES shop(shop_no)
);

--사용자 'id1','id2' 추가
INSERT INTO account(user_id, user_pwd, user_type, user_status)
VALUES ('id1', 'pwd1', 1, 1);
INSERT INTO account(user_id, user_pwd, user_type, user_status)
VALUES ('id2', 'pwd2', 1, 1);

--음식점 'shop1', 'shop2' 추가
INSERT INTO shop(shop_no, shop_name)
VALUES (1, 'shop1');
INSERT INTO shop(shop_no, shop_name)
VALUES (2, 'shop2');

--리뷰 추가
INSERT INTO review(review_no, review_content, review_rating, review_date, user_id, shop_no)
VALUES (1, '너무 맛있어요!', 5, SYSDATE, 'id1', 1);

INSERT INTO review(review_no, review_content, review_rating, review_date, user_id, shop_no)
VALUES (2, '맛대가리없어요 ㅠㅠ', 1, SYSDATE, 'id2', 2);

--리뷰 삭제
DELETE review WHERE user_id='id1' AND shop_no=1;

--리뷰 내용 수정
update review SET review_content = '소소한 맛이네요' WHERE user_id='id2' AND shop_no=2;

--되돌리기(커밋 안 했을 때만)
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