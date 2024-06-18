CREATE TABLE user_item (
                             user_id INT,
                             item_id INT,
                             FOREIGN KEY (user_id) REFERENCES users(id),
                             FOREIGN KEY (item_id) REFERENCES items(id),
                             PRIMARY KEY (user_id, item_id)
);