CREATE SCHEMA  IF NOT EXISTS  hrm AUTHORIZATION sa;

CREATE TABLE persons(id INTEGER AUTO_INCREMENT PRIMARY KEY, fname VARCHAR(30) NOT NULL, lname VARCHAR(30), birthdate DATE);

CREATE TABLE personscontacts(id INTEGER AUTO_INCREMENT PRIMARY KEY, phonenumber varchar(11), email varchar(30), personId INTEGER, FOREIGN KEY (id) REFERENCES persons(id));

CREATE TABLE rolenames(id INTEGER AUTO_INCREMENT PRIMARY KEY, rolename varchar(225));

CREATE TABLE personsroles(id INTEGER AUTO_INCREMENT PRIMARY KEY, roleid INTEGER, FOREIGN KEY (id) REFERENCES rolenames(id), personId INTEGER, FOREIGN KEY (id) REFERENCES persons(id));

CREATE TABLE subjects(subjectcode INTEGER PRIMARY KEY, subjectname VARCHAR(620));

CREATE TABLE questiontypes(qtypecode INTEGER PRIMARY KEY, qtype VARCHAR(225));

CREATE TABLE exquestiontypes(exquestiontype_code INTEGER PRIMARY KEY, question_type VARCHAR(225));

--CREATE TABLE questions(id INTEGER AUTO_INCREMENT PRIMARY KEY, subjectcode INTEGER, FOREIGN KEY(subjectcode) REFERENCES 
	-- subjects(subjectcode), teacherid INTEGER, FOREIGN KEY (id) REFERENCES persons(id), questiontype INTEGER, FOREIGN KEY (qtypecode) REFERENCES questiontypes(qtypecode));

--CREATE TABLE exam_questions(id INTEGER AUTO_INCREMENT PRIMARY KEY, subjectcode INTEGER, FOREIGN KEY(subjectcode) REFERENCES subjects(subjectcode), teacherid INTEGER, FOREIGN KEY(id) REFERENCES persons(id));

--ALTER TABLE exam_questions ADD exquestiontype_id INTEGER";

--ALTER TABLE exam_questions  ADD FOREIGN KEY (exquestiontype_id) REFERENCES exquestiontypes(exquestiontype_code);


--CREATE TABLE IF NOT EXISTS my_table (
--  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
--);