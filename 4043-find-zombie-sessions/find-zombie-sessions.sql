# Write your MySQL query statement below
select session_id, user_id, timestampdiff(minute ,min(event_timestamp), max(event_timestamp))   as session_duration_minutes, sum(event_type = 'scroll') as scroll_count
from app_events
group by session_id, user_id
having session_duration_minutes > 30 && scroll_count >= 5 && (sum(event_type = 'click') / scroll_count) < 0.20 && sum(event_type = 'purchase') = 0
order by scroll_count desc, session_id;