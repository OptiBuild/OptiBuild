create table case_form_factor_compatibility
(
    case_id             bigint not null,
    form_factor_type_id bigint not null,
    primary key (case_id, form_factor_type_id),
    constraint FK70vchafsu79fkrsnkwyr0ss70
        foreign key (case_id) references `case` (id),
    constraint FKsx54c9v2a683qn0wrp874hj33
        foreign key (form_factor_type_id) references form_factor_compatibility (id)
);

