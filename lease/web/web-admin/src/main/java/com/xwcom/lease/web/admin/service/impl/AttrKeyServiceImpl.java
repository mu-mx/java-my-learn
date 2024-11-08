package com.xwcom.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwcom.lease.model.entity.AttrKey;
import com.xwcom.lease.web.admin.service.AttrKeyService;
import com.xwcom.lease.web.admin.vo.attr.AttrKeyVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xwcom.lease.web.admin.mapper.AttrKeyMapper;

/**
 * @author liubo
 * @description 针对表【attr_key(房间基本属性表)】的数据库操作Service实现
 * @createDate 2023-07-24 15:48:00
 */
@Service
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey> implements AttrKeyService {


    @Autowired
    private AttrKeyMapper attrKeyMapper;

    @Override
    public List<AttrKeyVo> listAttrInfo() {

        return attrKeyMapper.listAttrInfo();
    }

}




