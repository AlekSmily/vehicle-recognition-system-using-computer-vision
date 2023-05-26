INSERT INTO USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES ('user@gmail.com', 'User', 'Last_Name', '{noop}password'),
       ('admin@gmail.com', 'Admin', 'L_Name', '{noop}password');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('ROLE_USER', 1),
       ('ROLE_ADMIN', 2),
       ('ROLE_USER', 2);

INSERT INTO VEHICLES (LICENSE_PLATE, COLOR, BRAND)
VALUES ('ВН1352СА', 'Red', 'Mitsubishi'),
       ('АА5508ЕР', 'Blue', 'Fiat');

INSERT INTO VEHICLE_CLASS (TRANSPORT_CLASS, VEHICLE_ID)
VALUES ('SEDAN', 1),
       ('MINIVAN', 2);
