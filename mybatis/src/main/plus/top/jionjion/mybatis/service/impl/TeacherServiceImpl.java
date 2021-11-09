package top.jionjion.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.jionjion.mybatis.dto.Teacher;
import top.jionjion.mybatis.mapper.TeacherCurdMapper;
import top.jionjion.mybatis.service.ITeacherService;

/**
 * 封装的Service类的具体实现, 提供更多的方法
 *
 * @author Jion
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherCurdMapper, Teacher> implements ITeacherService {

}
