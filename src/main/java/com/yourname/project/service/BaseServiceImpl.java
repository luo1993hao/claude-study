package com.yourname.project.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * MyBatis Plus 基础 Service 实现类
 *
 * @param <M> Mapper 类型
 * @param <T> 实体类型
 */
public class BaseServiceImpl<M extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

}
