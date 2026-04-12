# Write your MySQL query statement below
select distinct c.customer_id
from Customer c
group by c.customer_id
having not exists(
    select p.product_key
    from Product p
    where p.product_key not in(
        select c1.product_key
        from Customer c1
        where c1.customer_id = c.customer_id
    )
);