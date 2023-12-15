package com.cf.boke.service.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/12/15 14:19
 * @version 1.0
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cf.boke.entity.Collect;
import com.cf.boke.mapper.CollectMapper;
import com.cf.boke.service.CollectService;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
}
