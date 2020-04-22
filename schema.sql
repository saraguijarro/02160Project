#you can use this queries to create tables in the database to try to run the program

CREATE TABLE client(
                    ID INT PRIMARY KEY AUTO_INCREMENT,Name VARCHAR(255),
                    Address VARCHAR(255),Person VARCHAR(255),Email VARCHAR(255));

CREATE TABLE users(
                      id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                      email VARCHAR(100) NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE actions(
                        id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        action_type VARCHAR(100) NOT NULL,
                        created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO actions(action_type) VALUES
('ADD_CONTAINER'),
('CONTAINER_HISTORY'),
('FIND_JOURNEY');

CREATE TABLE user_actions(
                             id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                             user_id INT NOT NULL,
                             action_id INT NOT NULL,
                             started TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             ended TIMESTAMP NOT NULL,
                             FOREIGN KEY (user_id) REFERENCES users(id),
                             FOREIGN KEY (action_id) REFERENCES actions(id)
);