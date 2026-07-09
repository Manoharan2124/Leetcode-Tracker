-- Last updated: 7/9/2026, 3:17:35 PM
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;