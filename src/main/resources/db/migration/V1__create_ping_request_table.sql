CREATE TABLE ping_request (
                              id SERIAL PRIMARY KEY,
                              host VARCHAR(255) NOT NULL,
                              date TIMESTAMP NOT NULL,
                              status VARCHAR(20) NOT NULL,
                              result TEXT NOT NULL
);
