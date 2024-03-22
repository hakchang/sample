DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    id                     BIGSERIAL PRIMARY KEY,
    username               VARCHAR(255) NOT NULL,
    password               VARCHAR(255) NOT NULL,
    nickname               VARCHAR(255),
    created_datetime       TIMESTAMP DEFAULT NOW(),
    last_modified_datetime TIMESTAMP DEFAULT NOW()
);
COMMENT ON TABLE account IS '계정';
COMMENT ON COLUMN account.id IS '계정 ID';
COMMENT ON COLUMN account.username IS '아이디';
COMMENT ON COLUMN account.password IS '패스워드';
COMMENT ON COLUMN account.nickname IS '이름';
COMMENT ON COLUMN account.created_datetime IS '생성일시';
COMMENT ON COLUMN account.last_modified_datetime IS '마지막 변경일시';

DROP TABLE IF EXISTS term;
CREATE TABLE term
(
    id                     BIGSERIAL PRIMARY KEY,
    title                  VARCHAR(255),
    description            TEXT,
    created_datetime       TIMESTAMP DEFAULT NOW(),
    last_modified_datetime TIMESTAMP
);

DROP TABLE if EXISTS account_term;
CREATE TABLE account_term
(
    account_id             BIGINT  NOT NULL,
    term_id                BIGINT  NOT NULL,
    agree                  BOOLEAN NOT NULL DEFAULT FALSE,
    created_datetime       TIMESTAMP        DEFAULT NOW(),
    last_modified_datetime TIMESTAMP        DEFAULT NOW()
);
ALTER TABLE account_term
    ADD CONSTRAINT account_term_account_fk FOREIGN KEY (account_id)
        REFERENCES account (id) ON DELETE CASCADE;
ALTER TABLE account_term
    ADD CONSTRAINT account_term_term_fk FOREIGN KEY (term_id)
        REFERENCES term (id) ON DELETE CASCADE;
CREATE UNIQUE INDEX account_term_account_id_term_id_uk
    ON account_term (account_id, term_id);

DROP TABLE IF EXISTS "user";
CREATE TABLE "user"
(
    id                     BIGSERIAL PRIMARY KEY,
    account_id             BIGINT NOT NULL,
    name                   VARCHAR(100),
    phone                  VARCHAR(50),
    email                  VARCHAR(255),
    created_datetime       TIMESTAMP DEFAULT NOW(),
    last_modified_datetime TIMESTAMP DEFAULT NOW()
);
ALTER TABLE "user"
    ADD CONSTRAINT user_account_fk FOREIGN KEY (account_id)
        REFERENCES account (id) ON DELETE CASCADE;
