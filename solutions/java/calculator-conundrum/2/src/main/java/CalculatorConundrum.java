class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        validateOperation(operand2, operation);

        return switch (operation) {
            case "/" -> generateResultString(operand1, operand2, operation, operand1 / operand2);
            case "+" -> generateResultString(operand1, operand2, operation, operand1 + operand2);
            case "*" -> generateResultString(operand1, operand2, operation, operand1 * operand2);
            default -> throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        };
    }

    private static String generateResultString(int operand1, int operand2, String operation, int result) {
        return String.format("%s %s %s = %s", operand1, operation, operand2, result);
    }

    private void validateOperation(int operand2, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }
        if (operation.equals("/") && operand2 == 0) {
            throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());
        }
    }
}
