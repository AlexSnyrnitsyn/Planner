create table "project"
(
    "id" BigInt not null,
    "project_name" VarChar(255) not null,
    "goal_project" VarChar(255) not null,
    "complexity_project" VarChar(255) not null,
    constraint "project_Pkey" primary key ("id")
);

create table "project_user"
(
    "id" BigInt not null,
    "project_id" BigInt not null,
    "user_id" BigInt not null,
    constraint "project_user_Pkey" primary key ("id"),
    constraint "project_user_user_fkey" foreign key ("user_id") references "user" ("id"),
    constraint "project_user_project_fkey" foreign key ("project_id") references "project" ("id")
);



