package com.xwcom.schedule.dao;

import com.xwcom.schedule.pojo.SysSchedule;
import java.util.List;

/**
 * @ author Administrator
 * @ date 2024/11/3
 * <p>
 * dao层,用于操作数据库,一般定义接口和实现类
 */
public interface SysScheduleDao {

    int addSchedule(SysSchedule sysSchedule);

    List<SysSchedule> getAll();
}
