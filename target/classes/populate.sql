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