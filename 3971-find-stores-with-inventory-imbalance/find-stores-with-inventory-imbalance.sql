# Write your MySQL query statement below
select a.store_id, stores.store_name, stores.location, a.product_name as most_exp_product, b.product_name as cheapest_product, round(b.quantity / a.quantity, 2) imbalance_ratio 
from 
(
    select  inventory_id,  store_id,  product_name, quantity,  price as max_price
    from inventory
    where (store_id, price) in (select store_id, max(price) as price from inventory group by store_id having count(distinct inventory_id) >= 3)
) a
join 
(
    select  inventory_id,  store_id,  product_name, quantity,  price as min_price
    from inventory
    where (store_id, price) in (select store_id, min(price) as price from inventory group by store_id having count(distinct inventory_id) >= 3)
) b
join stores
on a.store_id = b.store_id && a.store_id = stores.store_id
where a.quantity < b.quantity
order by imbalance_ratio desc, stores.store_name;