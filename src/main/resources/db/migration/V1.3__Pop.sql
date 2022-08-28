create table role(
id varchar(255) primary key,
name varchar(255)

);
INSERT INTO role(id, name)
  VALUES (uuid(), 'USER'), (uuid(), 'ADMIN');