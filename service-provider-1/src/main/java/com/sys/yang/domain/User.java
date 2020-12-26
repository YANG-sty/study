package com.sys.yang.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangLongFei 2020-12-26-17:27
 */
@Data
@TableName("first_user")
public class User implements Serializable {
    private static final long serialVersionUID = 2107651223108826390L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private String userPassword;

    private String userName;

    @TableField(value = "creator", fill = FieldFill.INSERT)
    private String creator;

    @TableField(value="create_time", fill= FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updator", fill = FieldFill.INSERT_UPDATE)
    private String updator;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 资源
     */
    private String resource;


}

