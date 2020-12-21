CREATE TABLE FileN (
id INT NOT NULL,
CONSTRAINT file_pk PRIMARY KEY(id),
storage_fk INT,
CONSTRAINT file_fk FOREIGN KEY (storage_fk) REFERENCES Storage(id),
name_file NVARCHAR2(20) NOT NULL,
format_file NVARCHAR2(30) NOT NULL,
size_file NUMBER(5,0) NOT NULL
);