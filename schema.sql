#you can use this queries to create tables in the database to try to run the program

CREATE TABLE client(
                       ID VARCHAR(255) PRIMARY KEY NOT NULL ,Name VARCHAR(255),
                       Address VARCHAR(255),Person VARCHAR(255),Email VARCHAR(255));

CREATE TABLE users(
                      id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                      user_type ENUM('CLIENT', 'LOGISTIC_COMPANY') NOT NULL,
                      email VARCHAR(100) UNIQUE NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_actions(
                             id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                             user_id INT NOT NULL,
                             action ENUM('ADD_CONTAINER', 'CONTAINER_HISTORY', 'FIND_JOURNEY') NOT NULL,
                             started TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             ended TIMESTAMP NOT NULL,
                             FOREIGN KEY (user_id) REFERENCES users(id)
);

create table containers
(
    id VARCHAR(40) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    description  VARCHAR(255) NOT NULL
);


CREATE TABLE journeys(
                         id VARCHAR(40) PRIMARY KEY NOT NULL,
                         origin VARCHAR(255) NOT NULL,
                         destination VARCHAR (255) NOT NULL,
                         container_id VARCHAR (255) NOT NULL,
                         description VARCHAR (255) NOT NULL,
                         company VARCHAR (255) NOT NULL,
                         created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (container_id) REFERENCES containers(id)
);

CREATE TABLE container_status(
                                 id VARCHAR(40) PRIMARY KEY NOT NULL,
                                 temperature NUMERIC not null,
                                 humidity NUMERIC not null,
                                 pressure NUMERIC not null,
                                 journey_id VARCHAR(40) NOT NULL,
                                 container_id VARCHAR(40) NOT NULL,
                                 FOREIGN KEY (container_id) REFERENCES containers(id),
                                 FOREIGN KEY (journey_id) REFERENCES journeys(id)
);


