package top.jionjion.json.jackson.format;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化类,不能使用内部类.因此采用共有类
 *
 * @author Jion
 */
public class JsonFormatSerializer extends StdSerializer<Date> {

    /**
     * 必须有无参数的构造方法
     */
    public JsonFormatSerializer() {
        this(null);
    }

    /**
     * 重写构造方法
     */
    public JsonFormatSerializer(Class<Date> t) {
        super(t);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // 日期格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 格式结果
        jsonGenerator.writeString(simpleDateFormat.format(date));
    }
}