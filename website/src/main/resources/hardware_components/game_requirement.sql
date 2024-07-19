create table game_requirement
(
    id               bigint auto_increment
        primary key,
    name             varchar(255) null,
    pc_requirements  text         null,
    os               varchar(255) null,
    processor        varchar(255) null,
    memory           int          null,
    graphics         varchar(255) null,
    directx          varchar(255) null,
    network          varchar(255) null,
    storage          int          null,
    sound_card       varchar(255) null,
    additional_notes text         null
);

