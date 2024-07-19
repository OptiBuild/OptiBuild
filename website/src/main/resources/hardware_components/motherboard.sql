create table motherboard
(
    id            bigint auto_increment
        primary key,
    brand         varchar(255) null,
    model         varchar(255) null,
    socket_type   varchar(255) null,
    chipset       varchar(255) null,
    memorySlot    int          null,
    clock_speed   int          null,
    maxMemory     int          null,
    ddrx          int          null,
    PCIe4x16Slots int          null,
    SATASlots     int          null,
    SATASpeed     int          null,
    M2Slots       int          null,
    M2Type        varchar(255) null,
    supportNVMe   tinyint(1)   null,
    form_factor   varchar(255) null,
    price         double       not null,
    max_memory    int          not null,
    memory_slot   int          not null,
    constraint CHK_supportNVMe
        check (`supportNVMe` in (0, 1))
);

