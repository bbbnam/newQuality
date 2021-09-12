### Member 도메인
- 생성 
```sql
create table member 
(id bigint generated by default as identity, 
city varchar(255), 
street varchar(255), 
zip_code varchar(255), 
age integer, 
email varchar(255), 
password varchar(255), 
primary key (id))
```
