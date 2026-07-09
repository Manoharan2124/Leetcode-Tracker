-- Last updated: 7/9/2026, 3:05:24 PM
UPDATE Salary
SET sex = CASE
    WHEN sex = 'm' THEN 'f'
    ELSE 'm'
END;