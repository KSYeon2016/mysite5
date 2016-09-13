
CREATE TABLE BBS 
(
 	 NO	 NUMBER NOT NULL ,
 	 TITLE	 VARCHAR2(200)   ,
 	 CONTENT	 VARCHAR2(4000)   ,
 	 REGDATE	 DATE  
);

COMMENT ON COLUMN BBS.NO IS '게시판아이디';

COMMENT ON COLUMN BBS.TITLE IS '제목';

COMMENT ON COLUMN BBS.CONTENT IS '내용';

COMMENT ON COLUMN BBS.REGDATE IS '등록일';

COMMENT ON TABLE BBS IS '게시판';


CREATE UNIQUE INDEX BBS_PK ON BBS
 ( NO );

ALTER TABLE BBS
 ADD CONSTRAINT BBS_PK PRIMARY KEY ( NO )
 USING INDEX BBS_PK;

CREATE SEQUENCE seq_bbs;
select seq_bbs.nextval from dual;

-- select
select * from bbs;
select no, title, regdate from bbs;

delete from bbs where no=2;

update bbs set title='두번째 수정', content='두번째 수정임다' where no=2;