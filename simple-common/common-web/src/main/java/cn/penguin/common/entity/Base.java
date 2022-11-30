package cn.penguin.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Base implements Serializable {

    private Long id;

    private Integer pageNum;

    private Integer pageSize;
}
