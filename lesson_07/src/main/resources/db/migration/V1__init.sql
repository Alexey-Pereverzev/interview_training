SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS students;

CREATE TABLE students (
                       id                    INT(11) NOT NULL AUTO_INCREMENT,
                       fullname                  VARCHAR(36) NOT NULL,
                       age                   INT NOT NULL,
                       PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO students (fullname, age)
VALUES
    ('Даниил Сысоев', 22),
    ('Кристина Гурьева', 18),
    ('Богдан Королёв', 22),
    ('Елена Дьячкова', 18),
    ('Игорь Панов', 21),
    ('Владимир Шаров', 20),
    ('Виктория Маслова', 16),
    ('Даниил Сазонов', 19),
    ('Екатерина Нестерова', 18),
    ('Игорь Петухов', 16);



