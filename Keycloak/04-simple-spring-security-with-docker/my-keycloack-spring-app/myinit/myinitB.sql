CREATE TABLE roles (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `role` varchar(45) DEFAULT NULL,
                         `user_id` int DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `user_fk_idx` (`user_id`),
                         CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)