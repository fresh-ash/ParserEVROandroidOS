package interfaces;

import android.util.JsonReader;

import com.example.sergei.a02myjsonparser.data.EntityEVRO2016;

import java.io.IOException;
import java.util.List;

/**
 * Created by sergei on 19.01.2017.
 */

public interface IParserJSON {
    List<EntityEVRO2016> parseEntitys(JsonReader jr) throws IOException;
    EntityEVRO2016 parseEntity(JsonReader jr) throws IOException;

}
