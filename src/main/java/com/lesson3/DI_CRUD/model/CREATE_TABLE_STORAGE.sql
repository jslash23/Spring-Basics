CREATE TABLE Storage (
id INT,
CONSTRAINT storage_pk PRIMARY KEY(id),
formatsSupported NVARCHAR2(10) NOT NULL,
storageCountry NVARCHAR2(20) NOT NULL,
storageSize NUMBER(10) NOT NULL
);