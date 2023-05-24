
CREATE TABLE IF NOT EXISTS usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS procesos_desminado (
    id SERIAL PRIMARY KEY,
    ubicacion VARCHAR(100) NOT NULL,
    region VARCHAR(100) NOT NULL,
    tipo_desminado VARCHAR(50) NOT NULL,
    usuario_id INTEGER NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES "usuarios" (id)
);
