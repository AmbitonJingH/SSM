package com.ambitionjh.auth.Activiti;
/*
 * @author  AmbitionJingH
 * @date  2023/10/15 23:30
 * @version 1.0
 */

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

@SpringBootTest
public class ProcessTest {
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

    //常见流程实例，指定BusinessKey
    @Test
    public void startUpProcessAddBusinessKey(){
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("qingjia", "1001");
        System.out.println(instance.getBusinessKey());
        System.out.println(instance.getId());
    }
    @Test
    public void deployProcessByZip() {
        // 定义zip输入流
        InputStream inputStream = this
                .getClass()
                .getClassLoader()
                .getResourceAsStream(
                        "process/qingjia.zip");
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);

        // 流程部署
        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假申请流程")
                .deploy();
        System.out.println("流程部署id：" + deployment.getId());
        System.out.println("流程部署名称：" + deployment.getName());
    }

    //启动流程实例
    @Test
    public void startProcess(){
        ProcessInstance qingjia = runtimeService.startProcessInstanceByKey("qingjia");
        System.out.println("流程定义id："+qingjia.getProcessDefinitionId());
        System.out.println("流程实例id："+qingjia.getId());
        System.out.println("流程活动id："+qingjia.getActivityId());
    }

    //单个文件部署
    @Test
    public void deployProcess(){
        //流程部署
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("process/qingjia.bpmn20.xml")
                .addClasspathResource("process/qingjia.png")
                .name("请假申请流程")
                .deploy();

        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }

    //查询某个人待办的任务
    @Test
    public void findTaskLish(){
        String assignee = "zhangsan";
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

    //完成任务
    @Test
    public void completeTask(){
        Task task = taskService.createTaskQuery()
                .taskAssignee("zhangsan")
                .singleResult();
        //完成任务
        taskService.complete(task.getId());
    }
    
    @Test
    public void findCompletedTaskList(){
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
                .taskAssignee("lisi")
                .finished()
                .list();

        for(HistoricTaskInstance t:list){
            System.out.println("流程实例id：" + t.getProcessInstanceId());
            System.out.println("任务id：" + t.getId());
            System.out.println("任务负责人：" + t.getAssignee());
            System.out.println("任务名称：" + t.getName());
        }
    }

    //全部流程实例挂起
    @Test
    public void suspendProcessInstanceAll(){
        //获取流程定义的对象
        ProcessDefinition qingjia = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("qingjia")
                .singleResult();
        //调用流程定义对象的方法判断当前状态P:挂起 激活
        boolean suspended = qingjia.isSuspended();
        //判断如果挂起状态就激活
        if(suspended){
            //参数1：流程定义id 参数2：是否激活 true 参数3： 时间点
            repositoryService.activateProcessDefinitionById(qingjia.getId(),true,null);
            System.out.println(qingjia.getId()+"已激活");
        }else {
            //否则挂起
            repositoryService.suspendProcessDefinitionById(qingjia.getId(),true,null);
            System.out.println(qingjia.getId()+"已挂起");
        }
    }

    //单个流程实例
    @Test
    public void SingleSuspendProcessInstance(){
        String instanceId ="b189cd36-6c22-11ee-ac16-005056c00008";
        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(instanceId)
                .singleResult();
        boolean suspended = instance.isSuspended();
        if(suspended){
            runtimeService.activateProcessInstanceById(instanceId);
            System.out.println(instanceId+"已激活");
        }else {
            runtimeService.suspendProcessInstanceById(instanceId);
            System.out.println(instanceId+"已挂起");
        }
    }
}
