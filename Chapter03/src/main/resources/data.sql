INSERT INTO cart (id, customer_id)
VALUES ('81bf8cf4-dff5-4e08-a298-1286f779f4d1', 'customer-uuid');

INSERT INTO item (id, product_id, unit_price, quantity)
VALUES ('13ee026b-c5e8-4b77-baef-e96c7c36ce6a', 'testing-product-id-0', 1000, 1);

INSERT INTO item (id, product_id, unit_price, quantity)
VALUES ('82ee15f6-47c0-4b51-aa07-3d76afca453a', 'testing-product-id-1', 500, 3);

INSERT INTO cart_item (cart_id, item_id)
VALUES ('81bf8cf4-dff5-4e08-a298-1286f779f4d1', '13ee026b-c5e8-4b77-baef-e96c7c36ce6a');

INSERT INTO cart_item (cart_id, item_id)
VALUES ('81bf8cf4-dff5-4e08-a298-1286f779f4d1', '82ee15f6-47c0-4b51-aa07-3d76afca453a');
