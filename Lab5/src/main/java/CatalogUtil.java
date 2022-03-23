import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.extern.java.Log;

import java.io.File;
import java.io.IOException;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Log

/**
 * abstract class to save/load catalog to/from json files
 */
public abstract class CatalogUtil {
    public CatalogUtil(){
        super();
    }

    /**
     * save catalog to json in path
     * @param catalog
     * @param path
     * @throws IOException
     */
    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    /**
     * load catalog from json from path
     * @param path
     * @return
     * @throws InvalidCatalogException
     * @throws IOException
     */
    public static Catalog load(String path) throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);

        return catalog;
    }
}
