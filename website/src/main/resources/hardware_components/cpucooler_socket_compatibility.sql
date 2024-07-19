create table cpucooler_socket_compatibility
(
    cooler_id        bigint not null,
    compatibility_id bigint not null,
    primary key (cooler_id, compatibility_id),
    constraint cpucooler_socket_compatibility_ibfk_1
        foreign key (cooler_id) references cpucooler (id),
    constraint cpucooler_socket_compatibility_ibfk_2
        foreign key (compatibility_id) references socketcompatibility (id)
);

create index compatibility_id
    on cpucooler_socket_compatibility (compatibility_id);

