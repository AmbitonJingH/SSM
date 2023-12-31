package com.ambitionjh.process.controller;


import com.ambitionjh.common.result.Result;
import com.ambitionjh.model.process.Process;
import com.ambitionjh.model.process.ProcessTemplate;
import com.ambitionjh.process.service.OaProcessTemplateService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * <p>
 * 审批模板 前端控制器
 * </p>
 *
 * @author ambitionjh
 * @since 2023-10-18
 */
@RestController
@RequestMapping("/admin/process/processTemplate")
public class OaProcessTemplateController {
    @Autowired
    private OaProcessTemplateService processTemplateService;

    //分页查询审批模板
    @ApiOperation("分页查询")
    @GetMapping("/{page}/{limit}")
    public Result page(@PathVariable Long page,
                       @PathVariable Long limit){
        Page<ProcessTemplate> pageParam = new Page<>(page,limit);
        IPage<ProcessTemplate> pageModel = processTemplateService.selectPageProcessTemplate(pageParam);
        return Result.ok(pageModel);
    }

    //@PreAuthorize("hasAuthority('bnt.processTemplate.list')")
    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        ProcessTemplate processTemplate = processTemplateService.getById(id);
        return Result.ok(processTemplate);
    }

    //@PreAuthorize("hasAuthority('bnt.processTemplate.templateSet')")
    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody ProcessTemplate processTemplate) {
        processTemplateService.save(processTemplate);
        return Result.ok();
    }

    //@PreAuthorize("hasAuthority('bnt.processTemplate.templateSet')")
    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody ProcessTemplate processTemplate) {
        processTemplateService.updateById(processTemplate);
        return Result.ok();
    }

    //@PreAuthorize("hasAuthority('bnt.processTemplate.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        processTemplateService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "上传流程定义")
    @PostMapping("/uploadProcessDefinition")
    public Result uploadProcessDefinition(MultipartFile file) throws FileNotFoundException {
        //获取classes目录位置
        String path = new File(ResourceUtils.getURL("classpath:").getPath()).getAbsolutePath();
        //设置上传文件夹
        File templateFile = new File(path + "/processes/");
        if(!templateFile.exists()){
            templateFile.mkdirs();
        }
        //创建空文件，实现文件写入
        String filename = file.getOriginalFilename();
        File zipFile = new File(path + "/processes/" + filename);
        try {
            //保存文件
            file.transferTo(zipFile);
        } catch (IOException e) {
            return Result.fail();
        }

        //根据上传地址后续部署流程定义，文件名称为流程定义的默认key
        HashMap<String, Object> map = new HashMap<>();
        map.put("processDefinitionPath","processes/"+filename);
        map.put("processDefinitionKey",filename.substring(0,filename.lastIndexOf(".")));
        return Result.ok(map);
    }

    //部署流程定义
    @ApiOperation("发布")
    @GetMapping("/publish/{id}")
    public Result publish(@PathVariable Long id){
        //修改模版发布状态 1表示已经发布
        processTemplateService.publish(id);
        return Result.ok();
    }

    public static void main(String[] args) {
        try {
            String absolutePath = new File(ResourceUtils.getURL("classpath:").getPath()).getAbsolutePath();
            System.out.println(absolutePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

