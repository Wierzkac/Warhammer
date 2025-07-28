-- USERS TABLE
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(255) NOT NULL UNIQUE,
    role VARCHAR(32) DEFAULT 'USER',
    enabled BOOLEAN DEFAULT FALSE,
    account_non_expired BOOLEAN DEFAULT TRUE,
    account_non_locked BOOLEAN DEFAULT TRUE,
    credentials_non_expired BOOLEAN DEFAULT TRUE
);

-- CAREERS TABLE (extends WarhammerObject)
CREATE TABLE careers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    type VARCHAR(32)
);

-- CAREERS_CAREERS (many-to-many self-join)
CREATE TABLE careers_careers (
    career_entry INT NOT NULL,
    career_exit INT NOT NULL,
    PRIMARY KEY (career_entry, career_exit),
    FOREIGN KEY (career_entry) REFERENCES careers(id),
    FOREIGN KEY (career_exit) REFERENCES careers(id)
);

-- TALENTS TABLE (extends WarhammerObject)
CREATE TABLE talents (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT
);

-- SKILLS TABLE (extends WarhammerObject)
CREATE TABLE skills (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    type VARCHAR(32),
    characteristic VARCHAR(32)
);

-- SKILLS_TALENTS (many-to-many)
CREATE TABLE skills_talents (
    skill_id INT NOT NULL,
    talent_id INT NOT NULL,
    PRIMARY KEY (skill_id, talent_id),
    FOREIGN KEY (skill_id) REFERENCES skills(id),
    FOREIGN KEY (talent_id) REFERENCES talents(id)
);

-- CHARACTERS TABLE
CREATE TABLE characters (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    race VARCHAR(32),
    gender VARCHAR(32),
    current_career_id INT,
    user_id BIGINT,
    experience_points_free INT,
    experience_points_total INT,
    FOREIGN KEY (current_career_id) REFERENCES careers(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- CHARACTER_TALENTS (many-to-many)
CREATE TABLE character_talents (
    character_id BIGINT NOT NULL,
    talent_id INT NOT NULL,
    PRIMARY KEY (character_id, talent_id),
    FOREIGN KEY (character_id) REFERENCES characters(id),
    FOREIGN KEY (talent_id) REFERENCES talents(id)
);

-- CHARACTER_SKILLS (many-to-many)
CREATE TABLE character_skills (
    character_id BIGINT NOT NULL,
    skill_id INT NOT NULL,
    PRIMARY KEY (character_id, skill_id),
    FOREIGN KEY (character_id) REFERENCES characters(id),
    FOREIGN KEY (skill_id) REFERENCES skills(id)
);

-- CHARACTER_CHARACTERISTICS (element collection)
CREATE TABLE character_characteristics (
    character_id BIGINT NOT NULL,
    characteristic VARCHAR(32) NOT NULL,
    value INT NOT NULL,
    PRIMARY KEY (character_id, characteristic),
    FOREIGN KEY (character_id) REFERENCES characters(id)
);

-- IMAGES TABLE
CREATE TABLE images (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    file_name VARCHAR(255) NOT NULL,
    original_file_name VARCHAR(255) NOT NULL,
    content_type VARCHAR(255) NOT NULL,
    file_size BIGINT NOT NULL,
    file_path VARCHAR(500) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    image_type VARCHAR(32) NOT NULL,
    entity_type VARCHAR(32) NOT NULL,
    entity_id BIGINT NOT NULL,
    is_active BOOLEAN DEFAULT FALSE
);

-- EMAILS TO SEND
CREATE TABLE emails_to_send (
    id INT PRIMARY KEY AUTO_INCREMENT,
    recipient VARCHAR(255) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    status VARCHAR(32) NOT NULL,
    email_type VARCHAR(32) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL
);

CREATE TABLE email_arguments (
    email_id INT NOT NULL,
    argument_key VARCHAR(255) NOT NULL,
    argument_value TEXT,
    PRIMARY KEY (email_id, argument_key),
    FOREIGN KEY (email_id) REFERENCES emails_to_send(id)
);

-- INDEXES
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_nickname ON users(nickname);
CREATE INDEX idx_characters_user_id ON characters(user_id);
CREATE INDEX idx_images_entity ON images(entity_type, entity_id);
CREATE INDEX idx_images_type_active ON images(image_type, is_active); 