ALTER TABLE "user_roles"
drop constraint "user_id_fkey";

ALTER TABLE "user_roles"
drop constraint "role_id_fkey";

DROP TABLE "user_roles";