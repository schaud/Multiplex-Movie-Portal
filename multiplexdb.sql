CREATE Table multiplex (
id int KEY AUTO_INCREMENT,
name varchar(200),
address varchar(500),
number_of_screens int(3)
);

INSERT INTO multiplex VALUES (0, 'AMC Glen Cove 6', '5 School St Glen Cove, New York 11542', 77);
INSERT INTO multiplex VALUES (0, 'AMC Empire 25', '234 West 42nd Street New York, New York 10036', 89);
INSERT INTO multiplex VALUES (0, 'AMC Huntington Square 12', '4000 Jericho Turnpike East Northport, New York 11731', 56);
INSERT INTO multiplex VALUES (0, 'AMC Staten Island 11', '2655 Richmond Avenue Staten Island, New York 10314', 67);
INSERT INTO multiplex VALUES (0, 'AMC Bay Plaza Cinema 13', '2210 Bartow Avenue Bronx, New York 10475', 101);
INSERT INTO multiplex VALUES (0, 'AMC 84th Street 6', '2310 Broadway New York, New York 10024', 185);
INSERT INTO multiplex VALUES (0, 'AMC Orpheum 7', '1538 Third Ave (86th St.) New York, New York 10028', 72);

CREATE TABLE multiplex_movies(
movie KEY varchar(200)
multiplex_id int,
);

INSERT INTO multiplex_movies VALUES (1, 'Avengers');
INSERT INTO multiplex_movies VALUES (2, 'Avengers');
INSERT INTO multiplex_movies VALUES (3, 'Avengers');
INSERT INTO multiplex_movies VALUES (4, 'Avengers');
INSERT INTO multiplex_movies VALUES (5, 'Avengers');
INSERT INTO multiplex_movies VALUES (6, 'Avengers');
INSERT INTO multiplex_movies VALUES (7, 'Avengers');

INSERT INTO multiplex_movies VALUES (1, 'The Conjuring');
INSERT INTO multiplex_movies VALUES (2, 'Slumdog Millionaire');
INSERT INTO multiplex_movies VALUES (3, 'Avengers: Age of Ultron');
INSERT INTO multiplex_movies VALUES (4, 'Inception');
INSERT INTO multiplex_movies VALUES (5, 'The Conjuring');
INSERT INTO multiplex_movies VALUES (6, 'Slumdog Millionaire');
INSERT INTO multiplex_movies VALUES (7, 'The Conjuring');
