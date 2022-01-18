create table board_free(
num number primary key, 
userid varchar2(50) not null,
title varchar2(100),
content blob,
regdate date default sysdate,
viewCount number,
startRowNum number,
endRowNum number
);

create sequence board_free_seq;