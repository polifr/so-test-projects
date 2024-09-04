CREATE TABLE Book (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  isbn VARCHAR(20) NOT NULL UNIQUE,
  published VARCHAR(10) NOT NULL,
  pages INT NOT NULL
);
