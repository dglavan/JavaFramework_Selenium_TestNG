package SeleniumFramework.utils;

import SeleniumFramework.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String takeScreenshot(String name) {
        if (BaseClass.driver == null) return null;
        File src = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + name + ".png";
        try {
            FileUtils.copyFile(src, new File(path));
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
