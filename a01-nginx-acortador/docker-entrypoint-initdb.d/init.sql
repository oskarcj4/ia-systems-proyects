CREATE TABLE links(
    code VARCHAR(7) PRIMARY KEY,
    url text CHECK(length(text) <= 2048),
    created_at TIMESTAMPZ NOT NULL DEFAULT NOW()
);
