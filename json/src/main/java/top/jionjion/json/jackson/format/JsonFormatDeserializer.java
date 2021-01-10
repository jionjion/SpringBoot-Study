package top.jionjion.json.jackson.format;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化类,不能使用内部类.因此采用共有类
 *
 * @author Jion
 */
public class JsonFormatDeserializer extends StdDeserializer<Date> {

    /**
     * 必须有无参数的构造方法
     */
    public JsonFormatDeserializer() {
        this(null);
    }

    /**
     * 重写构造方法
     */
    public JsonFormatDeserializer(Class<Date> t) {
        super(t);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        // 日期格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获得JSON属性值
        String date = jsonParser.getText();
        // 格式结果
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}