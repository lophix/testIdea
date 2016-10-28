package main.output;

import main.pojo.IOutputDataPackage;
import main.pojo.enums.CMDType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by pingxin on 2015/12/23.
 */
@SuppressWarnings("unchecked")
public class OutputDataPackageFactory {
    private static Logger LOG = LogManager.getLogger(OutputDataPackageFactory.class);

    /**
     * 获取输出流的修改器
     */
    public static IOutputDataPackage createOutputDateRectifier(Class <? extends IOutputDataPackage> clazz){
        IOutputDataPackage outputRectifier =null;
        try {
            outputRectifier =(IOutputDataPackage) Class.forName(clazz.getName()).newInstance();
            LOG.info("instance the {} success ",clazz.getName());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            LOG.error("instance the {} faied, detail: {}  ",clazz.getName(),e);
            throw new RuntimeException("handle the OutputDatePackage failed ");
        }
        return outputRectifier;
    }

    /**
     * 通过CMDType获取修改器
     */
    public static IOutputDataPackage getOutputDataRectifierByCMDType(CMDType cmdType){
        Class clazz = cmdType.getClazz();
        return createOutputDateRectifier(clazz);
    }
}
