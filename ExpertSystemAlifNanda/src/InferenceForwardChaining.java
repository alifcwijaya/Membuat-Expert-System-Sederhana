import java.util.List;
import java.util.Set;

public class InferenceForwardChaining {

    public static String doForwardChaining(List<Rule> rules, Set<String> facts) {
        for (Rule rule : rules) {
            if (facts.containsAll(rule.getAntecedent())) {
                return rule.getConsequent();  // Segera kembalikan penyakit jika gejala terpenuhi
            }
        }
        return null;
    }
}