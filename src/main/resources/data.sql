insert into persons(fname, lname, birthdate) values('Ethan', 'Patelia', '2010-01-27');

insert into personscontacts(phonenumber, email, personId) values('5104995471', 'Patelia@gmail.com', 1);
--insert into personscontacts(phonenumber, email, personId) values('4804995471', 'pateliaet@gmail.com', 65);

insert into rolenames(rolename) values('teacher');
insert into rolenames(rolename) values('student');

insert into personsroles(roleid, personId) values(1, 1);
--insert into personsroles(roleid, personId) values(2, 33);