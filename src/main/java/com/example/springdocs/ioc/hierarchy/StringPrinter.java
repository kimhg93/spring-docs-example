package com.example.springdocs.ioc.hierarchy;

public class StringPrinter implements Printer {

    private StringBuilder builder = new StringBuilder();

    @Override
    public void print(String message) {
        this.builder.append(message);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
