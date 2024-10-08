import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 * UI sistem pakar untuk memeriksa apakah g bernilai true dari fakta a, b, c, f  
 * Sistem ini memiliki 4 pertanyaan yang akan diberikan pada user
 * 4 pertanyaan merepresentasikan 4 fakta
 * fact: a, b, c, f
 * conclussion: g
 * @author AERO
 */
public class UI {
    private ArrayList<String> questions;
    private int answers[];

    public UI() {
        this.answers = new int[17];
        this.questions = new ArrayList<>();
        setQuestions();
    }

    private void setQuestions() {
    questions.add("Are the leaves chlorotic?");  // G1: chlorotic colored leaves (Bulai)
    questions.add("Is the plant growth stunted?");  // G2: stunted growth (Bulai)
    questions.add("Is there white powder on the surface of the leaves?");  // G3: white powder (Bulai)
    questions.add("Are the leaves wilted?");  // G4: wilted leaves (Blight)
    questions.add("Are there brown spots on the leaves?");  // G5: brown spots (Blight, Leaf Rust)
    questions.add("Are there elongated light brown spots on the leaves?");  // G6: elongated light brown spots (Blight)
    questions.add("Are there red spots on the leaves?");  // G7: red spots (Leaf Rust)
    questions.add("Is there yellowish powder on the leaves?");  // G8: yellowish powder (Leaf Rust)
    questions.add("Is the cob swollen?");  // G9: swelling of the cob (Burn)
    questions.add("Is there white to black fungus on the seeds?");  // G10: white to black fungus (Burn)
    questions.add("Are the seeds swollen?");  // G11: swollen seeds (Burn)
    questions.add("Are there small holes in the leaves?");  // G12: small holes in leaf (Stem Borer)
    questions.add("Are there slits in the stem?");  // G13: slits in stem (Stem Borer)
    questions.add("Do the stems or tassels break easily?");  // G14: stems break easily (Stem Borer)
    questions.add("Are there transverse holes in the leaves?");  // G15: transverse holes in leaf (Cob Borer)
    questions.add("Is the corn silk cut?");  // G16: corn silk cut (Cob Borer)
    questions.add("Is there the presence of larvae?");  // G17: presence of larvae (Cob Borer)
}

    public Set<String> getFacts(List<Rule> rules) {
    Set<String> facts = new HashSet<>();
    Scanner sc = new Scanner(System.in);
    String diagnosis = null;

    for (int i = 0; i < questions.size(); i++) {
        System.out.println(questions.get(i));
        System.out.println("0. Tidak    1. Ya");
        int a = sc.nextInt();
        while (a != 0 && a != 1) {
            System.out.println("Jawaban tidak sesuai! Masukkan 0 atau 1.");
            a = sc.nextInt();
        }
        if (a == 1) {
            String fact = mapQuestionToFact(i);
            facts.add(fact);

            diagnosis = InferenceForwardChaining.doForwardChaining(rules, facts);
            if (diagnosis != null) {
                break;  // Hentikan loop setelah penyakit ditemukan
            }
        }
    }

    // Jika diagnosis terdeteksi, cetak hasilnya
    if (diagnosis != null) {
        System.out.println("Penyakit yang terdeteksi: " + diagnosis);
    } else {
        // Jika tidak ada penyakit yang terdeteksi, cetak pesan
        System.out.println("Penyakit tidak terdeteksi.");
    }

    return facts;
}

    private String mapQuestionToFact(int index) {
    switch (index) {
        case 0: return "chlorotic colored leaves";
        case 1: return "stunted growth";
        case 2: return "white powder";
        case 3: return "wilted leaves";
        case 4: return "brown spots";
        case 5: return "elongated light brown spots";
        case 6: return "red spots";
        case 7: return "yellowish powder";
        case 8: return "swelling of the cob";
        case 9: return "white to black fungus";
        case 10: return "swollen seeds";
        case 11: return "small holes in leaf";
        case 12: return "slits in stem";
        case 13: return "stems break easily";
        case 14: return "transverse holes in leaf";
        case 15: return "corn silk cut";
        case 16: return "presence of larvae";
        default: return "";
    }
}

    public void showConclusion(String diagnosis) {
        if (diagnosis != null) {
            System.out.println("Penyakit yang terdeteksi: " + diagnosis);
        } else {
            System.out.println("Penyakit tidak terdeteksi.");
        }
    }
}