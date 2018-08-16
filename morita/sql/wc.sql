select countries.name, players.name, players.uniform_num goals.goal_time from countries INNER JOIN players on countries.id = players.id INNER JOIN goals.id on countries.id= players.id;


SELECT countries.name,players.name,goals.goal_time FROM countries INNER JOIN players ON countries.id = players.id INNER JOIN goals ON countries.id = goals.id where goals.player_id is not null;
