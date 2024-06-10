CREATE TABLE IF NOT EXISTS hotels(
     id UUID PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     phone VARCHAR(20) NOT NULL,
     number_of_rooms INT NOT NULL,
     available_rooms INT
);


CREATE TABLE IF NOT EXISTS reservations(
   id UUID PRIMARY KEY,
   travel_reservation_id UUID NOT NULL,
   status VARCHAR(50) NOT NULL,
   hotel_id UUID NOT NULL,
   number_of_rooms INT NOT NULL,
   check_in_date DATE,
   check_out_date DATE,
   FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);