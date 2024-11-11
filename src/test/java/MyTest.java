import com.company.Dish;
import com.company.Parser;
import org.junit.Test;
import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class MyTest {

    @Test
    public void testMultiply() {
        Dish dish = new Dish();
        dish.setProduct(Parser.getProductByType("Food"));
        assertNotNull(dish.getProduct());
    }

    @Test
    public void testMultiply1() {
        ArrayList<Dish> breakfast = new ArrayList<>();
        ArrayList<Dish> lunch = new ArrayList<>();
        Parser parser = Parser.getInstance();
        parser.create();
        breakfast = parser.getBreakfast(breakfast);
        lunch =parser.getLunch(lunch);
        assertFalse(breakfast.equals(lunch));
    }

    @Test
    public void testMultiply2() {
        ArrayList<Dish> breakfast = new ArrayList<>();
        Parser parser = Parser.getInstance();
        parser.create();
        breakfast = parser.getBreakfast(breakfast);
        assertNotNull(breakfast);
    }
}
