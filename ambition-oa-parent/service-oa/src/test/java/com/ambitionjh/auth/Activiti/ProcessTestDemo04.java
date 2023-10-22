package com.ambitionjh.auth.Activiti;
/*
 * @author  AmbitionJingH
 * @date  2023/10/16 21:32
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
public class ProcessTestDemo04 {
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
    //1 部署流程定义和启动流程实例
    @Test
    public void deployProcess(){
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("process/jiaban04.bpmn20.xml")
                .name("加班申请流程")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }

    //2 查询组任务
    @Test
    public void findGroupTaskList(){
        List<Task> list = taskService.createTaskQuery()
                .taskCandidateUser("tom01")
                .list();
        for(Task task:list){
            System.out.println("----------------------------");
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }

    }
    //3 拾取组任务
    @Test
    public void claimTask(){
        Task task = taskService.createTaskQuery()
                .taskCandidateUser("tom01")
                .singleResult();
        if(task != null){
            taskService.claim(task.getId(),"tom01");
            System.out.println("任务已拾取");
        }
    }

    //4 查询某个人待办的任务
    @Test
    public void findTaskList(){
        String assignee = "tom01";
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

    //5 办理个人任务
    @Test
    public void completTask() {
        Task task = taskService.createTaskQuery()
                .taskAssignee("tom01")  //要查询的负责人
                .singleResult();//返回一条

       // Map<String, Object> variables = new HashMap<>();
        //variables.put("assignee2", "zhao");
        //完成任务,参数：任务id
        taskService.complete(task.getId());
    }

    //启动流程实例
    @Test
    public void startProcess(){
//        Map<String, Object> map = new HashMap<>();
//        //设置任务人
//        map.put("assignee1","lucy03");
//        //map.put("assignee2","mary03");
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("jiaban04");
        System.out.println(instance.getProcessDefinitionId());
        System.out.println(instance.getId());
    }





}
