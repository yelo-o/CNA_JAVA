SELECT * FROM employees;

--�޿��� 5000�̻��� ����� ���, �޿�, �μ���ȣ�� ����Ͻÿ�
SELECT employee_id, salary, department_id
FROM employees
WHERE salary >= 5000;

--�޿��� 5000�̻��� ����� �μ��� �μ���ȣ, �ѱ޿��� ����Ͻÿ�
SELECT department_id, SUM(salary) --ó������4
FROM employees --ó������1
WHERE salary >= 5000 --ó������2
GROUP BY department_id; --ó������3

--�޿��� 5000�̻��� ����� �μ��� �μ���ȣ, �ѱ޿��� ����Ͻÿ�
--��, �Ѻμ��� �ѱ޿��� 20000������ �μ��鸸 ����Ѵ� <- HAVING�� �ʿ�
SELECT department_id, SUM(salary) --ó������4
FROM employees --ó������1
WHERE salary >= 5000 --ó������2
GROUP BY department_id --ó������3
HAVING SUM(salary) < 20000;

--�μ��� ������ �μ���ȣ, ������ȣ, ������� ����Ͻÿ�
--��, ���� �μ���ȣ����, ����� ���� �������� ����Ѵ�
SELECT department_id �μ���ȣ, job_id ������ȣ, COUNT(*) �����
FROM employees
GROUP BY department_id, job_id
ORDER BY department_id, ����� DESC;

--�μ��� �ִ�޿��� ����Ͻÿ�
SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id;


--�μ��� �ִ�޿����� ���, �̸�, �޿��� ����Ͻÿ� : SUBQUERY�� �ذ�
SELECT department_id
       , employee_id, first_name, salary
FROM employees
GROUP BY department_id;

--������ ������ȣ(location_id), �μ����� ����Ͻÿ�
SELECT location_id, COUNT(*)
FROM departments
GROUP BY location_id;

--�޿��� 5000�̻��� ����� �μ��� �μ���ȣ, �ѱ޿��� ����Ͻÿ�
--��, �Ѻμ��� �ѱ޿��� 20000������ �μ��鸸 ����Ѵ� <- HAVING�� �ʿ�
--�μ���ġ�� �������� ����� �����Ѵ�
SELECT department_id, SUM(salary)
FROM employees --ó������1
WHERE salary >= 5000 AND department_id IS NOT NULL --ó������2
GROUP BY department_id --ó������3
HAVING SUM(salary) < 20000;


SELECT employee_id, department_id
FROM employees; --107��

SELECT department_id, department_name
FROM departments; --27��

--īƼ�����δ�Ʈ : ���Ǿ��� ����(�� ���ϱ� ��)
SELECT employee_id, department_name 
FROM employees, departments; --�ƹ����Ǿ��� ����(107�� * 27��)

--ǥ��(ANSI)����

--����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ� : 106��
SELECT employee_id, employees.department_id, department_name
FROM employees 
JOIN departments ON (employees.department_id = departments.department_id);

SELECT employee_id, e.department_id, department_name
FROM employees e
JOIN departments d ON (e.department_id = d.department_id);


--����� ���, �̸�, �μ���ȣ, �μ���, ������ȣ, �������� ����Ͻÿ�
SELECT employee_id, employees.department_id, department_name, employees.job_id, job_title
FROM employees
JOIN departments ON (employees.department_id = departments.department_id)
JOIN jobs ON (employees.job_id = jobs.job_id);

SELECT employee_id, e.department_id, department_name, e.job_id, job_title
FROM employees e
JOIN departments d ON (e.department_id = d.department_id)
JOIN jobs j ON (e.job_id = j.job_id);

--������ ������ȣ(country_id), �����̸�(country_name), ���ø�(city)�� ����Ͻÿ�
SELECT * FROM countries; --25��
SELECT * FROM locations; --23��

SELECT 1.country_id
      ,c.country_name
      ,l.city
