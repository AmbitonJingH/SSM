package com.ambitionjh.process.service;
/*
 * @author  AmbitionJingH
 * @date  2023/11/15 17:48
 * @version 1.0
 */

public interface MessageService {

    /**
     * 推送待审批人员
     * @param processId
     * @param userId
     * @param taskId
     */
    void pushPendingMessage(Long processId, Long userId, String taskId);
}
