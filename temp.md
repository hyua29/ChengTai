LOAD DATA INFILE '/home/cooper/Projects/idea/ChengTai/pods_reduced.csv' 
INTO TABLE ChengTai.PODs 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

CREATE USER 'adminchengtai'@'aa1htwrjode8zsm.cpzkief0te2p.us-east-2.rds.amazonaws.com' IDENTIFIED BY 'Yhm20082008';
GRANT ALL PRIVILEGES ON ChengTai.* TO 'admin'@'aa1htwrjode8zsm.cpzkief0te2p.us-east-2.rds.amazonaws.com';
flush privileges;
