package Code;

public class CalcMain {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        CalcModel model = new CalcModel();
        CalcView view = new CalcView();
        CalcController controller = new CalcController(model, view);
    }
}
