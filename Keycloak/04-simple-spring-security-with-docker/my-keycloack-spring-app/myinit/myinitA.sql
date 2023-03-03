CREATE TABLE user (
                       id int NOT NULL AUTO_INCREMENT,
                       first_name varchar(45) DEFAULT NULL,
                       last_name varchar(45) DEFAULT NULL,
                       email varchar(45) DEFAULT NULL,
                       username varchar(45) DEFAULT NULL,
                       password varchar(255) DEFAULT NULL,
                       usercol varchar(45) DEFAULT NULL,
                       PRIMARY KEY (id)
)