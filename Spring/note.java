@PostConstruct 
public void init(){ System.out.println("初始化方法...."); }
@PreDestroy 
public void destroy(){ System.out.println("销毁方法....."); }