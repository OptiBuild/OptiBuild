create table cpu
(
    id          bigint auto_increment
        primary key,
    brand       varchar(255) null,
    model       varchar(255) null,
    score       int          null,
    coreNum     int          null,
    threadNum   int          null,
    upperClock  float        null,
    lowerClock  float        null,
    socket_type varchar(255) null,
    L3Cache     int          null,
    TDP         int          null,
    price       double       not null,
    core_num    int          not null,
    lower_clock float        not null,
    thread_num  int          not null,
    upper_clock float        not null
);

