CREATE TABLE cards(
                       id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       number varchar(45) not null,
                       user_id int REFERENCES cards (id) ON DELETE CASCADE
);