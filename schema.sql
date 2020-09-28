

CREATE TABLE basket (
    basketid serial PRIMARY KEY,
    status character varying(3) DEFAULT 'ON'::character varying NOT NULL
)
WITHOUT OIDS;
ALTER TABLE basket OWNER TO quarkus_test;
CREATE INDEX idx_basket_basketid ON basket(basketid);



CREATE TABLE book (
    bookid serial PRIMARY KEY,
    basketid integer NOT NULL,
    title character varying(100),
    author character varying(120),
    isbn character varying(10),
    status character varying(3) DEFAULT 'ON'::character varying NOT NULL,
    CONSTRAINT fk_book_basketid FOREIGN KEY (basketid) REFERENCES basket (basketid) ON UPDATE CASCADE ON DELETE SET NULL
)
WITHOUT OIDS;
ALTER TABLE book OWNER TO quarkus_test;
CREATE INDEX idx_book_bookid ON book(bookid);
