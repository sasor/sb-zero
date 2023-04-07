package com.sasor.todoapp.mapper;

public interface Mapper<I, O>
{
    public O map(I in);
}
