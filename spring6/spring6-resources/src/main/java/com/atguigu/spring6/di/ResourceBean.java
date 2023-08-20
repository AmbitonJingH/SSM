package com.atguigu.spring6.di;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 23:27
 * @version 1.0
 */

import org.springframework.core.io.Resource;

public class ResourceBean {

    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void parse(){
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
    }
}
