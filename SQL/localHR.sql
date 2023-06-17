SELECT * FROM employees;

--급여가 5000이상인 사원의 사번, 급여, 부서번호를 출력하시오
SELECT employee_id, salary, department_id
FROM employees
WHERE salary >= 5000;

--급여가 5000이상인 사원의 부서별 부서번호, 총급여를 출력하시오
SELECT department_id, SUM(salary) --처리순서4
FROM employees --처리순서1
WHERE salary >= 5000 --처리순서2
GROUP BY department_id; --처리순서3

--급여가 5000이상인 사원의 부서별 부서번호, 총급여를 출력하시오
--단, 총부서별 총급여가 20000이하인 부서들만 출력한다 <- HAVING절 필요
SELECT department_id, SUM(salary) --처리순서4
FROM employees --처리순서1
WHERE salary >= 5000 --처리순서2
GROUP BY department_id --처리순서3
HAVING SUM(salary) < 20000;

--부서별 직무별 부서번호, 직무번호, 사원수를 출력하시오
--단, 작은 부서번호부터, 사원수 많은 직무부터 출력한다
SELECT department_id 부서번호, job_id 직무번호, COUNT(*) 사원수
FROM employees
GROUP BY department_id, job_id
ORDER BY department_id, 사원수 DESC;

--부서별 최대급여를 출력하시오
SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id;


--부서별 최대급여자의 사번, 이름, 급여를 출력하시오 : SUBQUERY로 해결
SELECT department_id
       , employee_id, first_name, salary
FROM employees
GROUP BY department_id;

--지역별 지역번호(location_id), 부서수를 출력하시오
SELECT location_id, COUNT(*)
FROM departments
GROUP BY location_id;

--급여가 5000이상인 사원의 부서별 부서번호, 총급여를 출력하시오
--단, 총부서별 총급여가 20000이하인 부서들만 출력한다 <- HAVING절 필요
--부서배치를 받지못한 사원은 제외한다
SELECT department_id, SUM(salary)
FROM employees --처리순서1
WHERE salary >= 5000 AND department_id IS NOT NULL --처리순서2
GROUP BY department_id --처리순서3
HAVING SUM(salary) < 20000;


SELECT employee_id, department_id
FROM employees; --107건

SELECT department_id, department_name
FROM departments; --27건

--카티션프로덕트 : 조건없는 조인(행 곱하기 행)
SELECT employee_id, department_name 
FROM employees, departments; --아무조건없이 결합(107건 * 27건)

--표준(ANSI)조인

--사원의 사번, 이름, 부서번호, 부서명을 출력하시오 : 106건
SELECT employee_id, employees.department_id, department_name
FROM employees 
JOIN departments ON (employees.department_id = departments.department_id);

SELECT employee_id, e.department_id, department_name
FROM employees e
JOIN departments d ON (e.department_id = d.department_id);


--사원의 사번, 이름, 부서번호, 부서명, 직무번호, 직무명을 출력하시오
SELECT employee_id, employees.department_id, department_name, employees.job_id, job_title
FROM employees
JOIN departments ON (employees.department_id = departments.department_id)
JOIN jobs ON (employees.job_id = jobs.job_id);

SELECT employee_id, e.department_id, department_name, e.job_id, job_title
FROM employees e
JOIN departments d ON (e.department_id = d.department_id)
JOIN jobs j ON (e.job_id = j.job_id);

--국가의 국가번호(country_id), 국가이름(country_name), 도시명(city)을 출력하시오
SELECT * FROM countries; --25건
SELECT * FROM locations; --23건

SELECT 1.country_id
      ,c.country_name
      ,l.city
FROM locations l
JOIN countries c ON (l.country_id = c.country_id);

--NATURAL JOIN
--사원의 사번, 직무번호, 직무명을 출력하시오
SELECT employee_id, jobs.job_id, jobs.job_title
FROM employees
JOIN jobs ON (employees.job_id = jobs.job_id);

