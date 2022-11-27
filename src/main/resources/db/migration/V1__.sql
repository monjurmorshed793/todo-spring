CREATE TABLE role
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE todo_user
(
    id               UUID        NOT NULL,
    email            VARCHAR(50) NOT NULL,
    firstName        VARCHAR(25) NOT NULL,
    lastName         VARCHAR(25),
    password         VARCHAR(255),
    isAccountExpired CHAR,
    isAccountBlocked CHAR,
    isEnabled        CHAR        NOT NULL,
    CONSTRAINT pk_todo_user PRIMARY KEY (id)
);

CREATE TABLE todo_user_roles
(
    User_id  UUID NOT NULL,
    roles_id UUID NOT NULL,
    CONSTRAINT pk_todo_user_roles PRIMARY KEY (User_id, roles_id)
);

ALTER TABLE todo_user
    ADD CONSTRAINT uc_todo_user_email UNIQUE (email);

ALTER TABLE todo_user_roles
    ADD CONSTRAINT uc_todo_user_roles_roles UNIQUE (roles_id);

ALTER TABLE todo_user_roles
    ADD CONSTRAINT fk_toduserol_on_role FOREIGN KEY (roles_id) REFERENCES role (id);

ALTER TABLE todo_user_roles
    ADD CONSTRAINT fk_toduserol_on_user FOREIGN KEY (User_id) REFERENCES todo_user (id);