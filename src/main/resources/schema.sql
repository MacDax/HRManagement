CREATE SCHEMA  IF NOT EXISTS  hrm AUTHORIZATION sa;

CREATE TABLE persons(id INTEGER AUTO_INCREMENT PRIMARY KEY, fname VARCHAR(30) NOT NULL, lname VARCHAR(30), birthdate DATE);

CREATE TABLE personscontacts(id INTEGER AUTO_INCREMENT PRIMARY KEY, phonenumber varchar(11), email varchar(30), personId INTEGER, FOREIGN KEY (id) REFERENCES persons(id));

CREATE TABLE rolenames(id INTEGER AUTO_INCREMENT PRIMARY KEY, rolename varchar(225));

CREATE TABLE personsroles(id INTEGER AUTO_INCREMENT PRIMARY KEY, roleid INTEGER, FOREIGN KEY (id) REFERENCES rolenames(id), personId INTEGER, FOREIGN KEY (id) REFERENCES persons(id));

CREATE TABLE IF NOT EXISTS my_table (
  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);