create table `case`
(
    id                  bigint auto_increment
        primary key,
    brand               varchar(255) null,
    model               varchar(255) null,
    price               double       not null,
    dimension           varchar(255) null,
    drive_bays25        int          not null,
    drive_bays35        int          not null,
    maxcpucooler_height int          not null,
    maxgpulength        int          not null,
    maxpsulength        int          not null,
    weight              double       not null
);

