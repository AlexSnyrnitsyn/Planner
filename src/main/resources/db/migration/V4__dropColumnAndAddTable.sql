alter table "user"
drop column "status";

alter table "user"
drop column "role";

create table "roles"
(
    "id" BigInt not null,
    "name" VarChar(100) not null,
    constraint "roles_Pkey" primary key ("id")
);

insert into "roles" values (1, 'ROLE_USER');
insert into "roles" values (2, 'ROLE_ADMIN');

create table "user_roles"
(
    "id" BigInt not null,
    "user_id" BigInt not null,
    "role_id" BigInt not null,
    constraint "roles_user_Pkey" primary key ("id"),

    constraint "user_id_fkey" foreign key ("user_id") references "user" ("id"),
    constraint "role_id_fkey" foreign key ("role_id") references "roles" ("id")
);

insert into "user_roles" values (1, 1, 2);
insert into "user_roles" values (2, 2, 1);
insert into "user_roles" values (3, 3, 1);
insert into "user_roles" values (4, 4, 1);