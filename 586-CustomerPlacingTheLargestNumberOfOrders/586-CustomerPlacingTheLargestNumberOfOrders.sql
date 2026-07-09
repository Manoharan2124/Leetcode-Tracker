-- Last updated: 7/9/2026, 3:17:14 PM
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;