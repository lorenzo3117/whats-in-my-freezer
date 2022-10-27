psql -U postgres -f scripts/initialize-db.sql
psql -U postgres -d whats_in_my_freezer -f scripts/create-schemas.sql
psql -U postgres -d whats_in_my_freezer -f scripts/create-tables.sql