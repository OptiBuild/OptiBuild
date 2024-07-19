create table harddrives
(
    id                   bigint auto_increment
        primary key,
    type                 varchar(50)  null,
    capacity             varchar(255) null,
    formFactor           float        null,
    hdInterface          varchar(255) null,
    NVMe                 tinyint(1)   null,
    brand                varchar(255) null,
    model                varchar(255) null,
    price                double       not null,
    maxTransferRate      int          null,
    cache                int          null,
    maxSequentialRead    int          null,
    maxSequentialWrite   int          null,
    memoryComponent      varchar(255) null,
    max_transfer_rate    int          null,
    max_sequential_read  int          null,
    max_sequential_write int          null,
    memory_component     varchar(255) null,
    form_factor          float        not null,
    hd_interface         varchar(255) null
);

