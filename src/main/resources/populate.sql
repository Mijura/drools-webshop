INSERT INTO user VALUES ('Salesman', 'dragan', 'Dragan', 'Petrovic', 'dragan', '2017-02-10 07:28:22', NULL, NULL, NULL);
INSERT INTO user VALUES ('Manager', 'ivan', 'Ivan', 'Ivanovic', 'ivan', '2017-03-04 08:14:52', NULL, NULL, NULL);

INSERT INTO category (`name`) VALUES ("BRONZE");
INSERT INTO category (`name`) VALUES ("SILVER");
INSERT INTO category (`name`) VALUES ("GOLD");

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
INSERT INTO article_category VALUES ('category 7', '12', 'Cleaning Products', 'category 1');
INSERT INTO article_category VALUES ('category 8', '12', 'Home Appliances', 'category 2');
INSERT INTO article_category VALUES ('category 9', '25', 'Audio and TV', 'category 2');
INSERT INTO article_category VALUES ('category 10', '15', 'Computers', 'category 2');

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
