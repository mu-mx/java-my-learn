package com.xwcom.schedule.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ author Administrator
 * @ date 2024/11/3
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule implements Serializable {
    private int sid;
    private int uid;
    private String title;
    private int completed;
}
