# Use these queries to create the tables in the database

CREATE TABLE client(
                       ID VARCHAR(255) PRIMARY KEY NOT NULL ,
                       Name VARCHAR(255),
                       Address VARCHAR(255),
                       Reference_person VARCHAR(255),
                       Email VARCHAR(255),
                       Password VARCHAR(255),
                       created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);

CREATE TABLE company(
                        ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        name varchar(255) not null,
                        password varchar(255) not null
);


create table containers
(
    id VARCHAR(40) PRIMARY KEY NOT NULL,
    position VARCHAR(255) NOT NULL ,
    journey_id VARCHAR(40) NOT NULL,
    in_journey BOOLEAN DEFAULT FALSE,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE journeys(
                         id VARCHAR(40) PRIMARY KEY NOT NULL,
                         origin VARCHAR(255) NOT NULL,
                         destination VARCHAR (255) NOT NULL,
                         container_id VARCHAR (255) NOT NULL,
                         description VARCHAR (255) NOT NULL,
                         company VARCHAR (255) NOT NULL,
                         ongoing BOOLEAN DEFAULT FALSE,
                         FOREIGN KEY (container_id) REFERENCES containers(id),
                         created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE container_status(
                                 temperature NUMERIC not null,
                                 humidity NUMERIC not null,
                                 pressure NUMERIC not null,
                                 container_id VARCHAR(40) NOT NULL,
                                 created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (container_id) REFERENCES containers(id)
);