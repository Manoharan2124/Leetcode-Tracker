-- Last updated: 7/9/2026, 3:17:44 PM
SELECT 
    firstName,
    lastName,
    city,
    state
FROM person 
LEFT JOIN Address 
ON Person.personId = Address.personId   