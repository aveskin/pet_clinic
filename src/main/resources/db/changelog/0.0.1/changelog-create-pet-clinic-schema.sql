--liquibase formatted sql

--changeset aveskin:create-pet_clinic-schema
create schema pet_clinic;
--rollback drop schema pet_clinic;