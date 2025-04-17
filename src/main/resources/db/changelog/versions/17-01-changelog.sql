-- liquibase formatted sql

-- changeset luigi:1744907983404-20
ALTER TABLE user
    ADD keycloak_id VARCHAR(255) NULL;

-- changeset luigi:1744907983404-21
ALTER TABLE user MODIFY keycloak_id VARCHAR (255) NOT NULL;

-- changeset luigi:1744907983404-22
ALTER TABLE user
    ADD CONSTRAINT uc_user_keycloakid UNIQUE (keycloak_id);

ALTER TABLE user
    DROP COLUMN password