FROM locations l
JOIN countries c ON (l.country_id = c.country_id);

--NATURAL JOIN
--����� ���, ������ȣ, �������� ����Ͻÿ�
SELECT employee_id, jobs.job_id, jobs.job_title
FROM employees
JOIN jobs ON (employees.job_id = jobs.job_id);

--���� �ڵ带 NATURAL JOIN���� ���� (1:1 ������ �Ǵ� ���)
SELECT employee_id, job_id, job_title
FROM employees NATURAL JOIN jobs;

--NATURAL JOIN�� ���� �ȵǴ� ���

--JOIN ON ���
--����� ���, �μ���ȣ, �μ����� ����Ͻÿ� : 106��
SELECT employee_id, departments.department_id, departments.department_name
FROM employees JOIN departments ON (employees.department_id = departments.department_id);

--NATURAL JOIN ���
--����� ���, �μ���ȣ, �μ����� ����Ͻÿ� : 32�� <- ����ϸ� �ȵ�
SELECT employee_id, department_id, department_name
FROM employees NATURAL JOIN departments;

--���� ���� ������ JOIN ON���� ����ϸ� �̿� ����
SELECT employee_id, employees.department_id, department_name
FROM employees JOIN departments
ON (employees.department_id = departments.department_id AND employees.manager_id = departments.manager_id);

--3) JOIN USING ���
--����� ���, ������ȣ, �������� ����Ͻÿ�
--JOIN ON ���
SELECT employee_id, jobs.job_id, jobs.job_title
FROM employees
JOIN jobs ON (employees.job_id = jobs.job_id);

--JOIN USING���� ����
SELECT employee_id, job_id, job_title
FROM employees JOIN jobs USING (job_id);

--JOIN ON ���
--����� ���, �μ���ȣ, �μ����� ����Ͻÿ� : 106��
SELECT employee_id, departments.department_id, departments.department_name
FROM employees JOIN departments ON (employees.department_id = departments.department_id);

--JOIN USING���� ����
SELECT employee_id, department_id, department_name
FROM employees JOIN departments USING(department_id);


--OUTER JOIN
--��ü ����� ���, �μ���ȣ, �μ����� ����Ͻÿ� : 107��
SELECT employee_id, employees.department_id, department_name
FROM employees LEFT OUTER JOIN departments --���� ���̺�(employees) �� �����̴�.
ON (employees.department_id = departments.department_id);

--��� ������ ������ȣ(country_id), �����̸�(country_name), ���ø�(city)�� ����Ͻÿ�
--���ð� ��Ͼȵ� ������ ����Ѵ�
SELECT country_id, country_name, city
FROM countries LEFT OUTER JOIN locations USING(country_id);

SELECT country_id, country_name, city
FROM locations RIGHT OUTER JOIN countries
USING(country_id);

--��ü ����� ���, �μ���ȣ, �μ����� ����Ͻÿ�
--�μ� ���� ����� ����ϰ�, ����� ���� �μ��� ����Ѵ�

SELECT employee_id, e.department_id, department_name
FROM employees e LEFT JOIN departments d
ON(e.department_id = d.department_id); --�μ� ���� ����� ��� : 107��

SELECT employee_id, e.department_id, department_name
FROM employees e RIGHT JOIN departments d
ON(e.department_id = d.department_id); --��� ���� �μ��� ��� : 122��

SELECT employee_id, e.department_id, department_name
FROM employees e FULL JOIN departments d
ON(e.department_id = d.department_id); --�μ� ���� ����� ��� : 123��

SELECT first_name, employee_id FROM employees;
SELECT first_name, manager_id FROM employees;

--SELF JOIN
--���������� 1���� ���̺��� 2���� ���̺��� ��ó�� ����
--����� ���, �̸�, �����ڹ�ȣ, �������̸��� ����Ͻÿ�
SELECT e.employee_id ���, e.first_name �̸�
     , m.employee_id �����ڹ�ȣ, m.first_name �������̸�
