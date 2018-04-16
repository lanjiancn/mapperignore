package cn.yoogate.mapper;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.UUID;

/**
 * Created by wencongjian on 2018/4/16.
 */
@Slf4j
public class MapperIgnorePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        log.info("===============>>"+UUID.randomUUID().toString());
        return false;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        log.info(">>>>>>>>field="+ field.getName());
        return true;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        log.info(">>>>>>field" + method.getClass().getName());
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        log.info(">>>>>>>BLOBS" + topLevelClass.toString());
        return super.modelRecordWithBLOBsClassGenerated(topLevelClass, introspectedTable);
    }
}
