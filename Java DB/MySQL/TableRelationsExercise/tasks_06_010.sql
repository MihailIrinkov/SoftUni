-- University Database_06
use test_me;

CREATE TABLE majors (
    major_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE subjects (
    subject_id INT PRIMARY KEY AUTO_INCREMENT,
    subject_name VARCHAR(50)
);

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_number VARCHAR(12),
    student_name VARCHAR(50),
    major_id INT,
    CONSTRAINT fk_students_major FOREIGN KEY (major_id)
        REFERENCES majors (major_id)
);

CREATE TABLE payments (
    payments_id INT PRIMARY KEY AUTO_INCREMENT,
    payments_date DATE,
    payments_amount DECIMAL(8 , 2 ),
    student_id INT,
    CONSTRAINT fk_payments_students FOREIGN KEY (student_id)
        REFERENCES students (student_id)
);

CREATE TABLE agenda (
    student_id INT,
    subject_id INT,
    CONSTRAINT pk_student_id_subject_id PRIMARY KEY (student_id , subject_id),
    CONSTRAINT fk_student_id_students FOREIGN KEY (student_id)
        REFERENCES students (student_id),
    CONSTRAINT fk_subject_id_subjects FOREIGN KEY (subject_id)
        REFERENCES subjects (subject_id)
);

-- Peaks in Rila_09

SELECT
    mountain_range, peak_name, elevation AS peak_elevation
FROM
    mountaINS AS m
        JOIN
    peaks AS p ON m.id = p.mountain_id
WHERE
    mountain_range = 'Rila'
ORDER BY peak_elevation DESC;

