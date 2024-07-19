create table ram
(
    id          bigint auto_increment
        primary key,
    brand       varchar(255) null,
    model       varchar(255) null,
    price       double       not null,
    DDRVersion  int          null,
    stickNum    int          null,
    size        int          null,
    clock_speed int          null,
    voltage     double       not null,
    RGB         tinyint(1)   null,
    stick_num   int          not null
);

