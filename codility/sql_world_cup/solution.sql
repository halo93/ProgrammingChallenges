-- Implement your solution here
SELECT t.team_id, t.team_name, SUM(IFNULL(home.points, 0) + IFNULL(away.points, 0)) AS num_points
from teams t LEFT OUTER JOIN
     (SELECT t.team_id, t.team_name, SUM(CASE
                                             WHEN m.host_goals > m.guest_goals THEN '3'
                                             WHEN m.host_goals = m.guest_goals THEN '1'
                                             WHEN m.host_goals < m.guest_goals THEN '0' END) AS points
      from teams t join matches m on t.team_id = m.host_team GROUP by t.team_id, t.team_name) AS home
     ON t.team_id = home.team_id
             LEFT OUTER JOIN
     (SELECT t2.team_id, t2.team_name, SUM(CASE
                                               WHEN m2.host_goals < m2.guest_goals THEN '3'
                                               WHEN m2.host_goals = m2.guest_goals THEN '1'
                                               WHEN m2.host_goals > m2.guest_goals THEN '0' END) AS points
      from teams t2 join matches m2 on t2.team_id = m2.guest_team GROUP by t2.team_id, t2.team_name) AS away
     ON t.team_id = away.team_id
GROUP by t.team_id, t.team_name
ORDER BY num_points desc, t.team_id
;



