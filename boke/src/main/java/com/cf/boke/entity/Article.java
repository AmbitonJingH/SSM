package com.cf.boke.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Article implements Serializable {
    private Integer id = 0;

    private Integer userId;

    private Integer sortId;

    @TableField(exist = false)
    private String sorted;

    private Integer labelId;

    private String articleCover;

    private String articleTitle;

    private String articleContent;

    private String tips;

    private Integer commentStatus;

    private Integer recommendCount;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;

    private String updateBy;

    private Integer deleted;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSortId() == null ? other.getSortId() == null : this.getSortId().equals(other.getSortId()))
            && (this.getLabelId() == null ? other.getLabelId() == null : this.getLabelId().equals(other.getLabelId()))
            && (this.getArticleCover() == null ? other.getArticleCover() == null : this.getArticleCover().equals(other.getArticleCover()))
            && (this.getArticleTitle() == null ? other.getArticleTitle() == null : this.getArticleTitle().equals(other.getArticleTitle()))
            && (this.getArticleContent() == null ? other.getArticleContent() == null : this.getArticleContent().equals(other.getArticleContent()))
            && (this.getTips() == null ? other.getTips() == null : this.getTips().equals(other.getTips()))
            && (this.getCommentStatus() == null ? other.getCommentStatus() == null : this.getCommentStatus().equals(other.getCommentStatus()))
            && (this.getRecommendCount() == null ? other.getRecommendCount() == null : this.getRecommendCount().equals(other.getRecommendCount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSortId() == null) ? 0 : getSortId().hashCode());
        result = prime * result + ((getLabelId() == null) ? 0 : getLabelId().hashCode());
        result = prime * result + ((getArticleCover() == null) ? 0 : getArticleCover().hashCode());
        result = prime * result + ((getArticleTitle() == null) ? 0 : getArticleTitle().hashCode());
        result = prime * result + ((getArticleContent() == null) ? 0 : getArticleContent().hashCode());
        result = prime * result + ((getTips() == null) ? 0 : getTips().hashCode());
        result = prime * result + ((getCommentStatus() == null) ? 0 : getCommentStatus().hashCode());
        result = prime * result + ((getRecommendCount() == null) ? 0 : getRecommendCount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", sortId=").append(sortId);
        sb.append(", labelId=").append(labelId);
        sb.append(", articleCover=").append(articleCover);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", articleContent=").append(articleContent);
        sb.append(", tips=").append(tips);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append(", recommendStatus=").append(recommendCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}