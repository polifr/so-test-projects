
-- Drop the users table if it exists
DROP TABLE IF EXISTS users;

-- Create the users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert seed data into the users table
INSERT INTO users (name, email, password) VALUES
('John Doe', 'johndoe@example.com', 'password123'),
('Jane Smith', 'janesmith@example.com', 'password456'),
('Alice Johnson', 'alicejohnson@example.com', 'password789');


DROP TABLE IF EXISTS project_items;
DROP TABLE IF EXISTS projects;


CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table project_items (
    id SERIAL primary key,
    project_id serial4 references projects(id),
    project_item_name VARCHAR(100) not null,
    created_at TIMESTAMP default CURRENT_TIMESTAMP
);


INSERT INTO projects
(id, project_name, created_at)
VALUES(1, 'project name 1', '2024-08-19 04:20:50.868');
INSERT INTO projects
(id, project_name, created_at)
VALUES(2, 'project 2', '2024-08-19 04:21:04.680');

INSERT INTO project_items
(id, project_id, project_item_name, created_at)
VALUES(1, 1, 'item 1', '2024-08-19 04:21:32.593');
INSERT INTO project_items
(id, project_id, project_item_name, created_at)
VALUES(2, 1, 'item 2', '2024-08-19 04:21:32.617');
INSERT INTO project_items
(id, project_id, project_item_name, created_at)
VALUES(3, 2, 'item 1 , project 2', '2024-08-19 04:22:40.658');
INSERT INTO project_items
(id, project_id, project_item_name, created_at)
VALUES(4, 2, 'item 2 , project 2', '2024-08-19 04:22:40.672');
INSERT INTO project_items
(id, project_id, project_item_name, created_at)
VALUES(5, 2, 'item 3 , project 2', '2024-08-19 04:22:40.680');