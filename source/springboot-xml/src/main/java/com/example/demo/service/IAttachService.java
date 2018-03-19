package com.example.demo.service;

import com.example.demo.model.AttachVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.PanYang on 2018/3/15.
 */
@Component
public interface IAttachService {
    /**
     * 分页查询附件
     * @param page
     * @param limit
     * @return
     */
    PageInfo<AttachVo> getAttachs(Integer page, Integer limit);

    /**
     * 保存附件
     *
     * @param fname
     * @param fkey
     * @param ftype
     * @param author
     */
    void save(String fname, String fkey, String ftype, Integer author);

    /**
     * 根据附件id查询附件
     * @param id
     * @return
     */
    AttachVo selectById(Integer id);

    /**
     * 删除附件
     * @param id
     */
    void deleteById(Integer id);
}
