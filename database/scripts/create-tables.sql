-- Tables
CREATE TABLE whats_in_my_freezer."users" (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE whats_in_my_freezer."freezers" (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES whats_in_my_freezer."users"(id),
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE whats_in_my_freezer."items" (
    id SERIAL PRIMARY KEY,
    freezer_id INTEGER NOT NULL REFERENCES whats_in_my_freezer."freezers"(id),
    name VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);