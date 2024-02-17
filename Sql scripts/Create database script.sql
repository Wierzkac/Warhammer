-- Create the database
CREATE SCHEMA IF NOT EXISTS Warhammer;

-- Use the database
USE Warhammer;

-- Create the Talents table
CREATE TABLE IF NOT EXISTS Talents (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

-- Create the Skills table
CREATE TABLE IF NOT EXISTS Skills (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type ENUM('BASIC', 'ADVANCED') NOT NULL,
    characteristic ENUM('INTELLIGENCE', 'FELLOWSHIP', 'WILL_POWER', 'AGILITY', 'STRENGTH', 'TOUGHNESS') NOT NULL,
    description VARCHAR(255) NOT NULL
);

-- Create the table for the many-to-many relationship between Skills and Talents
CREATE TABLE IF NOT EXISTS Skill_Talent (
    skill_id BIGINT,
    talent_id BIGINT,
    PRIMARY KEY (skill_id, talent_id),
    FOREIGN KEY (skill_id) REFERENCES Skills(id),
    FOREIGN KEY (talent_id) REFERENCES Talents(id)
);

-- Create the Users table
CREATE TABLE IF NOT EXISTS Users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    profile_picture VARCHAR(255),
    UNIQUE KEY (email)
);

-- Create the Characters table
CREATE TABLE IF NOT EXISTS Characters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    profession VARCHAR(255),
    sex ENUM('MALE', 'FEMALE', 'OTHER'),
    height DECIMAL(5, 2),
    age INT,
    traits VARCHAR(255),
    equipment VARCHAR(255),
    team VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

-- Create the Options table
CREATE TABLE IF NOT EXISTS Options (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    value VARCHAR(50) NOT NULL
);

-- Create the Talents table
CREATE TABLE IF NOT EXISTS Items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

-- Create the Careers table
CREATE TABLE IF NOT EXISTS Careers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    modifiers VARCHAR(255)
);

-- Create the Translation tables
CREATE TABLE IF NOT EXISTS Languages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);
CREATE TABLE IF NOT EXISTS TextContent (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);
CREATE TABLE IF NOT EXISTS Languages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);



