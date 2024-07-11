public class AverageCalculatorController {

    private final NumberService numberService;
    private final DoubleLinkedList<Double> numbers = new DoubleLinkedList<>();
    private final int windowSize;

    public AverageCalculatorController(NumberService numberService, @Value("${window.size}") int windowSize) {
        this.numberService = numberService;
        this.windowSize = windowSize;
    }

    @GetMapping("/{numberType}")
    public ResponseEntity<AverageResponse> getAverage(@PathVariable String numberType) throws Exception {
        List<Double> fetchedNumbers = numberService.getNumbers(numberType);
        numbers.addAll(fetchedNumbers);
        if (numbers.size() > windowSize) {
            numbers.removeFirst();
        }
        double average = calculateAverage(numbers);
        return ResponseEntity.ok(new AverageResponse(fetchedNumbers, numbers.toList(), average));
    }

    private double calculateAverage(DoubleLinkedList<Double> numbers) {
        double sum = 0;
        for (Double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }
}
