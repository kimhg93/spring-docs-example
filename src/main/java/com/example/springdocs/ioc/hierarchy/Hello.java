package com.example.springdocs.ioc.hierarchy;

public class Hello {

    String name;
    Printer printer;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print() {
        this.printer.print(sayHello());
    }

    public String sayHello() {
        return "Hello " + name;
    }
}
