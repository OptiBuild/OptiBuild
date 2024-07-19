create table cpucooler
(
    id          bigint auto_increment
        primary key,
    size        int          null,
    height      int          null,
    RGB         tinyint(1)   null,
    addressable tinyint(1)   null,
    brand       varchar(255) null,
    model       varchar(255) null,
    price       double       not null
);

