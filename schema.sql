#you can use this queries to create tables in the database to try to run the program

CREATE TABLE client(
                    ID INT PRIMARY KEY AUTO_INCREMENT,Name VARCHAR(255),
                    Address VARCHAR(255),Person VARCHAR(255),Email VARCHAR(255));

CREATE TABLE users(
                      id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                      user_type ENUM('CLIENT', 'LOGISTIC_COMPANY') NOT NULL,
                      email VARCHAR(100) UNIQUE NOT NULL,
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
                                                                           
CREATE TABLE journeys(
                         id VARCHAR(255) PRIMARY KEY NOT NULL,
                         port_of_origin VARCHAR(255)NOT NULL,
                         destination VARCHAR (255) NOT NULL,
                         container_id VARCHAR (255) NOT NULL,
                         content VARCHAR (255) NOT NULL,
                         company VARCHAR (255) NOT NULL,
                         container_position VARCHAR (255),
                         created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (container_id) REFERENCES containers(id)
);

create unique index journeys_container_id_uindex
    on journeys (container_id);


create table containers
(
    id VARCHAR(255) not null
);

create unique index containers_id_uindex
    on containers (id);

alter table containers
    add constraint containers_pk
        primary key (id);

CREATE TABLE competed_journeys(
                                  id VARCHAR(255) PRIMARY KEY NOT NULL,
                                  port_of_origin VARCHAR(255)NOT NULL,
                                  destination VARCHAR (255) NOT NULL,
                                  container_id VARCHAR (255) NOT NULL,
                                  content VARCHAR (255) NOT NULL,
                                  company VARCHAR (255) NOT NULL,
                                  container_position VARCHAR (255),
                                  FOREIGN KEY (container_id) REFERENCES containers(id)
);
INSERT INTO competed_journeys SELECT * FROM journeys WHERE id = ?;
DELETE FROM journeys WHERE id = ?;
