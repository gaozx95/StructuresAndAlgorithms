1、Executor          接口，执行某些（runnable）任务，用run执行      执行任务有excutor  submit两种方法
2、ExecutorService   子接口，submit，可以接受runnable和callbale任务，有返回
3、Callable          约等于runnable，有返回值
4、Executors         工具类，常用一些操作
5、Future

线程池

    newFixedThreadPool
    newCachedThreadPool()
    newSingleThreadExecutor()
    newScheduledThreadPool()
背后都是实现ThreadPoolExecutor

 newWorkStealingPool()       //守护线程
 背后由ForkJoinPool实现