INSERT INTO ACTOR
VALUES('AC101', 'Mr. A', '9872583211', 24),
('AC102', 'Mr. B', '8459673214', 31),
('AC103', 'Mr. C', '7456982334', 28),
('AC104', 'Mr. D', '9546213547', 35),
('AC105', 'Mr. E', '9153578624', 52);

INSERT INTO MOVIE
VALUES('M1', 'movie1', 3.7, '100cr'),
('M2', 'movie2', 4.1, '150cr'),
('M3', 'movie3', 4.6, '270cr'),
('M4', 'movie4', 3.9, '120cr');

INSERT INTO WORKS_ON
VALUES('AC101', 'M2', 38.0, '20cr'),
('AC101', 'M3', 54.4, '70cr'),
('AC102', 'M1', 29.0, '10cr'),
('AC103', 'M1', 42.7, '50cr'),
('AC103', 'M3', 32.0, '40cr'),
('AC103', 'M4', 21.0, '7cr'),
('AC104', 'M2', 52.1, '60cr'),
('AC104', 'M4', 46.0, '30cr'),
('AC105', 'M3', 48.3, '60cr');

INSERT INTO AWARD
VALUES('AW1', 'Award1'),
('AW2', 'Award2'),
('AW3', 'Award3');

INSERT INTO AWARDS_WON
VALUES('AC101', 'AW1', 1),
('AC101', 'AW2', 2),
('AC102', 'AW2', 1),
('AC103', 'AW2', 2),
('AC103', 'AW3', 3),
('AC104', 'AW1', 2),
('AC105', 'AW1', 1),
('AC105', 'AW3', 1);

INSERT INTO RELATIONSHIP
VALUES(NULL, 'R101', 'Relation1', 'spouse'),
(NULL, 'R102', 'Relation2', 'son'),
(NULL, 'R103', 'Relation3', 'brother'),
(NULL, 'R104', 'Relation4', 'daughter');