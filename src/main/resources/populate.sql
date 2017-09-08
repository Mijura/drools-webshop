INSERT INTO user VALUES ('Salesman', 'dragan', 'Dragan', 'Petrovic', 'dragan', '2017-02-10 07:28:22', NULL, NULL, NULL);
INSERT INTO user VALUES ('Manager', 'ivan', 'Ivan', 'Ivanovic', 'ivan', '2017-03-04 08:14:52', NULL, NULL, NULL);

INSERT INTO category (`name`) VALUES ("BRONZE");
INSERT INTO category (`name`) VALUES ("SILVER");
INSERT INTO category (`name`) VALUES ("GOLD");

INSERT INTO user VALUES ('Customer', 'mio', 'Miodrag', 'Vilotijevic', 'mio', '2017-03-04 08:14:52', NULL, 0, 1);

INSERT INTO spending_limit (`from_limit`, `to_limit`, `price_to_points`) VALUES (0, 5000, 2);
INSERT INTO spending_limit (`from_limit`, `to_limit`, `price_to_points`) VALUES (5000, 10000, 3);
INSERT INTO spending_limit (`from_limit`, `to_limit`, `price_to_points`) VALUES (10000, 15000, 5);

INSERT INTO spending_limit (`from_limit`, `to_limit`, `price_to_points`) VALUES (0, 5000, 3);
INSERT INTO spending_limit (`from_limit`, `to_limit`, `price_to_points`) VALUES (5000, 10000, 5);
INSERT INTO spending_limit (`from_limit`, `to_limit`, `price_to_points`) VALUES (10000, 15000, 10);

INSERT INTO spending_limit (`from_limit`, `to_limit`, `price_to_points`) VALUES (0, 5000, 5);
INSERT INTO spending_limit (`from_limit`, `to_limit`, `price_to_points`) VALUES (5000, 10000, 10);
INSERT INTO spending_limit (`from_limit`, `to_limit`, `price_to_points`) VALUES (10000, 15000, 15);

INSERT INTO category_limits (`category_id`, `limits_id`) VALUES (1, 1);
INSERT INTO category_limits (`category_id`, `limits_id`) VALUES (1, 2);
INSERT INTO category_limits (`category_id`, `limits_id`) VALUES (1, 3);

INSERT INTO category_limits (`category_id`, `limits_id`) VALUES (2, 4);
INSERT INTO category_limits (`category_id`, `limits_id`) VALUES (2, 5);
INSERT INTO category_limits (`category_id`, `limits_id`) VALUES (2, 6);

INSERT INTO category_limits (`category_id`, `limits_id`) VALUES (3, 7);
INSERT INTO category_limits (`category_id`, `limits_id`) VALUES (3, 8);
INSERT INTO category_limits (`category_id`, `limits_id`) VALUES (3, 9);

INSERT INTO article_category (`id`, `max_discount`, `name`) VALUES ('category 1', '20', 'Consumer goods');
INSERT INTO article_category (`id`, `max_discount`, `name`) VALUES ('category 2', '20', 'Eletronics');
INSERT INTO article_category (`id`, `max_discount`, `name`) VALUES ('category 3', '30', 'Sport');
INSERT INTO article_category (`id`, `max_discount`, `name`) VALUES ('category 4', '50', 'Clothes and Shoes');

INSERT INTO article_category VALUES ('category 5', '15', 'Groceries', 'category 1');
INSERT INTO article_category VALUES ('category 6', '12', 'Cosmetics', 'category 1');
INSERT INTO article_category VALUES ('category 7', '20', 'Cleaning Products', 'category 1');
INSERT INTO article_category VALUES ('category 8', '12', 'Home Appliances', 'category 2');
INSERT INTO article_category VALUES ('category 9', '25', 'TV', 'category 2');
INSERT INTO article_category VALUES ('category 10', '15', 'Computers', 'category 2');
INSERT INTO article_category VALUES ('category 11', '17', 'Audio', 'category 2');
INSERT INTO article_category VALUES ('category 12', '16', 'Laptops', 'category 2');

INSERT INTO sale (`id`, `name`, `discount`, `from_date`, `to_date`) VALUES ('sale 1', 'New Year', 30, '2017-12-20 00:00:00', '2018-01-30 00:00:00');
INSERT INTO sale (`id`, `name`, `discount`, `from_date`, `to_date`) VALUES ('sale 2', '1. May', 40, '2017-04-30 00:00:00', '2017-05-01 00:00:00');
INSERT INTO sale (`id`, `name`, `discount`, `from_date`, `to_date`) VALUES ('sale 3', 'Summer',  20, '2017-06-20 00:00:00', '2018-08-21 00:00:00');

