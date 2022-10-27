-- Group roles
CREATE ROLE admin_freezer INHERIT NOCREATEDB NOCREATEROLE;

-- Login roles
CREATE ROLE freezer_owner INHERIT LOGIN PASSWORD 'freezer_owner';
GRANT admin_freezer TO freezer_owner;

-- Database
CREATE DATABASE whats_in_my_freezer
    WITH OWNER = freezer_owner
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;