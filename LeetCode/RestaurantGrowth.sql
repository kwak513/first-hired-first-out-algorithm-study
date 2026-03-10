SELECT 
    A.visited_on,
    SUM(B.DAY_SUM) AS AMOUNT,
    ROUND(SUM(B.DAY_SUM) / 7, 2) AS AVERAGE_AMOUNT
FROM (
    SELECT visited_on, SUM(amount) AS DAY_SUM
    FROM CUSTOMER
    GROUP BY visited_on
) A
JOIN (
    SELECT visited_on, SUM(amount) AS DAY_SUM
    FROM CUSTOMER
    GROUP BY visited_on
) B

ON DATEDIFF(A.visited_on, B.visited_on) BETWEEN 0 AND 6
GROUP BY A.visited_on
HAVING COUNT(*) = 7
ORDER BY A.visited_on;
