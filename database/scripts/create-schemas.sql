-- Schema
CREATE SCHEMA whats_in_my_freezer AUTHORIZATION freezer_owner;
ALTER SCHEMA whats_in_my_freezer OWNER TO freezer_owner;

ALTER DATABASE whats_in_my_freezer SET SEARCH_PATH TO whats_in_my_freezer,public;

-- Privileges
GRANT ALL ON SCHEMA whats_in_my_freezer TO admin_freezer;