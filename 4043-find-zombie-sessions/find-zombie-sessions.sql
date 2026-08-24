# Write your MySQL query statement below
select session_id, user_id, timestampdiff(minute ,min(event_timestamp), max(event_timestamp))   as session_duration_minutes, sum(if(event_type = 'scroll', 1, 0)) as scroll_count
from app_events
group by session_id, user_id
having session_duration_minutes > 30 && scroll_count >= 5 && (sum(if(event_type = 'click', 1, 0)) / scroll_count) < 0.20 && sum(if(event_type = 'purchase', 1, 0)) = 0
order by scroll_count desc, session_id;