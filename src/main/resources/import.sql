

insert  into `sys_role`(`id`,`name`) values (1,'ROLE_ADMIN'),(2,'ROLE_USER');

Create PROCEDURE proc()
BEGIN

insert  into `sys_user`(`id`,`create_time`,`email`,`password`,`phone`,`username`,`name`) values (1,'2017-11-06','1160431608@qq.com','123456','18211111111','admin1','张三');


insert  into `sys_user_roles`(`sys_user_id`,`roles_id`) values (1,1);

