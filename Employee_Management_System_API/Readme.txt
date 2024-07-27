create database employee_management;
use employee_management;


CREATE TABLE organization (
    organization_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL,
    created_by VARCHAR(255),
    created_at TIMESTAMP,
    updated_by VARCHAR(255),
    updated_at TIMESTAMP
);

CREATE TABLE Branch (
    branch_Id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(10) NOT NULL,
    createdBy VARCHAR(255),
    cratedAt TIME,
    updateBy VARCHAR(255),
    updatedAt TIME,
    status VARCHAR(255),
    parent_organization VARCHAR(255),
    pincode VARCHAR(10),
    state VARCHAR(255),
    districts VARCHAR(255),
    city VARCHAR(255),
    email_id VARCHAR(255),
    createdDate DATE,
    createdTime TIME,
    organization_id INT,
    CONSTRAINT CHK_name CHECK (name REGEXP '^[a-zA-Z]+( [a-zA-Z]+)?$'),
    CONSTRAINT CHK_phone_number CHECK (phone_number REGEXP '^[6-9]\\d{9}$'),
    CONSTRAINT FK_organization FOREIGN KEY (organization_id) REFERENCES Organization(organization_id)
);
