create table computercase_formfactorcompatibility
(
    case_id             bigint not null,
    form_factor_type_id bigint not null,
    primary key (case_id, form_factor_type_id),
    constraint computercase_formfactorcompatibility_ibfk_1
        foreign key (case_id) references computercase (id),
    constraint computercase_formfactorcompatibility_ibfk_2
        foreign key (form_factor_type_id) references formfactorcompatibility (id)
);

create index formFactorType_id
    on computercase_formfactorcompatibility (form_factor_type_id);

