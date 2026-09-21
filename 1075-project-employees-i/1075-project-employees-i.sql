# Write your MySQL query statement below
SELECT p.project_id,ROUND(AVG(experience_years),2) AS average_years
FROM Project p
RIGHT JOIN Employee e
ON  e.employee_id=p.employee_id
WHERE p.project_id IS NOT NULL
GROUP BY p.project_id 
ORDER BY p.project_id 