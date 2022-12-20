package Interface;

import model.Terremoto;
import java.util.ArrayList;

/**
 *
 */
public interface TerremotoInterfaz {
    public void create(Terremoto producto);
    public ArrayList<Terremoto> read();
    public void update(ArrayList<Terremoto> terremotos);
    public void delete();
}