FROM employees e JOIN employees m ON (e.manager_id = m.employee_id);

--����� ���, �̸�, ����μ� �����ڹ�ȣ, �������̸�, ������ �ҼӺμ��� ����Ͻÿ�
--����μ��� �����ںμ��� �ٸ� ����鸸 ����Ѵ�
SELECT e.employee_id ���, e.first_name �̸�, e.department_id ����ҼӺμ�
     , m.employee_id �����ڹ�ȣ, m.first_name �������̸�, m.department_id �����ڼҼӺμ�
FROM employees e JOIN employees m ON (e.manager_id = m.employee_id)
WHERE e.department_id <> m.department_id;

--����� ���, �̸�, ����޿�, �����ڹ�ȣ, �������̸�, �����ڱ޿��� ����Ͻÿ�
--����޿��� �����ڱ޿����� ���� ����鸸 ����Ͻÿ�
SELECT e.employee_id ���, e.first_name �̸�, e.salary ����޿�
     , m.employee_id �����ڹ�ȣ, m.first_name �������̸�, m.salary �����ڱ޿�
FROM employees e JOIN employees m ON (e.manager_id = m.employee_id)
WHERE e.salary > m.salary;

SELECT * FROM job_history
ORDER BY employee_id;

--����� ���, ������ȣ�� ����Ͻÿ�
SELECT employee_id, job_id
FROM employees;

--����������(���,����������ȣ)�� ����Ͻÿ�
SELECT employee_id, job_id
FROM job_history;

--��������� �������� ���, ������ȣ�� ����Ͻÿ�
--UNION
SELECT employee_id, job_id --115��
FROM employees
UNION
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;
--UNION ALL
SELECT employee_id, job_id --117��
FROM employees
UNION ALL
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;

--���� ������ �ٸ� ������ ����ϴ� ����� ���, ������ȣ�� ����Ͻÿ�
SELECT employee_id, job_id --105��
FROM employees
MINUS
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;

--���������� ���� ������ ����ϴ� ����� ���, ������ȣ�� ����Ͻÿ�
SELECT employee_id, job_id --2��
FROM employees
INTERSECT
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;

--1. �޿��� 10000 �̻��� ����� ���, �μ���ȣ, �̸�, �޿�, ������ ����Ͻÿ�.��, �μ���ȣ��
--   30 ��,60 ��, 90 ���� �μ��� �����ϰ� ����� �˻��Ѵ�
SELECT employee_id ���, department_id �μ���ȣ, first_name �̸�, salary �޿�, salary*commission_pct ���� 
FROM employees
WHERE salary >=10000 AND NOT department_id IN(30,60,90);


--2.�޿��� 4000 ���� ���� ������� �μ��� �޿���ո� ����Ͻÿ�. �� �޿������ �Ҽ������� 2 �ڸ����� �ݿø�(�Ҽ�������1�ڸ����� ǥ��)�Ѵ�
SELECT department_id �μ�, SUM(salary) �հ�, COUNT(*) �����, ROUND(AVG(salary),1) �޿����
FROM employees
WHERE salary >=4000
GROUP BY department_id;

--3. �μ���ġ�� ���� ���� ����� �����ϰ� �޿������ 10000 �̻��� �μ��� �޿������ ����Ͻÿ�.
SELECT department_id �μ�, ROUND(AVG(salary),1) �޿����
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING ROUND(AVG(salary),1) >= 10000;

--4. 'Seattle', 'Toronto'���ÿ� �ٹ��ϴ� ������� 
--   �ٹ����ø�,���, �̸�, �μ� ID, �μ��� �� ����Ͻÿ�
SELECT city, employee_id, first_name, e.department_id, department_name
FROM employees e
JOIN departments d ON (e.department_id = d.department_id)
JOIN locations l ON (d.location_id = l.location_id)
WHERE l.city IN ( 'Seattle', 'Toronto');

