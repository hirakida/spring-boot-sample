/*
 - schema-(platform).sql
 - schema.sql
 - data-(platform).sql
 - data.sql
*/
DELETE FROM `user`;
INSERT INTO `user`(name, enabled, created_at, updated_at) VALUES ('user1', true, '2019-01-02T12:00:00', '2019-01-02T12:00:00');
INSERT INTO `user`(name, enabled, created_at, updated_at) VALUES ('user2', true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `user`(name, enabled, created_at, updated_at) VALUES ('user3', true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `user`(name, enabled, created_at, updated_at) VALUES ('user4', true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `user`(name, enabled, created_at, updated_at) VALUES ('user5', true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `user`(name, enabled, created_at, updated_at) VALUES ('user6', true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
