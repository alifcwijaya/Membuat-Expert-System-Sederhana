import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnowledgeBase {
    private List<Rule> rules;

    public KnowledgeBase() {
        rules = new ArrayList<>();
        setRules();
    }

    private void setRules() {
        rules.add(new Rule(Arrays.asList("chlorotic colored leaves", "stunted growth", "white powder"), "Bulai"));
        rules.add(new Rule(Arrays.asList("wilted leaves", "brown spots", "elongated light brown spots"), "Blight"));
        rules.add(new Rule(Arrays.asList("brown spots", "red spots", "yellowish powder"), "Leaf Rust"));
        rules.add(new Rule(Arrays.asList("swelling of the cob", "white to black fungus", "swollen seeds"), "Burn"));
        rules.add(new Rule(Arrays.asList("small holes in leaf", "slits in stem", "stems break easily"), "Stem Borer"));
        rules.add(new Rule(Arrays.asList("transverse holes in leaf", "corn silk cut", "presence of larvae"), "Cob Borer"));
    }

    public List<Rule> getRules() {
        return rules;
    }
}
