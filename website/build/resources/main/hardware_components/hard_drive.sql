create table hard_drive
(
    type                 varchar(31)  not null,
    id                   bigint auto_increment
        primary key,
    brand                varchar(255) null,
    model                varchar(255) null,
    price                double       not null,
    nvme                 bit          not null,
    capacity             varchar(255) null,
    form_factor          varchar(10)  null,
    hd_interface         varchar(255) null,
    cache                int          null,
    max_transfer_rate    int          null,
    max_sequential_read  int          null,
    max_sequential_write int          null,
    memory_component     varchar(255) null
);

