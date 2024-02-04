CREATE TABLE public.book (
                book_id SERIAL NOT NULL,
                book_title VARCHAR(256) NOT NULL,
                book_authors VARCHAR(256) NOT NULL,
                CONSTRAINT pk_book PRIMARY KEY (book_id)
);
ALTER TABLE public.book OWNER TO pgrou;

CREATE TABLE public.person (
                person_id SERIAL NOT NULL,
                person_firstname VARCHAR(128) NOT NULL,
                person_lastname VARCHAR(128) NOT NULL,
                person_birthdate DATE,
                CONSTRAINT pk_person PRIMARY KEY (person_id)
);
ALTER TABLE public.person OWNER TO pgrou;

CREATE TABLE public.borrow (
                borrow_id SERIAL NOT NULL,
                person_id INTEGER NOT NULL,
                book_id INTEGER NOT NULL,
                borrow_date DATE NOT NULL,
                borrow_return DATE,
                CONSTRAINT pk_borrow PRIMARY KEY (borrow_id)
);
ALTER TABLE public.borrow OWNER TO pgrou;

TRUNCATE public.borrow CASCADE;
TRUNCATE public.person CASCADE;
TRUNCATE public.book CASCADE;

INSERT INTO public.person(person_firstname, person_lastname, person_birthdate) VALUES
('Pierre', 'KIMOUS', '2000-02-04'),
('Jean-Yves', 'MARTIN', '1963-08-12'),
('Jean-Marie', 'NORMAND', '1991-04-16')
;


INSERT INTO public.book(book_title, book_authors) VALUES
('Astérix chez les Bretons', 'René Goscinny, Albert Uderzo'),
('La Foire aux immortels', 'Enki Bilal'),
('Les Passagers du Vent, Volume 1', 'François Bourgeon'),
('Fairy Tail, Vol 1', 'Hiro Mashima'),
('Reincarnated as a Sword, Vol 1', 'Yuu Tanaka')
;

INSERT INTO public.borrow(person_id, book_id, borrow_date, borrow_return) VALUES
(2, 4, '2023-07-15', '2023-09-01'),
(1, 2, '2023-08-01', NULL),
(3, 3, '2023-10-01', NULL),
(2, 1, '2023-10-02', NULL)
;


ALTER TABLE public.borrow ADD CONSTRAINT book_borrow_fk
FOREIGN KEY (book_id)
REFERENCES public.book (book_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.borrow ADD CONSTRAINT person_borrow_fk
FOREIGN KEY (person_id)
REFERENCES public.person (person_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


