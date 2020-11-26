INSERT INTO tipocomprobante (nombre_tipocomprobante) VALUES ('BOLETA');
INSERT INTO tipocomprobante (nombre_tipocomprobante) VALUES ('FACTURA');
INSERT INTO tipocomprobante (nombre_tipocomprobante) VALUES ('TICKET');
INSERT INTO tipocomprobante (nombre_tipocomprobante) VALUES ('GUIA DE REMISION');

INSERT INTO tipodocumento (nombre_tipodocumento) VALUES ('DNI');
INSERT INTO tipodocumento (nombre_tipodocumento) VALUES ('RUC');
INSERT INTO tipodocumento (nombre_tipodocumento) VALUES ('CARNET DE EXTRANJERIA');
INSERT INTO tipodocumento (nombre_tipodocumento) VALUES ('PASAPORTE');

INSERT INTO rol (rol,detail_rol) VALUES ('ADMIN','ROLE_ADMIN');
INSERT INTO rol (rol,detail_rol) VALUES ('INVENTARIADOR','ROLE_INVENTOR')

--INSERT INTO usuario (apellido_usuario,email_usuario,nombre_usuario,numerodocumento_usuario,password,telefono_usuario,username,id_tipodocumento,password_descrypt)
--VALUES('Storage','admin@greatstorage.com','Great','12345678','$2a$04$kHkdvWjajDF0RkyAV.NgEe2A9v4y4zVyDy/HC1FpkHiV2VJjO5wee','123456789','admin',1,'1234')
--INSERT INTO usuarios_roles
--(id_usuario,id_rol)
--VALUES
--(1,1)

--Ejemplo Generado de PassGenerator:    $2a$04$kHkdvWjajDF0RkyAV.NgEe2A9v4y4zVyDy/HC1FpkHiV2VJjO5wee