INSERT INTO movimiento (id, id_empresa, descripcion, bodega_origen_codigo, bodega_destino_codigo, fecha_creacion, fecha_entrega, estado)
VALUES
    (1, 1001, 'Movimiento de prueba1', 'BOD-01', 'BOD-02', '2023-08-13 10:00:00', '2023-08-14 15:00:00', 'P'),
    (2, 1002, 'Movimiento de prueba2', 'BOD-01', 'BOD-03', '2023-08-13 11:00:00', '2023-08-15 12:00:00', 'T'),
    (3, 1001, 'Movimiento de prueba3', 'BOD-02', 'BOD-04', '2023-08-13 12:00:00', '2023-08-16 14:00:00', 'E'),
    (4, 1002, 'Movimiento de prueba4', 'BOD-03', 'BOD-04', '2023-08-14 10:00:00', '2023-08-15 11:00:00', 'P'),
    (5, 1001, 'Movimiento de prueba5', 'BOD-02', 'BOD-03', '2023-08-14 11:00:00', '2023-08-16 12:00:00', 'T'),
    (6, 1002, 'Movimiento de prueba6', 'BOD-01', 'BOD-04', '2023-08-14 12:00:00', '2023-08-17 14:00:00', 'E'),
    (7, 1001, 'Movimiento de prueba7', 'BOD-03', 'BOD-02', '2023-08-15 10:00:00', '2023-08-16 11:00:00', 'P'),
    (8, 1002, 'Movimiento de prueba8', 'BOD-04', 'BOD-01', '2023-08-15 11:00:00', '2023-08-17 12:00:00', 'T'),
    (9, 1001, 'Movimiento de prueba9', 'BOD-03', 'BOD-04', '2023-08-16 10:00:00', '2023-08-18 11:00:00', 'E'),
    (10, 1002, 'Movimiento de prueba10', 'BOD-01', 'BOD-03', '2023-08-16 11:00:00', '2023-08-19 12:00:00', 'P');
