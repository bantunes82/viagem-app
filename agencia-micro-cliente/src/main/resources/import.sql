CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;
INSERT INTO Cliente(id,nome) VALUES (nextval('hibernate_sequence'),'João');
INSERT INTO Cliente(id,nome) VALUES (nextval('hibernate_sequence'),'Maria');
INSERT INTO Cliente(id,nome) VALUES (nextval('hibernate_sequence'),'José');
INSERT INTO Cliente(id,nome) VALUES (nextval('hibernate_sequence'),'Ana');