--5. ��(last_name)�� 'Davies'�� ����� ���� �μ��� �ٹ��ϴ� ������� ���, ��, �̸��� ����Ͻÿ�
SELECT e.employee_id, e.last_name, e.first_name
FROM employees e JOIN employees d ON (e.department_id = d.department_id)
WHERE d.last_name = 'Davies';

--5-1 ����. ��(last_name)�� 'Davies'�� ����� ���� �μ��� �ٹ��ϴ�
--   ������� ���, ��, �̸��� ����Ͻÿ�
--   Davies�� �����ϰ� ����Ѵ�
SELECT e.employee_id, e.last_name, e.first_name
FROM employees e JOIN employees d ON (e.department_id = d.department_id)
WHERE d.last_name = 'Davies' AND e.last_name <> 'Davies';

--����� �ִ�޿��� ����Ͻÿ�
SELECT  MAX(salary)
FROM employees;

--����� �ִ�޿����� ���, �̸�, �޿��� ����Ͻÿ�
--1) ����� �ִ�޿��� ����Ѵ�
--2) 1)�� ���� �޿��� ���� ��� �˻�, ����Ѵ�
SELECT employee_id, first_name, salary
FROM employees 
WHERE salary = (SELECT MAX(salary)
                FROM employees
                );
                
--��(last_name)�� 'Davies'�� ����� ���� �μ��� �ٹ��ϴ� ������� ���, ��, �̸��� ����Ͻÿ�
--1) ��(last_name)�� 'Davies'�� �μ���ȣ�� �˻��Ѵ�
--2) 1)�� ���� �μ���ȣ�� ���� ��� �˻�, ���
SELECT employee_id, last_name, first_name 
FROM employees
WHERE department_id=(SELECT department_id
                     FROM employees
                     WHERE last_name = 'Davies'
                     )
AND last_name <> 'Davies';

--�μ��� �ִ�޿��� ����Ͻÿ�
SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id;

--�μ��� �ִ�޿����� �μ���ȣ, ���, �̸�, �޿��� ����Ͻÿ�
--1) �μ��� �ִ�޿� ���
--2) 1)�� ���� �޿��� ���� ��� �˻�, ���
SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE salary IN (SELECT MAX(salary)
                FROM employees
                GROUP BY department_id
                ); --24��(x)
--���������� ���������� PAIRWISING �ʿ�
SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN (SELECT department_id, MAX(salary)
                                FROM employees
                                GROUP BY department_id
                                ); --11��(O)
                                
SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE (NVL(department_id, 0), salary) IN (SELECT NVL(department_id, 0), MAX(salary)
                                FROM employees
                                GROUP BY department_id
                                ); --12��(�μ����� ����� ���)
                                
--�μ��� �ִ�޿��ڸ� ������ ����� �μ���ȣ, ���, �̸�, �޿��� ����Ͻÿ�
--1) �μ��� �ִ�޿����� �μ���ȣ, �ִ�޿����
--2) 1)�� �ٸ� �μ���ȣ, �޿��� ���� ����� �˻�, ���

SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE (department_id, salary) NOT IN (SELECT department_id, MAX(salary)
                                      FROM employees
                                      GROUP BY department_id
                                      );
-- =ANY�� IN�� ����, >ANY, <ANY
-- =ALL, >ALL, <ALL
SELECT employee_id, department_id, first_name, salary
FROM employees
WHERE (NVL(department_id, 0), salary) =ANY (SELECT NVL(department_id, 0), MAX(salary)
                                            FROM employees
                                            GROUP BY department_id
                                           ); --12��(�μ����� ����� ���)
--InlineView
--����� ���, �޿��� ����Ͻÿ�
SELECT rownum, employee_id, salary
FROM employees;

--�Ի����ڰ� '07/01/01' ���� �Ի��� ����� ���ȣ, ���, �޿��� ����Ͻÿ�
SELECT rownum, employee_id, hire_date, salary
FROM employees
WHERE hire_date >= '07/01/01';

