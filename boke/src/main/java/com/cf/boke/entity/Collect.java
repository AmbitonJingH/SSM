package com.cf.boke.entity;

import lombok.Data;

import java.io.Serializable;

/*
 * @author  AmbitionJingH
 * @date  2023/12/14 18:53
 * @version 1.0
 */
@Data
public class Collect implements Serializable {
    private Integer id = 0;

    private Integer userId;

    private Integer articleId;

    private Integer deleted;

    private static final long serialVersionUID = 1L;

}
