# Write your MySQL query statement below
select ROUND(COUNT(DISTINCT a.player_id )/(select COUNT(DISTINCT player_id) from Activity),2) AS fraction
from Activity a
join Activity b
on a.player_id=b.player_id
AND DATEDIFF(b.event_date,a.event_date)=1
where a.event_date= (select MIN(c.event_date) FROM Activity c
    where c.player_id=a.player_id)

