CREATE TYPE book_status AS ENUM('0', '1');

CREATE TABLE person (
    id SERIAL NOT NULL,
    name VARCHAR(45) NOT NULL,
    nickname VARCHAR(45),
    cpf VARCHAR(11) NOT NULL,
    birthDate DATE NOT NULL,
    phone VARCHAR(14),
    email VARCHAR(45),
    password VARCHAR(25),

    CONSTRAINT pk_person_id PRIMARY KEY(id)
);

CREATE TABLE book (
    id SERIAL NOT NULL,
    title VARCHAR(45) NOT NULL,
    synopsis VARCHAR(200),
    authorName VARCHAR(45) NOT NULL,
    publishedAt DATE NOT NULL,
    publisher VARCHAR(40) NOT NULL,
    status book_status NOT NULL,

    CONSTRAINT pk_book_id PRIMARY KEY(id)
);

CREATE TABLE withdrawal(
    withdrawId SERIAL NOT NULL,
    person_id INT NOT NULL,
    book_id INT NOT NULL,
    drawnDate DATE NOT NULL,
    returnDate DATE,

    CONSTRAINT pk_withdrawal_id PRIMARY KEY(withdrawId),
    CONSTRAINT fk_person_withdrawal_id FOREIGN KEY(person_id) REFERENCES person(id),
    CONSTRAINT fk_book_withdrawal_id FOREIGN KEY(book_id) REFERENCES book(id)
);