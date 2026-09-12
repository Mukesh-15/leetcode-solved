# Write your MySQL query statement below
select books.book_id , title, author, genre, pages , (max(session_rating) - min(session_rating)) as rating_spread , round(sum(if(session_rating <= 2 or session_rating >= 4, 1, 0)) / count(session_rating), 2) as polarization_score 
from reading_sessions
join books on
books.book_id = reading_sessions.book_id
group by book_id
having count(session_id) >= 5 && max(session_rating) >= 4 && min(session_rating) <= 2 && polarization_score >= 0.6
order by polarization_score desc, title desc;
