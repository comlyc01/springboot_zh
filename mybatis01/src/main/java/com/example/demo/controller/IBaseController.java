package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dao.IBaseMapper;
import com.example.demo.entity.Muser;
import com.example.demo.server.IBaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.*;

@RequestMapping("/IBASE")
@RestController
public class IBaseController {

    @Resource
    private IBaseService iBaseService;


    /**
     * 插入一条记录（选择字段，策略插入）
     * @param
     * @return
     */
    @RequestMapping("/save")
    public Map save (){
        HashMap<String, Object> map = new HashMap<>();
        Muser muser = new Muser();
        muser.setName("李四");
        muser.setAge(23);
        muser.setEmail("lisi@email.com");
        boolean save = iBaseService.save(muser);
        if (save){
            System.out.println("插入成功");
            map.put("msg","插入成功");
            return map;
        }{
            System.out.println("插入失败");
            map.put("msg","插入失败");
            return map;
        }
    }

    /**
     * 插入（批量）
     * @param
     * @return
     */
    @RequestMapping("/saveBatch")
    public Map saveBatch(){
        HashMap<String, Object> map = new HashMap<>();
        Muser muser1 = new Muser();
        Muser muser2 = new Muser();
        Muser muser3 = new Muser();
        muser1.setName("张三02");
        muser1.setAge(16);
        muser1.setEmail("zhangsan02@email.com");
        muser2.setName("张三03");
        muser2.setAge(45);
        muser2.setEmail("zhangsan03@email.com");
        muser3.setName("张三04");
        muser3.setAge(23);
        muser3.setEmail("zhangsan04@email.com");

        List<Muser> muserList = Arrays.asList(muser1, muser2, muser3);
        boolean b = iBaseService.saveBatch(muserList);
        if (b){
            map.put("msg","批量插入成功");
            return map;
        }else {
            map.put("msg","批量插入失败");
            return map;
        }
    }

    /**
     * 插入（批量）
     * @param
     * @return
     */
    @RequestMapping("/saveBatchCode")
    public Map saveBatchCode(){
        HashMap<String, Object> map = new HashMap<>();
        Muser muser1 = new Muser();
        Muser muser2 = new Muser();
        Muser muser3 = new Muser();
        muser1.setName("张三002");
        muser1.setAge(16);
        muser1.setEmail("zhangsan002@email.com");
        muser2.setName("张三003");
        muser2.setAge(34);
        muser2.setEmail("zhangsan003@email.com");
        muser3.setName("张三004");
        muser3.setAge(65);
        muser3.setEmail("zhangsan004@email.com");

        List<Muser> muserList = Arrays.asList(muser1, muser2, muser3);
        boolean b = iBaseService.saveBatch(muserList, 1);
        if (b){
            map.put("msg","批量插入成功");
            return map;
        }else {
            map.put("msg","批量插入失败");
            return map;
        }
    }

    /**
     * TableId 注解存在更新记录，否插入一条记录
     * @return
     */
    @RequestMapping("/saveOrUpdate")
    public Map saveOrUpdate(){
        HashMap<String, Object> map = new HashMap<>();
        Muser muser = new Muser();
        muser.setAge(16);
        muser.setName("张三三");
        muser.setEmail("zhangsansan@email.com");
        boolean b = iBaseService.saveOrUpdate(muser);
        if (b){
            map.put("msg","插入成功");
            return map;
        }else {
            map.put("msg","插入失败");
            return map;
        }
    }

    /**
     * 根据updateWrapper尝试更新，否继续执行saveOrUpdate(T)方法
     * @return
     */
    @RequestMapping("/saveOrUpdates")
    public Map saveOrUpdates(){
        HashMap<String, Object> map = new HashMap<>();
        Muser muser = new Muser();
        muser.setAge(16);
        muser.setName("张三三01");
        muser.setEmail("zhangsansan@email.com");

        UpdateWrapper<Muser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name","张三三");

        boolean b = iBaseService.saveOrUpdate(muser,updateWrapper);
        if (b){
            map.put("msg","修改成功");
            return map;
        }else {
            map.put("msg","修改失败");
            return map;
        }
    }

    /**
     * 批量修改插入
     * @return
     */
    @RequestMapping("/saveOrUpdateBatch")
    public Map saveOrUpdateBatch(){
        HashMap<String, Object> map = new HashMap<>();
        Muser muser1 = new Muser();
        Muser muser2 = new Muser();
        Muser muser3 = new Muser();
        muser1.setName("王五002");
        muser1.setAge(16);
        muser1.setEmail("wangwu002@email.com");
        muser2.setName("王五003");
        muser2.setAge(34);
        muser2.setEmail("wangwu003@email.com");
        muser3.setName("王五004");
        muser3.setAge(65);
        muser3.setEmail("wangwu004@email.com");

        List<Muser> muserList = Arrays.asList(muser1, muser2, muser3);

        boolean b = iBaseService.saveOrUpdateBatch(muserList);
        if (b){
            map.put("msg","批量修改插入成功");
            return map;
        }else {
            map.put("msg","批量修改插入失败");
            return map;
        }
    }

