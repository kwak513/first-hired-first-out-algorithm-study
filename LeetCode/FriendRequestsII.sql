SELECT 
    ID,
    COUNT(*) AS NUM

FROM 
(
(SELECT requester_id AS ID
FROM RequestAccepted)

UNION ALL

(SELECT accepter_id AS ID
FROM RequestAccepted)
) AS TEMP

GROUP BY ID
ORDER BY NUM DESC
LIMIT 1
