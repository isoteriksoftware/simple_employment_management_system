CREATE TABLE public.admin (
    id int NOT NULL,
    email character varying(50) NOT NULL UNIQUE,
    password character varying(100) NOT NULL,
    token character varying(100) NOT NULL,
    CONSTRAINT admin_pk PRIMARY KEY (id)
);

CREATE TABLE public.employee (
    id int NOT NULL,
    email character varying(50) NOT NULL UNIQUE,
    password character varying(100) NOT NULL,
    token character varying(100) NOT NULL,
    last_attendance_date timestamp with time zone NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY (id)
);