CREATE TABLE "user_data" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(100),
    role VARCHAR(100),
    password VARCHAR(100)
);