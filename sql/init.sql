CREATE TABLE owners (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL CHECK (status IN ('Feito', 'Pendente')),
    description TEXT,
    priority VARCHAR(50) NOT NULL CHECK (priority IN ('Alta', 'Média', 'Baixa')),
    deadline DATE NOT NULL,
    owner_id INTEGER REFERENCES owner(id)
);

INSERT INTO owner (name) VALUES ('John Doe');
INSERT INTO owner (name) VALUES ('Jane Smith');

INSERT INTO task (title, status, description, priority, deadline, owner_id) 
VALUES ('Complete project', 'Pendente', 'Finish the task manager', 'Alta', '2024-10-31', 1);

INSERT INTO task (title, status, description, priority, deadline, owner_id) 
VALUES ('Prepare report', 'Feito', 'Prepare the monthly report', 'Média', '2024-09-30', 2);
