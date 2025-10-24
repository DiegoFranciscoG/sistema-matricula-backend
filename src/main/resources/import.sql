-- Niveles
INSERT INTO nivel (nombre, descripcion, created_at, updated_at) VALUES ('PRIMERO', 'Primer Nivel Academico', NOW(), NOW());

-- Periodos
INSERT INTO periodo (nombre, fecha_inicio, fecha_fin, estado, created_at, updated_at) VALUES ('2025-2P', '2025-09-22', '2026-01-19', 'Activo', NOW(), NOW());

-- Institucion
INSERT INTO institucion (nombre, tipo_educativo, created_at, updated_at) VALUES ('INSTITUTO SUPERIOR TECNOLOGICO DEL AZUAY', 'INSTITUTO UNIVERSITARIO', NOW(), NOW());

-- Jornadas
INSERT INTO jornada (nombre, created_at, updated_at) VALUES ('MATUTINA', NOW(), NOW());

-- Paralelos
INSERT INTO paralelo (nombre, jornada_id, created_at, updated_at) VALUES ('A_MATUTINA', 1, NOW(), NOW());

-- Tipos de Matricula
INSERT INTO tipo_matricula (nombre, descripcion, created_at, updated_at) VALUES ('ORDINARIA', 'Matricula ordinaria', NOW(), NOW());

-- Carreras
INSERT INTO carrera (nombre_carrera, duracion_periodos, created_at, updated_at) VALUES ('TECNOLOGIA SUPERIOR EN BIG DATA R', 6, NOW(), NOW());

-- Estudiantes
INSERT INTO estudiante (cedula, nombres, apellidos, fecha_nacimiento, direccion, telefono, email, estado, created_at, updated_at) VALUES ('0107042194', 'MICHELLE YAMILETH', 'YASCARIBAY PALTA', '2000-05-15', 'Cuenca', '0987654321', 'michelle.yascaribay@tecazuay.edu.ec', 'Activo', NOW(), NOW());
INSERT INTO estudiante (cedula, nombres, apellidos, fecha_nacimiento, direccion, telefono, email, estado, created_at, updated_at) VALUES ('0105057775', 'MARY NOEMI', 'PATINO ASTUDILLO', '1999-08-20', 'Cuenca', '0987654322', 'mary.patino@tecazuay.edu.ec', 'Activo', NOW(), NOW());
INSERT INTO estudiante (cedula, nombres, apellidos, fecha_nacimiento, direccion, telefono, email, estado, created_at, updated_at) VALUES ('0106123456', 'JUAN CARLOS', 'LOPEZ MARTINEZ', '2001-03-10', 'Cuenca', '0987654323', 'juan.lopez@tecazuay.edu.ec', 'Activo', NOW(), NOW());

-- Asignaturas
INSERT INTO asignatura (codigo, nombre, descripcion, nivel_id, created_at, updated_at) VALUES ('TSBD R-111', 'FUNDAMENTOS DE ESTADISTICA', 'Estadistica basica', 1, NOW(), NOW());
INSERT INTO asignatura (codigo, nombre, descripcion, nivel_id, created_at, updated_at) VALUES ('TSBD R-112', 'MATEMATICAS', 'Matematicas', 1, NOW(), NOW());
INSERT INTO asignatura (codigo, nombre, descripcion, nivel_id, created_at, updated_at) VALUES ('TSBD R-113', 'OFIMATICA', 'Ofimatica', 1, NOW(), NOW());
INSERT INTO asignatura (codigo, nombre, descripcion, nivel_id, created_at, updated_at) VALUES ('TSBD R-114', 'FUNDAMENTOS DE PROGRAMACION', 'Programacion', 1, NOW(), NOW());
INSERT INTO asignatura (codigo, nombre, descripcion, nivel_id, created_at, updated_at) VALUES ('TSBD R-115', 'INTRODUCCION A LA BIG DATA', 'Big Data', 1, NOW(), NOW());

-- Matricula
INSERT INTO matricula (numero_matricula, estudiante_id, nivel_id, periodo_id, institucion_id, paralelo_id, tipo_matricula_id, carrera_id, jornada_id, fecha_matricula, estado, created_at, updated_at) VALUES ('2025-2P-0001', 1, 1, 1, 1, 1, 1, 1, 1, '2025-09-11', 'Activa', NOW(), NOW());

-- Detalles Matricula
INSERT INTO detalle_matricula (matricula_id, asignatura_id, numero_matricula_asignatura, created_at, updated_at) VALUES (1, 1, 1, NOW(), NOW());
INSERT INTO detalle_matricula (matricula_id, asignatura_id, numero_matricula_asignatura, created_at, updated_at) VALUES (1, 2, 1, NOW(), NOW());
INSERT INTO detalle_matricula (matricula_id, asignatura_id, numero_matricula_asignatura, created_at, updated_at) VALUES (1, 3, 1, NOW(), NOW());
INSERT INTO detalle_matricula (matricula_id, asignatura_id, numero_matricula_asignatura, created_at, updated_at) VALUES (1, 4, 1, NOW(), NOW());
INSERT INTO detalle_matricula (matricula_id, asignatura_id, numero_matricula_asignatura, created_at, updated_at) VALUES (1, 5, 1, NOW(), NOW());