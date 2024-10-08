import java.util.List;
import java.util.Set;
/**
 * UI sistem pakar untuk memeriksa apakah g bernilai true dari fakta a, b, c, f  
 * Sistem ini memiliki 4 pertanyaan yang akan diberikan pada user
 * 4 pertanyaan merepresentasikan 4 fakta
 * fact: a, b, c, f
 * conclussion: g
 * @author AERO
 */
public class Main {

    public static void main(String[] args) {
        UI tampilan = new UI();

        KnowledgeBase knowledgeBase = new KnowledgeBase();
        List<Rule> rules = knowledgeBase.getRules();

        Set<String> facts = tampilan.getFacts(rules);

        String diagnosis = InferenceForwardChaining.doForwardChaining(rules, facts);
    }
}