INSERT INTO sale_article_categories values ('sale 1', 'category 2');
INSERT INTO sale_article_categories values ('sale 2', 'category 1');
INSERT INTO sale_article_categories values ('sale 2', 'category 10');
INSERT INTO sale_article_categories values ('sale 3', 'category 7');
INSERT INTO sale_article_categories values ('sale 3', 'category 3');
INSERT INTO sale_article_categories values ('sale 3', 'category 4');
INSERT INTO sale_article_categories values ('sale 3', 'category 1');

INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('2.0 Sound System', 'category 11', 17.99, 20, '2016-08-02 17:41:51', FALSE, 10, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Bread', 'category 5', 0.88, 100, '2017-04-03 05:44:12', FALSE, 30, 'ARCHIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Chair', 'category 8', 124.79, 4, '2013-05-09 17:41:51', FALSE, 5, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Coca Cola 6 Pack', 'category 1', 3.99, 111, '2017-08-22 06:37:43', FALSE, 100, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Ferrero Gift box 24 count', 'category 1', 8.43, 46, '2016-08-02 17:41:51', FALSE, 32, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Fiji Water 1.5l', 'category 1', 1, 200, '2016-08-02 17:41:51', TRUE, 50, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Keyboard Usb', 'category 10', 13.23, 25, '2016-08-02 17:41:51', FALSE, 15, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Loreal Oaris Perfect Hydra Nutrion', 'category 6', 6.32, 40, '2016-08-02 17:41:51', FALSE, 25, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Mens Light Jacket', 'category 4', 44, 17, '2016-08-02 17:41:51', FALSE, 15, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Mens Raglan Sweatshirt', 'category 4', 67.23, 8, '2016-08-02 17:41:51', FALSE, 7, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Mens Shirt', 'category 4', 9, 15, '2016-08-02 17:41:51', FALSE, 10, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Mens Skateboarding Shoe', 'category 4', 172.99, 8, '2016-08-02 17:41:51', FALSE, 10, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Mens Sweatshirt', 'category 4', 54.55, 0, '2016-08-02 17:41:51', FALSE, 15, 'ARCHIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Mini Basketball Hoop', 'category 3', 20, 2, '2016-08-02 17:41:51', FALSE, 1, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Mouse Usb', 'category 10', 6.87, 20, '2016-08-02 17:41:51', FALSE, 10, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Mr. Clean', 'category 7', 3, 56, '2016-08-02 17:41:51', FALSE, 20, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('NIVEA Creme Cream', 'category 6', 5, 150, '2016-08-02 17:41:51', TRUE, 30, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('NIVEA for Men Sensitive Shaving Gel', 'category 6', 10, 7, '2016-08-02 17:41:51', FALSE, 5, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('NIVEA Men Cool 3-in-1 Body Wash', 'category 6', 6.5, 20, '2016-11-29 20:01:04', FALSE, 15, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Nutella', 'category 5', 5, 50, '2017-04-08 10:39:17', FALSE, 30, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Pizza Oven', 'category 8', 23, 10, '2015-01-01 07:55:23', FALSE, 5, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Samsung Electronics 28-Inch', 'category 9', 255, 8, '2016-08-02 17:41:51', FALSE, 7, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Smartwater 6x1.5l', 'category 1', 5, 10, '2016-08-02 17:41:51', FALSE, 7, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Toaster Oven', 'category 8', 50, 4, '2016-08-02 17:41:51', FALSE, 5, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Vizari Striker Soccer Shoe', 'category 3', 150, 10, '2017-07-08 13:11:26', FALSE, 10, 'ACTIVE');
INSERT INTO article (`name`, `category_id`, `price`, `count`, `created`, `ordered`, `min_count`, `status`) VALUES ('Acer Aspire F 15-Inch', 'category 12', 470, 30, '2016-11-11 03:18:32', FALSE, 15, 'ACTIVE');

INSERT INTO receipt (`date`, `state`, `customer_username`) VALUES ('2017-09-03 03:18:32', 'SUCCESS', 'mio');
INSERT INTO receipt (`date`, `state`, `customer_username`) VALUES ('2017-08-10 03:18:32', 'SUCCESS', 'mio');
INSERT INTO receipt (`date`, `state`, `customer_username`) VALUES ('2017-09-05 03:18:32', 'SUCCESS', 'mio');

INSERT INTO item (`article`, `receipt`) VALUES (1, 1);
INSERT INTO item (`article`, `receipt`) VALUES (1, 2);
INSERT INTO item (`article`, `receipt`) VALUES (1, 3);

INSERT INTO user_receipts VALUES ("mio", 1);
INSERT INTO user_receipts VALUES ("mio", 2);
INSERT INTO user_receipts VALUES ("mio", 3);

