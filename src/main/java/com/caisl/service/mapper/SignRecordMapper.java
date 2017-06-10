package com.caisl.service.mapper;

import com.caisl.domain.SignRecord;

public interface SignRecordMapper {
    int deleteByPrimaryKey(String signRecordId);

    int insert(SignRecord record);

    int insertSelective(SignRecord record);

    SignRecord selectByPrimaryKey(String signRecordId);

    int updateByPrimaryKeySelective(SignRecord record);

    int updateByPrimaryKey(SignRecord record);
}