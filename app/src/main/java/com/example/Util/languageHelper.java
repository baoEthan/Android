package com.example.Util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;

public class languageHelper {
    private Context applicationContext;

    public static Context updateLanguage(Context context, String languageCode) {
        Locale locale = new Locale(languageCode); //创建新的语言环境
        locale.setDefault(locale);
        Resources resources = context.getResources(); //获取资源对象
        Configuration config = resources.getConfiguration();  //获取配置对象
        config.setLocale(locale); //设置语言环境
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale);
        }
        return  context.createConfigurationContext(config);
    }
}
