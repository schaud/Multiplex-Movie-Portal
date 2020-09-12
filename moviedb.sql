CREATE Table movie (
id int KEY AUTO_INCREMENT,
name varchar(200),
category int(2),
producer varchar(200),
release_date Date
);

CREATE Table category (
id int KEY AUTO_INCREMENT,
category varchar(200)
);

INSERT INTO movie VALUES (0, 'Avengers', 0, 'Kevin Feige', '2012-05-04');
INSERT INTO movie VALUES (0, 'Avengers: Age of Ultron', 0, 'Kevin Feige', '2015-05-01');
INSERT INTO movie VALUES (0, 'Avengers: Infinity War', 0, 'Kevin Feige', '2018-04-27');
INSERT INTO movie VALUES (0, 'Avengers: Infinity War', 0, 'Kevin Feige', '2019-04-26');
INSERT INTO movie VALUES (0, 'Inception', 6, 'Christoper Nolan', '2010-07-16');
INSERT INTO movie VALUES (0, 'Slumdog: Millionaire', 2, 'Danny Boyle', '2008-11-12');
INSERT INTO movie VALUES (0, 'The Conjuring', 3, 'James Wan', '2013-07-19');



INSERT INTO category VALUES (0, 'Action/Adventure');
INSERT INTO category VALUES (0, 'Romance');
INSERT INTO category VALUES (0, 'Horror');
INSERT INTO category VALUES (0, 'Comedy');
INSERT INTO category VALUES (0, 'Drama');
INSERT INTO category VALUES (0, 'Science Fiction');
INSERT INTO category VALUES (0, 'Animation');
INSERT INTO category VALUES (0, 'Documentary');
INSERT INTO category VALUES (0, 'Historic Fiction');