create table power_supply
(
    id           bigint auto_increment
        primary key,
    brand        varchar(255) null,
    model        varchar(255) null,
    price        double       not null,
    maxpsulength int          not null,
    max_power    int          not null,
    modular      tinyint      null,
    type         varchar(255) null,
    check (`modular` between 0 and 2)
);

