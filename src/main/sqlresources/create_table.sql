CREATE DOMAIN phoneNumber AS VARCHAR CHECK(VALUE SIMILAR TO '\+?[0-9]+');
CREATE DOMAIN posint AS INTEGER CHECK(VALUE>0);
-----------------------------------
--ACCOMMODATION(student,holiday,dormroom,family,startdate,enddate)
CREATE TABLE ACCOMMODATION (
holiday VARCHAR NOT NULL FOREIGN KEY REFERENCES HOLIDAY(id) ON DELETE CASCADE,
student VARCHAR NOT NULL FOREIGN KEY REFERENCES STUDENT(email) ON DELETE CASCADE,
family VARCHAR NOT NULL, FOREIGN KEY REFERENCES FAMILY(email) ON DELETE CASCADE,
college INTEGER NOT NULL FOREIGN KEY REFERENCES COLLEGE(idcode) ON DELETE CASCADE,
dooroom VARCHAR NOT NULL FOREIGN KEY (college,number )REFERENCES DORMROOM(college,number) ON DELETE CASCADE,
startdate DATE NOT NULL,
enddate DATE NOT NULL,
PRIMARY KEY(holiday, student)
)

--Activity (college, name, description)
CREATE TABLE ACTIVITY(
name VARCHAR NOT NULL,
description VARCHAR NOT NULL,
college INTEGER NOT NULL FOREIGN KEY REFERENCES COLLEGE(id) ON DELETE CASCADE,
PRIMARY KEY(college,name)
);

--Allergy (student, allergen, precautions)
CREATE TABLE ALLERGY(
allergen VARCHAR NOT NULL,
precautions VARCHAR NOT NULL,
student VARCHAR NOT NULL FOREIGN KEY REFERENCES STUDENT(email) ON DELETE CASCADE,
PRIMARY KEY(allergen, student)
);

--Answer (holiday, student, question, answer)
CREATE table ANSWER(
holiday VARCHAR FOREIGN KEY REFERENCES HOLIDAY(id) ON DELETE CASCADE,
student VARCHAR NOT NULL REFERENCES STUDENT(email) ON DELETE CASCADE,
question VARCHAR NOT NULL,
answer VARCHAR NOT NULL,
PRIMARY KEY(holiday,student,question),
FOREIGN KEY(holiday, question) REFERENCES QUESTION(holiday, question) ON DELETE CASCADE
);


--College (id,name,address,postalcode,city,provinceorstate,country,language)
CREATE TABLE COLLEGE(
id VARCHAR PRIMARY KEY,
name VARCHAR NOT NULL,
address VARCHAR NOT NULL,
postalCode VARCHAR NOT NULL,
city VARCHAR NOT NULL,
provinceorstate VARCHAR NOT NULL,
country VARCHAR NOT NULL,
language VARCHAR NOT NULL
);
--FieldTrip (Holiday, destination, description, hours, price)
CREATE TABLE FIELDTRIP(
destination VARCHAR,
price posint NOT NULL,
hours posint NOT NULL,
description VARCHAR NOT NULL,
holiday INTEGER FOREIGN KEY REFERENCES HOLIDAY(id) ON DELETE CASCADE,
PRIMARY KEY(holiday, destination)
);

--DormRoom (college, number, beds)
CREATE TABLE DORMROOM(
number VARCHAR,
college VARCHAR FOREIGN KEY REFERENCES COLLEGE(id) ON DELETE CASCADE,
beds INTEGER NOT NULL CHECK(posti>0 AND posti<4)
PRIMARY KEY(number, college),
);

--Family (email,college,name,surname,members,pets,bedrooms,bathrooms,citydistance)
CREATE TABLE FAMILY(
email VARCHAR NOT NULL,
college VARCHAR NOT NULL FOREIGN KEY REFERENCES COLLEGE(id) ON DELETE CASCADE,
name VARCHAR NOT NULL,
surname VARCHAR NOT NULL,
members POSINT NOT NULL,
bathrooms POSINT NOT NULL,
bedooms POSINT NOT NULL,
pets BOOL NOT NULL,
citydistance VARCHAR NOT NULL
);


--Hobby (student, hobby)
CREATE TABLE HOBBY(
student VARCHAR FOREIGN KEY REFERENCES STUDENT(email) ON DELETE CASCADE,
hobby VARCHAR,
PRIMARY KEY(student, hobby),
)

--Holiday (id,startdate,weeks,college)
CREATE TABLE HOLIDAY(
id VARCHAR PRIMARY KEY,
startdate DATE NOT NULL,
weeks POSINT NOT NULL,
college INTEGER NOT NULL FOREIGN KEY REFERENCES COLLEGE(idcode) ON DELETE CASCADE,
);

--Parent (email,child,name,surname,phonenumber)
CREATE TABLE PARENT(
email VARCHAR PRIMARY KEY,
phoneNumber VARCHAR NOT NULL,
name VARCHAR NOT NULL,
surname VARCHAR NOT NULL,
child VARCHAR NOT NULL FOREIGN KEY REFERENCES STUDENT(email) ON DELETE CASCADE
);

--  Question (holiday,question)
CREATE TABEL SURVEYQUESTION(
holiday VARCHAR FOREIGN KEY REFERENCES HOLIDAY(id) ON DELETE CASCADE,
question VARCHAR NOT NULL,
PRIMARY KEY(holiday,question),
);

--Reservation (holiday,student,familystay*,single*,friend*,paymentmethod)
CREATE TABLE RESERVATION(
student VARCHAR NOT NULL FOREIGN KEY REFERENCES STUDENT(email) ON DELETE CASCADE,
holiday INTEGER FOREIGN KEY REFERENCES HOLIDAY(id) ON DELETE CASCADE,
single BOOL DEFAULT = FALSE,
familystay BOOLEAN NOT NULL,
friend VARCHAR DEFAULT '' FOREIGN KEY REFERENCES STUDENT(email) ON DELETE CASCADE
CHECK(single IS NOT NULL OR friend IS NOT NULL),
paymentmethod VARCHAR NOT NULL,
PRIMARY KEY(student, holiday)
);

--  Survey (holiday,student,score,comment)
CREATE TABLE SURVEY(
holiday VARCHAR FOREIGN KEY REFERENCES HOLIDAY(id) ON DELETE CASCADE,
student VARCHAR NOT NULL REFERENCES STUDENT(email) ON DELETE CASCADE,
score INTEGER NOT NULL,
comment VARCHAR DEFAULT ' ',
PRIMARY KEY(holiday,student)
);


--  Student (email,password,name,surname,birthday,birthplace,address,sex,phonenumber*)
CREATE TABLE STUDENT(
email VARCHAR PRIMARY KEY,
password VARCHAR NOT NULL,
name VARCHAR NOT NULL,
surname VARCHAR NOT NULL,
birthday DATE NOT NULL,
birthplace VARCHAR NOT NULL,
sex VARCHAR NOT NULL,
address VARCHAR NOT NULL,
phoneNumber VARCHAR DEFAULT ' ',
);

--TravelAgent (email, password, name, surname ,phonenumber)
CREATE TABLE TRAVELAGENT(
email VARCHAR PRIMARY KEY,
password VARCHAR NOT NULL,
name VARCHAR NOT NULL,
surname VARCHAR NOT NULL,
phoneNumber VARCHAR NOT NULL
);
