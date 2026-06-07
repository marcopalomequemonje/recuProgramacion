CREATE TABLE Especies (id INT PRIMARY KEY, nombre VARCHAR(50), bonificador_vida INT);
CREATE TABLE Profesiones (id INT PRIMARY KEY, nombre VARCHAR(50), sensible_fuerza BOOLEAN);
CREATE TABLE Planetas (id INT PRIMARY KEY, nombre VARCHAR(50), nivel_amenaza INT);
CREATE TABLE Equipamiento (id INT PRIMARY KEY, nombre VARCHAR(50), tipo VARCHAR(50), precio_creditos INT, bonificador_ataque INT, bonificador_defensa INT);
CREATE TABLE Personajes (id INT PRIMARY KEY, nombre VARCHAR(50), nivel INT, creditos INT, vida_actual INT, lado_oscuro INT, id_especie INT REFERENCES Especies(id), id_profesion INT REFERENCES Profesiones(id), id_planeta_actual INT REFERENCES Planetas(id));
CREATE TABLE Inventarios (id_personaje INT REFERENCES Personajes(id), id_equipo INT REFERENCES Equipamiento(id), cantidad INT, PRIMARY KEY (id_personaje, id_equipo));
CREATE TABLE Naves (id INT PRIMARY KEY, nombre VARCHAR(50), modelo VARCHAR(50), integridad_casco INT, id_propietario INT REFERENCES Personajes(id));

INSERT INTO Especies VALUES (1, 'Humano', 10), (2, 'Wookiee', 50), (3, 'Twi''lek', 5);
INSERT INTO Profesiones VALUES (1, 'Jedi', TRUE), (2, 'Sith', TRUE), (3, 'Contrabandista', FALSE);
INSERT INTO Planetas VALUES (1, 'Tatooine', 3), (2, 'Coruscant', 1), (3, 'Hoth', 5);
INSERT INTO Equipamiento VALUES (1, 'Sable de Luz', 'Arma', 5000, 100, 20), (2, 'Blaster DL-44', 'Arma', 800, 60, 0);
INSERT INTO Personajes VALUES (1, 'Luke Skywalker', 10, 2000, 100, 5, 1, 1, 1), (2, 'Darth Vader', 15, 15000, 150, 100, 1, 2, 2);
INSERT INTO Inventarios VALUES (1, 1, 1), (1, 2, 1), (2, 1, 1);
INSERT INTO Naves VALUES (1, 'X-Wing', 'T-65', 100, 1), (2, 'Halcón Milenario', 'YT-1300', 80, 1);
