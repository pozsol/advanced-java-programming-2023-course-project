CREATE TABLE "address" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    city VARCHAR(100),
    street VARCHAR(100),
    house_number INTEGER
);

CREATE TABLE "driving_license" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    validity DATE
);

CREATE TABLE "citizen" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_of_birth DATE,
    address_id INTEGER,
    driving_license_id INTEGER,
    CONSTRAINT fk_address
        FOREIGN KEY(address_id)
            REFERENCES address(id),
    CONSTRAINT fk_driving_license
        FOREIGN KEY(driving_license_id)
            REFERENCES driving_license(id)
);

CREATE TABLE "bank_account" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    bank_name VARCHAR(100),
    account_number BIGINT,
    citizen_id INTEGER,
    CONSTRAINT fk_citizen
        FOREIGN KEY(citizen_id)
            REFERENCES citizen(id)
);
