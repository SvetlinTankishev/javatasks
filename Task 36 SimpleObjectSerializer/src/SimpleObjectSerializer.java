import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SimpleObjectSerializer {

    public void storeToXML(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        List<String> fieldNames = new ArrayList<>();
        List<Object> fieldValues = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            fieldNames.add(field.getName());
            fieldValues.add(field.get(object));
        }

        FileWriter writer = new FileWriter(clazz.getSimpleName() + ".xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        writer.write("<" + clazz.getSimpleName() + ">\n");

        for (int i = 0; i < fieldNames.size(); i++) {
            writer.write("\t<" + fieldNames.get(i) + ">" + fieldValues.get(i) + "</" + fieldNames.get(i) + ">\n");
        }

        writer.write("</" + clazz.getSimpleName() + ">\n");
        writer.close();
    }

}