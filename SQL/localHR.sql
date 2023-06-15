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