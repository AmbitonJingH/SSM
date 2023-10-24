package com.ambitionjh.process.service.impl;


import com.ambitionjh.model.process.Process;
import com.ambitionjh.model.process.ProcessTemplate;
import com.ambitionjh.model.process.ProcessType;
import com.ambitionjh.process.mapper.OaProcessTemplateMapper;
import com.ambitionjh.process.service.OaProcessService;
import com.ambitionjh.process.service.OaProcessTemplateService;
import com.ambitionjh.process.service.OaProcessTypeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 审批模板 服务实现类
 * </p>
 *
 * @author ambitionjh
 * @since 2023-10-18
 */
@Service
public class OaProcessTemplateServiceImpl extends ServiceImpl<OaProcessTemplateMapper, ProcessTemplate> implements OaProcessTemplateService {
    @Autowired
    private OaProcessTypeService processTypeService;
    @Autowired
    private OaProcessService processService;
    @Override
    public IPage<ProcessTemplate> selectPageProcessTemplate(Page<ProcessTemplate> pageParam) {
        //1. 调用mapper的方法实现分页查询
        Page<ProcessTemplate> processTemplatePage = baseMapper.selectPage(pageParam, null);
        //2. 第一步分页查询返回分页数据，从分页数据获取列表list集合
        List<ProcessTemplate> records = processTemplatePage.getRecords();
        //3. 遍历list集合，得到每个对象的审批类型id
        for (ProcessTemplate processTemplate:records){
            Long processTypeId = processTemplate.getProcessTypeId();
            //4. 根据审批类型id，查询获取对应的名称
            LambdaQueryWrapper<ProcessType> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ProcessType::getId,processTypeId);
            ProcessType processType = processTypeService.getOne(wrapper);
            if(processType == null){
                continue;
            }
            //5. 完成最终的封装processTypeName
            processTemplate.setProcessTypeName(processType.getName());
        }
        return processTemplatePage;
    }

    @Override
    public void publish(Long id) {
        //修改模版发布状态 1表示已经发布
        ProcessTemplate processTemplate = baseMapper.selectById(id);
        processTemplate.setStatus(1);
        baseMapper.updateById(processTemplate);

        //TODO 后续完善，流程定义部署
        if(!StringUtils.isEmpty(processTemplate.getProcessDefinitionPath())) {
            processService.deployByZip(processTemplate.getProcessDefinitionPath());
        }

    }

}