    /**
     * 根据 entity 条件，删除记录
     * @return
     */
    @RequestMapping("/remove")
    public Map remove(){
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Muser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "王五004");

        boolean b = iBaseService.remove(queryWrapper);
        if (b){
            map.put("msg","删除成功");
            return map;
        }else {
            map.put("msg","删除失败");
            return map;
        }
    }

    /**
     * 根据 ID 删除
     * @return
     */
    @RequestMapping("/removeById")
    public Map removeById(){
        HashMap<String, Object> map = new HashMap<>();
        boolean b = iBaseService.removeById(17);
        if (b){
            map.put("msg","删除成功");
            return map;
        }else {
            map.put("msg","删除失败");
            return map;
        }
    }

    /**
     * 根据 columnMap 条件，删除记录
     * @return
     */
    @RequestMapping("/removeByMap")
    public Map removeByMap(){
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map1 = new HashMap<>();
        map.put("name","王五002");
        boolean b = iBaseService.removeByMap(map);
        if (b){
            map1.put("msg","删除成功");
            return map1;
        }else {
            map1.put("msg","删除失败");
            return map1;
        }
    }

    /**
     * 删除（根据ID 批量删除）
     * @return
     */
    @RequestMapping("/removeByIds")
    public Map removeByIds(){
        HashMap<String, Object> map = new HashMap<>();
        List<Integer> integers = Arrays.asList(12, 13, 14, 15);   // 这里数组为数据库Id
        boolean b = iBaseService.removeByIds(integers);
        if (b){
            map.put("msg","批量删除成功");
            return map;
        }else {
            map.put("msg","批量删除失败");
            return map;
        }
    }

    /**
     * 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
     * @return
     */
    @RequestMapping("/update")
    public Map update(){
        HashMap<String, Object> map = new HashMap<>();
        Muser muser = new Muser();
        muser.setName("马六01");
        muser.setAge(21);
        muser.setEmail("maliu01@email.com");

        UpdateWrapper<Muser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name","李四");

        boolean b = iBaseService.update(muser,updateWrapper);
        if (b){
            map.put("msg","更新成功");
            return map;
        }else {
            map.put("msg","更新失败");
            return map;
        }
    }

    /**
     * 根据 ID 选择修改
     * @return
     */
    @RequestMapping("/updateById")
    public Map updateById(){
        HashMap<String, Object> map = new HashMap<>();
        Muser muser = new Muser();
        muser.setId(11);
        muser.setName("马六02");
        muser.setAge(21);
        muser.setEmail("maliu02@email.com");
        boolean b = iBaseService.updateById(muser);
        if (b){
            map.put("msg","修改成功");
            return map;
        }else {
            map.put("msg","修改失败");
            return map;
        }
    }
    /**
     * 根据ID 批量更新
     * @return
     */
    @RequestMapping("/updateBatchById")
    public Map updateBatchById(){
        HashMap<String, Object> map = new HashMap<>();

        Muser muser1 = new Muser();
        Muser muser2 = new Muser();
        List<Muser> asList = Arrays.asList(muser1,muser2);
        boolean b = iBaseService.updateBatchById(asList);
        if (b){
            map.put("msg","批量更新成功");
            return map;
        }else {
            map.put("msg","批量更新失败");
            return map;
        }
    }

    /**
     * 根据 ID 查询
     * @return
     */
    @RequestMapping("/getById")
    public Map getById(){
        HashMap<String, Object> map = new HashMap<>();
        Muser muser = iBaseService.getById(1);
        System.out.println("muser = " + muser);
        if (muser != null){
            map.put("data",muser);
            return map;
        }else {
            map.put("data","查询失败");
            return map;
        }
    }

    /**
     * 根据 Wrapper，查询一条记录。结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")
     * @return
     */
    @RequestMapping("/getOne")
    public Map getOne(){
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Muser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",2);
        Muser muser = iBaseService.getOne(queryWrapper);
        if (muser != null){
            map.put("data",muser);
            return map;
        }else {
            map.put("data","查询失败");
            return map;
        }
    }

    /**
     * 根据 Wrapper，查询一条记录
     * @return
     */
    @RequestMapping("/getMap")
    public Map getMap(){
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Muser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","张三");
        Map<String, Object> serviceMap = iBaseService.getMap(queryWrapper);
        if (serviceMap != null){
            map.put("data",serviceMap);
            return map;
        }else {
            map.put("data","查询失败");
            return  map;
        }
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/list")
    public Map list(){
        HashMap<String, Object> map = new HashMap<>();
        List<Muser> list = iBaseService.list();
        map.put("list",list);
        return map;
    }

    /**
     * 查询列表
     * @return
     */
    @RequestMapping("/lists")
    public Map lists(){
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Muser> queryWrapper = new QueryWrapper<>();
        List<Muser> list = iBaseService.list(queryWrapper);
        map.put("list",list);
        return map;
    }

    /**
     *  查询（根据ID 批量查询）
     * @return
     */
    @RequestMapping("/listByIds")
    public Map listByIds(){
        HashMap<String, Object> map = new HashMap<>();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Muser> muserList = iBaseService.listByIds(integers);
        map.put("data",muserList);
        return map;
    }

    /**
     *  查询（根据 columnMap 条件）
     * @return
     */
    @RequestMapping("/listByMap")
    public Map listByMap(){
        HashMap<String, Object> map = new HashMap<>();
        List<Map<String, Object>> maps = iBaseService.listMaps();
        map.put("data",maps);
        return map;
    }

    /**
     *   查询所有列表
     * @return
     */
    @RequestMapping("/listMaps")
    public Map listMaps(){
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Muser> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map1 = iBaseService.getMap(queryWrapper);
        map.put("map",map1);
        return map;
    }

    /**
     * 无条件分页查询
     * @return
     */
    @RequestMapping("/pageNull")
    public Map pageNull(){
        HashMap<String, Object> map = new HashMap<>();
        IPage<Muser> page = new Page<>(1,2,5);
        IPage<Muser> page1 = iBaseService.page(page);
        map.put("pageData",page1);
        return map;
    }

    /**
     * 条件分页查询
     * @return
     */
    @RequestMapping("/page")
    public Map page(){
        HashMap<String, Object> map = new HashMap<>();
        IPage<Muser> page = new Page<>(1,2,5);
        QueryWrapper<Muser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",16);
        IPage<Muser> muserIPage = iBaseService.page(page, queryWrapper);
        map.put("data",muserIPage);
        return map;
    }

    /**
     * 无条件分页查询
     * @return
     */
    @RequestMapping("/pageMapsNull")
    public Map pageMapsNull(){
        HashMap<String, Object> map = new HashMap<>();
        IPage<Map<String,Object>> page = new Page<>(1,2,5);
        IPage<Map<String, Object>> mapIPage = iBaseService.pageMaps(page);
        map.put("page",mapIPage);
        return map;
    }

    /**
     * 条件分页查询
     * @return
     */
    @RequestMapping("/pageMaps")
    public Map pageMaps(){
        HashMap<String, Object> map = new HashMap<>();
        Page<Map<String, Object>> mapPage = new Page<>();
        QueryWrapper<Muser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",16);
        Page<Map<String, Object>> pageMaps = iBaseService.pageMaps(mapPage, queryWrapper);
        map.put("page",pageMaps);
        return map;
    }

    /**
     * 查询总记录数
     * @return
     */
    @RequestMapping("/count")
    public Map count(){
        HashMap<String, Object> map = new HashMap<>();
        int count = iBaseService.count();
        map.put("conut",count);
        return map;
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     * @return
     */
    @RequestMapping("/counts")
    public Map counts(){
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Muser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",16);
        int count = iBaseService.count(queryWrapper);
        map.put("conut",count);
        return map;
    }

    @Resource
    private IBaseMapper iBaseMapper;

    /**
     * 链式查询 普通
     * @return
     */
    @RequestMapping("/query")
    public Map query(){
        HashMap<String, Object> map = new HashMap<>();
        QueryChainWrapper<Muser> chainWrapper = new QueryChainWrapper<>(iBaseMapper);
        Muser one = chainWrapper.eq("name", "张三").one();
        List<Muser> list = chainWrapper.eq("age", 16).list();
        list.forEach(System.out::println);
        System.out.println("one = " + one);
        map.put("data",one);
        return map;
    }

    /**
     * 链式查询 lambda 式。注意：不支持 Kotlin
     * @return
     */
    @RequestMapping("/lambdaQuery")
    public Map lambdaQuery(){
        HashMap<String, Object> map = new HashMap<>();
        LambdaQueryChainWrapper<Muser> chainWrapper = new LambdaQueryChainWrapper<>(iBaseMapper);
        List<Muser> list = chainWrapper.eq(Muser::getId, 1).list();
        System.out.println("list = " + list);
        map.put("data",list);
        return map;
    }

    /**
     * 链式更改 普通
     * @return
     */
    @RequestMapping("/chainupdate")
    public Map chainupdate(){
        HashMap<String, Object> map = new HashMap<>();
        UpdateChainWrapper<Muser> chainWrapper = new UpdateChainWrapper<>(iBaseMapper);
        boolean remove = chainWrapper.eq("name", "马六02").remove();
        if (remove){
            map.put("msg","更新成功");
            return map;
        }else {
            map.put("msg","更新失败");
            return map;
        }
    }


    /**
     * 链式更改 lambda 式。注意：不支持 Kotlin
     * @return
     */
    @RequestMapping("/lambdaUpdate")
    public Map lambdaUpdate(){
        HashMap<String, Object> map = new HashMap<>();
        LambdaUpdateChainWrapper<Muser> chainWrapper = new LambdaUpdateChainWrapper<>(iBaseMapper);
        Muser muser = new Muser();
        muser.setName("ann");
        muser.setAge(18);
        muser.setEmail("ann@email.com");
        boolean update = chainWrapper.eq(Muser::getId, 1).update(muser);
        if (update){
            map.put("msg","更新成功");
            return map;
        }else {
            map.put("msg","更新失败");
            return map;
        }

    }

}
