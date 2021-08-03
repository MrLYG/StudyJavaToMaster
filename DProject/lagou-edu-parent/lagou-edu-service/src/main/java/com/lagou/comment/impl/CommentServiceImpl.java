package com.lagou.comment.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.comment.CommentService;
import com.lagou.entity.CourseComment;
import mapper.CourseCommentDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @BelongsProject: lagou-edu
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-10 13:44
 * @Description:
 */
@Service // 暴露服务
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CourseCommentDao courseCommentDao;
    public Integer saveComment(CourseComment comment) {
        return courseCommentDao.saveComment(comment);
    }

    public List<CourseComment> getCommentsByCourseId(Integer courseid, Integer offset, Integer pageSize) {
        return courseCommentDao.getCommentsByCourseId(courseid, offset, pageSize);
    }

    /**
     *点赞：
     * 先查看当前用户对这条留言是否点过赞，
     * 如果点过：修改is_del状态即可，取消赞
     * 如果没点过：保存一条点赞的信息
     *
     * 最终，更新赞的数量
      */
    public Integer saveFavorite(Integer comment_id, Integer userid) {
        Integer i = courseCommentDao.existsFavorite(comment_id, userid);
        int i1 = 0;
        int i2 = 0;
        if(i == 0){ //没点过赞
            i1 = courseCommentDao.saveCommentFavorite(comment_id,userid);
        }else{
            i1 = courseCommentDao.updateFavoriteStatus(0,comment_id,userid);
        }
        i2 = courseCommentDao.updateLikeCount(1,comment_id);

        if(i1==0 || i2==0){
            throw  new RuntimeException("点赞失败！");
        }
        return comment_id;
    }

    /**
     * 删除点赞的信息（is_del = 1）
     * 更新留言赞的数量-1
     * @param comment_id 留言编号
     * @param userid 用户编号
     * @return 0:失败，1：成功
     */
    public Integer cancelFavorite(Integer comment_id, Integer userid) {
        Integer i1 = courseCommentDao.updateFavoriteStatus(1, comment_id, userid);
        Integer i2 = courseCommentDao.updateLikeCount(-1,comment_id);

        if(i1==0 || i2==0){
            throw  new RuntimeException("取消赞失败！");
        }
        return i2;
    }
}
