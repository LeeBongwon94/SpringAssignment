CREATE TABLE schedules (
    schedule_id bigint auto_increment primary key,
    username varchar(20) not null,
    title varchar(50) not null,
    contents varchar(100) not null,
    created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
    updated_at TIMESTAMP not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
);

CREATE TABLE comments(
    comment_id bigint auto_increment primary key,
    contents varchar(100) not null,
    comments_user VARCHAR(20) not null,
    created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
    updated_at TIMESTAMP not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
);

CREATE TABLE users(
     user_id bigint auto_increment primary key,
     email varchar(100) not null,
     created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
     updated_at TIMESTAMP not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
);