-- Insertar usuarios de ejemplo
INSERT INTO "usuarios" (nombre, email, password, role) VALUES
    ('Admin usuarios', 'admin@test.com', '$2a$10$1Gu2Gc1vSS1Y3KltlzCK4OxwPSeyZBgyvTGUYXWFGbAZq6Y14ia7e', 'ROLE_ADMIN'),
    ('Agent usuarios', 'agent@test.com', '$2a$10$1Gu2Gc1vSS1Y3KltlzCK4OxwPSeyZBgyvTGUYXWFGbAZq6Y14ia7e', 'ROLE_AGENT'),
    ('Analyst usuarios', 'analyst@test.com', '$2a$10$1Gu2Gc1vSS1Y3KltlzCK4OxwPSeyZBgyvTGUYXWFGbAZq6Y14ia7e', 'ROLE_ANALYST');

-- Obtener los IDs de los usuarios insertados
--SELECT id FROM "user" WHERE role = 'AGENT' LIMIT 1;
--SELECT id FROM "user" WHERE role = 'ANALYST' LIMIT 1;

-- Insertar proceso de desminado relacionado con los usuarios
INSERT INTO procesos_desminado (ubicacion, region, tipo_desminado, usuario_id) VALUES
    ('Ubicacion1', 'Region1', 'Militar', (SELECT id FROM "usuarios" WHERE role = 'ROLE_AGENT' LIMIT 1)),
    ('Ubicacion3', 'Region3', 'Militar', (SELECT id FROM "usuarios" WHERE role = 'ROLE_AGENT' LIMIT 1)),
    ('Ubicacion2', 'Region2', 'Humanitario', (SELECT id FROM "usuarios" WHERE role = 'ROLE_ANALYST' LIMIT 1));
