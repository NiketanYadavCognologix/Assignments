package com.cognologix.mapper;

public interface CSVToPojoMapper <T>{
    public T map(String[] input);
}
