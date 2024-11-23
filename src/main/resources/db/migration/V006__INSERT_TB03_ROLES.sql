
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'areta'), 'ROLE_ADMIN');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'ana'), 'ROLE_USER');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'bruno'), 'ROLE_ADMIN');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'beatriz'), 'ROLE_USER');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'camila'), 'ROLE_ADMIN');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'cintia'), 'ROLE_USER');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'daniel'), 'ROLE_ADMIN');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'daniela'), 'ROLE_USER');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'eder'), 'ROLE_ADMIN');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'emanuelle'), 'ROLE_USER');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'fabiana'), 'ROLE_ADMIN');
insert into tb03_roles (id_usuario, nome) values ((select id from tb02_usuario where username = 'fabio'), 'ROLE_USER');