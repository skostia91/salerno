UPDATE users
SET phone_number = CASE
                       WHEN id = 1 THEN '1234567890'
                       WHEN id = 2 THEN '9876543210'
                       WHEN id = 3 THEN '5551234567'
                       ELSE phone_number
    END
WHERE id IN (1, 2, 3);
