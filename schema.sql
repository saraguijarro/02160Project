#Use these queries to create the tables in the database in order to be able to save the data

CREATE TABLE client(
                       ID VARCHAR(255) PRIMARY KEY NOT NULL ,
                       Name VARCHAR(255),
                       Address VARCHAR(255),
                       Reference_person VARCHAR(255),
                       Email VARCHAR(255),
                       Password VARCHAR(255),
                       created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);

CREATE TABLE company(
                        ID VARCHAR(255) PRIMARY KEY NOT NULL ,
                        name varchar(255) not null,
                        password varchar(255) not null,
                        details varchar(255),
                        created timestamp not null default current_timestamp
);


CREATE TABLE users(
                      id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                      user_type ENUM('CLIENT', 'LOGISTIC_COMPANY') NOT NULL,
                      email VARCHAR(100) UNIQUE NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_actions(
                             id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                             user_id VARCHAR(255) NOT NULL,
                             action ENUM('ADD_CONTAINER', 'CONTAINER_HISTORY', 'FIND_JOURNEY') NOT NULL,
                             started TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             ended TIMESTAMP NOT NULL,
                             FOREIGN KEY (user_id) REFERENCES client(ID)
);

create table containers
(
    id VARCHAR(40) PRIMARY KEY NOT NULL,
    location VARCHAR(255) NOT NULL,
    journey_id  VARCHAR(255) NOT NULL,
    used BOOLEAN NOT NULL default false,
    FOREIGN KEY (journey_id) REFERENCES journeys(id),
    FOREIGN KEY (location) REFERENCES journeys(location)
);


CREATE TABLE journeys(
                         id VARCHAR(40) PRIMARY KEY NOT NULL,
                         origin VARCHAR(255) NOT NULL,
                         destination VARCHAR (255) NOT NULL,
                         container_id VARCHAR (255) NOT NULL,
                         description VARCHAR (255) NOT NULL,
                         company VARCHAR (255) NOT NULL,
                         location VARCHAR(255) NOT NULL,
                         ongoing Boolean NOT NULL default false,
                         created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (container_id) REFERENCES containers(id)
);

CREATE TABLE container_status(
                                 id VARCHAR(40) PRIMARY KEY NOT NULL,
                                 temperature NUMERIC not null,
                                 humidity NUMERIC not null,
                                 pressure NUMERIC not null,
                                 location VARCHAR(255) not null,
                                 journey_id VARCHAR(40) NOT NULL,
                                 container_id VARCHAR(40) NOT NULL,
                                 created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (location) REFERENCES  journeys(location),
                                 FOREIGN KEY (container_id) REFERENCES containers(id),
                                 FOREIGN KEY (journey_id) REFERENCES journeys(id)
);