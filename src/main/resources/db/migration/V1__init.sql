create table "user"
(
"id" BigInt not null,
"first_name" VarChar(255) not null,
"last_name" VarChar(255) not null,
"login" VarChar(10) not null,
"password" VarChar(20) not null,
"position_id" BigInt not null,
"subdivision_id" BigInt not null,
constraint "user_Pkey" primary key ("id"),
constraint "user_subdivision_fkey" foreign key ("subdivision_id") references "subdivision" ("id"),
constraint "user_position_fkey" foreign key ("position_id") references "position" ("id")
);

insert into "user" values (1, 'Alexander', 'Alexandrov', 1111, 2222, 1, 1);
insert into "user" values (2, 'Foma', 'Fomov', 3333, 4444, 2, 2);
insert into "user" values (3, 'Stas', 'Stasov', 5555, 6666, 3, 3);
insert into "user" values (4, 'Misha', 'Mishov', 7777, 8888, 2, 1);

create table "skill"
(
"id" BigInt not null,
"skill_name" VarChar(255) not null,
"description" VarChar(255) not null,
"first_grade" VarChar(255) not null,
"second_grade" VarChar(255) not null,
"third_grade" VarChar(255) not null,
"fourth_grade" VarChar(255) not null,
"fifth_grade" VarChar(255) not null,
constraint "skill_Pkey" primary key ("id")
);

insert into "skill" values (1, 'Java', 'Java lan','ООП', 'basedata', 'Springs', 'frameworks', 'WebService');
insert into "skill" values (2, 'C++', 'C++ lan','ООП', 'basedata', 'Springs', 'frameworks', 'WebService' );
insert into "skill" values (3, 'JavaScript', 'JavaScript lan','ООП', 'basedata', 'Springs', 'frameworks', 'WebService');
insert into "skill" values (4, 'pyton', 'pyton lan','ООП', 'basedata', 'Springs', 'frameworks', 'WebService' );

create table "user_skill"
(
"id" BigInt not null,
"user_id" BigInt not null,
"skill_id" BigInt not null,
"grade" Int not null,
constraint "user_skill_Pkey" primary key ("id"),
constraint "user_skill_user_fkey" foreign key ("user_id") references "user" ("id"),
constraint "user_skill_skill_fkey" foreign key ("skill_id") references "skill" ("id")
);

create table "subdivision"
(
"id" BigInt not null,
"subdivision_name" VarChar(255) not null,
constraint "subdivision_Pkey" primary key ("id")
);
insert into "subdivision" values (1, 'отдел разработки');
insert into "subdivision" values (2, 'отдел тестирования');
insert into "subdivision" values (3, 'отдел аналитики');

create table "position"
(
"id" BigInt not null,
"position_name" VarChar(255) not null,
constraint "position_Pkey" primary key ("id")
);
insert into "position" values (1, 'джуниор');
insert into "position" values (2, 'мидл');
insert into "position" values (3, 'сеньор');