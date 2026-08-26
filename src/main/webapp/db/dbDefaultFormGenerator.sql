-- DB 생성
DROP DATABASE IF EXISTS DB_MEMBER;
DROP DATABASE IF EXISTS DB_MEMO;

CREATE DATABASE DB_TOY;
USE DB_TOY;
SHOW DATABASES;

-- 
CREATE TABLE tbl_mb(
   mb_no            INT      	AUTO_INCREMENT  COMMENT '멤버 번호',
   mb_id            VARCHAR(20) NOT NULL 		COMMENT '멤버 아이디',
   mb_pw   			VARCHAR(20) NOT NULL 		COMMENT '멤버 비밀번호',
   mb_mail			VARCHAR(30) NOT NULL		COMMENT '멤버 메일',
   mb_phone			VARCHAR(20) NOT NULL 		COMMENT '멤버 전화번호',
   PRIMARY KEY(mb_no)
);

DESC tbl_mb;

INSERT INTO tbl_mb(mb_no, mb_id, mb_pw, mb_mail, mb_phone)
VALUES(1, 'user001', '1234', 'user001@gmail.com', '010-1234-5678');

CREATE TABLE tbl_memo(
   memo_no          INT           NOT NULL   COMMENT '메모 번호',
   memo_name        VARCHAR(30)   NOT NULL   COMMENT '메모 제목',
   memo_content     VARCHAR(200)  NOT NULL   COMMENT '메모 내용',
   memo_writer_id   VARCHAR(20)   NOT NULL   COMMENT '메모 작성자 아이디',
   memo_write_date  TIMESTAMP			     COMMENT '메모 작성날짜',
   memo_last_modify TIMESTAMP				 COMMENT '메모 마지막 수정날짜',
   primary key(memo_no)
);

INSERT INTO tbl_memo(memo_no, memo_name, memo_content, memo_writer_id, memo_write_date)
VALUES(1, '오늘날씨맑음', '오늘 놀이동산에 갔다 재밌었다', 'user001', '2020-01-01', '2020-01-01');

DESC tbl_memo;