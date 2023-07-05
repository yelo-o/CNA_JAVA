--mango_user 테이블 변경 사항
--컬럼 이름 변경
ALTER TABLE mango_user RENAME COLUMN ADRESS TO ADDRESS;

--shop_review 테이블 변경 사항
--1. 별점 컬럼 추가
ALTER TABLE shop_review ADD review_rating Number(1);

--2. 별점 제약조건(not null) 추가
ALTER TABLE shop_review
MODIFY review_rating CONSTRAINT review_rating_nn NOT NULL;
--3. 커밋
COMMIT;

--3. 리뷰데이터 추가
INSERT INTO shop_review(shop_no, review_no, writer, review_content, review_date, review_rating)
VALUES(1, 1, 'flyordig', 'very good', SYSDATE, 5);

--리뷰데이터 수정
UPDATE shop_review SET review_content='very good' WHERE review_no=0;

--리뷰데이터 삭제
DELETE shop_review WHERE review_no = 2;
