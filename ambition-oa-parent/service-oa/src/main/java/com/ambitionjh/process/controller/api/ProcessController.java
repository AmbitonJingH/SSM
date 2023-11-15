package com.ambitionjh.process.controller.api;
/*
 * @author  AmbitionJingH
 * @date  2023/10/24 18:55
 * @version 1.0
 */

import com.ambitionjh.auth.service.SysUserService;
import com.ambitionjh.common.result.Result;
import com.ambitionjh.model.process.Process;
import com.ambitionjh.model.process.ProcessTemplate;
import com.ambitionjh.model.process.ProcessType;
import com.ambitionjh.process.service.OaProcessService;
import com.ambitionjh.process.service.OaProcessTemplateService;
import com.ambitionjh.process.service.OaProcessTypeService;
import com.ambitionjh.vo.process.ApprovalVo;
import com.ambitionjh.vo.process.ProcessFormVo;
import com.ambitionjh.vo.process.ProcessVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private SysUserService sysUserService;

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

    @ApiOperation("待处理")
    @GetMapping("/findPending/{page}/{limit}")
    public Result findPending(@PathVariable Long page,
                              @PathVariable Long limit){
        Page<Process> pageParam = new Page<>(page,limit);
        IPage<ProcessVo> pageModel = processService.findPending(pageParam);
        return Result.ok(pageModel);
    }

    //查看审批详情信息
    @GetMapping("show/{id}")
    public Result show (@PathVariable Long id){
        Map<String,Object> map = processService.show(id);
        return Result.ok(map);
    }

    //审批
    @ApiOperation("审批")
    @PostMapping("approve")
    public Result approve(@RequestBody ApprovalVo approvalVo){
        processService.approve(approvalVo);
        return Result.ok();
    }

    @ApiOperation("已处理")
    @GetMapping("/findProcessed/{page}/{limit}")
    public Result findProcessed(@PathVariable Long page,
                                @PathVariable Long limit){
        Page<Process> pageParam = new Page<>(page,limit);
        IPage<ProcessVo> processModel = processService.findProcessed(pageParam);
        return Result.ok(processModel);
    }

    @ApiOperation("已发起")
    @GetMapping("/findStarted/{page}/{limit}")
    public Result findStarted(@PathVariable Long page,
                              @PathVariable Long limit){
        Page<ProcessVo> pageParam = new Page<>(page, limit);
        IPage<ProcessVo> pageModel = processService.findStarted(pageParam);
        return Result.ok(pageModel);
    }


}
