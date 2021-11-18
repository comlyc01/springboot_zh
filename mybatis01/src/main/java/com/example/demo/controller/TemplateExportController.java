package com.example.demo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.demo.entity.MsgClient;
import com.example.demo.entity.MsgClientGroup;
import jxl.Workbook;
import net.sf.jxls.transformer.XLSTransformer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

@Controller
public class TemplateExportController {
    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {

        try {
            List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
            Map<String, Object> m1 = new HashMap<String, Object>();
            m1.put("PRONAME", "项目1");
            m1.put("PLANTYPE", "计划1");
            m1.put("PROTYPE", "类别1");
            Map<String, Object> m2 = new HashMap<String, Object>();
            m2.put("PRONAME", "项目2");
            m2.put("PLANTYPE", "计划2");
            m2.put("PROTYPE", "类别2");
            list2.add(m1);
            list2.add(m2);

            List<String> params = new ArrayList<>();
            params.add("test1");
            params.add("test2");
            kbToCreateExcel(request, response, list2, params);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void kbToCreateExcel(HttpServletRequest request, HttpServletResponse response, List list, List<String> params) {
        //String basePath = request.getSession().getServletContext().getRealPath("");
        // 放置xls模板的位置，关联模板
        XLSTransformer transformer = new XLSTransformer();
        //String fileName = request.getServletContext().getRealPath("/templates/u1.xls");

        Map<String, Object> para = new HashMap<String, Object>();
        para.put("result", list);

        ClassPathResource resource;
        resource = new ClassPathResource("templates/u1.xls");
        Workbook wb;
        try {
            File file = resource.getFile();
            String filePath = file.getPath();
            String loadPath = "D:/edc.xlsx";
            transformer.transformXLS(filePath, para, loadPath);  //在classPath2下生成excel文件
            InputStream is = resource.getInputStream();
            //wb = transformer.transformXLS(is,para);   //获得Workbook对象
            //wb.write(new FileOutputStream(loadPath));  //导出Excel
            //workbook = (HSSFWorkbook) transformer.transformMultipleSheetsList(is,list,params,"xls",new HashMap(),0);
            //saveWorkbook(wb,response,"edc.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveWorkbook(Workbook workbook, HttpServletResponse response, String fileName) {
        try {
            response.setHeader("content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/msexcel");
            OutputStream os = response.getOutputStream();
            //workbook.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("exportExcel2")
    public void bigDataExport() {
        List<MsgClient> list = new ArrayList<MsgClient>();
        Workbook workbook = null;
        Date start = new Date();
        try {
            ExportParams params = new ExportParams("大数据测试", "测试");
            for (int i = 0; i < 1000000; i++) {  //一百万数据量
                MsgClient client = new MsgClient();
                client.setBirthday(new Date());
                client.setClientName("小明" + i);
                client.setClientPhone("18797" + i);
                client.setCreateBy("JueYue");
                client.setId("1" + i);
                client.setRemark("测试" + i);
                MsgClientGroup group = new MsgClientGroup();
                group.setGroupName("测试" + i);
                client.setGroup(group);
                list.add(client);
                if (list.size() == 10000) {
                    //ExcelExportUtil.exportBigExcel(params, MsgClient.class, list);
                    list.clear();
                }
            }
            //ExcelExportUtil.closeExportBigExcel();
            System.out.println(new Date().getTime() - start.getTime());
            File savefile = new File("D:/excel/");
            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("D:/excel/ExcelExportBigData.bigDataExport.xlsx");
            //workbook.write(fos);

            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
