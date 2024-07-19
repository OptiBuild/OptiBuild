create table computercase
(
    id                  bigint auto_increment
        primary key,
    brand               varchar(255) null,
    model               varchar(255) null,
    type                varchar(255) null,
    price               double       not null,
    drive_bays35        int          null,
    drive_bays25        int          null,
    maxgpulength        int          null,
    maxcpucooler_height int          null,
    maxpsulength        int          null,
    dimension           varchar(255) null,
    weight              double       null
);

