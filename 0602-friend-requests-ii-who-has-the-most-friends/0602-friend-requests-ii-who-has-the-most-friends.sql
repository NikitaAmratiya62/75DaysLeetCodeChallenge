# Write your MySQL query statement below
SELECT id,count(*) AS num
FROM (SELECT requester_id AS id
    FROM RequestAccepted AS t
    UNION ALL
    SELECT accepter_id AS id
    FROM RequestAccepted AS t
 ) t
GROUP BY id
ORDER BY NUM DESC
LIMIT 1