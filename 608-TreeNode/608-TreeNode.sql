-- Last updated: 7/9/2026, 3:05:33 PM
SELECT id,
       CASE
           WHEN p_id IS NULL THEN 'Root'
           WHEN id IN (
               SELECT DISTINCT p_id
               FROM Tree
               WHERE p_id IS NOT NULL
           ) THEN 'Inner'
           ELSE 'Leaf'
       END AS type
FROM Tree;