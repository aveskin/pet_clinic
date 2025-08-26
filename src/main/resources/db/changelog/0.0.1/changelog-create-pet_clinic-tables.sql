--liquibase formatted sql


--changeset aveskin:001-create-owners
CREATE TABLE pet_clinic.owners (
                        id BIGSERIAL PRIMARY KEY,
                        first_name VARCHAR(50) NOT NULL,
                        last_name VARCHAR(50) NOT NULL,
                        phone VARCHAR(20),
                        email VARCHAR(100) UNIQUE,
                        address VARCHAR(255)
);
--rollback DROP TABLE pet_clinic.owners;

--changeset aveskin:002-create-pets
CREATE TABLE pet_clinic.pets (
                      id BIGSERIAL PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      birth_date DATE,
                      species VARCHAR(50) NOT NULL,
                      breed VARCHAR(50),
                      owner_id BIGINT NOT NULL,
                      CONSTRAINT fk_pets_owner FOREIGN KEY (owner_id)
                          REFERENCES pet_clinic.owners(id) ON DELETE CASCADE
);
--rollback DROP TABLE pet_clinic.pets;

--changeset aveskin:003-create-vets
CREATE TABLE pet_clinic.vets (
                      id BIGSERIAL PRIMARY KEY,
                      first_name VARCHAR(50) NOT NULL,
                      last_name VARCHAR(50) NOT NULL,
                      specialization VARCHAR(100),
                      phone VARCHAR(20),
                      email VARCHAR(100) UNIQUE
);
--rollback DROP TABLE pet_clinic.vets;

--changeset aveskin:004-create-visits
CREATE TABLE pet_clinic.visits (
                        id BIGSERIAL PRIMARY KEY,
                        visit_date TIMESTAMP NOT NULL,
                        pet_id BIGINT NOT NULL,
                        vet_id BIGINT NOT NULL,
                        description TEXT,
                        CONSTRAINT fk_visits_pet FOREIGN KEY (pet_id)
                            REFERENCES pet_clinic.pets(id) ON DELETE CASCADE,
                        CONSTRAINT fk_visits_vet FOREIGN KEY (vet_id)
                            REFERENCES pet_clinic.vets(id) ON DELETE CASCADE
);
--rollback DROP TABLE pet_clinic.visits;

--changeset aveskin:005-create-bills
CREATE TABLE pet_clinic.bills (
                       id BIGSERIAL PRIMARY KEY,
                       visit_id BIGINT NOT NULL,
                       amount DECIMAL(10,2) NOT NULL CHECK (amount >= 0),
                       status VARCHAR(20) NOT NULL CHECK (status IN ('PAID', 'UNPAID', 'CANCELED')),
                       payment_date TIMESTAMP,
                       CONSTRAINT fk_bills_visit FOREIGN KEY (visit_id)
                           REFERENCES pet_clinic.visits(id) ON DELETE CASCADE
);
--rollback DROP TABLE pet_clinic.bills;