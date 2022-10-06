CREATE TABLE RESOURCE_CLASS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    uuid VARCHAR(36) NOT NULL,
    name VARCHAR(250) NOT NULL,
    CONSTRAINT CLASS_RESOURCE_UUID UNIQUE (uuid)
);