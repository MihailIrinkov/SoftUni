-- 02.	Insert_02

insert into products(name, type, price)
(
select
concat(last_name, ' specialty'),
'Cocktail',
ceiling(salary * 0.01)
from waiters
where id > 6
);

-- 03.	Update_03

update orders
set
    table_id = table_id - 1
where
    id between 12 and 23;

   SET SQL_SAFE_UPDATES = 0;

-- Delete_04

select
    w.id,
    (SELECT
            COUNT(*)
        FROM
            orders
        WHERE
            waiter_id = w.id) AS o_count
FROM
    waiters AS w
HAVING o_count = 0;

delete from waiters
where
    (SELECT
        COUNT(*)
    FROM
        orders

    WHERE
        waiter_id = waiters.id) = 0;

-- DELETE FROM waiters AS w
--WHERE
--(select count(*) from orders where waiter_id = w.id) = 0;