package com.ambitionjh.process.service;


import com.ambitionjh.model.process.Process;
import com.ambitionjh.model.process.ProcessTemplate;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 审批模板 服务类
 * </p>
 *
 * @author ambitionjh
 * @since 2023-10-18
 */
public interface OaProcessTemplateService extends IService<ProcessTemplate> {

    IPage<ProcessTemplate> selectPageProcessTemplate(Page<ProcessTemplate> pageParam);

    void publish(Long id);

}
