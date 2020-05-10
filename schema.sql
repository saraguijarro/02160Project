# Use these queries to create the tables in the database

CREATE TABLE client(
                       ID VARCHAR(255) PRIMARY KEY NOT NULL,
                       Name VARCHAR(255),
                       Reference_person VARCHAR(255),
                       Email VARCHAR(255),
                       Password VARCHAR(255),
                       country VARCHAR(255),
                       city VARCHAR(255),
                       postcode VARCHAR(255),
                       street_name varchar(255),
                       street_number varchar(255),
                       created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);

CREATE TABLE company(
        ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
        name varchar(255) not null,
        password varchar(255) not null
);


create table containers
(
    id VARCHAR(40) PRIMARY KEY NOT NULL,
    position VARCHAR(255),
    journey_id VARCHAR(255),
    in_journey BOOLEAN DEFAULT FALSE,
    temperature VARCHAR(1000),
    humidity VARCHAR(1000),
    pressure VARCHAR(1000),
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
         created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

