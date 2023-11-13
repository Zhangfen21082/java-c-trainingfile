package com.example.springbootfirst2023_11_12;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("dbtypes")
@Data
public class ListTest {
    private List<String> name;
}
