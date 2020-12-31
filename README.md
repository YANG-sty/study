服务停服

post: `http://192.168.8.158:8760/actuator/shutdown`

Eureka: `http://localhost:8760/`

user: `root`

password: `123456`

查看信息： `http://192.168.8.158:8760/actuator`

消费者服务 `http://172.28.14.55:9091/order/123`

提供服务者 `http://172.28.14.55:7072/product/list`

提供服务者 `http://172.28.14.55:7071/product/list`

远程调用新增用户，异常回滚 `http://172.28.14.55:9091/user/userAdd`