--위의 코드를 NATURAL JOIN으로 변경 (1:1 대응이 되는 경우)
SELECT employee_id, job_id, job_title
FROM employees NATURAL JOIN jobs;

--NATURAL JOIN을 쓰면 안되는 경우

--JOIN ON 사용
--사원의 사번, 부서번호, 부서명을 출력하시오 : 106건
SELECT employee_id, departments.department_id, departments.department_name
FROM employees JOIN departments ON (employees.department_id = departments.department_id);

--NATURAL JOIN 사용
--사원의 사번, 부서번호, 부서명을 출력하시오 : 32건 <- 사용하면 안됨
SELECT employee_id, department_id, department_name
FROM employees NATURAL JOIN departments;

--위와 같은 구문을 JOIN ON으로 사용하면 이와 같음
SELECT employee_id, employees.department_id, department_name
FROM employees JOIN departments
ON (employees.department_id = departments.department_id AND employees.manager_id = departments.manager_id);

--3) JOIN USING 사용
--사원의 사번, 직무번호, 직무명을 출력하시오
--JOIN ON 사용
SELECT employee_id, jobs.job_id, jobs.job_title
FROM employees
JOIN jobs ON (employees.job_id = jobs.job_id);

--JOIN USING으로 변경
SELECT employee_id, job_id, job_title
FROM employees JOIN jobs USING (job_id);

--JOIN ON 사용
--사원의 사번, 부서번호, 부서명을 출력하시오 : 106건
SELECT employee_id, departments.department_id, departments.department_name
FROM employees JOIN departments ON (employees.department_id = departments.department_id);

--JOIN USING으로 변경
SELECT employee_id, department_id, department_name
FROM employees JOIN departments USING(department_id);


--OUTER JOIN
--전체 사원의 사번, 부서번호, 부서명을 출력하시오 : 107건
SELECT employee_id, employees.department_id, department_name
FROM employees LEFT OUTER JOIN departments --왼쪽 테이블(employees) 이 기준이다.
ON (employees.department_id = departments.department_id);

--모든 국가의 국가번호(country_id), 국가이름(country_name), 도시명(city)을 출력하시오
--도시가 등록안된 국가도 출력한다
SELECT country_id, country_name, city
FROM countries LEFT OUTER JOIN locations USING(country_id);

SELECT country_id, country_name, city
FROM locations RIGHT OUTER JOIN countries
USING(country_id);

--전체 사원의 사번, 부서번호, 부서명을 출력하시오
--부서 없는 사원도 출력하고, 사원이 없는 부서도 출력한다

SELECT employee_id, e.department_id, department_name
FROM employees e LEFT JOIN departments d
ON(e.department_id = d.department_id); --부서 없는 사원도 출력 : 107건

SELECT employee_id, e.department_id, department_name
FROM employees e RIGHT JOIN departments d
ON(e.department_id = d.department_id); --사원 없는 부서도 출력 : 122건

SELECT employee_id, e.department_id, department_name
FROM employees e FULL JOIN departments d
ON(e.department_id = d.department_id); --부서 없는 사원도 출력 : 123건

SELECT first_name, employee_id FROM employees;
SELECT first_name, manager_id FROM employees;

--SELF JOIN
--물리적으로 1개의 테이블을 2개의 테이블인 것처럼 생각
--사원의 사번, 이름, 관리자번호, 관리자이름을 출력하시오
SELECT e.employee_id 사번, e.first_name 이름
     , m.employee_id 관리자번호, m.first_name 관리자이름
FROM employees e JOIN employees m ON (e.manager_id = m.employee_id);

--사원의 사번, 이름, 사원부서 관리자번호, 관리자이름, 관리자 소속부서을 출력하시오
--사원부서와 관리자부서가 다른 사원들만 출력한다
SELECT e.employee_id 사번, e.first_name 이름, e.department_id 사원소속부서
     , m.employee_id 관리자번호, m.first_name 관리자이름, m.department_id 관리자소속부서
