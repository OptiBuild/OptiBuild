create table powersupply
(
    id           bigint auto_increment
        primary key,
    model        varchar(255) null,
    brand        varchar(255) null,
    price        double       not null,
    formFactor   varchar(255) null,
    max_power    int          null,
    maxpsulength int          null,
    modular      varchar(255) null,
    type         varchar(255) null
);