--�Ի����ڰ� '07/01/01' ���� �Ի��� ����� ���ȣ, ���, �޿��� ����Ͻÿ�
--���� �޿��ں��� ����Ѵ�
SELECT rownum, employee_id, hire_date, salary
FROM employees
WHERE hire_date >= '07/01/01'
ORDER BY salary;

--�Ի����ڰ� '07/01/01' ���� �Ի��� ����� ���ȣ, ���, �޿��� ����Ͻÿ�
--���� �޿��ں��� ����Ѵ�
--�޿��� ���� ������� 5��(5���� ��) �̱�
SELECT rownum, employee_id, hire_date, salary
FROM (
      select employee_id, hire_date, salary
      From employees
      WHERE hire_date >= '07/01/01'
      ORDER BY salary
      )
WHERE rownum <= 5;

--�Ի����ڰ� '07/01/01' ���� �Ի��� ����� ���ȣ, ���, �޿��� ����Ͻÿ�
--���� �޿��ں��� 6����� 10�ุ ����Ѵ�
SELECT rownum, employee_id, hire_date, salary
FROM (
      select employee_id, hire_date, salary
      From employees
      WHERE hire_date >= '07/01/01'
      ORDER BY salary
      )
WHERE rownum BETWEEN 6 AND 10 ; --rownum�� �ʱⰪ�� 1�̱� ������ ��¾ȵ�

--�ذ��� #1
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
--�ذ��� #2 (���)
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

--�Ի����ڰ� '07/01/01' ���� �Ի��� ����� ���ȣ, ���, �޿��� ����Ͻÿ�
--�����޿��ں��� ����Ѵ�
--2�������� ����Ѵ�
--���������� �ִ� 10�����̴�
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
--����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ�
--JOIN ON �ذ�
SELECT employee_id, first_name, d.department_id, d.department_name
FROM employees e JOIN departments d ON (e.department_id = d.department_id);
--Scalar Subquery �ذ�
SELECT employee_id, first_name, department_id,
    (SELECT department_name
     FROM departments
     WHERE department_id = employees.department_id)
FROM employees;

--����� �μ��� �μ���ȣ, �μ���, �ѱ޿��� ����Ͻÿ�
--JOIN ON �ذ� <- INNER JOIN �̹Ƿ� �μ������� ��� �ȵ�
SELECT e.department_id, department_name, SUM(salary)
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
GROUP BY e.department_id, department_name;
--�μ����� ����鵵 ��� <-LEFT OUTER JOIN ���
SELECT e.department_id, department_name, SUM(salary)
FROM employees e LEFT JOIN departments d ON (e.department_id = d.department_id)
GROUP BY e.department_id, department_name;


--Scalar Subquery �ذ� <- �μ��� null�� �͵� ���
SELECT department_id,
       (SELECT department_name 
       FROM departments 
       WHERE department_id = employees.department_id),
       SUM(salary)
FROM employees
GROUP BY department_id;

--'Sales'�μ��� ��ձ޿��� ����Ͻÿ�
SELECT department_name, ROUND(AVG(salary),0)
FROM employees e
JOIN departments d ON(e.department_id = d.department_id) 
WHERE department_name ='Sales'
GROUP BY department_name;

--'Sales' �μ��� ��ձ޿����� ���� �޿��� �޴� ����� �μ���ȣ, �޿��� ���
SELECT department_name, SUM(salary) ,COUNT(*)
FROM employees e
JOIN departments d ON(e.department_id = d.department_id) 
WHERE department_name ='Sales'
GROUP BY department_name;

--'Sales' �μ��� ��ձ޿����� ���� �޿��� �޴� ����� �μ���ȣ, �޿��� ���
SELECT employee_id, department_id, salary
FROM employees e
WHERE e.salary > (
                 SELECT ROUND(AVG(salary),0)
                 FROM employees e
                 JOIN departments d ON(e.department_id = d.department_id) 
                 WHERE department_name ='Sales'
                 GROUP BY department_name
                 );
                 
