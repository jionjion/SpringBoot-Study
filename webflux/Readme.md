## 响应式

### reactor 和 steam 区别
reactor: push模式, 服务端推送数据给客户端, 非阻塞异步
steam: pull模式, 客户端主动调用服务端数据, 同步

### reactor 线程模型
Schedulers.immediate():当前线程
Schedulers.single():可重用的单线程
Schedulers.elastic():弹性线程池
Schedulers.parallel):固定大小线程池
Schedulers.fromExecutorService():自定义线程池

### 源数据流
数据源 -> map -> publishOn -> filter -> publishOn -> flatMap -> subscribeOn -> end

publishOn: 将上游信号传递给下游, 同时改变后续的操作符的执行所在线程.直到下个publishOn出现
subscribeOn: 作用于向上的订阅链,无论位置,都会影响到源头的线程执行环境,但不会影响到后续的publishOn


### 编码套路
1. 定义 `Handler` 处理响应与输出
2. 编写 `ServerRequest` 和 `Mono<ServerResponse>` 
3. 定义 `Router` 配置映射规则

