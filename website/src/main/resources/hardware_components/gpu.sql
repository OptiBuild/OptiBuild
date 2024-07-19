create table gpu
(
    id                   bigint auto_increment
        primary key,
    brand                varchar(255) null,
    model                varchar(255) null,
    score                int          null,
    codaCoreNum          int          null,
    baseClock            int          null,
    boostClock           int          null,
    memory               int          null,
    memoryClock          int          null,
    request_system_power int          null,
    length               int          null,
    price                double       not null,
    base_clock           int          not null,
    boost_clock          int          not null,
    coda_core_num        int          not null,
    memory_clock         int          not null,
    cuda_core_num        int          not null
);