FROM employees e JOIN employees m ON (e.manager_id = m.employee_id)
WHERE e.department_id <> m.department_id;

--사원의 사번, 이름, 사원급여, 관리자번호, 관리자이름, 관리자급여를 출력하시오
--사원급여가 관리자급여보다 많은 사원들만 출력하시오
SELECT e.employee_id 사번, e.first_name 이름, e.salary 사원급여
     , m.employee_id 관리자번호, m.first_name 관리자이름, m.salary 관리자급여
FROM employees e JOIN employees m ON (e.manager_id = m.employee_id)
WHERE e.salary > m.salary;

SELECT * FROM job_history
ORDER BY employee_id;

--사원의 사번, 직무번호를 출력하시오
SELECT employee_id, job_id
FROM employees;

--사원경력정보(사번,이전직무번호)를 출력하시오
SELECT employee_id, job_id
FROM job_history;

--경력정보와 현재사원의 사번, 직무번호를 출력하시오
--UNION
SELECT employee_id, job_id --115건
FROM employees
UNION
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;
--UNION ALL
SELECT employee_id, job_id --117건
FROM employees
UNION ALL
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;

--이전 직무와 다른 직무를 담당하는 사원의 사번, 직무번호를 출력하시오
SELECT employee_id, job_id --105건
FROM employees
MINUS
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;

--이전직무와 같은 직무를 담당하는 사원의 사번, 직무번호를 출력하시오
SELECT employee_id, job_id --2건
FROM employees
INTERSECT
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;

--1. 급여가 10000 이상인 사원의 사번, 부서번호, 이름, 급여, 수당을 출력하시오.단, 부서번호가
--   30 번,60 번, 90 번인 부서는 제외하고 사원을 검색한다
SELECT employee_id 사번, department_id 부서번호, first_name 이름, salary 급여, salary*commission_pct 수당 
FROM employees
WHERE salary >=10000 AND NOT department_id IN(30,60,90);


--2.급여가 4000 보다 많은 사원들의 부서별 급여평균를 출력하시오. 단 급여평균은 소숫점이하 2 자리에서 반올림(소숫점이하1자리까지 표현)한다
SELECT department_id 부서, SUM(salary) 합계, COUNT(*) 사원수, ROUND(AVG(salary),1) 급여평균
FROM employees
WHERE salary >=4000
GROUP BY department_id;

--3. 부서배치를 받지 않은 사원은 제외하고 급여평균이 10000 이상인 부서별 급여평균을 출력하시오.
SELECT department_id 부서, ROUND(AVG(salary),1) 급여평균
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING ROUND(AVG(salary),1) >= 10000;

--4. 'Seattle', 'Toronto'도시에 근무하는 사원들의 
--   근무도시명,사번, 이름, 부서 ID, 부서명 을 출력하시오
SELECT city, employee_id, first_name, e.department_id, department_name
FROM employees e
JOIN departments d ON (e.department_id = d.department_id)
JOIN locations l ON (d.location_id = l.location_id)
WHERE l.city IN ( 'Seattle', 'Toronto');

--5. 성(last_name)이 'Davies'인 사원과 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력하시오
SELECT e.employee_id, e.last_name, e.first_name
FROM employees e JOIN employees d ON (e.department_id = d.department_id)
WHERE d.last_name = 'Davies';

--5-1 번외. 성(last_name)이 'Davies'인 사원과 같은 부서에 근무하는
--   사원들의 사번, 성, 이름을 출력하시오
--   Davies는 제외하고 출력한다
SELECT e.employee_id, e.last_name, e.first_name
FROM employees e JOIN employees d ON (e.department_id = d.department_id)
WHERE d.last_name = 'Davies' AND e.last_name <> 'Davies';

--사원의 최대급여를 출력하시오
SELECT  MAX(salary)
FROM employees;

