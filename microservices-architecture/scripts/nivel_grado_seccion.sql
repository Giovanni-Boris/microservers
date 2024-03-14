INSERT INTO SECCION (nombre_seccion) VALUES ('A');
INSERT INTO SECCION (nombre_seccion) VALUES ('B');
INSERT INTO SECCION (nombre_seccion) VALUES ('C');
INSERT INTO SECCION (nombre_seccion) VALUES ('D');


INSERT INTO GRADO (num_grado) VALUES ('primero');
INSERT INTO GRADO (num_grado) VALUES ('segundo');
INSERT INTO GRADO (num_grado) VALUES ('tercero');

INSERT INTO NIVEL (nivel) VALUES ('primaria');
INSERT INTO NIVEL (nivel) VALUES ('secundaria');



INSERT INTO grado_nivel (id_grado, id_nivel) VALUES (1, 1);

-- 
INSERT INTO grado_nivel (id_grado, id_nivel) VALUES (2, 1);

--
INSERT INTO grado_nivel (id_grado, id_nivel) VALUES (3, 1);


INSERT INTO grado_nivel (id_grado, id_nivel) VALUES (1, 2);


INSERT INTO grado_nivel (id_grado, id_nivel) VALUES (2, 2);

INSERT INTO grado_nivel (id_grado, id_nivel) VALUES (3, 2);
