create table if not exists brands
(
    id   serial primary key,
    name varchar
);
create table if not exists carBodies
(
    id   serial primary key,
    name varchar
);

create table if not exists models
(
    id       serial primary key,
    name     varchar,
    brand_id int references brands (id)
);

create table if not exists photos
(
    id   serial primary key,
    name varchar,
    path varchar

);
create table if not exists posts
(
    id             serial primary key,
    created        timestamp,
    descrip        varchar,
    isSale         boolean not null,
    name           varchar,
    productionYear int,
    carBoby_id     int references carBodies (id),
    model_id       int references models (id),
    user_id        int references users (id)
);

create table if not exists posts_photos
(
    post_id   int references posts (id),
    photos_id int references photos (id)
);
create table if not exists users
(
    id    serial primary key,
    email varchar,
    name  varchar,
    phone varchar
)