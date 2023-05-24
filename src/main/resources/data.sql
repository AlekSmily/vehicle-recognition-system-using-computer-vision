INSERT INTO USERS (ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES (1, 'user@gmail.com', 'User', 'Last_Name', 'qwerty'),
       (2, 'admin@gmail.com', 'Admin', 'Last_Name', 'qwerty');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('ROLE_USER', 1),
       ('ROLE_ADMIN', 2),
       ('ROLE_USER', 2);