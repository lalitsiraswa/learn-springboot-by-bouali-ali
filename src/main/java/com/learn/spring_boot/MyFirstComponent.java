package com.learn.spring_boot;

//@Component
//@Service
//@Repository
public class MyFirstComponent {
    private String myVar;

    public MyFirstComponent(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello from the MyFirstComponent ==>> myVar : " + this.myVar;
    }
}
