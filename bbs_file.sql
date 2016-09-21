
CREATE TABLE bbs_file 
(
 	 fNO	 NUMBER NOT NULL ,
 	 NO	 NUMBER NOT NULL ,
 	 path	 VARCHAR2(300)   ,
 	 orgName	 VARCHAR2(300)   ,
 	 saveName	 VARCHAR2(300)   ,
 	 fileSize	 NUMBER  
);

COMMENT ON COLUMN bbs_file.fNO IS '첨부파일번호';


COMMENT ON COLUMN bbs_file.NO IS '게시판아이디';

COMMENT ON COLUMN bbs_file.path IS '전체경로';

COMMENT ON COLUMN bbs_file.orgName IS '원파일명';

COMMENT ON COLUMN bbs_file.saveName IS '저장파일명';

COMMENT ON COLUMN bbs_file.fileSize IS '파일크기';

COMMENT ON TABLE bbs_file IS '게시판첨부파일';


CREATE UNIQUE INDEX bbs_file_PK ON bbs_file
 ( fNO );

ALTER TABLE bbs_file
 ADD CONSTRAINT bbs_file_PK PRIMARY KEY ( fNO )
 USING INDEX bbs_file_PK;

CREATE SEQUENCE seq_bbs_file;

select * from bbs_file;