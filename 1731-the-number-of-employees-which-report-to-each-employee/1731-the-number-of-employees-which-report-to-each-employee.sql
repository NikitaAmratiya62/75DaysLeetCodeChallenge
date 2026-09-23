# Write your MySQL query statement below
SELECT e.employee_id,e.name,COUNT(r.employee_id) AS reports_count,
      ROUND(AVG(r.age)) as average_age
FROM Employees e
JOIN Employees r
on e.employee_id=r.reports_to
group by e.employee_id,e.name
order by e.employee_id