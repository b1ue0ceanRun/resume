package com.run.resume.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormInfo {
    private Integer uid;
    private Integer did;
    private List<Map<String,String>> formList;
}

