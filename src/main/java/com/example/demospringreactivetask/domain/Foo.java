package com.example.demospringreactivetask.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Foo {
    private String id;
    private String name;
}
