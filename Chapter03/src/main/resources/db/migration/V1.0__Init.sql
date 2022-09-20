CREATE TABLE cart
(
    id          VARCHAR(255) NOT NULL,
    customer_id VARCHAR(255) NULL COMMENT '고객ID',
    CONSTRAINT pk_cart PRIMARY KEY (id)
);

CREATE TABLE cart_item
(
    cart_id VARCHAR(255) NOT NULL,
    item_id VARCHAR(255) NOT NULL
);

CREATE TABLE item
(
    id         VARCHAR(255) NOT NULL,
    product_id VARCHAR(255) NULL COMMENT '상품ID',
    unit_price DECIMAL      NULL COMMENT '단가',
    quantity   INT          NULL COMMENT '수량',
    CONSTRAINT pk_item PRIMARY KEY (id)
);

ALTER TABLE cart_item
    ADD CONSTRAINT fk_cart_item_on_cart FOREIGN KEY (cart_id) REFERENCES cart (id);

ALTER TABLE cart_item
    ADD CONSTRAINT fk_cart_item_on_cart_item FOREIGN KEY (item_id) REFERENCES item (id);