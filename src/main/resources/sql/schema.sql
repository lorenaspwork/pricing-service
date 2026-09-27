CREATE TABLE BRAND (
                       ID INTEGER PRIMARY KEY,
                       NAME VARCHAR(50) NOT NULL
);

CREATE TABLE PRODUCT (
                         ID INTEGER PRIMARY KEY,
                         NAME VARCHAR(255)
);

CREATE TABLE PRICES (
                        ID INTEGER PRIMARY KEY,
                        BRAND_ID INTEGER NOT NULL,
                        PRODUCT_ID INTEGER NOT NULL,
                        START_DATE TIMESTAMP NOT NULL,
                        END_DATE TIMESTAMP NOT NULL,
                        PRICE_LIST INTEGER NOT NULL,
                        PRIORITY INTEGER NOT NULL,
                        PRICE DECIMAL(10,2) NOT NULL,
                        CURRENCY_ISO_CODE VARCHAR(3) NOT NULL,

                        CONSTRAINT FK_PRICES_BRAND
                            FOREIGN KEY (BRAND_ID)
                                REFERENCES BRAND(ID),

                        CONSTRAINT FK_PRICES_PRODUCT
                            FOREIGN KEY (PRODUCT_ID)
                                REFERENCES PRODUCT(ID),

                        CONSTRAINT CK_PRICES_DATE_RANGE
                            CHECK (END_DATE >= START_DATE),

                        CONSTRAINT CK_PRICES_PRICE
                            CHECK (PRICE >= 0)
);