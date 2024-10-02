SELECT create_date, COUNT(*) as OrderCount
FROM Orders
GROUP BY create_date
ORDER BY create_date ;
