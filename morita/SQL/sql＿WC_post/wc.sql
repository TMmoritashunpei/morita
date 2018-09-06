
SELECT countries.name,players.name,goals.goal_time FROM countries INNER JOIN players ON countries.id = players.id INNER JOIN goals ON countries.id = goals.id where goals.player_id is not null;


SELECT
 goals.goal_time,players.uniform_num,players.position,players.name FROM players LEFT JOIN goals ON players.id = goals.id;

 SELECT goals.goal_time,players.uniform_num,players.position,players.name FROM goals
  RIGHT JOIN players ON goals.id = players.id;


  SELECT countries.name as'contry_name',goals.goal_time,players.position,goals.player_id,players.name as'players_name' FROM goals INNER JOIN players ON goals.id = players.id INNER JOIN countries ON goals.id = countries.id;

select g.id, g.goal_time, p.name
from goals g
join players p on p.id = g.player_id;


select g.id , g.goal_time, (select p.name from players p where p.id = g.player_id)as players_name
from goals g
where g.player_id is not null;

select p1.position, p1.最大身長, p2.name, p2.club from(
  select position, max(height)as 最大身長 from players group by position
) p1
left join players p2 on p1.最大身長 =p2.height and p1.position = p2.position;



select group_name,max(ranking)as ランキング最上位,
min(ranking)as ランキング最下位 from
countries group by group_name;



select avg(height)as 平均身長, avg(weight)as 平均体重 from players group by position HAVING position = 'GK';

SELECT * FROM countries c
inner JOIN players p ON on c.id = p.country_id;


SELECT DISTINCT countries.name as 国名,(select avg(height) from players)as 平均身長 FROM countries
JOIN players ON countries.id = players.country_id;


sselect * from pairings
join pairings_tmp on pairings.kickoff = pairings_tmp.kickoff;


select kickoff,my_country as 国名１,enemy_country as 国名２  from pairings_tmp order by  kickoff asc;

select name,position from players 
