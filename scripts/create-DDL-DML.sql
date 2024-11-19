-- Create Users table
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL
);

-- Insert data into Users table
INSERT INTO users (first_name, last_name) VALUES
                                              ('John', 'Doe'),
                                              ('Jane', 'Smith'),
                                              ('Michael', 'Johnson'),
                                              ('Emily', 'Davis'),
                                              ('David', 'Wilson'),
                                              ('Sarah', 'Brown'),
                                              ('Chris', 'Taylor'),
                                              ('Jessica', 'Anderson'),
                                              ('Daniel', 'Thomas'),
                                              ('Sophia', 'Martinez');

-- Create Portfolio table with foreign key reference
CREATE TABLE portfolio (
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           user_id BIGINT NOT NULL,
                           CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Insert data into Portfolio table
INSERT INTO portfolio (name, user_id) VALUES
                                          ('John Portfolio', 1),
                                          ('Jane Portfolio', 2),
                                          ('Michael Portfolio', 3),
                                          ('Emily Portfolio', 4),
                                          ('David Portfolio', 5),
                                          ('Sarah Portfolio', 6),
                                          ('Chris Portfolio', 7),
                                          ('Jessica Portfolio', 8),
                                          ('Daniel Portfolio', 9),
                                          ('Sophia Portfolio', 10);

-- Optional: Create index on user_id for performance improvement
CREATE INDEX idx_user_id ON portfolio(user_id);