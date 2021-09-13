package lyt.util;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * 通用唯一识别码，是一种软件建构的标准。
 * 标准的UUID格式为：xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx (8-4-4-4-12)。
 */
@SuppressWarnings("all")//抑制警告
public class IDutils{
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
    }
}
