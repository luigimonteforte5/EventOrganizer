-- liquibase formatted sql

-- changeset luigi:1744743705057-1
CREATE TABLE event
(
    id    BIGINT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY ,
    title VARCHAR(255) NOT NULL, 
    description VARCHAR(255) NULL,
    starting_date datetime NOT NULL,
    end_date datetime NOT NULL,
    location VARCHAR(255) NOT NULL,
    event_type VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    seats_number INT NOT NULL);

-- changeset luigi:1744743705057-2
CREATE TABLE organizer_event
(
    id       BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
    user_id  BIGINT UNSIGNED NOT NULL,
    event_id BIGINT UNSIGNED NOT NULL
);

-- changeset luigi:1744743705057-3
CREATE TABLE user
(
    id         BIGINT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY ,
    uuid       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL, 
    role VARCHAR(255) NOT NULL,
    registration_date DATETIME NOT NULL,
    last_access_date DATETIME NOT NULL);

-- changeset luigi:1744743705057-4
CREATE TABLE user_event
(
    user_id     BIGINT UNSIGNED NOT NULL,
    event_id    BIGINT UNSIGNED NOT NULL,
    seat_number INT NOT NULL,
    id          BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY
);

-- changeset luigi:1744743705057-5
ALTER TABLE event
    ADD CONSTRAINT id UNIQUE (id);

-- changeset luigi:1744743705057-6
ALTER TABLE user
    ADD CONSTRAINT id UNIQUE (id);

-- changeset luigi:1744743705057-11
ALTER TABLE organizer_event
    ADD CONSTRAINT organizer_event_event_id_fk FOREIGN KEY (event_id) REFERENCES event (id) ON DELETE NO ACTION;
CREATE INDEX organizer_event_event_id_fk ON organizer_event (event_id);

-- changeset luigi:1744743705057-12
ALTER TABLE organizer_event
    ADD CONSTRAINT organizer_event_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE NO ACTION;
CREATE INDEX organizer_event_user_id_fk ON organizer_event (user_id);

-- changeset luigi:1744743705057-13
ALTER TABLE user_event
    ADD CONSTRAINT user_event_event_id_fk FOREIGN KEY (event_id) REFERENCES event (id) ON DELETE NO ACTION;
CREATE INDEX user_event_event_id_fk ON user_event (event_id);

-- changeset luigi:1744743705057-14
ALTER TABLE user_event
    ADD CONSTRAINT user_event_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE NO ACTION;
CREATE INDEX user_event_user_id_fk ON user_event (user_id);

