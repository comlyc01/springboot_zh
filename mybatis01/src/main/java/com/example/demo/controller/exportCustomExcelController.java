package com.example.demo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class exportCustomExcelController {

    @RequestMapping("exportExcel123")
    public void exportExcel() {
        try {
            ClassPathResource resource = new ClassPathResource("templates/u1.xls");
            String path = resource.getFile().getPath();
            TemplateExportParams params = new TemplateExportParams(path);
            List<Map<String, Object>> list2 = new ArrayList<>();
            Map<String, Object> m1 = new HashMap<>();
            m1.put("PRONAME", "项目1");
            m1.put("PLANTYPE", "计划1");
            m1.put("PROTYPE", "类别1");
            Map<String, Object> m2 = new HashMap<>();
            m2.put("PRONAME", "项目2");
            m2.put("PLANTYPE", "计划2");
            m2.put("PROTYPE", "类别2");
            list2.add(m1);
            list2.add(m2);


            List<Map<String, Object>> list3 = new ArrayList<>();
            Map<String, Object> m01 = new HashMap<>();
            m01.put("PRONAME", "项asdas目1");
            m01.put("PLANTYPE", "计asd划1");
            m01.put("PROTYPE", "类asda别1");
            Map<String, Object> m02 = new HashMap<>();
            m02.put("PRONAME", "项asd目2");
            m02.put("PLANTYPE", "asd计划2");
            m02.put("PROTYPE", "类asd别2");
            list3.add(m01);
            list3.add(m02);


            Map<String, Object> map = new HashMap<>();
            map.put("poundLogList", list2);
            map.put("poundLogList2", list3);
            Integer[] integers = {0, 1};
            params.setSheetNum(integers);
            //3.执行excel导出
            Workbook workbook = ExcelExportUtil.exportExcel(params, map);
            //4.创建文件存储路径
            String saveFile = "D:/68686868.xlsx";
            FileOutputStream fos;

            //4.写入文件
            fos = new FileOutputStream(saveFile);
            workbook.write(fos);
            fos.close();
            System.out.println("数据导出成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
