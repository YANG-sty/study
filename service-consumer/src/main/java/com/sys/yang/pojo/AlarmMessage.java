package com.sys.yang.pojo;

import lombok.*;

/**
 *
 * skywalking 警告信息，数据类
 *
 * @author yangLongFei 2021-02-06-19:12
 */

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AlarmMessage {
    private int scopeId;
    private String name;
    private String id0;
    private String id1;
    private String alarmMessage;
    private long startTime;
}
