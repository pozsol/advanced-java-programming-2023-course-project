INSERT INTO address(city, street, house_number) VALUES ('Budapest', 'Üllői út', 100);
INSERT INTO address(city, street, house_number) VALUES ('Budapest', 'József körút', 25);
INSERT INTO address(city, street, house_number) VALUES ('Debrecen', 'Kossuth utca', 2);

INSERT INTO driving_license(validity) VALUES ('2027-10-04');
INSERT INTO driving_license(validity) VALUES ('2022-06-26');
INSERT INTO driving_license(validity) VALUES ('2023-12-20');
INSERT INTO driving_license(validity) VALUES ('2030-01-17');

INSERT INTO citizen(first_name, last_name, date_of_birth, address_id, driving_license_id) VALUES ('Aladár', 'Kovács', '1983-07-21', 1, 1);
INSERT INTO citizen(first_name, last_name, date_of_birth, address_id, driving_license_id) VALUES ('Krisztina', 'Kovácsné', '1985-03-10', 1, 2);
INSERT INTO citizen(first_name, last_name, date_of_birth, address_id, driving_license_id) VALUES ('Róza', 'Kovács', '2007-12-01', 1, NULL);
INSERT INTO citizen(first_name, last_name, date_of_birth, address_id, driving_license_id) VALUES ('Patrik', 'Kovács', '2010-05-19', 1, NULL);
INSERT INTO citizen(first_name, last_name, date_of_birth, address_id, driving_license_id) VALUES ('Béla', 'Nagy', '1976-11-07', 2, 3);
INSERT INTO citizen(first_name, last_name, date_of_birth, address_id, driving_license_id) VALUES ('Dóra', 'Horváth', '1992-02-24', 3, 4);
INSERT INTO citizen(first_name, last_name, date_of_birth, address_id, driving_license_id) VALUES ('Tibor', 'Molnár', '1990-07-09', 3, NULL);

INSERT INTO bank_account(bank_name, account_number, citizen_id) VALUES ('OTP Bank', 1174756358473658, 1);
INSERT INTO bank_account(bank_name, account_number, citizen_id) VALUES ('Erste Bank', 1167947507462856, 1);
INSERT INTO bank_account(bank_name, account_number, citizen_id) VALUES ('K&H Bank', 1046947690053748, 2);
INSERT INTO bank_account(bank_name, account_number, citizen_id) VALUES ('OTP Bank', 1170759356849275, 3);
INSERT INTO bank_account(bank_name, account_number, citizen_id) VALUES ('OTP Bank', 1175968447264704, 5);
INSERT INTO bank_account(bank_name, account_number, citizen_id) VALUES ('K&H Bank', 1047937083919431, 5);
INSERT INTO bank_account(bank_name, account_number, citizen_id) VALUES ('K&H Bank', 1044608462857204, 6);
INSERT INTO bank_account(bank_name, account_number, citizen_id) VALUES ('Erste Bank', 1167946285704319, 7);
