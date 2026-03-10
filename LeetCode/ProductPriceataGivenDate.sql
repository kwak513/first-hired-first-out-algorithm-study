SELECT
    product_id,
    IFNULL(PRICE, 10) AS PRICE
FROM (
    SELECT DISTINCT product_id
    FROM Products
) AS L
LEFT JOIN (
    SELECT product_id,
        new_price AS PRICE,
        RANK() OVER (PARTITION BY product_id ORDER BY change_date DESC) AS RNK
    FROM Products
    WHERE change_date <= '2019-08-16'
) AS R
WHERE RNK = 1
