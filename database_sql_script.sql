
CREATE SEQUENCE public.interface_user_id_user_seq;

CREATE TABLE public.interface_user (
                id_user INTEGER NOT NULL DEFAULT nextval('public.interface_user_id_user_seq'),
                user_type VARCHAR,
                user_name VARCHAR NOT NULL,
                user_first_name VARCHAR NOT NULL,
                CONSTRAINT interface_user_pk PRIMARY KEY (id_user)
);


ALTER SEQUENCE public.interface_user_id_user_seq OWNED BY public.interface_user.id_user;

CREATE SEQUENCE public.subject_group_id_group_seq;

CREATE TABLE public.subject_group (
                id_group INTEGER NOT NULL DEFAULT nextval('public.subject_group_id_group_seq'),
                group_type VARCHAR,
                group_name VARCHAR NOT NULL,
                group_nb_students INTEGER,
                group_teacher_mail VARCHAR,
                group_student_mail VARCHAR,
                CONSTRAINT subject_group_pk PRIMARY KEY (id_group)
);


ALTER SEQUENCE public.subject_group_id_group_seq OWNED BY public.subject_group.id_group;

CREATE SEQUENCE public.survey_id_survey_seq;

CREATE TABLE public.survey (
                id_survey INTEGER NOT NULL DEFAULT nextval('public.survey_id_survey_seq'),
                survey_code VARCHAR NOT NULL,
                survey_date TIMESTAMP,
                survey_json_file_name VARCHAR,
                id_group INTEGER NOT NULL,
                CONSTRAINT survey_pk PRIMARY KEY (id_survey)
);


ALTER SEQUENCE public.survey_id_survey_seq OWNED BY public.survey.id_survey;

CREATE SEQUENCE public.subject_id_subject_seq;

CREATE TABLE public.subject (
                id_subject INTEGER NOT NULL DEFAULT nextval('public.subject_id_subject_seq'),
                subject_code VARCHAR NOT NULL,
                subject_acronym VARCHAR,
                subject_name VARCHAR,
                has_project BOOLEAN DEFAULT False,
                subject_semester INTEGER,
                subject_year INTEGER,
                subject_student_mail VARCHAR,
                subject_teacher_mail VARCHAR,
                last_survey_date TIMESTAMP,
                last_report_file_name VARCHAR,
                to_renew BOOLEAN DEFAULT False NOT NULL,
                CONSTRAINT subject_pk PRIMARY KEY (id_subject)
);


ALTER SEQUENCE public.subject_id_subject_seq OWNED BY public.subject.id_subject;

CREATE TABLE public.user_linked_to_subject (
                id_user INTEGER NOT NULL,
                id_subject INTEGER NOT NULL,
                CONSTRAINT user_linked_to_subject_pk PRIMARY KEY (id_user, id_subject)
);


CREATE TABLE public.group_contains_subject (
                id_subject INTEGER NOT NULL,
                id_group INTEGER NOT NULL,
                CONSTRAINT group_contains_subject_pk PRIMARY KEY (id_subject, id_group)
);


ALTER TABLE public.user_linked_to_subject ADD CONSTRAINT user_user_linked_to_subject_fk
FOREIGN KEY (id_user)
REFERENCES public.interface_user (id_user)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.group_contains_subject ADD CONSTRAINT group_group_contains_subject_fk
FOREIGN KEY (id_group)
REFERENCES public.subject_group (id_group)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.survey ADD CONSTRAINT group_survey_fk
FOREIGN KEY (id_group)
REFERENCES public.subject_group (id_group)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.group_contains_subject ADD CONSTRAINT subject_group_contains_subject_fk
FOREIGN KEY (id_subject)
REFERENCES public.subject (id_subject)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.user_linked_to_subject ADD CONSTRAINT subject_user_linked_to_subject_fk
FOREIGN KEY (id_subject)
REFERENCES public.subject (id_subject)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