--사원의 최대급여자의 사번, 이름, 급여를 출력하시오
--1) 사원의 최대급여를 계산한다
--2) 1)과 같은 급여를 갖는 사원 검색, 출력한다
SELECT employee_id, first_name, salary
FROM employees 
WHERE salary = (SELECT MAX(salary)
                FROM employees
                );
                
--성(last_name)이 'Davies'인 사원과 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력하시오
--1) 성(last_name)이 'Davies'의 부서번호를 검색한다
--2) 1)과 같은 부서번호를 갖는 사원 검색, 출력
SELECT employee_id, last_name, first_name 
FROM employees
WHERE department_id=(SELECT department_id
                     FROM employees
                     WHERE last_name = 'Davies'
                     )
AND last_name <> 'Davies';

--부서별 최대급여를 출력하시오
SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id;

--부서별 최대급여자의 부서번호, 사번, 이름, 급여를 출력하시오
--1) 부서별 최대급여 계산
--2) 1)과 같은 급여를 갖는 사원 검색, 출력
SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE salary IN (SELECT MAX(salary)
                FROM employees
                GROUP BY department_id
                ); --24건(x)
--메인쿼리와 서브쿼리의 PAIRWISING 필요
SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN (SELECT department_id, MAX(salary)
                                FROM employees
                                GROUP BY department_id
                                ); --11건(O)
                                
SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE (NVL(department_id, 0), salary) IN (SELECT NVL(department_id, 0), MAX(salary)
                                FROM employees
                                GROUP BY department_id
                                ); --12건(부서없는 사원도 출력)
                                
--부서별 최대급여자를 제외한 사원의 부서번호, 사번, 이름, 급여를 출력하시오
--1) 부서별 최대급여자의 부서번호, 최대급여계산
--2) 1)과 다른 부서번호, 급여를 갖는 사원을 검색, 출력

SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE (department_id, salary) NOT IN (SELECT department_id, MAX(salary)
                                      FROM employees
                                      GROUP BY department_id
                                      );
-- =ANY는 IN과 같음, >ANY, <ANY
-- =ALL, >ALL, <ALL
SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE (NVL(department_id, 0), salary) =ANY (SELECT NVL(department_id, 0), MAX(salary)
                                            FROM employees
                                            GROUP BY department_id
                                           ); --12건(부서없는 사원도 출력)
--InlineView
--사원의 사번, 급여를 출력하시오
SELECT rownum, employee_id, salary
FROM employees;

--입사일자가 '07/01/01' 이후 입사한 사원의 행번호, 사번, 급여를 출력하시오
SELECT rownum, employee_id, hire_date, salary
FROM employees
WHERE hire_date >= '07/01/01';

--입사일자가 '07/01/01' 이후 입사한 사원의 행번호, 사번, 급여를 출력하시오
--적은 급여자부터 출력한다
SELECT rownum, employee_id, hire_date, salary
FROM employees
WHERE hire_date >= '07/01/01'
ORDER BY salary;

--입사일자가 '07/01/01' 이후 입사한 사원의 행번호, 사번, 급여를 출력하시오
--적은 급여자부터 출력한다
--급여가 작은 순서대로 5명(5개의 행) 뽑기
SELECT rownum, employee_id, hire_date, salary
FROM (
      select employee_id, hire_date, salary
      From employees
      WHERE hire_date >= '07/01/01'
      ORDER BY salary
      )
WHERE rownum <= 5;

--입사일자가 '07/01/01' 이후 입사한 사원의 행번호, 사번, 급여를 출력하시오
--적은 급여자부터 6행부터 10행만 출력한다
SELECT rownum, employee_id, hire_date, salary
FROM (
      select employee_id, hire_date, salary
      From employees
      WHERE hire_date >= '07/01/01'
      ORDER BY salary
      )
WHERE rownum BETWEEN 6 AND 10 ; --rownum의 초기값은 1이기 때문에 출력안됨

