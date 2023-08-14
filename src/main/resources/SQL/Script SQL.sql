CREATE DATABASE testswisslub;

USE testswisslub;


-- Crear la tabla "movimiento"
CREATE TABLE movimiento (
    id INT PRIMARY KEY,
    id_empresa INT,
    descripcion TEXT,
    bodega_origen_codigo VARCHAR(50),
    bodega_destino_codigo VARCHAR(50),
    fecha_creacion DATE,
    fecha_entrega DATE,
    estado VARCHAR(20)
);

-- Crear la tabla "movimiento_detalle"
CREATE TABLE movimiento_detalle (
    id INT PRIMARY KEY,
    movimiento_id INT,
    item_codigo VARCHAR(20),
    cantidad_enviada INT,
    FOREIGN KEY (movimiento_id) REFERENCES movimiento(id)
);