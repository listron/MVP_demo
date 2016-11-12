# MVP_demo
目前相对成熟的android mvp架构设计


1.MVP介绍

    MVP模式是MVC模式的一个演化版本，MVP全称Model-View-Presenter。目前MVP在Android应用开发中越来越重要了。

在Android中，业务逻辑和数据存取是紧紧耦合的，很多缺乏经验的开发者很可能会将各种各样的业务逻辑塞进某个Activity、Fragment或者自定义View中，这样会使得这些组件的单个类型臃肿不堪。如果不将具体的业务逻辑抽离出来，当UI变化时，你就需要去原来的View中抽离具体业务逻辑，这必然会很麻烦并且易出错。
2.使用MVP的好处

（1）MVP模式会解除View与Model的耦合，有效的降低View的复杂性。同时又带来了良好的可扩展性、可测试性，保证系统的整洁性和灵活性。

（2）MVP模式可以分离显示层与逻辑层，它们之间通过接口进行通信，降低耦合。理想化的MVP模式可以实现同一份逻辑代码搭配不同的显示界面，因为它们之间并不依赖与具体，而是依赖于抽象。这使得Presenter可以运用于任何实现了View逻辑接口的UI，使之具有更广泛的适用性，保证了灵活度。
3.MVP模式的三个角色

（1）Presenter – 交互中间人：Presenter主要作为沟通View与Model的桥梁，它从Model层检索数据后，返回给View层，使得View与Model之间没有耦合，也将业务逻辑从View角色上抽离出来。

（2）View – 用户界面：View通常是指Activity、Fragment或者某个View控件，它含有一个Presenter成员变量。通常View需要实现一个逻辑接口，将View上的操作转交给Presenter进行实现，最后，Presenter 调用View逻辑接口将结果返回给View元素。

（3）Model – 数据的存取：Model 角色主要是提供数据的存取功能。Presenter 需要通过Model层存储、获取数据，Model就像一个数据仓库。更直白的说，Model是封装了数据库DAO或者网络获取数据的角色，或者两种数据方式获取的集合。
4.与MVC、MVVM的区别
1.与MVC的区别

这里写图片描述

从上图可以看出：MVC的耦合性还是较高的，View可以直接访问Model，导致3者之间构成了回路。所以两者的主要区别是，MVP中View不能直接访问Model，需要通过Presenter发出请求，View与Model不能直接通信。
2.与MVVM（Model-View-ViewModel）的区别

MVVM与MVP非常相似，唯一区别是View和Model进行双向绑定，两者之间有一方发生变化则会反应到另一方上。MVVM模式有点像ListView与Adapter、数据集的关系，当数据集发生变化时，调用Adapter的notifyDataSetChanged之后View就直接更新，同时它们之间又没有耦合，使得ListView变得更加灵活。
5.MVP简单实现

可以参考：

1. androidmvp

2. archi
6.MVP 与Activity、Fragment的生命周期

由于Presenter 经常性的持有Activity 的强引用，如果在一些请求结束之前Activity 被销毁了，那么Presenter 一直持有Activity 对象，使得Activity 对象无法回收，此时就会发生内存泄露。
