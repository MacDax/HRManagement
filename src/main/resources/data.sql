insert into persons(fname, lname, birthdate) values('Ethan', 'Patelia', '2010-01-27');

insert into personscontacts(phonenumber, email, personId) values('5104995471', 'Patelia@gmail.com', 1);
--insert into personscontacts(phonenumber, email, personId) values('4804995471', 'pateliaet@gmail.com', 65);

insert into rolenames(rolename) values('teacher');
insert into rolenames(rolename) values('student');

insert into personsroles(roleid, personId) values(1, 1);
--insert into personsroles(roleid, personId) values(2, 33);

insert into subjects(subjectcode, subjectname) values(101, 'Maths-1');
insert into subjects(subjectcode, subjectname) values(102, 'English-1');

insert into  exquestiontypes(exquestiontype_code, question_type) values(10, 'true/false');

--insert into  questiontypes(questiontype_code, question_type) values(10, 'true/false');
--insert into  questiontypes(questiontype_code, question_type) values(20, 'multiple choice');
--insert into  questiontypes(questiontype_code, question_type) values(30, 'Fill-in-the-blank');