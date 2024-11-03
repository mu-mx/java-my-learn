package com.xwcom.schedule.dao.impl;

import com.xwcom.schedule.dao.SysScheduleDao;
import com.xwcom.schedule.pojo.SysSchedule;
import com.xwcom.schedule.util.BaseDao;
import java.sql.ResultSet;
import java.util.List;

/**
 * @ author Administrator
 * @ date 2024/11/3
 * <p>
 * dao层,用于操作数据库,一般定义接口和实现类
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    BaseDao baseDao = new BaseDao();

    @Override
    public int addSchedule(SysSchedule sysSchedule) {
        System.out.println("addSchedule");

        int row = baseDao.update("insert into  sys_schedule (uid,title,completed) values (?,?,?);", sysSchedule);

        return row;
    }

    @Override
    public List<SysSchedule> getAll() {
        System.out.println("getAll");
        ResultSet query = baseDao.query("select sid,uid,title,completed from sys_schedule");

        return null;
    }


}
