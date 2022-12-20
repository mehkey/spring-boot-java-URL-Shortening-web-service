drop table if exists URL;
create table URL
(
    id    int         not null auto_increment,
    url  varchar(50) not null,
    created_date datetime ,
    primary key (id)
)