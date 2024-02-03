PGDMP      +                |         	   SpringApp    15.5    16.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16399 	   SpringApp    DATABASE     ~   CREATE DATABASE "SpringApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'French_France.1252';
    DROP DATABASE "SpringApp";
                pgrou    false                       0    0    DATABASE "SpringApp"    COMMENT     9   COMMENT ON DATABASE "SpringApp" IS 'SpringApp database';
                   pgrou    false    3347            �            1259    16410    book    TABLE     �   CREATE TABLE public.book (
    book_id integer NOT NULL,
    book_title character varying(256) NOT NULL,
    book_authors character varying(256) NOT NULL
);
    DROP TABLE public.book;
       public         heap    pgrou    false            �            1259    16409    book_book_id_seq    SEQUENCE     �   CREATE SEQUENCE public.book_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.book_book_id_seq;
       public          pgrou    false    215                       0    0    book_book_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.book_book_id_seq OWNED BY public.book.book_id;
          public          pgrou    false    214            �            1259    16426    borrow    TABLE     �   CREATE TABLE public.borrow (
    borrow_id integer NOT NULL,
    person_id integer NOT NULL,
    book_id integer NOT NULL,
    borrow_date date NOT NULL,
    borrow_return date
);
    DROP TABLE public.borrow;
       public         heap    pgrou    false            �            1259    16425    borrow_borrow_id_seq    SEQUENCE     �   CREATE SEQUENCE public.borrow_borrow_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.borrow_borrow_id_seq;
       public          pgrou    false    219                       0    0    borrow_borrow_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.borrow_borrow_id_seq OWNED BY public.borrow.borrow_id;
          public          pgrou    false    218            �            1259    16419    person    TABLE     �   CREATE TABLE public.person (
    person_id integer NOT NULL,
    person_firstname character varying(128) NOT NULL,
    person_lastname character varying(128) NOT NULL,
    person_birthdate date
);
    DROP TABLE public.person;
       public         heap    pgrou    false            �            1259    16418    person_person_id_seq    SEQUENCE     �   CREATE SEQUENCE public.person_person_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.person_person_id_seq;
       public          pgrou    false    217                       0    0    person_person_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.person_person_id_seq OWNED BY public.person.person_id;
          public          pgrou    false    216            o           2604    16413    book book_id    DEFAULT     l   ALTER TABLE ONLY public.book ALTER COLUMN book_id SET DEFAULT nextval('public.book_book_id_seq'::regclass);
 ;   ALTER TABLE public.book ALTER COLUMN book_id DROP DEFAULT;
       public          pgrou    false    215    214    215            q           2604    16429    borrow borrow_id    DEFAULT     t   ALTER TABLE ONLY public.borrow ALTER COLUMN borrow_id SET DEFAULT nextval('public.borrow_borrow_id_seq'::regclass);
 ?   ALTER TABLE public.borrow ALTER COLUMN borrow_id DROP DEFAULT;
       public          pgrou    false    219    218    219            p           2604    16422    person person_id    DEFAULT     t   ALTER TABLE ONLY public.person ALTER COLUMN person_id SET DEFAULT nextval('public.person_person_id_seq'::regclass);
 ?   ALTER TABLE public.person ALTER COLUMN person_id DROP DEFAULT;
       public          pgrou    false    216    217    217            	          0    16410    book 
   TABLE DATA           A   COPY public.book (book_id, book_title, book_authors) FROM stdin;
    public          pgrou    false    215   �                 0    16426    borrow 
   TABLE DATA           [   COPY public.borrow (borrow_id, person_id, book_id, borrow_date, borrow_return) FROM stdin;
    public          pgrou    false    219   V                 0    16419    person 
   TABLE DATA           `   COPY public.person (person_id, person_firstname, person_lastname, person_birthdate) FROM stdin;
    public          pgrou    false    217   �                  0    0    book_book_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.book_book_id_seq', 5, true);
          public          pgrou    false    214                       0    0    borrow_borrow_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.borrow_borrow_id_seq', 4, true);
          public          pgrou    false    218                       0    0    person_person_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.person_person_id_seq', 3, true);
          public          pgrou    false    216            s           2606    16417    book pk_book 
   CONSTRAINT     O   ALTER TABLE ONLY public.book
    ADD CONSTRAINT pk_book PRIMARY KEY (book_id);
 6   ALTER TABLE ONLY public.book DROP CONSTRAINT pk_book;
       public            pgrou    false    215            w           2606    16431    borrow pk_borrow 
   CONSTRAINT     U   ALTER TABLE ONLY public.borrow
    ADD CONSTRAINT pk_borrow PRIMARY KEY (borrow_id);
 :   ALTER TABLE ONLY public.borrow DROP CONSTRAINT pk_borrow;
       public            pgrou    false    219            u           2606    16424    person pk_person 
   CONSTRAINT     U   ALTER TABLE ONLY public.person
    ADD CONSTRAINT pk_person PRIMARY KEY (person_id);
 :   ALTER TABLE ONLY public.person DROP CONSTRAINT pk_person;
       public            pgrou    false    217            x           2606    16432    borrow book_borrow_fk    FK CONSTRAINT     x   ALTER TABLE ONLY public.borrow
    ADD CONSTRAINT book_borrow_fk FOREIGN KEY (book_id) REFERENCES public.book(book_id);
 ?   ALTER TABLE ONLY public.borrow DROP CONSTRAINT book_borrow_fk;
       public          pgrou    false    219    215    3187            y           2606    16437    borrow person_borrow_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.borrow
    ADD CONSTRAINT person_borrow_fk FOREIGN KEY (person_id) REFERENCES public.person(person_id);
 A   ALTER TABLE ONLY public.borrow DROP CONSTRAINT person_borrow_fk;
       public          pgrou    false    217    3189    219            	   �   x�5�KJA�u�)�!>�����# �)g��HOTuc�I�1s��c�VQ������(X;W�H/�����X�/�����l�:m��3�!�h^�D�׃`-�J�I���"h���u���62��s���d^��;6ͷ�#��Hʟ�٣��b/#���hO�Ty ���ÿ�hmN+(^�1�Mf         C   x�3�4�4�4202�50�54�2-u��8��� g��1'���b@� �01#�X� �.E         _   x�3��L-*J������4200�50�50�2��JM�Ӎ,K-��u
���4�43�5��54�2���&e�r���:�� �-�Zu͸b���� e��     