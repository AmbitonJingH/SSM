package com.ambitionjh.process.controller.api;
/*
 * @author  AmbitionJingH
 * @date  2023/10/24 18:55
 * @version 1.0
 */

import com.ambitionjh.common.result.Result;
import com.ambitionjh.model.process.ProcessTemplate;
import com.ambitionjh.model.process.ProcessType;
import com.ambitionjh.process.service.OaProcessService;
import com.ambitionjh.process.service.OaProcessTemplateService;
import com.ambitionjh.process.service.OaProcessTypeService;
import com.ambitionjh.vo.process.ProcessFormVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "审批流管理")
@RestController
@RequestMapping("/admin/process")
@CrossOrigin //跨域
public class ProcessController {
    @Autowired
    private OaProcessTypeService processTypeService;
    @Autowired
    private OaProcessTemplateService processTemplateService;
    @Autowired
    private OaProcessService processService;

    //查询所有审批分类和每个审批分类的审批模板
    @GetMapping("findProcessType")
    public Result finProcessType(){
        List<ProcessType> list = processTypeService.findProcessType();
        return Result.ok(list);
    }

    @GetMapping("getProcessTemplate/{processTemplateId}")
    public Result getProcessTemplate(@PathVariable Long processTemplateId){
        ProcessTemplate processTemplate = processTemplateService.getById(processTemplateId);
        return Result.ok(processTemplate);
    }

    @ApiOperation("启动流程")
    @PostMapping("/startUp")
    public Result startUp(@RequestBody ProcessFormVo processFormVo){
        processService.startUp(processFormVo);
        return Result.ok();
    }
}
