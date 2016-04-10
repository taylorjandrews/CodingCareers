drop table if exists TestCase;
drop table if exists Task;

create table Task
    (task_id        INT NOT NULL AUTO_INCREMENT,
     instructions   VARCHAR(256),
     code_template  VARCHAR(256),
     primary key (task_id)
    );

create table TestCase
    (test_id        INT NOT NULL AUTO_INCREMENT,
     task_id        INT,
     test_input     VARCHAR(64),
     expeced_output VARCHAR(65),
     primary key (test_id),
     foreign key (task_id) references Task (task_id)
        ON DELETE CASCADE
    );
