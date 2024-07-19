create table motherboard_formfactorcompatibility
(
    motherboard_id    bigint not null,
    formFactorType_id bigint not null,
    primary key (motherboard_id, formFactorType_id),
    constraint motherboard_formfactorcompatibility_ibfk_1
        foreign key (motherboard_id) references motherboard (id),
    constraint motherboard_formfactorcompatibility_ibfk_2
        foreign key (formFactorType_id) references formfactorcompatibility (id)
);

create index formFactorType_id
    on motherboard_formfactorcompatibility (formFactorType_id);

