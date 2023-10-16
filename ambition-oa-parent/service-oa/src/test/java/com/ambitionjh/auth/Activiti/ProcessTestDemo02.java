package com.ambitionjh.auth.Activiti;
/*
 * @author  AmbitionJingH
 * @date  2023/10/16 21:11
 * @version 1.0
 */

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ProcessTestDemo02 {
    //注入HistoryService
    @Autowired
    private HistoryService historyService;
    @Autowired

    private TaskService taskService;
    //注入RuntimeService
    @Autowired
    private RuntimeService runtimeService;

    //注入RepositoryService
    @Autowired
    private RepositoryService repositoryService;

    ///////////////////////////////////////
    //uel-value实现
    //部署流程定义
    @Test
    public void deployProcess(){
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("process/jiaban.bpmn20.xml")
                .addClasspathResource("process/jiaban.png")
                .name("加班申请流程")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }

    //启动流程实例
    @Test
    public void startProcess(){
        Map<String, Object> map = new HashMap<>();
        //设置任务人
        map.put("assignee1","lucy");
        map.put("assignee2","mary");
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("jiaban", map);
        System.out.println(instance.getProcessDefinitionId());
        System.out.println(instance.getId());
    }


    //查询某个人待办的任务
    @Test
    public void findTaskLish(){
        String assignee = "lucy";
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee(assignee)
                .list();

        for(Task task:list){
            System.out.println("----------------------------");
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }
    ///////////////////////////////////////
    //uel-method实现
    @Test
    public void deployProcess01(){
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("process/jiaban1.bpmn20.xml")
                .name("加班申请流程01")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());

    }

    @Test
    public void startProcess01(){
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("jiaban01");
        System.out.println(instance.getProcessDefinitionId());
        System.out.println(instance.getId());
    }

    @Test
    public void findTaskLish01(){
        String assignee = "yzf";
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee(assignee)
                .list();

        for(Task task:list){
            System.out.println("----------------------------");
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }
    /////////////////////////////////////////////
    //监听器分配任务
    @Test
    public void deployProcess02(){
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("process/jiaban2.bpmn20.xml")
                .name("加班申请流程02")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());

    }

    @Test
    public void startProcess02(){
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("jiaban02");
        System.out.println(instance.getProcessDefinitionId());
        System.out.println(instance.getId());
    }

    @Test
    public void findTaskLish02(){
        String assignee = "jack ";
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee(assignee)
                .list();

        for(Task task:list){
            System.out.println("----------------------------");
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }
}
