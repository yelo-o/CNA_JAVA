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