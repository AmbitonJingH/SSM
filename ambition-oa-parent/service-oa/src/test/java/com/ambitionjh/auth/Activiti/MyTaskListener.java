package com.ambitionjh.auth.Activiti;
/*
 * @author  AmbitionJingH
 * @date  2023/10/16 22:19
 * @version 1.0
 */

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTaskListener implements TaskListener {
    @Override
    public void notify(DelegateTask task) {
        if(task.getName().equals("经理审批")){
            //分配任务
            task.setAssignee("jack");
        } else if (task.getName().equals("人事审批")) {
            //分配任务
            task.setAssignee("tom");
        }
    }
}