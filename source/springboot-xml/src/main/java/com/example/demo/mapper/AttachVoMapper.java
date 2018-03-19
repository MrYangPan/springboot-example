package com.example.demo.mapper;

import com.example.demo.model.AttachVo;
import com.example.demo.model.AttachVoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/3/15.
 */
@Component
public interface AttachVoMapper {
    long countByExample(AttachVoExample example);

    int deleteByExample(AttachVoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttachVo record);

    int insertSelective(AttachVo record);

    List<AttachVo> selectByExample(AttachVoExample example);

    AttachVo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttachVo record, @Param("example") AttachVoExample example);

    int updateByExample(@Param("record") AttachVo record, @Param("example") AttachVoExample example);

    int updateByPrimaryKeySelective(AttachVo record);

    int updateByPrimaryKey(AttachVo record);
}
