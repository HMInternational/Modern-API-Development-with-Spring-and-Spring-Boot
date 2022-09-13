INSERT INTO cart_entity (id, customer_id)
VALUES ('2', 'uuid');

INSERT INTO item_entity (id, quantity, unit_price)
VALUES ('2', 1, 1000);

INSERT INTO item_entity (id, quantity, unit_price)
VALUES ('3', 1, 1000);

INSERT INTO cart_item (cart_id, item_id)
VALUES ('2', '2');

INSERT INTO cart_item (cart_id, item_id)
VALUES ('2', '3');