package com.run.resume.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {
    private Integer id;
    private Integer uid;
    private Integer did;
    private String fileName;
    private String newFileName;
    private String type;
    private String size;
    private String uploadTime;
    private String path;
    private String extension;
    private Integer ischeck;

}