--'Sales' �μ��� ��ձ޿����� ���� �޿��� �޴� 'Sales' ����� �μ���ȣ, �޿��� ���
--��� #1
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
                 
--��� #2
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
                         
--��� #2 (��ȣ�������������� ���̱�)
SELECT employee_id, department_id, salary
FROM employees e
WHERE department_id = (SELECT department_id
                       FROM departments
                       WHERE department_name = 'Sales')
AND salary > (SELECT AVG(salary)
              FROM employees
              WHERE department_id = e.department_id);


--1. ���̺� ����
CREATE TABLE product(
	prod_no VARCHAR2(5),
	prod_name VARCHAR2(20) 
);
--���̺� ���� Ȯ��
DESC product

--2. ���̺� ���� ����
ALTER TABLE product
ADD prod_price NUMBER(6);

ALTER TABLE product
ADD a NUMBER(1);

--2)�÷��̸�����
ALTER TABLE product
RENAME COLUMN a to abc;

--3)�÷��� �ڷ��� �Ǵ� �ڸ��� ����
ALTER TABLE product
MODIFY prod_price NUMBER(6);

--4)�÷� ����
ALTER TABLE product
DROP COLUMN abc;

--3)���̺� ����
DROP TABLE product;

--DML
--1. ������ �߰�
INSERT INTO product(prod_no, prod_name) VALUES ('C0001', '�Ƹ޸�ī��' );

SELECT * FROM product;

INSERT INTO product(prod_no, prod_name) VALUES ('C0002', '��' );

-- prod_price �⺻�� null���� 0���� ����
ALTER TABLE product
MODIFY prod_price DEFAULT 0;

INSERT INTO product(prod_no, prod_name) VALUES ('C0003', '������' );
INSERT INTO product(prod_no, prod_name) VALUES ('C0004', '���̽�����ƻ���' );

--prod_name �� ũ�� ����
ALTER TABLE product
MODIFY prod_name VARCHAR2(100);

--���̺� �÷� ���� ���� product(, ,) -> product
INSERT INTO product VALUES ('F0001', 'ġ������ũ', 1000);
INSERT INTO product VALUES ('F0002', 'ġ��̱�', NULL); --prod_price�� null�� ����
INSERT INTO product VALUES ('F0003', 'ġŲ������ġ', ''); --prod_price�� null�� ����
INSERT INTO product VALUES ('F0003', '�йڽ�'); --��ǰ�����Է� �ʼ�

INSERT INTO product VALUES ('C0001', '�ٸ���ǰ',0 ); --�ߺ� �߰��� �Ǿ���� -> �ĺ��� ������ ����
INSERT INTO product VALUES ('', '��ȣ���»�ǰ1',0 );
INSERT INTO product VALUES ('', '��ȣ���»�ǰ2',0 );

DELETE product WHERE prod_name = '�ٸ���ǰ';
DELETE product WHERE prod_no IS NULL;

-- �������� �߰�
ALTER TABLE product
ADD CONSTRAINTS prod_no_pk PRIMARY KEY(prod_no);

--�������� �߰� �� �ߺ��ڷ� �߰� �õ� - �ȵ�
INSERT INTO product VALUES ('C0001', '�ٸ���ǰ',0 );
--�������� �߰� �� null �� �߰� �õ� - �ȵ�
INSERT INTO product VALUES ('', '��ȣ���»�ǰ1',0 );

INSERT INTO product(prod_no, prod_name) VALUES ('D0001', '���Ӻ����'); --OK
INSERT INTO product(prod_no, prod_name) VALUES ('D0002', null);
DELETE product WHERE prod_name IS NULL; --prod_no�� (null)�� ��ǰ ����

--NOT NULL ���� ���� �߰�
ALTER TABLE product
MODIFY prod_name CONSTRAINT prod_name_nn NOT NULL;
