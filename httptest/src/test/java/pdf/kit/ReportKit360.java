package pdf.kit;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import pdf.kit.component.PDFHeaderFooter;
import pdf.kit.component.PDFKit;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by fgm on 2017/4/17.
 * 360报告
 *
 */
@Slf4j
public class ReportKit360 {



    public  String createPDF(Object data, String fileName){
        //pdf保存路径
        try {
            //设置自定义PDF页眉页脚工具类
            PDFHeaderFooter headerFooter=new PDFHeaderFooter();
            PDFKit kit=new PDFKit();
            kit.setHeaderFooterBuilder(headerFooter);
            //设置输出路径
            kit.setSaveFilePath("C:\\Users\\hiekn-hai\\Desktop\\pdf\\"+System.currentTimeMillis()+".pdf");
            String saveFilePath=kit.exportToFile(fileName,data);
            return  saveFilePath;
        } catch (Exception e) {
            System.out.println(("PDF生成失败{}" +  ExceptionUtils.getFullStackTrace(e)));
            return null;
        }

    }

    public static void main(String[] args) {

        ReportKit360 kit=new ReportKit360();
        TemplateBO templateBO=new TemplateBO();
        templateBO.setTitle("两种谐波电流检测方法的比较研究");
        templateBO.setAuthor("戴朝波");
        templateBO.setCheckDate("2018-03-12 12:00:00");
        templateBO.setCheckNo("97aa821e-77f7-45bd-aed5-2658abcb6562");
        templateBO.setMarkTxt("引言 电力供应是经济和社会发展的命脉，是推动国民经济发展和确保人民安居乐业的基础。电\n" +
                "压偏差过大不仅影响电网的稳定 和经济运行以及电力设备使用寿命，而且会影响客户正常的生产、\n" +
                "生活。对于供电企业而言，不断提高供电电压质量和电压合 格率，为客户的生产、生活提供合格的电力供应，是履行其社会责任的直接体现。在全面建设小康社会、社会主义新农村建设 的背景下，提高居民用电质量，对于建设和谐社会具有重要的支撑作用和现实意义。因此，确保安全、可靠、优质的电力供应 是供电企业义不容辞的职责，也是打造“服务好、管理好、形象好”企业的必由之路。 目前在欧、美、日等发达国家，配电网网架结构较为完善。在欧洲，80%的国家，如意大利、奥地利、保加利亚、波兰等 ，中压配电网均采用20～25kV电压等级。相比于10kV电压等级，在输送功率相同的情况下，单位距离上的电压损耗可减少 50%~60%，因此供电距离得到有效延长。\n" +
                "配电方面采用“小容量、多布点”方式，单相和三相混合供电相结合，缩短低电压等 级供电距离\n" +
                "，确保终端用户的电压质量。国内关于配电网电压质量的研究主要集中在装置的研发方面，特别是\n" +
                "中压配电网，如 10kV线路调压器技术、中压线路无功补偿技术、配网电压三级联调技术、分布式\n" +
                "电源接入对电压偏差影响与控制技术等。这项研究成果不仅分析了低电压台区的成因 ，同时为治理低电压台区提供支撑，从而提高供电安全。本文通过对台区的数据收集，并结合台区情况对数据进行分析，采用相域模型和前推回代法的潮流计算对配电网络进行分 析计算，根据24小时的运行数据，对台区情况进行分析，预防并减少低电压台区的问题，为治理低电压台区提供参考和支撑 。");
        List<String> likeSource=new ArrayList<String>();
        likeSource.add("1.相似度：0.61%(4569字)    文献名称：《供电企业辅助决策支持系统架构应用研究》\n" +
                "作者：崔奇明    发布机构：《东北电力技术》    时间：2013");
        likeSource.add("2.相似度：0.61%(4459字)    文献名称：《中压配电网供电可靠性与电压合格率的分析》\n" +
                "作者：张娟    发布机构：《中国科技投资》    时间：2013");
        likeSource.add("2.相似度：0.61%(4459字)    文献名称：《中压配电网供电可靠性与电压合格率的分析》\n" +
                "作者：张娟    发布机构：《中国科技投资》    时间：2013");
        templateBO.setLikeSourceList(likeSource);
        templateBO.setTotalCopyNum(1000);
        templateBO.setTotalWordNum(20000);
        templateBO.setTotalWordCopyPercent("11.02%");
        
        String path= kit.createPDF(templateBO,"hello.pdf");
        System.out.println(path);

    }






}
