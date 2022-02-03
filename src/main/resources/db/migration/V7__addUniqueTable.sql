
ALTER TABLE public.project_user
ADD CONSTRAINT uq_project_user UNIQUE(project_id, user_id);