--해결방법 #1
SELECT rn, employee_id, hire_date, salary
FROM( SELECT rownum rn, employee_id, hire_date, salary
      FROM (
            select employee_id, hire_date, salary
            From employees
            WHERE hire_date >= '07/01/01'
            ORDER BY salary
      )
)
WHERE rn BETWEEN 6 AND 10;
--해결방법 #2 (축약)
SELECT *
FROM( SELECT rownum rn, a.*
      FROM (
            select employee_id, hire_date, salary
            From employees
            WHERE hire_date >= '07/01/01'
            ORDER BY salary
      ) a
)
WHERE rn BETWEEN 6 AND 10;

--입사일자가 '07/01/01' 이후 입사한 사원의 행번호, 사번, 급여를 출력하시오
--적은급여자부터 출력한다
--2페이지만 출력한다
--한페이지는 최대 10개행이다
SELECT *
FROM( SELECT rownum rn, a.*
      FROM (
            select employee_id, hire_date, salary
            From employees
            WHERE hire_date >= '07/01/01'
            ORDER BY salary
      ) a
)
WHERE rn BETWEEN 11 AND 20;

--5. Scalar Subquery
--사원의 사번, 이름, 부서번호, 부서명을 출력하시오
--JOIN ON 해결
SELECT employee_id, first_name, d.department_id, d.department_name
FROM employees e JOIN departments d ON (e.department_id = d.department_id);
--Scalar Subquery 해결
SELECT employee_id, first_name, department_id,
    (SELECT department_name
     FROM departments
     WHERE department_id = employees.department_id)
FROM employees;

--사원의 부서별 부서번호, 부서명, 총급여를 출력하시오
--JOIN ON 해결 <- INNER JOIN 이므로 부서없으면 출력 안됨
SELECT e.department_id, department_name, SUM(salary)
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
GROUP BY e.department_id, department_name;
--부서없는 사원들도 출력 <-LEFT OUTER JOIN 사용
SELECT e.department_id, department_name, SUM(salary)
FROM employees e LEFT JOIN departments d ON (e.department_id = d.department_id)
GROUP BY e.department_id, department_name;


--Scalar Subquery 해결 <- 부서가 null인 것도 출력
SELECT department_id,
       (SELECT department_name 
       FROM departments 
       WHERE department_id = employees.department_id),
       SUM(salary)
FROM employees
GROUP BY department_id;

--'Sales'부서의 평균급여를 출력하시오
SELECT department_name, ROUND(AVG(salary),0)
FROM employees e
JOIN departments d ON(e.department_id = d.department_id) 
WHERE department_name ='Sales'
GROUP BY department_name;

--'Sales' 부서의 평균급여보다 많은 급여를 받는 사원의 부서번호, 급여를 출력
SELECT department_name, SUM(salary) ,COUNT(*)
FROM employees e
JOIN departments d ON(e.department_id = d.department_id) 
WHERE department_name ='Sales'
GROUP BY department_name;

--'Sales' 부서의 평균급여보다 많은 급여를 받는 사원의 부서번호, 급여를 출력
SELECT employee_id, department_id, salary
FROM employees e
WHERE e.salary > (
                 SELECT ROUND(AVG(salary),0)
                 FROM employees e
                 JOIN departments d ON(e.department_id = d.department_id) 
                 WHERE department_name ='Sales'
                 GROUP BY department_name
                 );
                 
--'Sales' 부서의 평균급여보다 많은 급여를 받는 'Sales' 사원의 부서번호, 급여를 출력
--방법 #1
SELECT employee_id, department_id, salary
FROM employees e
WHERE e.salary > (
                 SELECT ROUND(AVG(salary),0)
                 FROM employees e
                 JOIN departments d ON(e.department_id = d.department_id) 
                 WHERE department_name ='Sales'
                 GROUP BY department_name
                 ) AND e.department_id = 
                                       (SELECT department_id
                                        FROM departments
                                        WHERE department_name = 'Sales');
                 
