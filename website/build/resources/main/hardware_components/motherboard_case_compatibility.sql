create table motherboard_case_compatibility
(
    motherboard_id bigint not null,
    case_id        bigint not null,
    primary key (motherboard_id, case_id),
    constraint FKoi2e5tn9odx9p1i3f7v7nhc7c
        foreign key (motherboard_id) references motherboard (id)
);

