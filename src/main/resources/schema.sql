drop table if exists URL;
create table URL
(
    id    int not null auto_increment,
    url  varchar(50) not null,
    created_date date,
    short_url  varchar(10) not null,
    primary key (id)
)