--방법 #2
SELECT employee_id, department_id, salary
FROM employees
WHERE department_id = (SELECT department_id
											 FROM departments
											 WHERE department_name = 'Sales')
AND salary > (SELECT AVG(salary)
              FROM employees
              WHERE department_id = (SELECT department_id
                                     FROM departments
                                     WHERE department_name = 'Sales')
                                     );
                         
--방법 #2 (상호연관서브쿼리로 줄이기)
SELECT employee_id, department_id, salary
FROM employees e
WHERE department_id = (SELECT department_id
                       FROM departments
                       WHERE department_name = 'Sales')
AND salary > (SELECT AVG(salary)
              FROM employees
              WHERE department_id = e.department_id);


--1. 테이블 생성
CREATE TABLE product(
	prod_no VARCHAR2(5),
	prod_name VARCHAR2(20) 
);
--테이블 구조 확인
DESC product

--2. 테이블 구조 변경
ALTER TABLE product
ADD prod_price NUMBER(6);

ALTER TABLE product
ADD a NUMBER(1);

--2)컬럼이름변경
ALTER TABLE product
RENAME COLUMN a to abc;

--3)컬럼의 자료형 또는 자릿수 변경
ALTER TABLE product
MODIFY prod_price NUMBER(6);

--4)컬럼 삭제
ALTER TABLE product
DROP COLUMN abc;

--3)테이블 제거
DROP TABLE product;

--DML
--1. 데이터 추가
INSERT INTO product(prod_no, prod_name) VALUES ('C0001', '아메리카노' );

SELECT * FROM product;

INSERT INTO product(prod_no, prod_name) VALUES ('C0002', '라떼' );

-- prod_price 기본값 null에서 0으로 변경
ALTER TABLE product
MODIFY prod_price DEFAULT 0;

INSERT INTO product(prod_no, prod_name) VALUES ('C0003', '핫초코' );
INSERT INTO product(prod_no, prod_name) VALUES ('C0004', '아이스딸기아사이' );

--prod_name 의 크기 변경
ALTER TABLE product
MODIFY prod_name VARCHAR2(100);

--테이블 컬럼 나열 안함 product(, ,) -> product
INSERT INTO product VALUES ('F0001', '치즈케이크', 1000);
INSERT INTO product VALUES ('F0002', '치즈베이글', NULL); --prod_price를 null로 설정
INSERT INTO product VALUES ('F0003', '치킨샌드위치', ''); --prod_price를 null로 설정
INSERT INTO product VALUES ('F0003', '밀박스'); --상품가격입력 필수

INSERT INTO product VALUES ('C0001', '다른상품',0 ); --중복 추가가 되어버림 -> 식별자 역할을 못함
INSERT INTO product VALUES ('', '번호없는상품1',0 );
INSERT INTO product VALUES ('', '번호없는상품2',0 );

DELETE product WHERE prod_name = '다른상품';
DELETE product WHERE prod_no IS NULL;

-- 제약조건 추가
ALTER TABLE product
ADD CONSTRAINTS prod_no_pk PRIMARY KEY(prod_no);

--제약조건 추가 후 중복자료 추가 시도 - 안됨
INSERT INTO product VALUES ('C0001', '다른상품',0 );
--제약조건 추가 후 null 값 추가 시도 - 안됨
INSERT INTO product VALUES ('', '번호없는상품1',0 );

INSERT INTO product(prod_no, prod_name) VALUES ('D0001', '라임블렌디드'); --OK
INSERT INTO product(prod_no, prod_name) VALUES ('D0002', null);
DELETE product WHERE prod_name IS NULL; --prod_no가 (null)인 상품 삭제

--NOT NULL 제약 조건 추가
ALTER TABLE product
MODIFY prod_name CONSTRAINT prod_name_nn NOT NULL;
