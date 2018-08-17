select name as 名前, position as ポジション,club as 所属クラブ,(select pairing_id from goals)as ゴール数 from players;

select players.name as 名前,players.position as ポジション,players.club as 所属クラブ,count(goals.id) as ゴール数  from players
join goals on players.id = goals. player_id group by players.name,players.club,players.position ;


select name as 名前, position as ポジション,club as 所属クラブ,(select count(goals.id)from goals) as ゴール数  from players;


select players.position as ポジション,count(goals.id) as ゴール数 from goals right join
players on goals.player_id = players.id
group by players.position;

select count(g.goal_time) from goals g
where count(g.goal_time)is null;


select  countries.group_name,count(goals.id) from goals  join pairings
on goals.pairing_id = pairings.id
 join countries on countries.id = pairings.my_country_id
where pairings.kickoff between '2014-06-13 0:00:00' AND '2014-06-27 23:59:59'
group by countries.group_name;
