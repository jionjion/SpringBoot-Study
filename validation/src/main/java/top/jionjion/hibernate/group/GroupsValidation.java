package top.jionjion.hibernate.group;

import javax.validation.constraints.NotNull;

/**
 * 分组校验
 *
 * @author Jion
 */
public class GroupsValidation {

    /**
     * 只有在Update分组下，限制才会起作用.
     * 如果想在不指定分组下仍会被校验,需要再次标注
     */
    @NotNull(message = "ID不能为空")
    @NotNull(groups = {GroupsEnum.UPDATE.class}, message = "更新时ID不能为空")
    public Long id;

}
