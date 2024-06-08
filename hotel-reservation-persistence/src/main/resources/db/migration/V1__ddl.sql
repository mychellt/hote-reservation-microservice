CREATE TABLE IF NOT EXISTS guests(
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    id CHAR(36)PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS hotels(
     id CHAR(36)PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     phone VARCHAR(20) NOT NULL,
     number_of_rooms INT NOT NULL,
     available_rooms INT
);


CREATE TABLE IF NOT EXISTS reservations(
   id CHAR(36)PRIMARY KEY,
   status VARCHAR(50) NOT NULL,
   hotel_id CHAR(36) NOT NULL,
   guest_id CHAR(36) NOT NULL,
   number_of_rooms INT NOT NULL,
   check_in_date DATE,
   check_out_date DATE,
   FOREIGN KEY (hotel_id) REFERENCES hotels(id),
   FOREIGN KEY (guest_id) REFERENCES guests(id)
);