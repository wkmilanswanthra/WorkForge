-- src/main/resources/db/migration/V1__create_projects.sql
CREATE TABLE IF NOT EXISTS projects (
                                        id UUID PRIMARY KEY,
                                        name VARCHAR(140) NOT NULL,
    description TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
    );
