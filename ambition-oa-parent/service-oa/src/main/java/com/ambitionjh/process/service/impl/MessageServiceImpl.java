package com.ambitionjh.process.service.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/11/15 17:49
 * @version 1.0
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ambitionjh.auth.service.SysUserService;
import com.ambitionjh.model.process.Process;
import com.ambitionjh.model.process.ProcessTemplate;
import com.ambitionjh.model.system.SysUser;
import com.ambitionjh.process.service.MessageService;
import com.ambitionjh.process.service.OaProcessService;
import com.ambitionjh.process.service.OaProcessTemplateService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private OaProcessService processService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private OaProcessTemplateService processTemplateService;
    @Autowired
    private WxMpService wxMpService;
    @Override
    public void pushPendingMessage(Long processId, Long userId, String taskId) {
        //根据这些id查询数据
        Process process = processService.getById(processId);
        SysUser sysUser = sysUserService.getById(userId);
        ProcessTemplate processTemplate = processTemplateService.getById(process.getProcessTemplateId());
        //获取提交审批人的信息
        SysUser submitSysUser = sysUserService.getById(process.getUserId());
        String openId = sysUser.getOpenId();
        System.out.println("openId = " + openId);
        if (StringUtils.isEmpty(openId)){
            openId = "oYSA56txSX5trLcnarw5tDEkF9L0";
        }
        //设置消息发送的信息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)//给谁发送消息(openid值)
                .templateId("pK1OlrAJqzUIkm6J6p0NUaZHkKrreCW4yLkyILhV17k")
                .url("http://ambitionoa2.v5.idcfengye.com#/show/" + processId + "/" + taskId)
                .build();

        JSONObject jsonObject = JSON.parseObject(process.getFormValues());
        JSONObject formShowData = jsonObject.getJSONObject("formShowData");
        StringBuffer content = new StringBuffer();
        for (Map.Entry entry : formShowData.entrySet()) {
            content.append(entry.getKey()).append("：").append(entry.getValue()).append("\n ");
        }
        //设置模版里面参数的值
        templateMessage.addData(new WxMpTemplateData("first",submitSysUser.getName()+"提交"+processTemplate.getName()+",请注意查看","#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword1", process.getProcessCode(), "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword2", new DateTime(process.getCreateTime()).toString("yyyy-MM-dd HH:mm:ss"), "#272727"));
        templateMessage.addData(new WxMpTemplateData("content", content.toString(), "#272727"));
        //消息发送
        try {
            String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            System.out.println(msg);
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }
}
